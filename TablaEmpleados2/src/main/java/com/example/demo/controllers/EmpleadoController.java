package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.dao.IEmpleadoDao;
import com.example.demo.models.entity.Empleado;

@Controller
public class EmpleadoController {
	
	@Autowired
	
	private IEmpleadoDao empleadoDao;
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Empledos");
		model.addAttribute("empleados", empleadoDao.fintAll());
		return "listar";
	}

	@RequestMapping(value="/form")
	public String crear(Map<String, Object>model) {
		
		Empleado empleado =new Empleado(); 
		model.put("empleado", empleado);
		model.put("titulo", "Tabla De Empleados");
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(Empleado empleado) {
		empleadoDao.save(empleado);
		return "redirect:listar";
		
	}
}
