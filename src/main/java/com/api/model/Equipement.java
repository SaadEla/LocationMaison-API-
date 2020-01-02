package com.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Equipement {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Long LocEq_id;
    
    
    
	public Equipement( String description, Long locEq_id) {
		super();
		this.description = description;
		LocEq_id = locEq_id;
	}

	protected Equipement() {
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

	public Long getLocEq_id() {
		return LocEq_id;
	}

	public void setLocEq_id(Long locEq_id) {
		LocEq_id = locEq_id;
	}

	@Override
	public String toString() {
		return "Equipement [id=" + id + ", description=" + description + ", LocEq_id=" + LocEq_id + "]";
	}
	
	
}
	



