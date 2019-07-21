package com.user.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.user.gestion.dao.UtilisateurRepository;
import com.user.gestion.entities.Utitlisateur;

@SpringBootApplication
public class GestionUtilisateurApplication implements CommandLineRunner {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	public static void main(String[] args) {

		SpringApplication.run(GestionUtilisateurApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Utitlisateur safa = new Utitlisateur("Rabhi", "Safa", 26, "safa.rabhi@gmail.com");
		Utitlisateur imene = new Utitlisateur("Rabhi", "Imene", 26, "imene.rabhi@gmail.com");
		Utitlisateur mohamed = new Utitlisateur("Chouaibi", "Mohamed", 26, "safa.rabhi@gmail.com");
		Utitlisateur melek = new Utitlisateur("Saadi", "Melek", 26, "safa.rabhi@gmail.com");
		utilisateurRepository.save(safa);
		utilisateurRepository.save(imene);
		utilisateurRepository.save(mohamed);
		utilisateurRepository.save(melek);
		List<Utitlisateur> utitlisateurs = utilisateurRepository.findAll();
		for (int i = 0; i < utitlisateurs.size(); i++) {
			System.out.println(utitlisateurs.get(i));
		}

	}

}
