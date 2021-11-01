package tn.esprit.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.FactureRepository;

@Service
public class FactureServiceImpl implements FactureService{

	@Autowired
	FactureRepository factureRepository;

	@Override
	public List<Facture> retrieveAllFactures() {

		return (List<Facture>) factureRepository.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		//factureRepository.findById(id).ifPresent(null);
		if(factureRepository.findById(id).get().getActive()){
			factureRepository.findById(id).get().setActive(false);
		}
	}

	@Override
	public Facture retrieveFacture(Long id) {	
		return factureRepository.findById(id).get();
	}
}
