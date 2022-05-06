package com.bank.api.services;

import com.bank.api.domain.Cliente;
import com.bank.api.domain.Conta;
import com.bank.api.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public Conta findById(Long id) {
        Optional<Conta> obj = contaRepository.findById(id);
        return obj.get();
    }

    public Conta insert(Conta conta) {
        Conta novaConta = contaRepository.save(conta);
        return novaConta;
    }

    public void delete(Long id) {
        contaRepository.deleteById(id);
    }

    public Conta update(Long id, Conta conta) {
        Conta atualiza = contaRepository.getById(id);
        updateConta(conta, atualiza);
        return contaRepository.save(conta);
    }

    private void updateConta(Conta conta, Conta atualiza) {
        conta.setTipoConta(atualiza.getTipoConta());
        conta.setAgenciaBancaria(atualiza.getAgenciaBancaria());
    }

}
