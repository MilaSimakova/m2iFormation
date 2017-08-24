package com.formation.wiki;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.formation.wiki.dao.ArticleDAO;
import com.formation.wiki.dao.UserDAO;
import com.formation.wiki.entity.Article;
import com.formation.wiki.entity.User;


public class Main {

	public static void main(String[] args) throws TimeoutException, SQLException {
		
		User user=new User();
		user.setLogin("Admin3");
		user.setPassword("3030");
		user.setNom("John2");
		user.setPrenom("Doe2");
		user.setEmail("xxx@xxx");
		user.setTel("33783000000");
		user.setActiver(true);	
		UserDAO dao = new UserDAO();
		dao.addUser(user);
		
		try {
			System.out.println(dao.isUserExist("Admin3", "3030"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(dao.findbyId(1).getActiver());
		dao.changerEtatUser(dao.findbyId(1));
		System.out.println(dao.findbyId(1).getActiver());
		
		
		
//		ArticleDAO.AjouterArticle(11, "Tale", 77, "Text2, text2, text2." );
		
//		List<User> listUser = UserDAO.getUser();	
//		System.out.println("List of users :");
//		for (User u: listUser){
//			System.out.println(u.toString());
//		}
//		
//		List<Article> listArt = ArticleDAO.getArticle();	
//		System.out.println("List of Articles :");
//		for (Article art: listArt){
//			System.out.println(art.toString());
//		}
//		
//		List<Article> listArtID = ArticleDAO.getArticle();	
//		System.out.println("List of Articles :");
//		for (Article artID: listArtID){
//			System.out.println(artID.toString());
//		}
//		
//		if (UserDAO.isUserExist("Liuda","123")) {
//			System.out.println("User exist");
//		} else {
//			System.out.println("User do not exist");
//		}
		
	}
}
