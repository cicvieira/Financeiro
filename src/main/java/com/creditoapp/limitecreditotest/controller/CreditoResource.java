/*
 * Cicero Vieira 2019-04-08
 * limitecreditoapp 1.0
 * 
 */
package com.creditoapp.limitecreditotest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.creditoapp.limitecreditotest.model.Credito;
import com.creditoapp.limitecreditotest.sevice.CreditoService;

	@RestController
	@RequestMapping("/api")
	public class CreditoResource {

		private CreditoService creditoService;

		public CreditoResource(CreditoService creditoService) {
			this.creditoService = creditoService;
		}

		@RequestMapping(value = "credito", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Credito> getAllCreditos() {
			return creditoService.findAll();
		}

		@RequestMapping(value = "credito", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Credito> createCredito(@RequestBody Credito credito) throws URISyntaxException {
			try {
				Credito result = creditoService.save(credito);
				return ResponseEntity.created(new URI("/api/credito/" + result.getId())).body(result);
			} catch (EntityExistsException e) {
				return new ResponseEntity<Credito>(HttpStatus.CONFLICT);
			}
		}

		@RequestMapping(value = "credito", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Credito> updateCredito(@RequestBody Credito credito) throws URISyntaxException {
			if (credito.getId() == null) {
				return new ResponseEntity<Credito>(HttpStatus.NOT_FOUND);
			}

			try {
				Credito result = creditoService.update(credito);

				return ResponseEntity.created(new URI("/api/credito/" + result.getId())).body(result);
			} catch (EntityNotFoundException e) {
				return new ResponseEntity<Credito>(HttpStatus.NOT_FOUND);
			}
		}

		@RequestMapping(value = "/credito/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void> deleteCredito(@PathVariable Integer id) {
			creditoService.delete(id);

			return ResponseEntity.ok().build();
		}
	}
