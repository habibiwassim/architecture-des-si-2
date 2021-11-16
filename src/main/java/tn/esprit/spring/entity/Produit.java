package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name="T_Produit")
public class Produit implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduit;
	@NonNull
	private String codeProduit;
	@NonNull
	private String libelleProduit;
	@NonNull
	private Float prixUnitaire;
	
	@ToString.Exclude
	@ManyToMany
	private Set<Fournisseur> fournisseurs;
	
	@ToString.Exclude
	@ManyToOne
	Rayon rayon;
	
	@ToString.Exclude
	@ManyToOne
	Stock stock;
	
	@ToString.Exclude
	@OneToOne
	private DetailProduit detailProduit;
	
	@ToString.Exclude
	@OneToMany(mappedBy="produit")
	private Set<DetailFacture> detailFactures;
}
