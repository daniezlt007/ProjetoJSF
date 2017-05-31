package com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dao.DAO;
import com.modelo.Responsavel;
import com.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ResponsavelBean {
	
	private Responsavel responsavel = new Responsavel();
	private Integer idResponsavel; 
	
	public Responsavel getResponsavel() {
		return responsavel;
	}
	
	public List<Responsavel> getResponsaveis() {
		return new DAO<Responsavel>(Responsavel.class).listaTodos();
	}
	
	public String gravar(){
			
		System.out.println("Gravando Responsavel " + this.responsavel.getNome());
		if (this.responsavel.getId() == null) {
			new DAO<Responsavel>(Responsavel.class).adiciona(this.responsavel);
			FacesUtil.addSuccessMessage("Responsável salvo com sucesso!");
		} else {
			new DAO<Responsavel>(Responsavel.class).atualiza(this.responsavel);
			FacesUtil.addSuccessMessage("Responsável atualizado com sucesso!");
		}
		
		limpar();

		return "responsavel?faces-redirect=true";
		
	}

	public void carregar(Responsavel responsavel) {
		System.out.println("Carregando Responsavel");
		this.responsavel = responsavel;
	}

	public void remover(Responsavel Responsavel) {
		System.out.println("Removendo Responsavel");
		new DAO<Responsavel>(Responsavel.class).remove(Responsavel);
	}

	public Integer getResponsavelId() {
		return idResponsavel;
	}

	public void setResponsavelId(Integer idResponsavel) {
		this.idResponsavel = idResponsavel;
	}
	
	public void carregarResponsavelPelaId() {
		this.responsavel = new DAO<Responsavel>(Responsavel.class).buscaPorId(idResponsavel);
	}
	
	public void limpar(){
		this.responsavel = new Responsavel();
	}
	
}
