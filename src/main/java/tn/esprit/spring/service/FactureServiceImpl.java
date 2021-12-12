package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.ProduitRepository;

@Service
@Slf4j
public class FactureServiceImpl implements FactureService{

	@Autowired
	FactureRepository factureRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	DetailFactureRepository detailFactureRepo;

	@Autowired
	ProduitRepository produitRepository;

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

		Facture f = factureRepository.getById(id);
		f.setActive(false);
		factureRepository.save(f);

	}

	@Override
	public Facture retrieveFacture(Long id) {	
		Facture facture = null;
		try {
			log.info("In method retrieveFacture");
			log.debug("Je vais me connecter à la base de données");
			facture = factureRepository.getById(id);
			log.debug("Le facture trouvé est: "+facture);
			log.info("Out method retrieveFacture without Errors");

		} catch (Exception e) {
			log.error("Error in retrieveFacture: "+e);
		}
		return facture;
	}

	@Override
	public List<Facture> getFacturesByClient(Long idClient) {
		Client client = clientRepository.getById(idClient);
		List<Facture> factures = new ArrayList<>();
		if(client!=null)
		{	
			factures.addAll(client.getFactures());
		}
		return factures;
	}

	@Override
	public Facture addFacture(Facture f, Long idClient) {
		Client client = clientRepository.getById(idClient);
		DetailFacture detailFacture = new DetailFacture();
		Set<DetailFacture> df = f.getDetailFactures();
		List<Produit>produits = new ArrayList<>();

		if(client!=null && !df.isEmpty()){
			detailFacture.setFacture(f);
			for(DetailFacture dfc : df){
				produits.add(dfc.getProduit());
			}
			for(Produit prod : produits){
				detailFacture.setProduit(prod);
				detailFacture.setPrixTotal(prod.getPrixUnitaire()*detailFacture.getQte());
			}
			detailFacture.setMontantRemise((int)(detailFacture.getPourcentageRemise()*detailFacture.getPrixTotal()/100));
			detailFactureRepo.save(detailFacture);

			f.setClient(client);
			factureRepository.save(f);
			return f;
		}
		return null;
	}






















}
