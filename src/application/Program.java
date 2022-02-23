package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc =  new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		
		System.out.println("Enter the client data: ");
		System.out.print("Name:");
		String clientName =  sc.nextLine();
		System.out.print("Email:");
		String clientEmail = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate =  sdf.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
		System.out.println("How many item to this order? ");
		int n = sc.nextInt();
		
		Order order = new Order(new Date(),orderStatus,client);
		
		System.out.println("Order Summary: ");
		for(int i =1 ; i<= n ; i++) {
			System.out.println("Enter item #" + i + ":");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice =  sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem =  new OrderItem(productQuantity,productPrice,product);
			
			order.addItem(orderItem);
			
			
		}
		
		
		System.out.println("Order Summary:");
		System.out.println(order);
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
