package it.akademy.barbecueapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Person {
    //donne un ID à la classe Person
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //Liaison entre la table person et la barbecue
    @JsonBackReference(value = "person-barbecue")
    @ManyToOne
    //créait l'attribut barbecue de la class Barbecue
    private Barbecue barbecue;

    //Créait l'attribut id de la class Person
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //fonction annonyme Person
    public Person() {}

    //Créait de Getter pour l'ID de Person
    public int getId() {
        return id;
    }

    //Créait le setter de l'ID de Person
    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Créait le Getter de Barbecue
    public Barbecue getBarbecue() {
        return barbecue;
    }

    //Créait le setter de Barbecue
    public void setBarbecue(Barbecue barbecue) {
        this.barbecue = barbecue;
    }

}
