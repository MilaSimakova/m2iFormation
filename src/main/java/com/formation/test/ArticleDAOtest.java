package com.formation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.formation.wiki.ConnectionManager;
import com.formation.wiki.dao.ArticleDAO;




public class ArticleDAOtest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	

	@Test (expected = SmallIdArticleExeption.class)
	public void AjouterArticle() throws SmallIdArticleExeption {
		
		//exception.expect(MySQLIntegrityConstraintViolationException.class);
		assertNotNull(ConnectionManager.getConnexion());
		
		int nbreArticleAvantInsertion=ArticleDAO.getArticle().size();
		ArticleDAO.AjouterArticle(5, "Title 1", 5, "Content 1");
		//Comparaison du nombre d'article avant et après insertion
		assertEquals(nbreArticleAvantInsertion+1, ArticleDAO.getArticle().size());
		
		int nbreArticleAvantInsertion2=ArticleDAO.getArticle().size();
		ArticleDAO.AjouterArticle(10, null, 45, null);
		//Comparaison du nombre d'article avant et après insertion
		assertEquals(nbreArticleAvantInsertion2+1, ArticleDAO.getArticle().size());
		
	}
	
	@Test
	public void getArticle() {
		int numberOfArticles = ArticleDAO.getArticle().size();
		assertNotEquals(0, numberOfArticles);
	}
	
	@Test
	public void getArticleById() {
		
	}

}
