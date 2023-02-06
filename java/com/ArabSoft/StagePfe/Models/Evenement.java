package com.ArabSoft.StagePfe.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "evenement")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Evenement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String NomEvenement;
	private String Lieu ; 
	private String Date ;
	private String Time ;
	private String Description;
	
	@ManyToMany(mappedBy = "evenements")
	  private List<User> users = new ArrayList<>();
	
}
