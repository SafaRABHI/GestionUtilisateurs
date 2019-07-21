package com.user.gestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.user.gestion.entities.Utitlisateur;

public interface UtilisateurRepository extends JpaRepository<Utitlisateur, Integer>{

	@Query("select u from Utitlisateur u where u.id=:id")
	Utitlisateur checherUtilisateur(@Param("id") Integer id);
}
