package com.bank.api.domain;

import com.bank.api.enums.TipoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroConta;

	@NonNull
	private Instant dataAbertura;

	@NonNull
	@OneToOne()
	@JsonIgnore
	private AgenciaBancaria agenciaBancaria;
	
	@NonNull
	@ManyToOne
	private Cliente cliente;
	
	@NonNull
	private TipoConta tipoConta;

	@NonNull
	private BigDecimal depositoInicial;
	
}
