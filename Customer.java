import java.util.Scanner;

public class Customer {
  private int customerID;
  private String customerName;
  private String customerAddress;
  private int customerContact;
  public Customer (int customerID, String customerName, String customerAddress, int customerContact){
    this.customerID = customerID;
    this.customerName = customerName;
    this.customerAddress = customerAddress;
    this.customerContact = customerContact;
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
  public void setCustomerAddress(String customerAddress){
    this.customerAddress = customerAddress;
  }
  public String getCustomerAddress(){
    return customerAddress;
  }
  public void setCustomerContact(int customerContact){
    this.customerContact = customerContact;
  }
  public int getCustomerContact(){
    return customerContact;
  }
  public static String [][] CustomerMenu (Scanner input, String[][] customer) {
    while (true) {
      System.out.println("\n***Customer Menu***\n1. Add Customer\n2. Edit Customer\n3. Remove Customer\n4. View all Customers\n5. Back to the Main menu\n");
      System.out.print("Enter option: ");
      int option = input.nextInt();
      switch (option) {
      case 1:
        System.out.print("Enter Customer ID: ");
        int customerID = input.nextInt();
        if (checkIDExistence(customer, customerID)){
          System.out.println("Error: ID already existed.");
          break;
        }
        else{
          System.out.print("\nEnter Customer full name: ");
          String customerName = input.nextLine();
          input.nextLine();
          System.out.print("\nEnter Customer Address: ");
          String customerAddress = input.nextLine();
          input.nextLine();
          System.out.print("\nEnter Customer contact number: ");
          int customerContact = input.nextInt();
          input.nextLine();
          String [][] newGuest = new String[customer.length+1][];
          System.arraycopy(customer, 0, newGuest, 0, customer.length);
          newGuest[customer.length] = new String[]{String.valueOf(customerID), customerName, String.valueOf(customerContact), customerAddress};
          customer = newGuest;
          System.out.println("Customer Added Successfully");
        }
        break;
      case 2:
        System.out.print("Enter Customer's ID to edit: ");
        int editID = input.nextInt();
        System.out.println();
        if (checkIDExistence(customer, editID) == false  ){
          System.out.println("Error: No ID found");
        }
        else {
          for (int i = 0; i<customer.length; i++){
            if (Integer.parseInt(customer[i][0]) == editID){
              System.out.println("Enter Customer's new ID: ");
              int newID = input.nextInt();
              input.nextLine();
              if (checkIDExistence(customer, newID) && newID != editID) {
                System.out.println("Error: New ID already exists.");
              }
              else{
                System.out.println("Enter Customer's full name to edit: ");
                String editName = input.nextLine();
                System.out.println("Enter Customer's contact number to edit: ");
                int editContact = input.nextInt();
                input.nextLine();
                System.out.println("Enter Customer's Address to edit: ");
                String editAddress = input.nextLine();
                customer[i] = new String[]{String.valueOf(newID), editName, String.valueOf(editContact), editAddress};
              }
            }
          }
        }
          break;
      case 3:
        System.out.println("Enter Customer's ID to remove: ");
        int removeID = input.nextInt();
        if (checkIDExistence(customer, removeID)) {
          String[][] newCustomerArray = new String[customer.length - 1][];
          int index = 0;
          for (int i = 0; i < customer.length; i++) {
              if (Integer.parseInt(customer[i][0]) != removeID) {
                  newCustomerArray[index++] = customer[i];
              }
          }
          customer = newCustomerArray;
          System.out.println("Customer removed successfully.");
      } else {
          System.out.println("Error: No ID found.");
      }        
        break;
      case 4:
        if (customer.length == 0) {
          System.out.println("No customers to display.");
        } 
        else {
          System.out.println("\nAll Customer Details:");
          for (int i = 0; i < customer.length; i++) {
            System.out.println("ID: " + customer[i][0]);
            System.out.println("Name: " + customer[i][1]);
            System.out.println("Contact: " + customer[i][2]);
            System.out.println("Address: " + customer[i][3]);
            System.out.println();
          }
      }
      break;
      case 5:
        System.out.println("Returning to the main menu.");
        return customer;
      default:
        System.out.println("Invalid option");
        break;
      }
    }
  }
  public static boolean checkIDExistence(String[][] customer, int customerID){
    for (int i =0; i<customer.length; i++){
      if (Integer.parseInt(customer[i][0]) == customerID){
        return true;
      }
    }
    return false;
  }
}
