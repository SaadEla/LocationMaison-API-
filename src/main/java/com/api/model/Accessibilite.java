package com.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Accessibilite {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Long LocAcc_id;
    
    
    
	protected Accessibilite() {
    }



	public Accessibilite(String description, Long locAcc_id) {
		super();
		this.description = description;
		LocAcc_id = locAcc_id;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Long getLocAcc_id() {
		return LocAcc_id;
	}



	public void setLocAcc_id(Long locAcc_id) {
		LocAcc_id = locAcc_id;
	}



	@Override
	public String toString() {
		return "Accessibilite [id=" + id + ", description=" + description + ", LocAcc_id=" + LocAcc_id + "]";
	}

	
	
}
	



