package br.com.caelum.lojavirtual.modelo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;

	public Autor(String nome) {
		if (nome == null || nome.isEmpty())
			throw new IllegalArgumentException("Nome não pode ser nulo ou em branco");

		this.nome = nome;
	}

}
