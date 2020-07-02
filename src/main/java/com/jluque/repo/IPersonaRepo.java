package com.jluque.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jluque.model.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Integer>{

}
