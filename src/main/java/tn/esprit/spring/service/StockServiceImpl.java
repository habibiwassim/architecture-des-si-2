package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockRepository stockRepository;
	
	@Override
	public List<Stock> retrieveAllStocks() {	
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		stockRepository.save(s);
		return null;
	}

	@Override
	public Stock updateStock(Stock u) {
		stockRepository.save(u);
		return null;
	}

	@Override
	public Stock retrieveStock(Long id) {
		return stockRepository.findById(id).get();
	}
	
}
