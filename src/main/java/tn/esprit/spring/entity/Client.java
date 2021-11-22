package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="T_Client")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idClient;
	@NonNull
	private String nom;
	@NonNull
	private String prenom;
	@NonNull @Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@NonNull
	private String email;
	@NonNull
	private String password;
	@NonNull @Enumerated(EnumType.STRING)
	private CategorieClient categorieClient;
	@NonNull @Enumerated(EnumType.STRING)
	private Profession profession;
	
	@OneToMany(mappedBy="client")
	@ToString.Exclude
	@JsonIgnore
	private Set<Facture> factures;
}
