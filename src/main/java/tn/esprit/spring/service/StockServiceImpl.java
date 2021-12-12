package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

@Service
@Slf4j
public class StockServiceImpl implements StockService{

	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> stocks = null;
		try {
			log.info("In method retrieveAllStocks");
			log.debug("Connection à la base de données: ");
			stocks = (List<Stock>) stockRepository.findAll();
			log.debug("Le nombre total de stocks: "+stocks.size());
			for(Stock stock : stocks){log.debug(" Stock : "+stock.toString());}
			log.info("Out method retrieveAllStocks without Errors");
		} catch (Exception e) {
			log.error("Error in retrieveAllStocks: "+e);
		}
		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		return stockRepository.save(u);
	}

	@Override
	public Stock retrieveStock(Long id) {
		Stock stock = null;
		try {
			log.info("In method retrieveStock");
			log.debug("Je vais me connecter à la base de données");
			stock = stockRepository.getById(id);
			log.debug("Le stock trouvé est: "+stock);
			log.info("Out method retrieveStock without Errors");

		} catch (Exception e) {
			log.error("Error in retrieveStock: "+e);
		}
		return stock;
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);
	}

	@Override
	public String retrieveStatusStock() {
		List<Produit> produits = retrieveProductsInDanger();
		if(!produits.isEmpty()){
			return "DANGER";
		}
		return null;
	}
	@Override
	public List<Produit> retrieveProductsInDanger() {
		List<Stock> stocks = (List<Stock>)stockRepository.findAll();
		List<Produit> produits = new ArrayList<Produit>();
		for(Stock s : stocks){
			if(s.getQteStock()<=s.getQteMin()){
				produits.addAll(s.getProduits());
			}
		}
		return produits;
	}
	@Scheduled(cron = "0 0 22 * * *",zone="Africa/Tunis")
    public void checkStock() {
		List<Stock> stocks = (List<Stock>)stockRepository.findAll();
		String status = retrieveStatusStock();
		if(status!=null){
			List<Produit> prod = retrieveProductsInDanger();
			for(Stock s : stocks){
				for(Produit p : prod){
					if(p.getStock().equals(s)){
						log.info("!!! Alerte d'épuisement du produit ("+p.getLibelleProduit()+
													") dans le stock ["+s.getLibelleStock()+"] !!!");
					}
				}
			}
		}
    }
}
