package com.formation.wiki.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.formation.test.SmallIdArticleExeption;
import com.formation.wiki.ConnectionManager;
import com.formation.wiki.entity.Article;
import com.formation.wiki.entity.Status;
import com.formation.wiki.entity.User;

public class ArticleDAO {
	
	private EntityManager em;
	private EntityTransaction tx;

	public ArticleDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	// add article
	public void addArticle(Article art) {
		tx.begin();
		em.persist(art);
		tx.commit();
	}
	
	// delete article
	public void deleteArticle(Article art) {
		tx.begin();
		em.remove(art);
		tx.commit();
	}
	
	// create article
	public void addNewArticle(int idArticle, String nomArticle, String kyewords, int idUser, String content, Date publishDate, Serializable photo) {
		Article art= new Article();
		art.setIdArticle(idArticle);
		art.setNomArticle(nomArticle);
		art.setKyewords(kyewords);
		art.setIdUser(idUser);
		art.setContent(content);
		art.setPublishDate(publishDate);
		art.setPhoto(photo);
		
		tx.begin();
		em.persist(art);
		tx.commit();
			
	}
	
	// validation
	public void validerArticle(Status st) {
		if (st.getPublished() == false) {
			st.setWaitingForValidaition(true);
		} else if (st.getPublished() == true) {
			st.setWaitingForValidaition(false);
		} else {
			st.setReportedAsAbsed(true);
		}
		tx.begin();
		em.merge(st);
		tx.commit();
	}
	
}
