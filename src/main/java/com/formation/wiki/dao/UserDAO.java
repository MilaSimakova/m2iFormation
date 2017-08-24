package com.formation.wiki.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.text.Utilities;

import com.formation.wiki.entity.User;

public class UserDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public UserDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	
	// Connection, checking if User exists
	public String isUserExist(String login, String pass) throws SQLException, TimeoutException {
		String role_user = null;
		Query q = em.createQuery("select user from User user where user.login = :login and user.password= :pass");
		q.setParameter("login", login);
		q.setParameter("pass", pass);
		User user_exist = (User) q.getSingleResult();
		if (user_exist != null) {
			role_user = user_exist.getRole().getName();
		}
		return role_user;
	}

	
	// Add a new User
	public void addUser(User user) {
		tx.begin();
		em.persist(user);
		// Suppression d'un objet em.remove(entity);
		// Mise à jour d'un objet em.merge(entity);
		// Récupération d'un objet em.find(entityClass, primaryKey);
		tx.commit();
	}

	// Find User by ID
	public User findbyId(int id) {
		Query q = em.createNamedQuery("User.findById");
		q.setParameter("id", id);
		User user = (User) q.getSingleResult();
		return user;
	}

	
	// Verification of user`s status
	public void changerEtatUser(User user) {
		if (user.getActiver() == false) {
			user.setActiver(true);
		} else {
			user.setActiver(false);
		}
		tx.begin();
		em.merge(user);
		tx.commit();
	}
	
	
	// Get All Users
	public List<User> getAllUsers(User user) {
		
		String query = "SELECT user FROM User user";
		Query q = em.createQuery(query);
		List<User> results = q.getResultList();
		return results;		
	}
	
	
	//Inscription
	public void newUserInscription(String login, String pass, String nom, String prenom, String email, String tel, boolean activer){
		
		User utilisateur=new User();
		utilisateur.setLogin(login);
		utilisateur.setPassword(pass);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setTel(tel);
		utilisateur.setActiver(false);	
		
		tx.begin();
		em.persist(utilisateur);
		tx.commit();
	}


}
