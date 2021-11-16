package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name="T_DetailProduit")
public class DetailProduit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idDetailProduit;
	
	@NonNull @Temporal(TemporalType.DATE)
	private Date dateCreation;
	@NonNull @Temporal(TemporalType.DATE)
	private Date dateDerniereModification;
	@NonNull @Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;
	
	@ToString.Exclude
	@OneToOne(mappedBy="detailProduit")
	private Produit produit;

	
}
