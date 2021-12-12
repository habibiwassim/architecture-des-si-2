package tn.esprit.spring.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
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
	public void testAddStock() throws ParseException {
		Stock s = new Stock("stock test",10,100);
		Stock savedStock = stockService.addStock(s);
		assertEquals(s.getLibelleStock(),savedStock.getLibelleStock());
	}
	
	@Test
	public void testUpdateStock() throws ParseException {
		Stock s = new Stock(2L,"stock test",14,100,null);
		Stock updatedStock = stockService.updateStock(s);
		assertEquals(s.getLibelleStock(),updatedStock.getLibelleStock());
	}
	
	@Test
	public void testDeleteStock() throws ParseException{
		stockService.deleteStock(1L);
		assertNull(stockService.retrieveStock(1L));
}
	
	@Test
	public void testRetrieveAllStocks() throws ParseException{
		List<Stock> allStocks = stockService.retrieveAllStocks();
		assertEquals(3, allStocks.size());
	}
}