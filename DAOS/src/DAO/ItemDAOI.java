package DAO;

import java.util.List;

import Models.Item;

public interface ItemDAOI {
	enum SQL{
		GET_ITEM_BY_ID("SELECT * FROM ITEM WHERE ID=?"),
		GET_ITEMS_COSTING_GREATER_THAN("SELECT * FROM ITEM WHERE PRICE >?"),
		GET_ITEMS_IN_STOCK("SELECT * FROM ITEM WHERE QUANTITY_IN_STOCK >?"),
		UPDATE_QUANTITY_IN_STOCK("UPDATE ITEM SET QUANTITY_IN_STOCK = QUANTITY_IN_STOCK - ? WHERE ID = ?");
		
		private final String query;
		
		private SQL(String s) {
			this.query = s;
		}
		
		public String getQuery() {
			return query;
		}	
	}
	
	//Method Structure 
	Item getItemByID(int id);
	List<Item> getItemsCostingGreaterThan(double condition);
	List<Item> getItemsInStock();
	boolean updateQuantityInStock(int id, int quantity);
	
}
