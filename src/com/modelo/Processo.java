package com.modelo;

public class Processo {
	
	private Integer numProcesso;
	private String responsavel;
	private String numOps;
	private String numCartaContrato;
	
	public Processo(){
		
	}
		
	public Processo(Integer numProcesso, String responsavel, String numOps, String numCartaContrato) {
		this.numProcesso = numProcesso;
		this.responsavel = responsavel;
		this.numOps = numOps;
		this.numCartaContrato = numCartaContrato;
	}

	public Integer getNumProcesso() {
		return numProcesso;
	}

	public void setNumProcesso(Integer numProcesso) {
		this.numProcesso = numProcesso;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getNumOps() {
		return numOps;
	}

	public void setNumOps(String numOps) {
		this.numOps = numOps;
	}

	public String getNumCartaContrato() {
		return numCartaContrato;
	}

	public void setNumCartaContrato(String numCartaContrato) {
		this.numCartaContrato = numCartaContrato;
	}
}
