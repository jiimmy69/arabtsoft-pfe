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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Autho")

public class Authorization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String personnel;
	private String Date;
	private String HeurDebut ;
	private String HeurFin;
	
	 @ManyToMany(mappedBy = "authorizations")
	  private List<User> users = new ArrayList<>();
}
