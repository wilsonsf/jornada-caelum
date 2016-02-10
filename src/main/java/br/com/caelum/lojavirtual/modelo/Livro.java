package br.com.caelum.lojavirtual.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="livros")
@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String titulo;
	private String descricao;
	private String capa;

	private BigDecimal precoDigital;
	private BigDecimal precoImpresso;
	private BigDecimal precoCombo;

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
