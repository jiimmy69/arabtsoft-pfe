package com.ArabSoft.StagePfe.Models;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignupRequest {
	@NotBlank
	@Size(min = 3)
	private String firstName;

	@NotBlank
	@Size(min = 5)
	private String lastName;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 3)
	private String adresse;

	@NotBlank
	@Size(min = 3)
	private String dateNaissance;

	@NotBlank
	@Size(min = 3)
	private String dateDebut;
	@NotBlank
	@Size(min = 3)
	private String ville;
	@NotBlank
	@Size(min = 3)
	private String gender;
	@NotBlank
	@Size(min = 3)
	private String matricule;
	@NotBlank
	@Size(min = 3)
	private String codeService;
	@NotBlank
	@Size(min = 8, max = 8)
	@Pattern(regexp = "^[0-9]*$")
	private String telephoneNumber;

	@NotBlank
	
	@Pattern(regexp = "^[0-9]+(\\.[0-9]+)?$")
	private String salaire;

	private Set<String> role;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	
}