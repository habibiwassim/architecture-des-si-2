package tn.esprit.spring.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockService;

@RestController
@Api(tags = "Stock management")
@RequestMapping("/stock")
public class StockRestController {
	@Autowired
	StockService stockService;
	
	// http://localhost:8089/SpringMVC/stock/retrieve-all-stocks
	@ApiOperation(value = "Récupérer la liste des éléments dans le stock")
	@GetMapping("/retrieve-all-stocks")
	public List<Stock> getStocks() {
		List<Stock> listStocks = stockService.retrieveAllStocks();
		return listStocks;
	}
	
	// http://localhost:8089/SpringMVC/stock/retrieve-stock/8
	@ApiOperation(value = "Récupérer les éléments dans un stock par son id")
	@GetMapping("/retrieve-stock/{stock-id}")
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
	return stockService.retrieveStock(stockId);
	}
	@ApiOperation(value = "Ajouter un stock")
	@PostMapping("/add-stock")
	public Stock addStock(@RequestBody Stock c) {
	return stockService.addStock(c);
	}
	
	// http://localhost:8089/SpringMVC/stock/remove-stock/{stock-id}
	@ApiOperation(value = "Supprimer un stock par son id")
	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
	stockService.deleteStock(stockId);
	}
	// http://localhost:8089/SpringMVC/stock/modify-stock
	@ApiOperation(value = "Modifier un stock")
	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock stock) {
	return stockService.updateStock(stock);
	}

}
