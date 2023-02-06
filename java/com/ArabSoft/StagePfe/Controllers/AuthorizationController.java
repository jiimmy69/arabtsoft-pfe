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

import com.ArabSoft.StagePfe.Models.Authorization;
import com.ArabSoft.StagePfe.Services.AuthorizationService;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/authorization")
public class AuthorizationController {


	@Autowired
	AuthorizationService authorizationService;

	@GetMapping
	public List<Authorization> getAllCongees(Authorization a) {

		return authorizationService.getAllAuthorization();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		authorizationService.deleteAuthorizationById(id);
	}

	@GetMapping("/{id}")

	public Authorization getAuthorizationById(@PathVariable Long id) {

		return authorizationService.getAuthorizationById((long) id);
	}

	@PutMapping("/{id}")
	public Authorization editAuthorization(@RequestBody Authorization a) {

		return authorizationService.editAuthorization(a);
	}

	@PostMapping
	public Authorization addAuthorization(@RequestBody Authorization a) {
		return authorizationService.addAuthorization(a);
	}
	
}
