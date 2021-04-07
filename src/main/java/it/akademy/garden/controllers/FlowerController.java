package it.akademy.garden.controllers;


import it.akademy.garden.dao.FlowerDao;
import it.akademy.garden.models.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flowers")
public class FlowerController {

    private final FlowerDao flowerDao;

    @Autowired
    public FlowerController(FlowerDao flowerDao){
        this.flowerDao = flowerDao;
    }

    @GetMapping
    public ResponseEntity<List<Flower>> getAllFlowers(){
        List<Flower> flowers = flowerDao.findAll();
        return new ResponseEntity<>(flowers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flower> getById(@PathVariable int id){
        Flower flower = flowerDao.findById(id);
        if(flower == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(flower, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flower> createFlower(@RequestBody Flower flower){
        flowerDao.save(flower);
        return new ResponseEntity<>(flower, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlower(@PathVariable int id){
        Flower flower = flowerDao.findById(id);
        if(flower == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        flowerDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
