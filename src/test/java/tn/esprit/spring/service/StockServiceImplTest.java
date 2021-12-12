package tn.esprit.spring.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entity.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	StockService stockService;
	@Test
	public void testAddStock() {
		Stock s = new Stock("stock test",10,100);
		Stock savedStock = stockService.addStock(s);
		assertEquals(s.getLibelleStock(),savedStock.getLibelleStock());
	}
	
	@Test
	public void testUpdateStock() {
		Stock s = new Stock(2L,"stock test",14,100,null);
		Stock updatedStock = stockService.updateStock(s);
		assertEquals(s.getLibelleStock(),updatedStock.getLibelleStock());
	}
	
	@Test
	public void testDeleteStock() {
		stockService.deleteStock(1L);
		assertNull(stockService.retrieveStock(1L));
}
	
	@Test
	public void testRetrieveAllStocks() {
		List<Stock> allStocks = stockService.retrieveAllStocks();
		assertEquals(3, allStocks.size());
	}
}