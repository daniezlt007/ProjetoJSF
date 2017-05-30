package com.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.dao.DAO;
import com.modelo.Processo;
import com.modelo.Responsavel;

@ManagedBean
@ViewScoped
public class ProcessoBean {
	
	private Processo processo = new Processo();
	
	private Integer responsavelId;
	private Integer processoId;
		
	public Processo getProcesso() {
		return processo;
	}

	public Integer getResponsavelId() {
		return responsavelId;
	}

	public void setResponsavelId(Integer responsavelId) {
		this.responsavelId = responsavelId;
	}

	public Integer getProcessoId() {
		return processoId;
	}

	public void setProcessoId(Integer processoId) {
		this.processoId = processoId;
	}

	public List<Processo> getProcessos() {
		return new DAO<Processo>(Processo.class).listaTodos();
	}

	public List<Responsavel> getResponsaveis() {
		return new DAO<Responsavel>(Responsavel.class).listaTodos();
	}

	public List<Responsavel> getResponsaveisDoProcesso() {
		return this.processo.getResponsaveis();
	}
	
	public void gravarResponsavel() {
		Responsavel responsavel = new DAO<Responsavel>(Responsavel.class).buscaPorId(this.responsavelId);
		this.processo.adicionarResponsavel(responsavel);
		System.out.println("Processo criado por: " + responsavel.getNome());
	}
	
	
	public void gravar(){
		//System.out.println("Gravando" + this.processo.getNumProcesso());
		if (processo.getResponsaveis().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("responsavel",
					new FacesMessage("Processo deve ter pelo menos um Responsavel."));
			return;
		}

		if (this.processo.getId() == null) {
			new DAO<Processo>(Processo.class).adiciona(this.processo);
			//carregarProcessoPelaId();
		} else {
			new DAO<Processo>(Processo.class).atualiza(this.processo);
		}
		limpar();
	}
	
	public void carregarProcesso(Processo processo){
		System.out.println("Gravando" + processo.getNumProcesso());
		this.processo = processo;
	}
	
	public void remover(Processo processo){
		System.out.println("Removendo" + processo.getNumProcesso());
		new DAO<Processo>(Processo.class).remove(this.processo);
	}
	
	public void removerResponsavelDoProcesso(Responsavel responsavel) {
		this.processo.removeResponsavel(responsavel);
	}

	public String formResponsavel() {
		System.out.println("Chamanda do formulário do Responsável.");
		return "responsavel?faces-redirect=true";
	}
	
	public void carregarProcessoPelaId() {
		this.processo = new DAO<Processo>(Processo.class).buscaPorId(processoId);
	}
	
	public void limpar(){
		this.processo = new Processo();
	}

}
