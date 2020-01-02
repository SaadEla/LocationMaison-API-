package com.api.controller;



import java.io.IOException;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.model.Hote;
import com.api.model.Location;
import com.api.model.Message;
import com.api.repository.HoteRepository;
import com.api.repository.MessageRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/Message")
public class MessageController {
	
	@Autowired
	MessageRepository msg;
	
	
	//Recuperer les message de l'hote saad
	@GetMapping("/MsgHote")
	public List<Message> MessageHote() {
        return msg.getMessHote();

	}
	
	//Recuperer les message du touriste rizk
	@GetMapping("/MsgTouriste")
	public List<Message> MessageTouriste() {
        return msg.getMessTouriste();

	}
	
    //Pour supprimer un message
	@DeleteMapping("/DeleteMsg/{id}")
	public ResponseEntity<Void> deleteMessage(@PathVariable("id") Long id) { 
		msg.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	//Envoyer Message
	 @PostMapping("/EnvoyerMsg")
	 public String EnvoyerMessage(@RequestParam("emetteur") String emetteur, @RequestParam("destinataire") String destinataire, @RequestParam("contenu") String contenu) throws IOException {
		 
		 Message Mesg=new Message(emetteur,destinataire,contenu) ;
		 msg.save(Mesg);
		 return "Message bien enregistrée";
	 }



}