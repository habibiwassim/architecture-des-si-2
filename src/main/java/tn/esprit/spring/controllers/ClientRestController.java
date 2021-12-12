package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.ClientService;

@RestController
@Api(tags = "Client management")
@RequestMapping("/client")
public class ClientRestController {
	@Autowired
	ClientService clientService;
	
	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@ApiOperation(value = "Récupérer la liste des clients")
	@GetMapping("/retrieve-all-clients")
	public List<Client> getClients() {
		List<Client> listClients = clientService.retrieveAllClients();
		return listClients;
	}
	
	// http://localhost:8089/SpringMVC/client/retrieve-client/8
	@ApiOperation(value = "Récupérer un client par son id")
	@GetMapping("/retrieve-client/{client-id}")
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
	return clientService.retrieveClient(clientId);
	}
	@ApiOperation(value = "Ajouter un client")
	@PostMapping("/add-client")
	public Client addClient(@RequestBody Client c) {
	return clientService.addClient(c);
	}
	
	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@ApiOperation(value = "Supprimer un client")
	@DeleteMapping("/remove-client/{client-id}")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
	clientService.deleteClient(clientId);
	}
	// http://localhost:8089/SpringMVC/client/modify-client
	@ApiOperation(value = "Modifier un client")
	@PutMapping("/modify-client")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client) {
	return clientService.updateClient(client);
	}

}
