package it.akademy.barbecueapi.dao;

import it.akademy.barbecueapi.models.Barbecue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarbecueDao extends JpaRepository<Barbecue, Integer> {

    //Fonction de recherche de tous les éléments de la liste Person
    List<Barbecue> findAll();

    List<Barbecue> findAllByName(String name);

    //appel Fonction de recherche par ID de la liste Person
    Barbecue findById(int id);

    // appelfonction save qui permet d'enregistrer people dans la base de donnée
    Barbecue save(Barbecue barbecue);

    // appel fonction qui permet d'effacer une information à partir de son ID
    void deleteBarbecuesById(int id);
}
