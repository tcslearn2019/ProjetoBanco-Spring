package com.tcs.ProjetoBancoSpring.services;

import com.tcs.ProjetoBancoSpring.entities.Conta;
import com.tcs.ProjetoBancoSpring.entities.Investimento;
import com.tcs.ProjetoBancoSpring.entities.ParamInvestimento;
import com.tcs.ProjetoBancoSpring.entities.TipoInvestimento;
import com.tcs.ProjetoBancoSpring.repositories.InvestimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository repository;

    @Autowired
    private ContaService contaService;

    @Autowired
    private TipoInvestimentoService tipoInvestimentoService;


    public List<Investimento> findAll() {
        return repository.findAll();
    }

    public Investimento findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean deleteById(Long id) {
        Investimento investimento = findById(id);
        if (investimento == null) {
            return false;
        } else {
            repository.deleteById(id);
            return true;
        }
    }

    public Investimento update(Investimento investimento) {
        Investimento inv = findById(investimento.getId());
        BeanUtils.copyProperties(investimento, inv, "id", "fkIdConta");
        return repository.save(inv);
    }

    public boolean createInvestiment(ParamInvestimento paramInvestimento) {
        Conta conta = contaService.findByIdUser(paramInvestimento.getIduser());

        if (validateInvestiment(paramInvestimento, conta)) {
            TipoInvestimento tipoInvestimento = tipoInvestimentoService.findById(paramInvestimento.getIdinv());

            Investimento investimento = new Investimento();
            investimento.setValor(paramInvestimento.getValor());
            investimento.setValorTemp(paramInvestimento.getValor());
            investimento.setFkIdConta(conta);
            investimento.setFkIdTipoInvestimento(tipoInvestimento);
            repository.save(investimento);

            conta.setSaldo(conta.getSaldo() - paramInvestimento.getValor());
            contaService.save(conta);
            return true;
        } else {
            return false;
        }
    }

    private boolean validateInvestiment(ParamInvestimento paramInvestimento, Conta conta) {
        return conta.getSaldo() >= paramInvestimento.getValor() && paramInvestimento.getValor() > 0;
    }

    public List<Investimento> findByIdUserAtivo(Long id) {
        return repository.findByFkIdContaFkIdUserIdAndAtivo(id, true);
    }

    public List<Investimento> findByIdUserInativo(Long id) {
        return repository.findByFkIdContaFkIdUserIdAndAtivo(id, false);
    }

    public boolean refound(Investimento investimento) {
        Investimento inv = findById(investimento.getId());
        inv.setAtivo(false);
        inv.setDataResgate(new Date(System.currentTimeMillis()));
        repository.save(investimento);
        inv.getFkIdConta().setSaldo(inv.getValorTemp() + inv.getFkIdConta().getSaldo());
        contaService.save(inv.getFkIdConta());
        return true;
    }
}
