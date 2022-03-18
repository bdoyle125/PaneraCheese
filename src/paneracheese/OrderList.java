// Bryce Doyle

package paneracheese;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class OrderList {
    
    Queue<Order> orderList = new LinkedList<>();
    
    protected void addOrder()
    {
        Scanner scan = new Scanner(System.in);
        
        // Asks for the customer's order description
        System.out.println("Enter order description:");
        String description = scan.nextLine();
        
        // Asks for their name
        System.out.println("Enter customer name:");
        String name = scan.nextLine();
        
        // I looked up how to do Timestamps. I've never learned it.
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
        // Adds these three componenets into a new order
        orderList.add(new Order(description, name, sdf.format(date)));
        scan.close();
    }
    
    protected void listOrders()
    {
        // Prints out the orders already on the list
        if (orderList.size() > 0)
        {
            System.out.printf("%-10s\t%-10s\t%-10s\n------------------------------------------------------\n", "Name", "Order", "Time");
            
            for (Order o: orderList)
            {
                System.out.printf("%-10s\t%-10s\t%-10s\n", o.customerName, o.customerDescription, o.customerTimestamp);
            }
        }
        
        // Included in case the size of orderList is empty
        else
        {
            System.out.println("No pending orders");
        } 
        
    }
    
    protected void serveNextOrder()
    {
        // Prints out the information of the order to be served before it is pulled from the queue
        System.out.printf("Now serving ... %-10s\t%-10s\t%-10s\n", orderList.peek().customerName, orderList.peek().customerDescription, orderList.peek().customerTimestamp);
        orderList.poll();
    }
    
    protected void cancelOrder()
    {
        Scanner scan = new Scanner(System.in);
        
        // Asks for the name, so that the program can cancel the correct order
        System.out.println("Enter customer name:");
        String name = scan.nextLine();
        
        // Searches the queue for the order name and deletes the order when found
        if (orderList.size() > 0)
        {
            for (Order o: orderList)
            {
                if (name.equals(o.customerName))
                {
                    System.out.println(o.customerName + "'s order has been removed");
                    orderList.remove(o);
                }
            }
        }
        
        // Exists in case there are no more orders.
        else
        {
            System.out.println("There are no orders to remove");
        }
        
        scan.close();
    }
    
}
