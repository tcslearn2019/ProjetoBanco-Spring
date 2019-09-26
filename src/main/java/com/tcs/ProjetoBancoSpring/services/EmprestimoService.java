package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.Emprestimo;
import com.tcs.ProjetoBancoSpring.entities.ParamEmprestimo;
import com.tcs.ProjetoBancoSpring.entities.User;
import com.tcs.ProjetoBancoSpring.repositories.EmprestimoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private ContaService contaService;

    public List<Emprestimo> findAll() {
        return repository.findAll();
    }

    public Emprestimo findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean deleteById(Long id) {
        Emprestimo emprestimo = findById(id);
        if (nonNull(emprestimo)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Emprestimo update(Emprestimo paramEmprestimo) {
        Emprestimo emp = findById(paramEmprestimo.getIdEmprestimo());
        BeanUtils.copyProperties(paramEmprestimo, emp, "idEmprestimo", "fkIdUser");
        return repository.save(emp);
    }

    public Emprestimo createEmprestimo(ParamEmprestimo paramEmprestimo) {
        if (repository.countByFkIdUserIdAndPago(paramEmprestimo.getIdOrigem(), false) <= 4) {
            if (paramEmprestimo.getValor() > 0 && paramEmprestimo.getValor() <= 5000) {
                Conta destino = contaService.findByUserId(paramEmprestimo.getIdOrigem());
                destino.setSaldo(destino.getSaldo() + paramEmprestimo.getValor());
                contaService.save(destino);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                Emprestimo emprestimo = new Emprestimo(destino.getFkIdUser(), dateFormat.format(new Date(System.currentTimeMillis())), 2.5, paramEmprestimo.getValor(), false);
                return repository.save(emprestimo);
            }
        }
        return null;
    }

    public List<Emprestimo> getValidation(Long id) {
        return repository.findByFkIdUserIdAndPago(id, false);
    }

    public List<Emprestimo> getValidationPayed(Long id) {
        return repository.findByFkIdUserIdAndPago(id, true);
    }

    public boolean getPay(Long id) {
        Emprestimo emprestimo = findById(id);
        Conta conta = emprestimo.getFkIdUser().getConta();
        if (conta.getSaldo() >= emprestimo.getValorPagar()) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            emprestimo.setDataPagamento(dateFormat.format(new Date(System.currentTimeMillis())));
            emprestimo.setPago(true);
            repository.save(emprestimo);
            conta.setSaldo(conta.getSaldo() - emprestimo.getValorPagar());
            contaService.save(conta);
            return true;
        } else {
            return false;
        }
    }
}

