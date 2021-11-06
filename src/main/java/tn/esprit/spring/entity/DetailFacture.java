package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="T_DetailFacture")
public class DetailFacture implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetailFacture;
	private Integer qte;
	private float prixTotal;
	private Integer pourcentageRemise;
	private Integer montantRemise;
	@ManyToOne
	Facture facture;
	@ManyToOne
	Produit produit;
}
