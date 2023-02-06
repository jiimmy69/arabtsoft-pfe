package com.ArabSoft.StagePfe.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ArabSoft.StagePfe.Models.Evenement;
import com.ArabSoft.StagePfe.Services.EvenementService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/evenements")
public class EvenementController {

	@Autowired
	EvenementService evenementService;

	@GetMapping
	public List<Evenement> getAllEvenements(Evenement e) {

		return evenementService.getAllEvenements();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		evenementService.deleteEvenementById(id);
	}

	@GetMapping("/{id}")

	public Evenement getEvenementById(@PathVariable Long id) {

		return evenementService.getEvenementById((long) id);
	}

	@PutMapping("/{id}")
	public Evenement editEvenement(@RequestBody Evenement e) {

		return evenementService.editEvenement(e);
	}

	@PostMapping
	public Evenement addEvenement(@RequestBody Evenement e) {
		return evenementService.addEvenement(e);
	}
}
