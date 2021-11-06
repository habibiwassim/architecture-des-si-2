package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="T_DetailProduit")
public class DetailProduit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idDetailProduit;
	private Date dateCreation;
	private Date dateDerniereModification;
	private CategorieProduit categorieProduit;
	@OneToOne(mappedBy="detailProduit")
	private Produit produit;

	
}
