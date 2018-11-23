package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Item;

public class ItemDAO extends AbstractDAO implements ItemDAOI  {
	

//	protected Connection conn = null;
//	protected PreparedStatement ps = null;
//	protected ResultSet rs = null;
	

	@Override
	public Item getItemByID(int id) {
		Item item = new Item();
		try {
			this.connect();
			ps=conn.prepareStatement(SQL.GET_ITEM_BY_ID.getQuery());//insert query
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				item.setId(rs.getInt(1));
				item.setName(rs.getString(2));
				item.setQuantityInStock(rs.getInt(3));
				item.setPrice(rs.getDouble(4));
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			this.dispose();//close
		}
		
		return item;
	}

	@Override
	public List<Item> getItemsCostingGreaterThan(double condition) {
		List<Item> items= new ArrayList<>();
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.GET_ITEMS_COSTING_GREATER_THAN.getQuery());
			
			ps.setDouble(1, condition);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Item listItem = new Item (rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
				items.add(listItem);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}finally{
			this.dispose();//close
		}
		return items;
	}

	@Override
	public List<Item> getItemsInStock() {
		List<Item> items = new ArrayList<>();
		try {
			this.connect();
			ps = conn.prepareStatement(SQL.GET_ITEMS_IN_STOCK.getQuery());
			ps.setInt(1, 0);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Item listItem = new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
				items.add(listItem);
			}
		}catch(SQLException e) {
			System.out.println();
		}finally {
			this.dispose();
		}
		return items;
	}

	//This methods quantity parameters subtracts from the existing quantity in the database
	@Override
	public boolean updateQuantityInStock(int id, int quantity) {
		try {
			this.connect();
			ps=conn.prepareStatement(SQL.UPDATE_QUANTITY_IN_STOCK.getQuery());
			ps.setInt(1,quantity);
			ps.setInt(2, id);
			return ps.execute();
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			this.dispose();
		}
		return false;
	}

}
