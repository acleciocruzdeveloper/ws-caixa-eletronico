package com.bank.api.domain;


import com.bank.api.enums.Banco;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AgenciaBancaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agencia;

	@NonNull
	private Banco banco;

	@NonNull
    private String nomeAgencia;	

	@NonNull
    private String endereco;

	@NonNull
    private String telefone;

	@OneToMany(mappedBy = "agenciaBancaria")
	@Setter(value = AccessLevel.PRIVATE)
	private List<Conta> conta;
    
}
