package com.example.demo.models.dao;

import java.util.List;

import com.example.demo.models.entity.Empleado;

public interface IEmpleadoDao {

	public List<Empleado> fintAll();
	
	public void save(Empleado empleado);
	
}
