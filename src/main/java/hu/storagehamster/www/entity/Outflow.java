package hu.storagehamster.www.entity;


import javax.validation.constraints.Min;

public class Outflow {
	@Min(value = 1)
	private long productID;
	@Min(value = 1)
	private int quantity;

	public Outflow(long productID, int quantity) {
		this.productID = productID;
		this.quantity = quantity;
	}

	public Outflow() {
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Outflow{" +
						"productID=" + productID +
						", quantity=" + quantity +
						'}';
	}
}
