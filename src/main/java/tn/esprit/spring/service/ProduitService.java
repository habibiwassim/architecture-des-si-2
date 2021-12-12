package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Produit;

public interface ProduitService {
	List<Produit> retrieveAllProduits();
	Produit addProduit(Produit p, Long idRayon, Long idStock);
	Produit updateProduit(Produit p, Long idRayon, Long idStock);
	Produit retrieveProduit(Long id);
	void deleteProduit(Long id);
	void assignProduitToStock(Long idProduit, Long idStock);
	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
	
}
