package com.user.gestion.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.user.gestion.entities.Utitlisateur;

@Component
public interface UtilisateurService {

	void creerUtilisateur(Utitlisateur utitlisateur);

	List<Utitlisateur> listerUtilisateur();
}
