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
	private final String loco;
	@NotNull
	private int capacity;
	@OneToMany
	@JoinColumn(name="SHELF_ID")
	private List<Product> stroredProducts;

	public Shelf(String loco, int capacity, List<Product> stroredProducts) {
		this.loco = loco;
		this.capacity = capacity;
		this.stroredProducts = stroredProducts;
	}

	public String getLoco() {
		return loco;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Product> getStroredProducts() {
		return stroredProducts;
	}

	public void setStroredProducts(List<Product> stroredProducts) {
		this.stroredProducts = stroredProducts;
	}

	@Override
	public String toString() {
		return "Shelf{" +
						"loco='" + loco + '\'' +
						", capacity=" + capacity +
						", stroredProducts=" + stroredProducts +
						'}';
	}
}
