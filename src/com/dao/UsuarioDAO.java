package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.modelo.Usuario;

public class UsuarioDAO {
	public boolean existe(Usuario usuario) {

		new JPAUtil();
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Usuario> query = em.createQuery(
						"select u from Usuario u where u.email = :pEmail and u.senha = :pSenha",
						Usuario.class);

		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());

		try {
			Usuario resultado = query.getSingleResult();
			System.out.println(resultado.getEmail());
			System.out.println(resultado.getSenha());
		} catch (NoResultException ex) {
			return false;
		}

		em.close();

		return true;
	}	
}
