package hu.storagehamster.www.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private final String name;
	@NotBlank
	private final String brand;
	@NotNull
	private final double price;

	public Product(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public String getBrand() {
		return brand;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product{" +
						"id=" + id +
						", name='" + name + '\'' +
						", brand='" + brand + '\'' +
						", price=" + price +
						'}';
	}
}
