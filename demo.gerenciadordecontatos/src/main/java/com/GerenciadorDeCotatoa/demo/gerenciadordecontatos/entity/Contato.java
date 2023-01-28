package com.GerenciadorDeCotatoa.demo.gerenciadordecontatos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contato_id;
	@Column(nullable = false, unique=true)
	private String nome;
	@Column(nullable = false)
	private String numeroDeCelular;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String endereco;
}
