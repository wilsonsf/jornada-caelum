package br.com.caelum.lojavirtual.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Table(name="livros")
@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	@NotBlank
	private String capa;

	@DecimalMin(value="0.01")
	private BigDecimal precoDigital;
	@DecimalMin(value="0.01")
	private BigDecimal precoImpresso;
	@DecimalMin(value="0.01")
	private BigDecimal precoCombo;

	@NotNull
	private List<Autor> autores = new LinkedList<>();


	/** CDI only */
	@Deprecated
	public Livro () {}

	public Livro(String titulo, String descricao, String capa, BigDecimal precoDigital, BigDecimal precoImpresso,
			BigDecimal precoCombo) {

	}

	public Livro(String titulo, String descricao, String capa, BigDecimal precoDigital, BigDecimal precoImpresso,
			BigDecimal precoCombo, List<Autor> autores) {
		if(ehValorMenorIgualAZero(precoDigital) || ehValorMenorIgualAZero(precoImpresso) || ehValorMenorIgualAZero(precoCombo))
			throw new IllegalArgumentException("Preço deve ser maior que zero");
		if(titulo.isEmpty())
			throw new IllegalArgumentException("Título não pode ser vazio");
		if(descricao.isEmpty())
			throw new IllegalArgumentException("Descrição não pode ser vazia");
		if(capa.isEmpty())
			throw new IllegalArgumentException("Capa não pode ser vazia");
		if(autores == null || autores.isEmpty())
			throw new IllegalArgumentException("Autor não pode ser vazio");

		this.titulo = titulo;
		this.descricao = descricao;
		this.capa = capa;
		this.precoDigital = precoDigital;
		this.precoImpresso = precoImpresso;
		this.precoCombo = precoCombo;
		this.autores = autores;
	}

	private boolean ehValorMenorIgualAZero(BigDecimal precoDigital) {
		return !(precoDigital.compareTo(BigDecimal.ZERO) > 0);
	}

	public void adicionaVarios(List<Autor> autores) {
		this.autores.addAll(autores);
	}

	public void adicionaUnicoAutor(Autor autor) {
		this.autores.add(autor);
	}

	public Integer getId() {
		return this.id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCapa() {
		return this.capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	public BigDecimal getPrecoDigital() {
		return this.precoDigital;
	}

	public void setPrecoDigital(BigDecimal precoDigital) {
		if (ehValorMenorIgualAZero(precoDigital))
			throw new IllegalArgumentException("Preço Digital: não pode ser negativo");
		this.precoDigital = precoDigital;
	}

	public BigDecimal getPrecoImpresso() {
		return this.precoImpresso;
	}

	public void setPrecoImpresso(BigDecimal precoImpresso) {
		if (ehValorMenorIgualAZero(precoImpresso))
			throw new IllegalArgumentException("Preço Impresso: não pode ser negativo");
		this.precoImpresso = precoImpresso;
	}

	public BigDecimal getPrecoCombo() {
		return this.precoCombo;
	}

	public void setPrecoCombo(BigDecimal precoCombo) {
		if (ehValorMenorIgualAZero(precoCombo))
			throw new IllegalArgumentException("Preço Combo: não pode ser negativo");
		this.precoCombo = precoCombo;
	}

	public List<Autor> getAutores() {
		return this.autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}


}
