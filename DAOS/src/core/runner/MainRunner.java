package core.runner;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import DAO.ItemDAO;
import DAO.OrdersDAO;
import Models.Item; 

/*
 * 1. import
 * 2.load and register the driver
 * 3.Establish the connection->Done by Driver manager
 * 4.Create the statement
 * 5.Execute the query
 * 6.Process the Results
 * 7.close the connection
 */


public class MainRunner {

	public static void main(String[] args) {
		/*
		 
		//Assignment 1
		 
		//return item with specified ID
		ItemDAO items = new ItemDAO();
		Item item = items.getItemByID(78);
		System.out.println(item.toString());
		
		//Return list of items which have a price value greater than the given price
		Double condition = 600.99;
		List<Item> listOfItems = items.getItemsCostingGreaterThan(condition);
		System.out.println("\nItems with price greater than "+condition);
		for(Item x: listOfItems) {
			System.out.println(x.toString());
		}
		
		//Return list of items with quantity in stock greater than 0
		listOfItems = items.getItemsInStock();
		System.out.println("\nItems with quantity in stock");
		for(Item y:listOfItems) {
			System.out.println(y.toString());
		}*/
		
		//part2
		
		//1.Displays available items to the user with the getItemsInStock() method
		System.out.println("ITEMS AVAILABLE \n");
		ItemDAO items = new ItemDAO(); ////Delete Later////
		List<Item> listOfItems = items.getItemsInStock();//Delete Later///
		System.out.println("\nItems with quantity in stock");
		for(Item y:listOfItems) {
			System.out.println(y.toString());
		}
		//2.Allows user to add them to their cart
		Map<Integer, Integer> ordersMap = new HashMap();
		Scanner input =  new Scanner(System.in);
		int finishedOrder = 1;
		while(finishedOrder!=0) {
			System.out.println("Enter ID of desired order: ");
			int orderId = input.nextInt();
			System.out.println("Enter quantity of your desired prooduct: ");
			int quantityOfOrder = input.nextInt();
			
			//Check to see if user put the same product more than once in their cart and if they did 
			//add the quantity from the previous cart input with the new one
			for(int key: ordersMap.keySet()) {
				if(key == orderId) {
					quantityOfOrder+=ordersMap.get(key);
				}
			}
			ordersMap.put(orderId, quantityOfOrder);
			
			System.out.println("Anything else?... YES enter 1 NO enter 0");
			finishedOrder = input.nextInt();
			
			
		}
		
		//3.Allows user to checkout
		System.out.println("Would you like to check out the items?");
		//Print out current cart
		for(int key: ordersMap.keySet()) {
			System.out.println("Item ID: " + key + " Quantity: " + ordersMap.get(key));
		}
	
		System.out.println("Yes Enter 1/No Enter 0?");
		
		int checkOut = input.nextInt();
		
		input.close();
		
		//4.When user checks out, use the createOrder() method to create an order with the item ids and quantities they purchased
		if(checkOut == 1) {
			OrdersDAO orders = new OrdersDAO();
			orders.createOrder(ordersMap);
			
		//5.After the order is created, use the updateQuantityInStock() method to update the quantity_in_stock for each item purchased
			
			for(int key: ordersMap.keySet()) {
				items.updateQuantityInStock(key, ordersMap.get(key));
			}
		}
		
	}
}
