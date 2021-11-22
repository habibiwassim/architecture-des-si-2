package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="T_Facture")
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	@NonNull
	private Float montantRemise;
	@NonNull
	private Float montantFacture;
	@NonNull
	private Date dateFacture;
	@NonNull
	private Boolean active;
	
	@ToString.Exclude
	@JsonIgnore
	@ManyToOne
	Client client;
	
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy="facture")
	private Set<DetailFacture> detailFactures;



}
