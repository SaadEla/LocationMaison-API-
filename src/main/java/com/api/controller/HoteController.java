package com.api.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Hote;
import com.api.model.Location;
import com.api.repository.HoteRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/User")
public class HoteController {
	
	@Autowired
	HoteRepository hote;
	
	@PostMapping("/Insc")
	public Hote UserInscription(@RequestBody Hote formInscr) {
		
        return hote.save(formInscr);

	}
	
    //afficher un hote
    @GetMapping(value = "/hoteLocation/{id}")
    public Optional<Hote> getbyId(@PathVariable Long id) {
        return hote.findById(id);
    }
    



}