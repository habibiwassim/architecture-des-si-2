package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Rayon")
public class Rayon implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idRayon;
	private String codeRayon;
	private String libelleRayon;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> produits;
	public Rayon(Long idRayon, String codeRayon, String libelleRayon, Set<Produit> produits) {
		super();
		this.idRayon = idRayon;
		this.codeRayon = codeRayon;
		this.libelleRayon = libelleRayon;
		this.produits = produits;
	}
	public Long getIdRayon() {
		return idRayon;
	}
	public void setIdRayon(Long idRayon) {
		this.idRayon = idRayon;
	}
	public String getCodeRayon() {
		return codeRayon;
	}
	public void setCodeRayon(String codeRayon) {
		this.codeRayon = codeRayon;
	}
	public String getLibelleRayon() {
		return libelleRayon;
	}
	public void setLibelleRayon(String libelleRayon) {
		this.libelleRayon = libelleRayon;
	}
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Rayon [idRayon=" + idRayon + ", codeRayon=" + codeRayon + ", libelleRayon=" + libelleRayon
				+ ", produits=" + produits + "]";
	}
	
}
