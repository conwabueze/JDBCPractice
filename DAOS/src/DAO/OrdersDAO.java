package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import DAO.ItemDAOI.SQL;

public class OrdersDAO extends AbstractDAO implements OrdersDAOI{
	

	@Override
	public boolean createOrder(Map<Integer, Integer> map) {
		
		
		try {
			//retrieving max order id
			this.connect();
			ps=conn.prepareStatement(SQL.GET_MAX.getQuery());//insert query
			rs=ps.executeQuery();
			rs.next();
			int max = rs.getInt(1) + 1; //found max and now want to add 1 to add new inserts to db
			rs.close();
			
			int itemId=0, quantity =0;
			
			Set<Integer> itemIdList = map.keySet();
			ps=conn.prepareStatement(SQL.CREATE_ORDER.getQuery());
			
			for(int key: itemIdList) {
				itemId = key;
				quantity=map.get(key);
				ps.setInt(1, max);
				ps.setInt(2, itemId);
				ps.setInt(3, quantity);
				ps.addBatch();
				max++;
			}
				int[] rows = ps.executeBatch();
				return ps.executeUpdate()>0;
			
		}catch(SQLException e){
			
		}finally {
			this.dispose();
		}
		return false;
	}

}
