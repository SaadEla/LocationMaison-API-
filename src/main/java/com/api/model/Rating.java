package com.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Long id;
    private int note;
    private String commentaire;
    private Long LocRat_id;
    private String nomPers;
    
	protected Rating() {
    }
	
	
	public Rating(Long id, int note, String commentaire, Long LocRat_id, String nomPers) {
		super();
		this.id = id;
		this.note = note;
		this.commentaire = commentaire;
		this.LocRat_id = LocRat_id;
		this.nomPers=nomPers;
	}



	public String getNomPers() {
		return nomPers;
	}


	public void setNomPers(String nomPers) {
		this.nomPers = nomPers;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getNote() {
		return note;
	}



	public void setNote(int note) {
		this.note = note;
	}



	public String getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



	public Long getLocRat_id() {
		return LocRat_id;
	}



	public void setLocRat_id(Long LocRat_id) {
		this.LocRat_id = LocRat_id;
	}


	@Override
	public String toString() {
		return "Rating [id=" + id + ", note=" + note + ", commentaire=" + commentaire + ", LocRat_id=" + LocRat_id
				+ ", nomPers=" + nomPers + "]";
	}




	
	


}
