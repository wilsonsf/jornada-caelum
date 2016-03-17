package br.com.caelum.lojavirtual.modelo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
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

	private Livro livro;

	@Before
	public void setUp() {
		this.livro = criaLivroDeTeste();
	}

	@Test
	public void devePoderVincularUmAutor() {
		this.livro.adicionaUnicoAutor(criaAutorDeTeste());


		assertEquals(1,this.livro.getAutores().size());

	}

	@Test
	public void devePoderVincularVariosAutores() {
		Autor autor1 = new Autor("Nome1");
		Autor autor2 = new Autor("Nome2");

		List<Autor> autores = Arrays.asList(autor1,autor2);

		this.livro.adicionaVarios(autores);
	}

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

	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirAtorVazio() {
		new Livro("Tiulo", "Descrição", "URL da Imagem", BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
	}

	private Livro criaLivroDeTeste() {
		return new Livro("Título", "Descrição", "URL da Imagem", BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(5));
	}

	private Autor criaAutorDeTeste() {
		return new Autor("Nome1");
	}

}
