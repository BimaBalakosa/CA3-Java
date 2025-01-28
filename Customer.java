import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Customer {
  int customerID;
  String customerName;
  int customerAddress;
  public Customer (int customerID, String customerName, int customerAddress){
    this.customerID = customerID;
    this.customerName = customerName;
    this.customerAddress = customerAddress;
  }
  public void setCustomerID (){

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
      case 2:
        System.out.println();
        break;
      case 3:
        System.out.println();
        break;
      case 4:
        System.out.println();
        break;
      case 5:
        System.out.println();
        return;
      default:
        System.out.println("Invalid option");
        return;
        }
      }
    }
}
