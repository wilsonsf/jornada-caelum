package br.com.caelum.lojavirtual.modelo;

import java.io.Serializable;

public interface Persistivel extends Serializable {
	public Integer getId();
	public void setId(Integer id);
}
