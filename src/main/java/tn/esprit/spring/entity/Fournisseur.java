package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="T_Fournisseur")
public class Fournisseur implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFournisseur;
	private String codeFournisseur;
	private String libelleFournisseur;

}
