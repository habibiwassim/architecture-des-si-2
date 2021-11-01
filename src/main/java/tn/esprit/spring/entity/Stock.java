package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="T_Stock")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idStock;
	private Integer qteStock;
	private Integer qteMin;
	private String libelleStock;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> produits;
	public Stock(Long idStock, Integer qteStock, Integer qteMin, String libelleStock, Set<Produit> produits) {
		super();
		this.idStock = idStock;
		this.qteStock = qteStock;
		this.qteMin = qteMin;
		this.libelleStock = libelleStock;
		this.produits = produits;
	}
	public Long getIdStock() {
		return idStock;
	}
	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}
	public Integer getQteStock() {
		return qteStock;
	}
	public void setQteStock(Integer qteStock) {
		this.qteStock = qteStock;
	}
	public Integer getQteMin() {
		return qteMin;
	}
	public void setQteMin(Integer qteMin) {
		this.qteMin = qteMin;
	}
	public String getLibelleStock() {
		return libelleStock;
	}
	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
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
		return "Stock [idStock=" + idStock + ", qteStock=" + qteStock + ", qteMin=" + qteMin + ", libelleStock="
				+ libelleStock + ", produits=" + produits + "]";
	}
	
	
}
