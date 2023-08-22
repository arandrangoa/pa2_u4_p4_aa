package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//http://localhost:8080/concesionario/propietarios/buscarPorId/1
	@GetMapping("/buscarPorId/{idPropietario}")
	public String buscarPorId(@PathVariable("idPropietario") Integer id, Model modelo) {
		Propietario prop=this.iPropietarioService.buscar(id);
		modelo.addAttribute("propietario",prop);	
		return "vistaPropietario";
	}
	
	@PutMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(@PathVariable("idPropietario") Integer id, Propietario propietario) {
		this.iPropietarioService.modificar(propietario);
		
		return "redirect:/propietarios/buscar";
	}
	
	//http://localhost:8080/concesionario/propietarios/borrar/1
	@DeleteMapping("/borrar/{idPropietario}")
	public String eliminarPorId(@PathVariable("idPropietario") Integer id) {
		this.iPropietarioService.borrar(id);
		return "redirect:/propietarios/buscar";
	}
	
	@PostMapping("/guardar")
	public String insertarPropietario(Propietario propietario) {
		this.iPropietarioService.agregar(propietario);
		return "redirect:/propietarios/buscar";
	}
	
	
	//Metodo de pagina de redireccionamiento 
	@GetMapping("/nuevoPropietario")
	public String paginaNuevoPropietario(Propietario propietario) {
		return "vistaNuevoPropietario";
	}
	
	
}
