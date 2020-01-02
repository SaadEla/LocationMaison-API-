package com.api.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import org.springframework.data.repository.CrudRepository;
import com.api.model.Location;


public interface LocationRepository extends JpaRepository<Location, Long>{


    @Query(value ="SELECT * FROM location  WHERE moyenne >= 4", nativeQuery = true)
    public List<Location> getbest();
    
    @Query(value ="SELECT * FROM location  WHERE emplacement='Barcelone'", nativeQuery = true)
    public List<Location> getRecom();
    
    public Optional<Location> findById(Long id);
    
    @Query(value ="SELECT * FROM location  WHERE id=?1", nativeQuery = true)
    public Location get(Long id);
    
	public void deleteById(Long id);
}
