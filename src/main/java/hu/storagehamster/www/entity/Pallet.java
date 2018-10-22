package hu.storagehamster.www.entity;

import javax.persistence.*;

@Entity
public class Pallet {
	@Id
	@GeneratedValue
	private long id;
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	public Pallet(int quantity, Product product) {
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
						", quantity=" + quantity +
						", product=" + product +
						'}';
	}
}

