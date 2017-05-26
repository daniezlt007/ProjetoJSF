package com.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("serial")
@ManagedBean(name="controle")
@SessionScoped
public class ControlePrincipal implements Serializable{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public ControlePrincipal(){
		mensagem = "Bem-vindo Daniel da Silva";
	}
	
	public String inicio(){
		mensagem = "você foi redirecionado dinâmicamente para index";
		return "index?faces-redirect=true";
	}
	
	public String sobre(){
		mensagem = "você navegou dinâmicamente para sobre";
		return "sobre";
	}
	
	public String redirecionadoSobre(){
		mensagem = "você foi redirecionado dinâmicamente para sobre";
		return "sobre?faces-redirect=true";
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
