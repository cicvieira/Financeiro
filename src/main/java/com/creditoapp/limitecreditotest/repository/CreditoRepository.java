/*
 * Cicero Vieira 2019-04-08
 * limitecreditoapp 1.0
 * 
 */
package com.creditoapp.limitecreditotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creditoapp.limitecreditotest.model.Credito;

public interface CreditoRepository extends JpaRepository<Credito, Integer> {
	Credito findByName(String name);
}
