package com.formation.test;

public class SmallIdArticleExeption extends Exception{
	
	private static final long serialVertionUID = 1L;
	
	private int idArticle;
	private String nomArticle;
	private int idUser;
	private String content;
	
	public SmallIdArticleExeption(int idArticle, String nomArticle, int idUser, String content) {
		super();
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.idUser = idUser;
		this.content = content;
	}

	@Override
	public String toString() {
		return "IdArticle est < 100";
	}

}
