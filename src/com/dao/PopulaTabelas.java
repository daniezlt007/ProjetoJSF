package com.dao;

import javax.persistence.EntityManager;

import com.modelo.Processo;
import com.modelo.Responsavel;
import com.modelo.Usuario;

public class PopulaTabelas {
	public static void main(String[] args) {

		new JPAUtil();
		// Executando o JPA'
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		// Criando Objetos
		
		Usuario developer = geraUsuario("danielzt007@outlook.com", "root");
		em.persist(developer);
		
		Responsavel daniel = geraResponsavel("Daniel da Silva", 1001);
		em.persist(daniel);

		Responsavel alice = geraResponsavel("Alice Farias Monteiro da Silva", 1002);
		em.persist(alice);

		Processo primeiro = geraProcesso("PA-03-2017", "PA-03-2017", 1, daniel);
		em.persist(primeiro);
		Processo segundo = geraProcesso("PA-04-2017", "PA-04-2017", 2, alice);
		em.persist(segundo);
		
		em.getTransaction().commit();
		em.close();

	}

	public static Responsavel geraResponsavel(String nome, Integer matricula) {
		Responsavel responsavel = new Responsavel();
		responsavel.setNome(nome);
		responsavel.setMatricula(matricula);
		return responsavel;
	}

	public static Processo geraProcesso(String numCartaContrato, String numOps, Integer numProcesso, Responsavel responsavel) {
		Processo processo = new Processo();
		processo.setNumProcesso(numProcesso);
		processo.setNumOps(numOps);
		processo.setNumCartaContrato(numCartaContrato);
		processo.adicionarResponsavel(responsavel);
		return processo;
	}
	
	public static Usuario geraUsuario(String email, String senha){
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		return usuario;
	}
}
