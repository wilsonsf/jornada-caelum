package br.com.caelum.lojavirtual.modelo;

import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

public class LivroTest {

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirValoresNegativosParaPrecos() {
		Livro livro = new Livro();
		livro.setPrecoDigital(BigDecimal.valueOf(-5.0));
		livro.setPrecoImpresso(BigDecimal.valueOf(-50));
		livro.setPrecoCombo(BigDecimal.valueOf(-50));
	}

}
