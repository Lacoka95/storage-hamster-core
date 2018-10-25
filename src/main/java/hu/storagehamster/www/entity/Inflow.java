package hu.storagehamster.www.entity;

public class Inflow {

	private int id;
	private String shelfId;
	private long productId;
	private int numberOfProductsOnPallet;
	private int numberOfPallets;

	public Inflow(String shelfId, long productId, int numberOfProductsOnPallet) {
		this.shelfId = shelfId;
		this.productId = productId;
		this.numberOfProductsOnPallet = numberOfProductsOnPallet;
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

	public int getNumberOfProductsOnPallet() {
		return numberOfProductsOnPallet;
	}

	public void setNumberOfProductsOnPallet(int numberOfProductsOnPallet) {
		this.numberOfProductsOnPallet = numberOfProductsOnPallet;
	}

	public int getNumberOfPallets() {
		return numberOfPallets;
	}

	public void setNumberOfPallets(int numberOfPallets) {
		this.numberOfPallets = numberOfPallets;
	}

	@Override
	public String toString() {
		return "Inflow{" +
						"id=" + id +
						", shelfId='" + shelfId + '\'' +
						", productId=" + productId +
						", numberOfProductsOnPallet=" + numberOfProductsOnPallet +
						", numberOfPallets=" + numberOfPallets +
						'}';
	}
}
