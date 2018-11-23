package DAO;

import java.util.Map;

public interface OrdersDAOI {
	enum SQL{
		CREATE_ORDER("insert into orders(id,ITEM_ID,quantity) values(?,?,?)"),
		GET_MAX("SELECT MAX(ID) FROM ORDERS");
		
		private final String query;
		
		private SQL(String s) {
			this.query = s;
		}
		
		public String getQuery() {
			return query;
		}
	}
	
		
	
	//Method Statements
	boolean createOrder(Map<Integer, Integer> map);

}
