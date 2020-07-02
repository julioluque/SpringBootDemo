package com.jluque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jluque.model.Persona;
import com.jluque.repo.IPersonaRepo;

@Controller
public class DemoController {

	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/home")
	public String inicio(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {

		Persona p = new Persona();
		p.setId(2); 
		p.setNombre("Julio");
		
		repo.save(p);
		
		model.addAttribute("name", name);
		return "inicio";
	}

	
	@GetMapping("/mostrar")
	public String mostrar(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {

		List <Persona> personas = repo.findAll();
		
		model.addAttribute("personas", personas);
		return "inicio";
	}

}
