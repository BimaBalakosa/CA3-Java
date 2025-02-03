import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Customer {
    private int customerID;
    private String customerName;
    private int customerAddress;
    public Customer (int customerID, String customerName, int customerAddress){
    this.customerID = customerID;
    this.customerName = customerName;
    this.customerAddress = customerAddress;
    }
  public void setCustomerID (int customerID){
    this.customerID = customerID;
  }
  public int getCustomerID (){
    return customerID;
  }
  public void setCustomerName(String customerName){
    this.customerName = customerName;
  }
  public String getCustomerName(){
    return customerName;
  }
  public void setCustomerAddress(int customerAddress){
    this.customerAddress = customerAddress;
  }
  public int getCustomerAddress(){
    return customerAddress;
  }
  public void CustomerMenu (Scanner input) {
    while (true) {
      int cake = input.nextInt();
      switch (cake) {
      case 1:
        System.out.print("Enter Customer ID: ");
        int customerID = input.nextInt();
        input.nextLine();
        System.out.print("\nEnter Customer full name: ");
        String customerName = input.nextLine();
        System.out.print("\nEnter Customer contact number: ");
        int customerContact = input.nextInt();
        input.nextLine();
        System.out.print("\nEnter Customer Address: ");
        String customerAddress = input.nextLine();
        break;
      case 2: // Edit Customer
                    System.out.print("Enter Customer ID to edit: ");
                    int editID = input.nextInt();
                    // Implement editing logic here
                    System.out.println("Editing customer with ID: " + editID + " (not implemented)");
                    break;

      case 3: // Remove Customer
          System.out.print("Enter Customer ID to remove: ");
          int removeID = input.nextInt();
          // Implement removing logic here
          System.out.println("Removing customer with ID: " + removeID + " (not implemented)");
          break;

      case 4: // View all Customers
          System.out.println("Viewing all customers (not implemented)");
          break;

      case 5: // Back to Main Menu
          return;

      default: 
          System.out.println("Invalid option");
          break;
  
        }
      }
    }
}
