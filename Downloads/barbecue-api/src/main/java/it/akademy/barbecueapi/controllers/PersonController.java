package it.akademy.barbecueapi.controllers;

import it.akademy.barbecueapi.dao.PersonDao;
import it.akademy.barbecueapi.models.Barbecue;
import it.akademy.barbecueapi.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/people")
public class PersonController {

    //déclaration de la variable personDao
    private final PersonDao personDao;

    //AutoWired sert à implément les beans and la class.
    @Autowired
    public PersonController(PersonDao gardenerDao){
        this.personDao = gardenerDao;
    }

    //Fonction pour récupérer tout le monde
    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople(){
        List<Person> people = personDao.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    //Fonction pour récupérer une personne par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id){
        Person person = personDao.findById(id);
        if(person == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    //Fonction pour créer une personne
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person addedPerson = personDao.save(person);
        return new ResponseEntity<>(addedPerson, HttpStatus.CREATED);
    }

    //Fonction pour effacer une information de la base de données en utilisant d'ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBarbecuesById(@PathVariable int id){
        Person person = personDao.findById(id);
        if(person == null){
            return new ResponseEntity<>(person, HttpStatus.NOT_FOUND);
        }
        personDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
