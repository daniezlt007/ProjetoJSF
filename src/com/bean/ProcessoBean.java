package com.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProcessoBean {
	
	private Processo p = new Processo();
	
	public Processo getP() {
		return p;
	}

	public void gravar(){
		System.out.println("Salvando" + this.p.getNumProcesso() + " - " + this.p.getResponsavel());
	}

}
