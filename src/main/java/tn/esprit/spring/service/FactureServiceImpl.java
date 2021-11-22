package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.FactureRepository;

@Service
@Slf4j
public class FactureServiceImpl implements FactureService{

	@Autowired
	FactureRepository factureRepository;

	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = null;
	try {
		log.info("In method retrieveAllFactures");
		log.debug("Connection à la base de données: ");
		factures = (List<Facture>) factureRepository.findAll();
		log.debug("Le nombre total de factures: "+factures.size());
		for(Facture facture : factures)
		{
			log.debug(" Facture : "+facture.toString());
		}
		log.info("Out method retrieveAllFactures without Errors");
	} catch (Exception e) 
	{
		log.error("Error in retrieveAllFactures: "+e);
	}
	return factures;
	}

	@Override
	public void cancelFacture(Long id) {
		//factureRepository.findById(id).ifPresent(null);
		//if(factureRepository.findById(id).get().getActive()){
		//factureRepository.findById(id).get().setActive(false);	
		//}
		
		Facture f = factureRepository.findById(id).orElse(null);
		f.setActive(false);
		factureRepository.save(f);
		
	}

	@Override
	public Facture retrieveFacture(Long id) {	
		Facture facture = null;
	try {
		log.info("In method retrieveFacture");
		log.debug("Je vais me connecter à la base de données");
		facture = factureRepository.findById(id).orElse(null);
		log.debug("Le facture trouvé est: "+facture);
		log.info("Out method retrieveFacture without Errors");

	} catch (Exception e) {
		log.error("Error in retrieveFacture: "+e);
	}
	return facture;
	}
}
