package com.example.demo.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.entity.Empleado;

@Repository
public class EmpleadoDaoImpl implements IEmpleadoDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Empleado> fintAll() {
		
		return em.createQuery("from Empleado").getResultList();
	}

	@Override
	@Transactional
	public void save(Empleado empleado) {
		// TODO Auto-generated method stub
		em.persist(empleado);
	}

}
