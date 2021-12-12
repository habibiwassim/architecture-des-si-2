package tn.esprit.spring.scheduled;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.FactureService;
import tn.esprit.spring.service.StockService;

@Component
@Slf4j
public class ScheduledTasks {
	@Autowired
	StockService stockService;
	
	@Autowired
	FactureService factureService;
	
	@Scheduled(fixedRate = 60000)
    public void alertRupture() {
		List<Stock> stocks = (List<Stock>)stockService.retrieveAllStocks();
		for(Stock stock : stocks){
			if(stock.getQteStock()<=stock.getQteStock()){
				log.info("!!! Alert - RUPTURE DU STOCK :"+stock.getLibelleStock()+" !!!");
			}
		}
    }
	
	@Scheduled(cron="@monthly",zone="Africa/Tunis")
	public void revenuMensuel(){
		float totalMensuel = 0;
		List<Facture> factures = (List<Facture>) factureService.retrieveAllFactures();
		LocalDate today = LocalDate.now(ZoneId.systemDefault());
		int currentMonth = today.getMonthValue();
		int currentYear = today.getYear();
		Calendar cal = Calendar.getInstance();
		for(Facture facture : factures){
			cal.setTime(facture.getDateFacture());
			if((cal.get(Calendar.MONTH)+1==currentMonth-1)&& currentMonth!=1&&(cal.get(Calendar.YEAR)==currentYear)){
				totalMensuel += facture.getMontantFacture();
			}
		}
		log.info("\nLe total du mois courant = "+totalMensuel);
	}
	
	@Scheduled(cron="@annually",zone="Africa/Tunis")
	public void revenuAnnuel(){
		
		float totalAnnuel = 0;
		List<Facture> factures = (List<Facture>) factureService.retrieveAllFactures();
		LocalDate today = LocalDate.now(ZoneId.systemDefault());
		int currentYear = today.getYear();
		Calendar cal = Calendar.getInstance();
		for(Facture facture : factures){
			cal.setTime(facture.getDateFacture());
			if((cal.get(Calendar.YEAR)==currentYear-1)){
				totalAnnuel += facture.getMontantFacture();
			}
		}
		log.info("\nLe total de l'année ("+(currentYear-1)+ ") = " +totalAnnuel);
	}	
}