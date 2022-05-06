package com.bank.api.services;

import com.bank.api.domain.AgenciaBancaria;
import com.bank.api.repositories.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BancoRepository repository;

    /**
     * Metodo para buscar todos os bancos cadastrados
     * @return lista de bancos cadastrados
     */
    public List<AgenciaBancaria> findAll() {
        return repository.findAll();
    }

    /**
     * Busca um banco
     * @param id
     * @return banco correspondente ao ID
     */
    public AgenciaBancaria findById(Long id) {
        Optional<AgenciaBancaria> obj = repository.findById(id);
        return obj.get();
    }

    /**
     * Método para cadastrar novo Banco
     * @param banco
     * @return um novo banco no banco de dados.
     */
    public AgenciaBancaria novoBanco(AgenciaBancaria banco) {
        return repository.save(banco);

    }

    /**
     * Método para atualizar dados de um banco
     * @param id
     * @param banco
     * @return dados atualizado ao banco de dados.
     */

    public AgenciaBancaria atualizarDados(Long id, AgenciaBancaria banco) {
        AgenciaBancaria bancoId = repository.getById(id);
        updateDados(banco, bancoId);
        return repository.save(banco);
    }

    private void updateDados(AgenciaBancaria banco, AgenciaBancaria bancoId) {
        banco.setNomeAgencia(banco.getNomeAgencia());
        banco.setEndereco(banco.getEndereco());
        banco.setTelefone(banco.getTelefone());
    }

    /**
     * Método para remover um banco
     * passando Id da instituição.
     * @param id
     */

    public void removerBanco(Long id) {
        repository.deleteById(id);
    }

}
