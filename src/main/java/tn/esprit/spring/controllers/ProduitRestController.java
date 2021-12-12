package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitService;

@RestController
@Api(tags = "Product management")
@RequestMapping("/produit")
public class ProduitRestController {
	@Autowired
	ProduitService produitService;
	
	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@ApiOperation(value = "Récupérer la liste des produits")
	@GetMapping("/retrieve-all-produits")
	public List<Produit> getProduits() {
		List<Produit> listProduits = produitService.retrieveAllProduits();
		return listProduits;
	}
	// http://localhost:8089/SpringMVC/produit/retrieve-produit/1
	@ApiOperation(value = "Récupérer un produit par son id")
	@GetMapping("/retrieve-produit/{produit-id}")
	public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
	return produitService.retrieveProduit(produitId);
	}

	@ApiOperation(value = "Ajouter un produit")
	@PostMapping("/add-produit")
	public Produit addProduit(@RequestBody Produit p, Long idRayon,Long idStock) {
	return produitService.addProduit(p,idRayon,idStock);
	}
	// http://localhost:8089/SpringMVC/produit/remove-produit/{produit-id}
	@ApiOperation(value = "Supprimer un produit")
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
	produitService.deleteProduit(produitId);
	}
	// http://localhost:8089/SpringMVC/produit/modify-produit
	@ApiOperation(value = "Modifier un produit")
	@PutMapping("/modify-produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody Produit p, Long idRayon, Long idStock) {
	return produitService.updateProduit(p,idRayon,idStock);
	}
}
