package com.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String emetteur;
    private String recepteur;
    private String contenu;
    
    
	protected Message() {
    }
	
	public Message(String emetteur, String recepteur, String contenu) {
		super();
		this.emetteur = emetteur;
		this.recepteur = recepteur;
		this.contenu = contenu;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmetteur() {
		return emetteur;
	}


	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}


	public String getRecepteur() {
		return recepteur;
	}


	public void setRecepteur(String recepteur) {
		this.recepteur = recepteur;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", emetteur=" + emetteur + ", recepteur=" + recepteur + ", contenu=" + contenu
				+ "]";
	}

	


	
	

}
	



