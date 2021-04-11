package it.akademy.barbecueapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Barbecue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @JsonManagedReference(value = "person-barbecue")
    @OneToMany
    //déclaration de la liste de Person PersoneList
    private List<Person> personList;

    //Construsteur Barbecue
    public Barbecue(int id, String name) {
        this.id = id;
        this.name = name;
        this.personList = new ArrayList<>();
    }

    // fonction anonyme Barbecue
    public Barbecue() {}

    //Getter de l'ID
    public int getId() {
        return id;
    }

    //Setter de l'ID
    public void setId(int id) {
        this.id = id;
    }

    //Getter de name
    public String getName() {
        return name;
    }

    //Setter de name
    public void setName(String name) {
        this.name = name;
    }

    //Getter de la list PersonList
    public List<Person> getPersonList() {
        return personList;
    }

    //Setter de la list personList
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
