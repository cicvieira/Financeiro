/*
 * Cicero Vieira 2019-04-08
 * limitecreditoapp 1.0
 * 
 */
package com.creditoapp.limitecreditotest.sevice;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditoapp.limitecreditotest.model.Credito;
import com.creditoapp.limitecreditotest.repository.CreditoRepository;


@Service
public class CreditoService {
	private CreditoRepository creditoRepository;

	@Autowired
	public CreditoService(CreditoRepository creditoRepository) {
		this.creditoRepository = creditoRepository;
	}

	public Credito save(Credito credito) {
		if (credito.getId() != null && creditoRepository.exists(credito.getId())) {
			throw new EntityExistsException("Já existe uma entidade com esse ID no banco de dados.");
		}

		return creditoRepository.save(credito);
	}

	public Credito update(Credito credito) {
		if (credito.getId() != null && !creditoRepository.exists(credito.getId())) {
			throw new EntityNotFoundException("Não existe entidade com tal ID no banco de dados.");
		}

		return creditoRepository.save(credito);
	}

	public List<Credito> findAll() {
		return creditoRepository.findAll();
	}

	public Credito findOne(Integer id) {
		return creditoRepository.findOne(id);
	}

	public void delete(Integer id) {
		creditoRepository.delete(id);
	}
}
