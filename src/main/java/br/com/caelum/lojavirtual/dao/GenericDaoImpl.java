package br.com.caelum.lojavirtual.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDaoImpl<T> implements GenericDao<T> {

	private final Class<T> classe;

	@Inject
	private EntityManager manager;

	public GenericDaoImpl(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void adiciona(T tipo) {
		this.manager.persist(tipo);
	}

	@Override
	public void remove(T tipo) {
		this.manager.remove(this.manager.merge(tipo));
	}

	@Override
	public void atualiza(T tipo) {
		this.manager.merge(tipo);
	}

	@Override
	public List<T> listaTodos() {
		CriteriaQuery<T> query = this.manager.getCriteriaBuilder()
				.createQuery(this.classe);

		query.select(query.from(this.classe));

		return this.manager.createQuery(query).getResultList();
	}

	@Override
	public T buscaPorId(Long id) {
		return this.manager.find(this.classe, id);
	}

	@Override
	public int contaTodos() {
		long contagem = (Long) this.manager.createQuery(
				"select count(n) from " + this.classe.getName() + " n")
				.getSingleResult();
		return (int) contagem;
	}

	@Override
	public List<T> listaTodosPaginado(int primeiroResultado, int maximosResultados) {
		CriteriaQuery<T> query = this.manager.getCriteriaBuilder()
				.createQuery(this.classe);

		query.select(query.from(this.classe));

		return this.manager.createQuery(query)
				.setFirstResult(primeiroResultado)
				.setMaxResults(maximosResultados)
				.getResultList();
	}

}
