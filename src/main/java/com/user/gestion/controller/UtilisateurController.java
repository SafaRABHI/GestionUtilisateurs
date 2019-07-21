package com.user.gestion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.user.gestion.dao.UtilisateurRepository;
import com.user.gestion.entities.Utitlisateur;

@Controller
public class UtilisateurController {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@RequestMapping(path = "/safa", method = RequestMethod.GET)
	public String getIndex(Model model) {
		List<Utitlisateur> utitlisateurs = utilisateurRepository.findAll();
		model.addAttribute("users", utitlisateurs);
		Utitlisateur utitlisateur = new Utitlisateur();
		model.addAttribute("utitlisateur", utitlisateur);
		return "index";
	}

	@GetMapping(path = "/add")
	public String createUtilisateur(Model model) {
		Utitlisateur utitlisateur = new Utitlisateur();
		model.addAttribute("utitlisateur", utitlisateur);
		return "add";
	}

	@GetMapping(path = "/edit/{id}")
	public String editUtilisateur(@PathVariable Integer id, Model model) {
		Utitlisateur utitlisateur = utilisateurRepository.checherUtilisateur(id);
		model.addAttribute("utilisateur", utitlisateur);
		return "edit";
	}

	@RequestMapping(path = "/adduser", method = RequestMethod.POST)
	public String adduser(@ModelAttribute(name = "utitlisateur") Utitlisateur user, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", "Failed");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");

		if (result.hasErrors()) {
			return "index";
		}
		redirectAttributes.addFlashAttribute("message", "Success");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		utilisateurRepository.save(user);
		return "redirect:/safa";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
	public String updateUser(@PathVariable("id") Integer id, @Valid Utitlisateur user, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "index";
		}
		utilisateurRepository.save(user);
		return "redirect:/safa";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		Utitlisateur user = utilisateurRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		utilisateurRepository.delete(user);
		return "redirect:/safa";
	}

}
