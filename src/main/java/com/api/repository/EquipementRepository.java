package com.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.model.Equipement;
//import org.springframework.data.repository.CrudRepository;
import com.api.model.Location;



public interface EquipementRepository extends JpaRepository<Equipement, Long>{

   /* @Query(value ="SELECT * FROM equipement  WHERE loc_eq_id=?1", nativeQuery = true)
    public List<Equipement> getEq(Long id);*/

}
