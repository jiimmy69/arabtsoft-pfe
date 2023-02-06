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

import com.ArabSoft.StagePfe.Models.NotreServices;
import com.ArabSoft.StagePfe.Services.NotreServicesService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/notreservices")
public class NotreServicesController {


	@Autowired
	NotreServicesService notreServicesService;

	@GetMapping
	public List<NotreServices> getAllServices(NotreServices s) {

		return notreServicesService.getAllNotreServices();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		notreServicesService.deleteNotreServicesById(id);
	}

	@GetMapping("/{id}")

	public NotreServices getServiceById(@PathVariable Long id) {

		return notreServicesService.getNotreServicesById((long) id);
	}

	@PutMapping("/{id}")
	public NotreServices editService(@RequestBody NotreServices s) {

		return notreServicesService.editNotreServices(s);
	}

	@PostMapping
	public NotreServices addService(@RequestBody NotreServices s) {
		return notreServicesService.addNotreServices(s);
	}
	
}
