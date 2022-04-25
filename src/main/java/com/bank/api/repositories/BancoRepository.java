package com.bank.api.repositories;

import com.bank.api.domain.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Banco, Long> {

}
