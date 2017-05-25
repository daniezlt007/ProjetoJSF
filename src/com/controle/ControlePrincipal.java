package com.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="controle")
@RequestScoped
public class ControlePrincipal implements Serializable{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public ControlePrincipal(){
		mensagem = "Bem-vindo Daniel da Silva";
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
