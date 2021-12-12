package tn.esprit.spring.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.service.RayonService;

@RestController
@Api(tags = "Rayon management")
@RequestMapping("/rayon")
public class RayonRestController {
	@Autowired
	RayonService rayonService;
	
	// http://localhost:8089/SpringMVC/rayon/retrieve-all-rayons
	@ApiOperation(value = "Récupérer la liste des éléments dans le rayon")
	@GetMapping("/retrieve-all-rayons")
	public List<Rayon> getRayons() {
		List<Rayon> listRayons = rayonService.retrieveAllRayons();
		return listRayons;
	}
	
	// http://localhost:8089/SpringMVC/rayon/retrieve-rayon/8
	@ApiOperation(value = "Récupérer les éléments dans un rayon par son id")
	@GetMapping("/retrieve-rayon/{rayon-id}")
	public Rayon retrieveRayon(@PathVariable("rayon-id") Long rayonId) {
	return rayonService.retrieveRayon(rayonId);
	}
	@ApiOperation(value = "Ajouter un rayon")
	@PostMapping("/add-rayon")
	public Rayon addRayon(@RequestBody Rayon c) {
	return rayonService.addRayon(c);
	}
	
	// http://localhost:8089/SpringMVC/rayon/remove-rayon/{rayon-id}
	@ApiOperation(value = "Supprimer un rayon par son id")
	@DeleteMapping("/remove-rayon/{rayon-id}")
	@ResponseBody
	public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
	rayonService.deleteRayon(rayonId);
	}
	// http://localhost:8089/SpringMVC/rayon/modify-rayon
	@ApiOperation(value = "Modifier un rayon")
	@PutMapping("/modify-rayon")
	@ResponseBody
	public Rayon modifyRayon(@RequestBody Rayon rayon) {
	return rayonService.updateRayon(rayon);
	}

}
