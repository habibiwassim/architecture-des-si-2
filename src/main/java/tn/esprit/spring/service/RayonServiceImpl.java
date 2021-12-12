package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;

@Service
@Slf4j
public class RayonServiceImpl implements RayonService{

	@Autowired
	RayonRepository rayonRepository;
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public List<Rayon> retrieveAllRayons() {
		List<Rayon> rayons = null;
		try {
			log.info("In method retrieveAllRayons");
			log.debug("Connection à la base de données: ");
			rayons = (List<Rayon>) rayonRepository.findAll();
			log.debug("Le nombre total de rayons: "+rayons.size());
			for(Rayon rayon : rayons){log.debug(" Rayon : "+rayon.toString());}
			log.info("Out method retrieveAllRayons without Errors");
		} catch (Exception e) {
			log.error("Error in retrieveAllRayons: "+e);
		}
		return rayons;
	}

	@Override
	public Rayon addRayon(Rayon r) {
		return rayonRepository.save(r);
	}

	@Override
	public Rayon updateRayon(Rayon u) {
		return rayonRepository.save(u);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		Rayon rayon = null;
		try {
			log.info("In method retrieveRayon");
			log.debug("Je vais me connecter à la base de données");
			rayon = rayonRepository.getById(id);
			log.debug("Le rayon trouvé est: "+rayon);
			log.info("Out method retrieveRayon without Errors");

		} catch (Exception e) {
			log.error("Error in retrieveRayon: "+e);
		}
		return rayon;
	}

	@Override
	public void deleteRayon(Long id) {
		rayonRepository.deleteById(id);
	}

	
}
