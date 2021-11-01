package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Client;
import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long>{
	//SEMI-PRET
	//List<Client> findByDateNaissanceBetween(Date d1,Date d2);
	@Query("SELECT c Client c WHERE c.dateNaissance BETWEEN :d1 AND :d2")
	List<Client> findByDateNaissances(@Param ("d1") Date d1,@Param("d2")Date d2);
}
