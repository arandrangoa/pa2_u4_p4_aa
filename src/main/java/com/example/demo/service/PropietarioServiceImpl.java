package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Propietario;
import com.example.demo.repository.IPropietarioRepo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements IPropietarioService{
	
	@Autowired
	private IPropietarioRepo iPropietarioRepo;

	@Override
	public void agregar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepo.insertar(propietario);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void modificar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepo.actualizar(propietario);
	}

	@Override
	public Propietario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iPropietarioRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iPropietarioRepo.eliminar(id);
	}

	@Override
	public List<Propietario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iPropietarioRepo.buscarTodos();
	}

}
