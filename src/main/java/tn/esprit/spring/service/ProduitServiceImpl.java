package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.DetailProduitRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.repository.StockRepository;

@Service
@Slf4j
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	DetailProduitRepository detailProduitRepository;
	@Autowired
	RayonRepository rayonRepository;
	@Autowired
	StockRepository stockRepository;

	@Autowired
	DetailFactureRepository detailFactureRepo;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = null;
		try {
			log.info("In method retrieveAllProduits");
			log.debug("Connection à la base de données: ");
			produits = (List<Produit>) produitRepository.findAll();
			log.debug("Le nombre total de produits: "+produits.size());
			for(Produit produit : produits){log.debug(" Produit : "+produit.toString());}
			log.info("Out method retrieveAllProduits without Errors");
		} catch (Exception e) {
			log.error("Error in retrieveAllProduits: "+e);
		}
		return produits;
	}


	@Transactional
	public Produit addProduit(Produit p, Long idRayon, Long idStock){
		Rayon rayon = rayonRepository.getById(idRayon);
		Stock stock = stockRepository.getById(idStock);
		p.setRayon(rayon);
		p.setStock(stock);
		//log.info("Appel methode save Detail Produit"+p);
		//DetailProduit dp = saveDetailProduit(p);
		//p.setDetailProduit(dp);
		//DetailProduit dp = p.getDetailProduit();
		//p.setDetailProduit(dp);
		//detailProduitRepository.save(dp);
		produitRepository.save(p);
		return p;

	}

	@Override
	public Produit retrieveProduit(Long id) {
		Produit produit = null;
		try {
			log.info("In method retrieveProduit");
			log.debug("Je vais me connecter à la base de données");
			produit = produitRepository.getById(id);
			log.debug("Le produit trouvé est: "+produit);
			log.info("Out method retrieveProduit without Errors");

		} catch (Exception e) {
			log.error("Error in retrieveProduit: "+e);
		}
		return produit;
	}
	@Override
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
	}

	@Override
	public Produit updateProduit(Produit p, Long idRayon, Long idStock) {
		produitRepository.save(p);
		return p;
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock){
		Stock stock = stockRepository.getById(idStock);
		Produit p = produitRepository.getById(idProduit);
		if(stock!=null && p!=null){
			Set<Produit> produits = stock.getProduits();
			produits.add(p);
			stock.setProduits(produits);
			stock.setQteStock(stock.getQteStock()+1);
			stockRepository.save(stock);
		}

	}


	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		float revenu=0;
		Produit p = produitRepository.getById(idProduit);
		List<DetailFacture> detailFactures = detailFactureRepo.findAll();
		
		if(p!=null && !detailFactures.isEmpty()){
			for(DetailFacture detf : detailFactures){
				if(detf.getProduit().getIdProduit()==idProduit){
					if(detf.getFacture().getDateFacture().compareTo(startDate)>0 
							&& detf.getFacture().getDateFacture().compareTo(endDate)<0){
						revenu += p.getPrixUnitaire() * detf.getQte();
					}
				}
			}
			return revenu;
		}
		return 0;
	}
}
