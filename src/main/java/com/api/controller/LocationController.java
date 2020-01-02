package com.api.controller;

import java.io.IOException;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.model.Accessibilite;
import com.api.model.Equipement;
import com.api.model.Location;
import com.api.model.Reglement;
import com.api.repository.AccessibiliteRepository;
import com.api.repository.EquipementRepository;
import com.api.repository.LocationRepository;
import com.api.repository.ReglementRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    LocationRepository location;
    @Autowired
    EquipementRepository equipp;
    @Autowired
    AccessibiliteRepository acc;
    @Autowired
    ReglementRepository reg;

    
    //afficher toute les locations
    @GetMapping(value = "/all")
    public List<Location> getAll() {
    	System.out.println("Location affich�e");
        return location.findAll();
    }
    
    //afficher recommendations
    @GetMapping(value = "/recommendations")
    public List<Location> getRecomm() {
    	
        PythonInterpreter pyInterp = new PythonInterpreter();
            pyInterp.exec("get_similar_housing(itemId,user_rating):\r\n" + 
            		"    similar_score = item_similarity_df[itemId]*(user_rating-2.5)\r\n" + 
            		"    similar_score = similar_score.sort_values(ascending=False)\r\n" + 
            		"    return similar_score\r\n" + 
            		"print(get_similar_housing(\"housing2\",1))");
            
            return location.getRecom();
   }
    
    
    //afficher une location
    @GetMapping(value = "/choosen/{id}")
    public Optional<Location> getbyId(@PathVariable Long id) {
    	System.out.println("1 Location affich�e"); 
        return location.findById(id);
    }
    
  //afficher meilleurs location
    @GetMapping(value = "/best")
    public List<Location> getbest() {
    	System.out.println("Location best affich�e");
        return location.getbest();
    }
    

    //Pour ajouter une location
    @PostMapping("/upload")
    public String uplaodOffre(@RequestParam("titre") String titre, @RequestParam("type") String type, @RequestParam("adresse") String adresse, @RequestParam("description") String description,@RequestParam("prix") int prix, @RequestParam("nbrpiece") int nbrpiece, @RequestParam("myFile") MultipartFile file, @RequestParam("equipements") String equipements,  @RequestParam("accessibilites") String accessibilites ,  @RequestParam("reglements") String reglements  ) throws IOException {
    
    //Pour remplir les suggestions o l3ibat
    Long locatid;
    	
    //Upload location
   	 Date date = new Date();
   	 float moyenne = 0;
       Location locat = new Location(type,adresse,titre,date,description,prix,nbrpiece,file.getBytes(),moyenne,(long)25);//hillo
       final Location savedLocation = location.save(locat);
       locatid=savedLocation.getId();
       System.out.println("Location saved");
       
    //Upload Equipement
       String[] equip = equipements.split(",");
       for(int i=0;i<equip.length;i++) {
       	Equipement equipement=new Equipement( equip[i], locatid);
       	equipp.save(equipement);
       	}
       System.out.println("Equipement saved");

    //Upload Accessibilite
       String[] access = accessibilites.split(",");
       for(int i=0;i<access.length;i++) {
       	Accessibilite accessibilite=new Accessibilite( access[i], locatid);
       	acc.save(accessibilite);
       	}
       System.out.println("Accessibilite saved");
    //Upload reglement
       String[] regle = reglements.split(",");
       for(int i=0;i<regle.length;i++) {
       	Reglement reglement=new Reglement( regle[i], locatid);
       	Reglement savedReglement = reg.save(reglement);
       	}
       System.out.println("Reglement saved");
       
       
       return "Offre bien enregistrée";

   }
    
    //Pour supprimer une location dans le menu de l'hote
	@DeleteMapping("/deleteLocation/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) { 
		location.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	//Pour modifier une location
    @PutMapping("/update")
    public String updateOffre(@RequestParam("id") Long id, @RequestParam("titre") String titre, @RequestParam("type") String type/*, @RequestParam("equipements") String equipements*/) throws IOException {
    	System.out.println("ana ");
    	//updateLocation
    	Location Location = location.get(id);
    	//List<Equipement> equipement=equipp.getEq(id);
    	if(titre.length()!=0) {
    		Location.setTitre(titre);
    	}
    	if(type.length()!=0) {
    		Location.setTypeLocation(type);
    	}
    	location.save(Location);
    	/*updateEquipement
    	if(equipements.length()!=0) {
	       String[] equip = equipements.split(",");
	       for(int i=0;i<equip.length;i++) {
	       	equipement.setDescription(equip[i]);
	       	equipp.save(equipement);
	       	}
    	}*/
    	

    	

       
       
       return "Offre bien modifiée";

   }
	/*@PutMapping("/dossiers/{id}")
	public ResponseEntity<Dossier> updateDossier(@PathVariable(value = "id") Long dossierId,
			@Valid @RequestBody Dossier dossierDetails) throws ResourceNotFoundException {
		Dossier dossier = dossierRepository.findById(dossierId)
				.orElseThrow(() -> new ResourceNotFoundException("Dossier not found for this id :: " + dossierId));

		dossier.setDate(dossierDetails.getDate());
		dossier.setNomPatient(dossierDetails.getNomPatient());
		dossier.setNumDossier(dossierDetails.getNumDossier());
		dossier.setTelPatient(dossierDetails.getTelPatient());
		final Dossier updatedDossier = dossierRepository.save(dossier);
		return ResponseEntity.ok(updatedDossier);
	}*/



}