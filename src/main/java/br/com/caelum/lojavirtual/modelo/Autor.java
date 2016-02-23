package br.com.caelum.lojavirtual.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="autores")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String nome;

	@ManyToMany
	private List<Livro> livros = new LinkedList<>();

	/** CDI only */
	@Deprecated
	public Autor() {}

	public Autor(String nome) {
		if (nome == null || nome.isEmpty())
			throw new IllegalArgumentException("Nome não pode ser nulo ou em branco");

		this.nome = nome;
	}

	public void adicionaUnico(Livro livro) {
		this.livros.add(livro);
	}

	public List<Livro> getLivros() {
		return this.livros ;
	}
}
