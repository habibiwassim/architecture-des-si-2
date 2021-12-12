package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.service.FactureService;

@RestController
@Api(tags = "Facture management")
@RequestMapping("/facture")
public class FactureRestController {
	@Autowired
	FactureService factureService;
	
	// http://localhost:8089/SpringMVC/facture/retrieve-all-factures
	@ApiOperation(value = "Récupérer la liste des factures")
	@GetMapping("/retrieve-all-factures")
	public List<Facture> getFactures() {
		List<Facture> listFactures = factureService.retrieveAllFactures();
		return listFactures;
	}
	
	// http://localhost:8089/SpringMVC/facture/retrieve-facture/8
	@ApiOperation(value = "Récupérer une facture par son id")
	@GetMapping("/retrieve-facture/{facture-id}")
	public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
	return factureService.retrieveFacture(factureId);
	}
	

	// http://localhost:8089/SpringMVC/facture/cancel-facture/{facture-id}
	@ApiOperation(value = "Annuler une facture par son id")
	@DeleteMapping("/cancel-facture/{facture-id}")
	@ResponseBody
	public void cancelFacture(@PathVariable("facture-id") Long factureId) {
	factureService.cancelFacture(factureId);
	}
	
}
