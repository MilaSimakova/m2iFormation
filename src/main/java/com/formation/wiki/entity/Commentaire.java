package com.formation.wiki.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commentaire implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idComment;
	@Temporal(TemporalType.DATE)
	private Date commentDate;
	private String comment;
	
	@OneToOne
	private Article article;
	
	public Integer getIdComment() {
		return idComment;
	}
	public void setIdComment(Integer idComment) {
		this.idComment = idComment;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
