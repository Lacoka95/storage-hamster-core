package hu.storagehamster.www.entity;

import javax.persistence.*;

@Entity
public class Pallet {
	@Id
	@GeneratedValue
	private long id;

	private int numberOfProductsOnPallet;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	public Pallet(int numberOfProductsOnPallet, Product product) {
		this.numberOfProductsOnPallet = numberOfProductsOnPallet;
		this.product = product;
	}

	public Pallet() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumberOfProductsOnPallet() {
		return numberOfProductsOnPallet;
	}

	public void setNumberOfProductsOnPallet(int numberOfProductsOnPallet) {
		this.numberOfProductsOnPallet = numberOfProductsOnPallet;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Pallet{" +
						"id=" + id +
						", numberOfProductsOnPallet=" + numberOfProductsOnPallet +
						", product=" + product +
						'}';
	}
}

