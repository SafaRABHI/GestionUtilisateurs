package com.user.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.user.gestion.dao.UtilisateurRepository;
import com.user.gestion.entities.Utitlisateur;

public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public void creerUtilisateur(Utitlisateur utitlisateur) {
		utilisateurRepository.save(utitlisateur);
	}

	@Override
	public List<Utitlisateur> listerUtilisateur() {
		return utilisateurRepository.findAll();
	}

}
