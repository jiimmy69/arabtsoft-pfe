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

import com.ArabSoft.StagePfe.Models.Congee;
import com.ArabSoft.StagePfe.Services.CongeeService;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/congee")
public class CongeeController {

	
	@Autowired
	CongeeService congeeService;

	@GetMapping
	public List<Congee> getAllCongees(Congee c) {

		return congeeService.getAllCongees();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		congeeService.deleteCongeeById(id);
	}

	@GetMapping("/{id}")

	public Congee getCongeeById(@PathVariable Long id) {

		return congeeService.getCongeeById((long) id);
	}

	@PutMapping("/{id}")
	public Congee editCongee(@RequestBody Congee c) {

		return congeeService.editCongee(c);
	}

	@PostMapping
	public Congee addCongee(@RequestBody Congee c) {
		return congeeService.addCongee(c);
	}
	
}
