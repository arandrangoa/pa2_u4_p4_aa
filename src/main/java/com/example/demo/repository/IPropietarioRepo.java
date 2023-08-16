package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Propietario;

public interface IPropietarioRepo {
	
	public void insertar(Propietario propietario);
	
	public void actualizar(Propietario propietario);
	
	public Propietario buscar(Integer id);
	
	public void eliminar(Integer id);
	
	public List<Propietario> buscarTodos ();

}
