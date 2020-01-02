package com.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Reglement {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Long LocReg_id;
    
    
    
	protected Reglement() {
    }

	public Reglement(String description, Long locReg_id) {
		super();
		this.description = description;
		LocReg_id = locReg_id;
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



	public Long getLocReg_id() {
		return LocReg_id;
	}



	public void setLocReg_id(Long locReg_id) {
		LocReg_id = locReg_id;
	}

	@Override
	public String toString() {
		return "Reglement [id=" + id + ", description=" + description + ", LocReg_id=" + LocReg_id + "]";
	}




	
	

}
	



