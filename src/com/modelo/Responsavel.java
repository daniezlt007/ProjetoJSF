package com.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="responsavel")
public class Responsavel {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="matricula", nullable=false, unique=true)
	private Integer matricula;
	@Column(nullable=false, length=50)
	private String nome;
		
	public Responsavel(){
		
	}
	
	public Responsavel(Integer id, Integer matricula, String nome) {
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
