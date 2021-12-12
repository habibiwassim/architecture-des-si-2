package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Set<Fournisseur> fournisseurs;
	
	@ToString.Exclude
	@JsonIgnore
	@ManyToOne
	Rayon rayon;
	
	@ToString.Exclude
	@JsonIgnore
	@ManyToOne
	Stock stock;
	
	@ToString.Exclude
	@OneToOne
	@JsonIgnore
	private DetailProduit detailProduit;
	
	@ToString.Exclude
	@OneToMany(mappedBy="produit")
	@JsonIgnore
	private Set<DetailFacture> detailFactures;
}
