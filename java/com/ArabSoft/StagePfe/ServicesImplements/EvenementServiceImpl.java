package com.ArabSoft.StagePfe.ServicesImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArabSoft.StagePfe.Models.Evenement;
import com.ArabSoft.StagePfe.Repositorys.EvenementRepository;
import com.ArabSoft.StagePfe.Services.EvenementService;


@Service
public class EvenementServiceImpl implements EvenementService {

	
	@Autowired
	EvenementRepository evenementRepository;
	
	@Override
	public List<Evenement> getAllEvenements() {
		// TODO Auto-generated method stub
		return (List<Evenement>) evenementRepository.findAll();
	}

	@Override
	public Evenement addEvenement(Evenement e) {
		// TODO Auto-generated method stub
		return evenementRepository.save(e);
	}

	@Override
	public void deleteEvenementById(Long id) {
		evenementRepository.deleteById(id);
		
	}

	@Override
	public Evenement editEvenement(Evenement e) {
		// TODO Auto-generated method stub
		return evenementRepository.save(e);
	}

	@Override
	public Evenement getEvenementById(Long id) {
		// TODO Auto-generated method stub
		Optional<Evenement> event = evenementRepository.findById(id);
		return event.isPresent() ? event.get() : null;
	}

}
