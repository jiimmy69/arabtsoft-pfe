package com.ArabSoft.StagePfe.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "congee")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Congee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	  @Column(length = 20)
	private String typeConge;
	 private int nombreJours;

	 @ManyToMany(mappedBy = "conges")
	  private List<User> users = new ArrayList<>();
	
}


