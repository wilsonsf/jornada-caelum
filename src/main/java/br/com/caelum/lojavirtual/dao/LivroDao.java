package br.com.caelum.lojavirtual.dao;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.lojavirtual.annotations.LivroRepository;
import br.com.caelum.lojavirtual.modelo.Livro;


@LivroRepository
public class LivroDao implements GenericDao<Livro> {

	@Inject
	EntityManager manager;

	@Override
	public void adiciona(Livro tipo) {
		this.manager.persist(tipo);
	}

	@Override
	public void remove(Livro tipo) {
		this.manager.remove(tipo);
	}

	@Override
	public void atualiza(Livro obj) {
		this.manager.merge(obj);
	}

	@Override
	public List<Livro> listaTodos() {
		return Collections.emptyList();
	}

	@Override
	public Livro buscaPorId(Long id) {
		return this.manager.find(Livro.class, id);
	}

	@Override
	public int contaTodos() {
		long total = (Long) this.manager.createQuery("SELECT count(l.id) FROM Livro l").getSingleResult();
		return (int) total;
	}

	@Override
	public List<Livro> listaTodosPaginado(int primeiroResultado, int maximosResultados) {
		return Collections.emptyList();
	}

}
