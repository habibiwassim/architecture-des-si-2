package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="T_Produit")
public class Produit implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prixUnitaire;
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<Fournisseur> fournisseurs;
	@ManyToOne
	Rayon rayon;
	@ManyToOne
	Stock stock;
	@OneToOne
	private DetailProduit detailProduit;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Set<DetailFacture> detailFactures;
}
