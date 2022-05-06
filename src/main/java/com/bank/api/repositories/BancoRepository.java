package com.bank.api.repositories;

import com.bank.api.domain.AgenciaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<AgenciaBancaria, Long> {

}
