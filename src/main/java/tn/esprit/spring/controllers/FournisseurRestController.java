package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.service.FournisseurService;

@RestController
@Api(tags = "Fournisseur management")
@RequestMapping("/fournisseur")
public class FournisseurRestController {
	@Autowired
	FournisseurService fournisseurService;
	
	// http://localhost:8089/SpringMVC/fournisseur/retrieve-all-fournisseurs
	@ApiOperation(value = "Récupérer la liste des fournisseurs")
	@GetMapping("/retrieve-all-fournisseurs")
	public List<Fournisseur> getFournisseurs() {
		List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseurs();
		return listFournisseurs;
	}
	
	// http://localhost:8089/SpringMVC/fournisseur/retrieve-fournisseur/8
	@ApiOperation(value = "Récupérer un fournisseur par son id")
	@GetMapping("/retrieve-fournisseur/{fournisseur-id}")
	public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
	return fournisseurService.retrieveFournisseur(fournisseurId);
	}
	@ApiOperation(value = "Ajouter un fournisseur")
	@PostMapping("/add-fournisseur")
	public Fournisseur addFournisseur(@RequestBody Fournisseur c) {
	return fournisseurService.addFournisseur(c);
	}
	
	// http://localhost:8089/SpringMVC/fournisseur/remove-fournisseur/{fournisseur-id}
	@ApiOperation(value = "Supprimer un fournisseur")
	@DeleteMapping("/remove-fournisseur/{fournisseur-id}")
	@ResponseBody
	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
	fournisseurService.deleteFournisseur(fournisseurId);
	}
	// http://localhost:8089/SpringMVC/fournisseur/modify-fournisseur
	@ApiOperation(value = "Modifier un fournisseur")
	@PutMapping("/modify-fournisseur")
	@ResponseBody
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur fournisseur) {
	return fournisseurService.updateFournisseur(fournisseur);
	}

}
