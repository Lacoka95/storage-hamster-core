package hu.storagehamster.www.entity;

public class Inflow {

	private int id;
	private String shelfId;
	private long productId;
	private int quantity;

	public Inflow(String shelfId, long productId, int quantity) {
		this.shelfId = shelfId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Inflow() {
	}

	public String getShelfId() {
		return shelfId;
	}

	public void setShelfId(String shelfId) {
		this.shelfId = shelfId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Inflow{" +
						"id=" + id +
						", shelfId='" + shelfId + '\'' +
						", productId=" + productId +
						", quantity=" + quantity +
						'}';
	}
}
