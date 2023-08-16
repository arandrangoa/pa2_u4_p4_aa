package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {

	@Autowired
	private IPropietarioService iPropietarioService;
	
	@PostMapping("/registra")
	private String registarPropietario(Propietario propietario) {
		return "vistaNuevoPropietario";
	}
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		
		List<Propietario> lista=this.iPropietarioService.buscarTodos();
		modelo.addAttribute("propietarios", lista);
		return "vistaListaPropietarios";
	}
	
}
