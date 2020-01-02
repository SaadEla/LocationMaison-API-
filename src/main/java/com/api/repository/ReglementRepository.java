package com.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Reglement;
//import org.springframework.data.repository.CrudRepository;



public interface ReglementRepository extends JpaRepository<Reglement, Long>{



}
