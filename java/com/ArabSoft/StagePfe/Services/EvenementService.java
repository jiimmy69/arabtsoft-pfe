package com.ArabSoft.StagePfe.Services;

import java.util.List;

import com.ArabSoft.StagePfe.Models.Evenement;



public interface EvenementService {

	public List<Evenement> getAllEvenements();

	public Evenement addEvenement(Evenement e);

	public void deleteEvenementById(Long id);

	public Evenement editEvenement(Evenement e);

	public Evenement getEvenementById(Long id);
	
}
