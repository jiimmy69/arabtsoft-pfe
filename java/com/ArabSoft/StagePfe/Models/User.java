package com.ArabSoft.StagePfe.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {
	
	//Attributes and conditions
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String adresse;
	@NotBlank
	private String dateNaissance;
	@NotBlank
	private String dateDebut;
	@NotBlank
	private String ville;
	@NotBlank
	private String gender;
	@NotBlank
	private String matricule;
	@NotBlank
	private String codeService;
	@NotBlank
	@Size(min = 8, max = 8)
	@Pattern(regexp="^[0-9]*$")
	private String telephoneNumber;
	@NotBlank
	@Pattern(regexp="^[0-9]+(\\.[0-9]+)?$")
	private String salaire;
	private String password;
	
	//one/many to many conditions
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(name = "user_service",
     joinColumns = { @JoinColumn(name = "matricule") },
     inverseJoinColumns = { @JoinColumn(name = "service_id") })
	 
	 private Set<NotreServices> services = new HashSet<>();

	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	            name = "user_conges",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "conge_id")
	    )
	    private Set<Congee> conges;
	
	//constructors
	public User(String firstName, String lastName, String email, String adresse
			,String dateNaissance,String dateDebut,String ville,String gender
			,String matricule,String codeService,String telephoneNumber,String salaire, String password ) {
		
		this.firstName = firstName; 			this.lastName = lastName;
		this.email = email; 					this.adresse=adresse;
		this.dateNaissance=dateNaissance;		this.dateDebut=dateDebut;
		this.ville=ville;						this.gender=gender;
		this.matricule=matricule;				this.codeService=codeService;
		this.telephoneNumber=telephoneNumber;	this.salaire=salaire;
							
								this.password = password;
		
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", adresse=" + adresse + ", dateNaissance=" + dateNaissance + ", dateDebut=" + dateDebut + ", ville="
				+ ville + ", gender=" + gender + ", matricule=" + matricule + ", codeService=" + codeService
				+ ", telephoneNumber=" + telephoneNumber + ", salaire=" + salaire + ", password=" + password
				+ ", roles=" + roles + "]";
	}








	
	
}