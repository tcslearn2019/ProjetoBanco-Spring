package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.ParamTransf;
import com.tcs.ProjetoBancoSpring.entities.RetornoMovimentacao;
import com.tcs.ProjetoBancoSpring.entities.Transferencias;
import com.tcs.ProjetoBancoSpring.repositories.TransferenciasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class TransferenciaService {

    @Autowired
    private TransferenciasRepository repository;

    @Autowired
    private ContaService contaService;

    public List<Transferencias> findAll() {
        return repository.findAll();
    }

    public Transferencias findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean deleteById(Long id) {
        Transferencias transferencia = findById(id);
        if (nonNull(transferencia)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Transferencias update(Transferencias transferencias) {
        Transferencias transfer = findById(transferencias.getIdTransferencias());
        BeanUtils.copyProperties(transferencias, transfer, "idTransferencias");
        return repository.save(transfer);
    }

    public Transferencias save(Transferencias transferencia) {
        return repository.save(transferencia);

    }

    public List<RetornoMovimentacao> listEmprestimo(Long id) {
        List<Transferencias> listaTransferencias = repository.findByContaOrigemIdcontaOrContaDestinoIdconta(id, id);
        return listaTransferencias.stream().map(RetornoMovimentacao::new).collect(Collectors.toList());
    }

    public boolean getValidation(ParamTransf paramTransf) {
        Conta origem = contaService.findByUserId(paramTransf.getIdOrigem());
        Conta destino = contaService.findByAgenciaAndConta(paramTransf.getAgencia(), paramTransf.getConta());
        if(destino == null){
            return false;
        }
        return Operacao(origem, destino, paramTransf.getValor());
    }

    private boolean Operacao(Conta contaOrigem, Conta contaDestino, Double valorTransfer) {
        if (contaOrigem.getSaldo() >= valorTransfer && valorTransfer > 0) {

            contaDestino.setSaldo(contaDestino.getSaldo() + valorTransfer);
            contaService.save(contaDestino);

            contaOrigem.setSaldo(contaOrigem.getSaldo() - valorTransfer);
            contaService.save(contaOrigem);

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            Transferencias transf = new Transferencias(valorTransfer, dateFormat.format(new Date(System.currentTimeMillis())), contaOrigem, contaDestino );
            repository.save(transf);
            return true;
        } else {
            return false;
        }
    }
}
