package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="T_Stock")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idStock;

	@NonNull 
	private String libelleStock;
	@NonNull 
	private Integer qteMin;
	@NonNull 
	private Integer qteStock;
	
	@ToString.Exclude
	@OneToMany(mappedBy="stock")
	@JsonIgnore
	private Set<Produit> produits;



}
