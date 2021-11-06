package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.sun.istack.NotNull;

import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="T_Stock")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idStock;
	
	@NotNull
	private String libelleStock;
	@NotNull
	private Integer qteMin;
	@NotNull
	private Integer qteStock;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> produits;
	
	public Stock(String libelleStock, Integer qteMin, Integer qteStock) {
		super();
		this.libelleStock = libelleStock;
		this.qteMin = qteMin;
		this.qteStock = qteStock;
	}
	
	
	
}
