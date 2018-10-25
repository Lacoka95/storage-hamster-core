package hu.storagehamster.www.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Shelf {
	@Id
	private String loco;
	@NotNull
	private int capacity;
	@OneToMany
	@JoinColumn(name = "SHELF_ID")
	private List<Pallet> stroredPallets;


	public Shelf(String loco, int capacity, List<Pallet> stroredPallets) {
		this.loco = loco;
		this.capacity = capacity;
		this.stroredPallets = stroredPallets;
	}

	public Shelf() {
	}

	public String getLoco() {
		return loco;
	}

	public void setLoco(String loco) {
		this.loco = loco;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Pallet> getStroredPallets() {
		return stroredPallets;
	}

	public void setStroredPallets(List<Pallet> stroredPallets) {
		this.stroredPallets = stroredPallets;
	}

	public void addPallet(Pallet pallet) {
		this.stroredPallets.add(pallet);

	}

	@Override
	public String toString() {
		return "shelf{" +
						"loco='" + loco + '\'' +
						", capacity=" + capacity +
						", stroredPallets=" + stroredPallets +
						'}';
	}
}

