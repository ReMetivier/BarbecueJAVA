package it.akademy.barbecueapi.dao;

import it.akademy.barbecueapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {
    //appel Fonction de recherche de tous les éléments de la liste Person
    List<Person> findAll();

    //appel Fonction de recherche par ID de la liste Person
    Person findById(int id);

    // appel fonction save qui permet d'enregistrer people dans la base de donnée
    Person save(Person people);

    // appel fonction qui permet d'effacer une information à partir de son ID
    void deleteById(int id);
}
