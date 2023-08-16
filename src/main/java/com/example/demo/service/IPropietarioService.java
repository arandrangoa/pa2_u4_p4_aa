package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Propietario;

public interface IPropietarioService {
	
	public void agregar(Propietario propietario);
	
	public void modificar(Propietario propietario);
	
	public Propietario buscar(Integer id);
	
	public void borrar(Integer id);
	
	public List<Propietario> buscarTodos ();

}
