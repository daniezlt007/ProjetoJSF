package com.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="processo")
public class Processo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idprocesso")
	private Integer id;
	@Column(name="numprocesso", nullable=false)
	private Integer numProcesso;
	@Column(name="numops", nullable=false, unique=true)
	private String numOps;
	@Column(name="numcartacontrato", nullable=false, unique=true)
	private String numCartaContrato;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Responsavel> responsaveis = new ArrayList<Responsavel>();
	
	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}
	
	public void adicionarResponsavel(Responsavel responsavel) {
		this.responsaveis.add(responsavel);
	}
	
	public Processo(){
		
	}
		
	public Processo(Integer id, Integer numProcesso, String numOps, String numCartaContrato) {
		this.id = id;
		this.numProcesso = numProcesso;
		this.numOps = numOps;
		this.numCartaContrato = numCartaContrato;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumProcesso() {
		return numProcesso;
	}

	public void setNumProcesso(Integer numProcesso) {
		this.numProcesso = numProcesso;
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

	public void removeResponsavel(Responsavel responsavel) {
		this.responsaveis.remove(responsavel);		
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processo)) {
            return false;
        }
        Processo other = (Processo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Processo[ id=" + id + " ]";
    }


}
