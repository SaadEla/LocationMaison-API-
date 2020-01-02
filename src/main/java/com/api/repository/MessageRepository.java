package com.api.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.api.model.Message;
//import org.springframework.data.repository.CrudRepository;



public interface MessageRepository extends JpaRepository<Message, Long>{

    @Query(value ="SELECT * FROM message  WHERE recepteur='Elaouani Saad'", nativeQuery = true)
    public List<Message> getMessHote();
    
    @Query(value ="SELECT * FROM message  WHERE recepteur='rizk makroum'", nativeQuery = true)
    public List<Message> getMessTouriste();
}
