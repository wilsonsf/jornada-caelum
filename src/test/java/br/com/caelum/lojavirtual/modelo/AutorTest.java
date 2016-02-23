package br.com.caelum.lojavirtual.modelo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

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

	@Test(expected=IllegalArgumentException.class)
	public void naoDeveTerNomeEmBranco() {
		new Autor("");
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDeveTerNomeNulo() {
		new Autor(null);
	}

	@Test
	public void deveVincularUmLivro() {
		Autor autor = new Autor("João");

		Livro livro = new Livro("Titulo", "Descrição", "Capa", BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN);
		livro.adicionaUnicoAutor(autor);
		autor.adicionaUnico(livro);

		assertEquals(1, livro.getAutores().size());
		assertEquals(1, autor.getLivros().size());
	}

}
