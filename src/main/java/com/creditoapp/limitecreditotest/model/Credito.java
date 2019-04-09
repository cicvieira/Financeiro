/*
 * Cicero Vieira 2019-04-08
 * limitecreditoapp 1.0
 * 
 */
package com.creditoapp.limitecreditotest.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Credito")
@EntityListeners(AuditingEntityListener.class)
public class Credito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String risco;

	private Integer limite;
	
	private Integer porcentagem;
	
	private Integer valorjuros;
	
	private Integer valorcomjuros;

	public Credito() {
	}
	
	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLimite() {
		return limite;
	}

	public void setLimite(Integer limite) {
		this.limite = limite;
	}
	
	public Integer getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(Integer porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	public Integer getValorjuros() {
		return valorjuros;
	}

	public void setValorjuros(Integer valorjuros) {
		this.valorjuros = valorjuros;
	}
	
	public Integer getValorcomjuros() {
		return valorcomjuros;
	}

	public void setValorcomjuros(Integer valorcomjuros) {
		this.valorcomjuros = valorcomjuros;
	}
	

}
