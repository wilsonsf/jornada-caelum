package br.com.caelum.lojavirtual.modelo;

import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <h1>Um autor deve</h1>
 * 	<ul>
 * 	<li>ter varios livros</li>
 * 	<li></li>
 * 	</ul>
 * <h1>Um autor não deve</h1>
 * 	<ul>
 * 	<li>ter nome em branco</li>
 * 	<li></li>
 * 	</ul>
 *
 * @author wilsonsf
 *
 */
public class AutorTest {

	private Autor autor;

	@Before
	public void setUp() {
		this.autor = new Autor("Nome");
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDeveTerNomeEmBranco() {
		new Autor("");
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDeveTerNomeNulo() {
		new Autor(null);
	}

	@Test
	public void devePermitirVincularUmLivro() {
		assertFalse(true);
	}

}
