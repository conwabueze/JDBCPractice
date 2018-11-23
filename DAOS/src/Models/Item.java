package Models;

public class Item {
	private int id;
	private String name;
	private int quantityInStock;
	private double price;
	
	public Item() {
		
	}
	public Item(int id, String name, int quantityInStock, double price) {
		super();
		this.id = id;
		this.name = name;
		this.quantityInStock = quantityInStock;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return "ID: " + id + " Name: " + name + " Quantity In Stock " + quantityInStock + " Price " + price; 
	}
	
	

}
