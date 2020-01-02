package com.api.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;
import java.util.ListIterator;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;
    private String typeLocation;
    private String emplacement;
    private String titre;
    private Date dateDisponibilite;
    private String description;
    private int prix;
    private int nbrPiece;
    private byte[] pic;
    private float moyenne;//glt ze3ma n7seb moyenne mn liste li lta7t
    
    private Long LocHote_id;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="LocRat_id", referencedColumnName="id")
    private List<Rating> Ratings;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="LocEq_id", referencedColumnName="id")
    private List<Equipement> Equipement;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="LocReg_id", referencedColumnName="id")
    private List<Reglement> Reglement;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="LocAcc_id", referencedColumnName="id")
    private List<Accessibilite> Accessibilite;
    
	
    

	protected Location() {
    }


    
	public Location(String typeLocation, String emplacement, String titre, Date dateDisponibilite,
			String description, int prix, int nbrPiece, byte[] pic, float moyenne, Long locHote_id) {
		super();
		this.id = id;
		this.typeLocation = typeLocation;
		this.emplacement = emplacement;
		this.titre = titre;
		this.dateDisponibilite = dateDisponibilite;
		this.description = description;
		this.prix = prix;
		this.nbrPiece = nbrPiece;
		this.pic = pic;
		this.moyenne = moyenne;
		LocHote_id = locHote_id;
	}



	public Long getLocHote_id() {
		return LocHote_id;
	}

	public void setLocHote_id(Long locHote_id) {
		LocHote_id = locHote_id;
	}
  
    
    public List<Accessibilite> getAccessibilite() {
		return Accessibilite;
	}

	public void setAccessibilite(List<Accessibilite> accessibilite) {
		Accessibilite = accessibilite;
	}

	public List<Reglement> getReglement() {
		return Reglement;
	}

	public void setReglement(List<Reglement> reglement) {
		Reglement = reglement;
	}

	public List<Equipement> getEquipement() {
		return Equipement;
	}

	public void setEquipement(List<Equipement> equipement) {
		Equipement = equipement;
	}

	public float getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(float moyenne) {
		List<Rating> list=getRatings();
		 ListIterator<Rating> it = list.listIterator();
		 int totale=0;
	     while(it.hasNext()){
	    	 Rating rat=it.next();
	    	 int note=rat.getNote();
	    	 totale=totale+note;
	     }
	     System.out.println("kan dreb tlila mera mera"); 
	     moyenne=(float)totale/(list.size());
		this.moyenne = moyenne;
	}

	public List<Rating> getRatings() {
		return Ratings;
	}

	public void setRatings(List<Rating> Ratings) {
		this.Ratings = Ratings;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTypeLocation() {
		return typeLocation;
	}


	public void setTypeLocation(String typeLocation) {
		this.typeLocation = typeLocation;
	}


	public String getEmplacement() {
		return emplacement;
	}


	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public Date getDateDisponibilite() {
		return dateDisponibilite;
	}


	public void setDateDisponibilite(Date dateDisponibilite) {
		this.dateDisponibilite = dateDisponibilite;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public int getNbrPiece() {
		return nbrPiece;
	}


	public void setNbrPiece(int nbrPiece) {
		this.nbrPiece = nbrPiece;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", typeLocation=" + typeLocation + ", emplacement=" + emplacement + ", titre="
				+ titre + ", dateDisponibilite=" + dateDisponibilite + ", description=" + description + ", prix=" + prix
				+ ", nbrPiece=" + nbrPiece + ", pic=" + Arrays.toString(pic) + "]";
	}





}
