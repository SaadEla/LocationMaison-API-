package com.api.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Hote;
//import org.springframework.data.repository.CrudRepository;



public interface HoteRepository extends JpaRepository<Hote, Long>{

	
}
