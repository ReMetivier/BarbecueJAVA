package it.akademy.garden.dao;

import it.akademy.garden.models.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowerDao extends JpaRepository<Flower, Integer> {

    @Override
    List<Flower> findAll();

    //Flower findById(int id);
}
