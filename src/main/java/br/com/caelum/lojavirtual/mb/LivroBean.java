package br.com.caelum.lojavirtual.mb;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.lojavirtual.annotations.LivroRepository;
import br.com.caelum.lojavirtual.dao.GenericDao;
import br.com.caelum.lojavirtual.modelo.Livro;

@Model
public class LivroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject @LivroRepository
	private GenericDao<Livro> dao;

	@SuppressWarnings("deprecation")
	private Livro livro = new Livro();

	@Transactional
	public void grava() {
		if (this.livro.getId() == null) {
			this.dao.adiciona(this.livro);
		} else {
			this.dao.atualiza(this.livro);
		}

		limpaFormularioDeLivro();
	}

	@SuppressWarnings("deprecation")
	private void limpaFormularioDeLivro() {
		this.livro = new Livro();
	}

	public Livro getLivro() {
		return this.livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
