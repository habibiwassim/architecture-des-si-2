package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.repository.FournisseurRepository;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	FournisseurRepository fournisseurRepository;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		List<Fournisseur> fournisseurs = null;
		try {
			log.info("In method retrieveAllFournisseurs");
			log.debug("Connection à la base de données: ");
			fournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();
			log.debug("Le nombre total de fournisseurs: "+fournisseurs.size());
			for(Fournisseur fournisseur : fournisseurs)
			{
				log.debug(" Fournisseur : "+fournisseur.toString());
			}
			log.info("Out method retrieveAllFournisseurs without Errors");
		} catch (Exception e) 
		{
			log.error("Error in retrieveAllFournisseurs: "+e);
		}
		return fournisseurs;
	}
	
	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		Fournisseur fournisseur = null;
		try {
			log.info("In method retrieveFournisseur");
			log.debug("Je vais me connecter à la base de données");
			fournisseur = fournisseurRepository.findById(id).orElse(null);
			log.debug("Le fournisseur trouvé est: "+fournisseur);
			log.info("Out method retrieveFournisseur without Errors");

		} catch (Exception e) {
			log.error("Error in retrieveFournisseur: "+e);
		}
		return fournisseur;
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		fournisseurRepository.save(f);
		return f;
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.deleteById(id);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		fournisseurRepository.save(f);
		return f;
	}

	

}
