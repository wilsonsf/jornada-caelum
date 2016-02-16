package br.com.caelum.lojavirtual.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

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


	/** CDI only */
	@Deprecated
	public Livro () {}

	public Livro(String titulo, String descricao, String capa, BigDecimal precoDigital, BigDecimal precoImpresso,
			BigDecimal precoCombo) {
		if (!(precoDigital.compareTo(BigDecimal.ZERO) > 0) || !(precoImpresso.compareTo(BigDecimal.ZERO) > 0) || !(precoCombo.compareTo(BigDecimal.ZERO) > 0)) {
			throw new IllegalArgumentException("preço deve ser maior que zero");
		}

		this.titulo = titulo;
		this.descricao = descricao;
		this.capa = capa;
		this.precoDigital = precoDigital;
		this.precoImpresso = precoImpresso;
		this.precoCombo = precoCombo;
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
		this.precoDigital = precoDigital;
	}

	public BigDecimal getPrecoImpresso() {
		return this.precoImpresso;
	}

	public void setPrecoImpresso(BigDecimal precoImpresso) {
		this.precoImpresso = precoImpresso;
	}

	public BigDecimal getPrecoCombo() {
		return this.precoCombo;
	}

	public void setPrecoCombo(BigDecimal precoCombo) {
		this.precoCombo = precoCombo;
	}

}
