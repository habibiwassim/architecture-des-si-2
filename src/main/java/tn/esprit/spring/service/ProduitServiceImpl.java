package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.DetailProduitRepository;
import tn.esprit.spring.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	DetailProduitRepository detailProduitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		return (List<Produit>) produitRepository.findAll();
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		produitRepository.save(p);
		return null;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return produitRepository.findById(id).get();
	}
	@Override
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
	}

	@Override
	public Produit updateProduit(Produit p, Long idRayon, Long idStock) {
		produitRepository.save(p);
		return null;
	}
}
