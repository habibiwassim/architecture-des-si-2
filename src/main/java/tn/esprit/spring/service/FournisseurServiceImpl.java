package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.ProduitRepository;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	FournisseurRepository fournisseurRepository;
	
	@Autowired
	ProduitRepository produitRepository;

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
			fournisseur = fournisseurRepository.getById(id);
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

	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Produit p = produitRepository.getById(produitId);
		Fournisseur f = fournisseurRepository.getById(fournisseurId);
		if(p!=null && f!=null){
			Set<Fournisseur> fournisseurs = p.getFournisseurs();
			fournisseurs.add(f);
			p.setFournisseurs(fournisseurs);
			produitRepository.save(p);	
		}
	}
}
