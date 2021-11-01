package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="T_Produit")
public class Produit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prixUnitaire;
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<Fournisseur> fournisseurs;
	@ManyToOne
	Rayon rayon;
	@ManyToOne
	Stock stock;
	@OneToOne
	private DetailProduit detailProduit;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Set<DetailFacture> detailFactures;
	public Produit(Long idProduit, String codeProduit, String libelleProduit, float prixUnitaire,
			Set<Fournisseur> fournisseurs, Rayon rayon, Stock stock, DetailProduit detailProduit,
			Set<DetailFacture> detailFactures) {
		super();
		this.idProduit = idProduit;
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prixUnitaire = prixUnitaire;
		this.fournisseurs = fournisseurs;
		this.rayon = rayon;
		this.stock = stock;
		this.detailProduit = detailProduit;
		this.detailFactures = detailFactures;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getCodeProduit() {
		return codeProduit;
	}
	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}
	public String getLibelleProduit() {
		return libelleProduit;
	}
	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public Set<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	public Rayon getRayon() {
		return rayon;
	}
	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public DetailProduit getDetailProduit() {
		return detailProduit;
	}
	public void setDetailProduit(DetailProduit detailProduit) {
		this.detailProduit = detailProduit;
	}
	public Set<DetailFacture> getDetailFactures() {
		return detailFactures;
	}
	public void setDetailFactures(Set<DetailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", codeProduit=" + codeProduit + ", libelleProduit=" + libelleProduit
				+ ", prixUnitaire=" + prixUnitaire + ", fournisseurs=" + fournisseurs + ", rayon=" + rayon + ", stock="
				+ stock + ", detailProduit=" + detailProduit + ", detailFactures=" + detailFactures + "]";
	}
	
}
