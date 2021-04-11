package it.akademy.barbecueapi.controllers;

import it.akademy.barbecueapi.dao.BarbecueDao;
import it.akademy.barbecueapi.dao.PersonDao;
import it.akademy.barbecueapi.models.Barbecue;
import it.akademy.barbecueapi.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbecues")

    //déclaration de la class BarbecueController.
    public class BarbecueController {

    //déclaration des variables.
    private final BarbecueDao barbecueDao;
    private final PersonDao personDao;

    //cosntructeur du BarbecueController
    @Autowired
    public BarbecueController(BarbecueDao barbecueDao, PersonDao personDao){
        this.barbecueDao = barbecueDao;
        this.personDao = personDao;
    }

    //fonction permettant de récuperer la liste complète des barbecues
    @GetMapping
    public ResponseEntity<List<Barbecue>> getAllBarbecues(){
        List<Barbecue> barbecues = barbecueDao.findAll();
        return new ResponseEntity<>(barbecues, HttpStatus.OK);
    }

    //fonction permettant de récupérer tous les barbecues correspondant au nom entré dans la requête
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Barbecue>> getAllBarbecuesByName(@PathVariable String name){
        List<Barbecue> barbecues = barbecueDao.findAllByName(name);
        return new ResponseEntity<>(barbecues, HttpStatus.OK);
    }

    //fonction permettant de récupérer un barbecue par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Barbecue> getBarbecueById(@PathVariable int id){
        Barbecue barbecue = barbecueDao.findById(id);
        if(barbecue == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(barbecue, HttpStatus.OK);
    }

    //Fonction pour effacer une information de la base de données en utilisant d'ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBarbecuesById(@PathVariable int id){
      Barbecue barbecue = barbecueDao.findById(id);
      if(barbecue == null){
          return new ResponseEntity<>(barbecue, HttpStatus.NOT_FOUND);
      }
      barbecueDao.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
