package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
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
			stock = stockRepository.findById(id).orElse(null);
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
	
	
	
}
