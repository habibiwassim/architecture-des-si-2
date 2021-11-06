package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name="T_Client")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String email;
	private String password;
	private CategorieClient categorieClient;
	private Profession profession;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture> factures;
	
}
