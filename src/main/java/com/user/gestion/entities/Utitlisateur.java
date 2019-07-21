package com.user.gestion.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_users")
public class Utitlisateur {

	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private String prenom;
	private Integer age;
	private String mail;

	public Utitlisateur() {
		super();
	}

	public Utitlisateur(String nom, String prenom, Integer age, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.mail = mail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Utitlisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", mail=" + mail
				+ "]";
	}

}
