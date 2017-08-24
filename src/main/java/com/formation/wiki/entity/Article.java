package com.formation.wiki.entity;

import java.io.Serializable;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="SelectAllArticles", query="SELECT art FROM Article art"),
	@NamedQuery(name="SelectArticIdUserNotNull", query="SELECT art FROM Article art WHERE art.idUser IS NOT NULL")
})
public class Article implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idArticle;
	@Column(name="Title")
	private String nomArticle;
	private String kyewords;
	private int idUser;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	@Lob
	@Column(name="PHOTO")
	private Serializable photo;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	@OneToMany(fetch=FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	@OneToOne
	private Status status;	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}	

	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getKyewords() {
		return kyewords;
	}

	public void setKyewords(String kyewords) {
		this.kyewords = kyewords;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Serializable getPhoto() {
		return photo;
	}

	public void setPhoto(Serializable photo) {
		this.photo = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
