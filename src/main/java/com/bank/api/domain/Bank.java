package com.bank.api.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Entity
public class Bank implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agencia;
    private String nomeAgencia;
    private String endereco;
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "bank")
    private List<Conta> contas = new ArrayList<>();


    public Bank() {
    }

    public Bank(Long agencia, String nomeAgencia, String endereco, String telefone) {
        this.agencia = agencia;
        this.nomeAgencia = nomeAgencia;
        this.endereco = endereco;
        this.telefone = telefone;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return agencia.equals(bank.agencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia);
    }
}
