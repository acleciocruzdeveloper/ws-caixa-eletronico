package com.bank.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.api.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
