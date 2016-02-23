package br.com.caelum.lojavirtual.dao;

import java.util.List;

public interface GenericDao<T> {

	public void adiciona(T tipo);
	public void remove(T tipo);
	public void atualiza(T tipo);
	public List<T> listaTodos();
	public T buscaPorId(Long id);
	public int contaTodos();
	public List<T> listaTodosPaginado(int primeiroResultado, int maximosResultados);
}
