package br.com.caelum.lojavirtual.modelo;

//import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * <h1>Um livro deve</h1>
 * 	<ul>
 * 	<li>ter título, descrição e capa definidos</li>
 * 	<li>ter um Autor associado</li>
 * 	<li>ter uma categoria associada</li>
 * 	</ul>
 * <h1>Um livro não deve</h1>
 * 	<ul>
 * 	<li>ter valores negativos de preços</li>
 * 	<li>ter valor zero de preços</li>
 * 	</ul>

 * @author wilsonsf
 */
public class LivroTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirLivroSemTitulo() {
		new Livro("", "Descrição", "URL da Imagem", BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(5));
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirLivroSemDescricao() {
		new Livro("Título", "", "URL da Imagem", BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(5));
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirLivroSemURL() {
		new Livro("Título", "Descrição", "", BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(5));
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirValoresNegativosParaPrecos() {
		new Livro("", "", "", BigDecimal.valueOf(-5), BigDecimal.valueOf(-5), BigDecimal.valueOf(-5));

	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirValorZeradoParaPrecos() {
		new Livro("Tiulo", "Descrição", "URL da Imagem", BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
	}

	@SuppressWarnings("unused")
	private Livro criaLivroDeTeste() {
		return new Livro("Título", "Descrição", "URL da Imagem", BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(5));
	}

}
