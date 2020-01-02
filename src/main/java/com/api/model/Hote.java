package com.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Hote {
    @Id
    @GeneratedValue
    private Long id;
    private String Nom;
    private String Prenom;
    private String email;
    private String password;
    private String typeCompte;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="LocHote_id", referencedColumnName="id")
    private List<Location> Locations;
    
    


	protected Hote() {
    }
	
	public Hote(String nom, String prenom, String email, String password, String typeCompte) {
		super();
		Nom = nom;
		Prenom = prenom;
		this.email = email;
		this.password = password;
		this.typeCompte = typeCompte;
	}
	
	public List<Location> getLocations() {
		return Locations;
	}

	public void setLocations(List<Location> locations) {
		Locations = locations;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	@Override
	public String toString() {
		return "Hote [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", email=" + email + ", password=" + password
				+ ", typeCompte=" + typeCompte + "]";
	}
    
    

}
