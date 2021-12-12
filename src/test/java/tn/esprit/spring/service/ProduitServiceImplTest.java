package tn.esprit.spring.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Produit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTest {
	@Autowired
	ProduitService produitService;
	
	@Test
	public void testAddProduit() {
		Produit p = new Produit("12","Milka",100.0F);
		Produit savedProduit = produitService.addProduit(p,3L,1L);
		assertEquals(p.getLibelleProduit(),savedProduit.getLibelleProduit());
	}

}
