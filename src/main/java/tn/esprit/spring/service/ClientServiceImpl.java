package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService{
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		List<Client> clients = null;
		try {
			log.info("In method retrieveAllClients");
			log.debug("Connection à la base de données: ");
			clients = (List<Client>) clientRepository.findAll();
			log.debug("Le nombre total de clients: "+clients.size());
			for(Client client : clients)
			{
				log.debug(" Client : "+client.toString());
			}
			log.info("Out method retrieveAllClients without Errors");
		} catch (Exception e) 
		{
			log.error("Error in retrieveAllClients: "+e);
		}
		return clients;
	}

	@Override
	public Client addClient(Client c) {
		clientRepository.save(c);
		return c;
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	public Client updateClient(Client c) {
		clientRepository.save(c);
		return c;
	}

	@Override
	public Client retrieveClient(Long id) {
		Client client = null;
	try {
		log.info("In method retrieveClient");
		log.debug("Je vais me connecter à la base de données");
		client = clientRepository.findById(id).orElse(null);
		log.debug("Le client trouvé est: "+client);
		log.info("Out method retrieveClient without Errors");

	} catch (Exception e) {
		log.error("Error in retrieveClient: "+e);
	}
	return client;
	}
}
