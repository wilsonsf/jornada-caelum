package br.com.caelum.lojavirtual.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.caelum.lojavirtual.modelo.Livro;

@Named
@RequestScoped
public class LivroBean {

	private Livro livro;

	public LivroBean() {
	}

	public String gravar() {
		return null;
	}

	public Livro getLivro() {
		return this.livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
