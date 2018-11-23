package Models;

public class Orders {
	private int id;
	private int item_id;
	private int quantity;
	
	public Orders() {
		
	}
	
	public Orders(int id, int item_id, int quantity) {
		super();
		this.id = id;
		this.item_id = item_id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
