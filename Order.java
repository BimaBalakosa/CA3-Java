import java.util.InputMismatchException;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Order {
  private int month;
  private int day;
  private int year;
  private int cakeOrderID;
  private int customerOrderID;
  private int orderID;
  
  public Order(int day, int month, int year, int cakeOrder, int customerOrderID, int orderID){
    this.month = month;
    this.day = day;
    this.year = year;
    this.orderID = orderID;
    this.cakeOrderID = cakeOrder;
    this.customerOrderID = customerOrderID;
  }
  public void setMonth(int month){
    this.month = month;
  }
  public void setDay(int day){
    this.day = day;
  }
  public void setYear(int year){
    this.year = year;
  }
  public void setOrderrID(int orderID){
    this.orderID = orderID;
  }
  public void setCakeOrderID(int cakeOrder){
    this.cakeOrderID = cakeOrder;
  }
  public void setOrderCustomerID(int customerID){
    this.customerOrderID = customerID;
  }
  public int getDay(){
    return day;
  }
  public int getMonth(){
    return month;
  }
  public int getYear(){
    return year;
  }
  public int getOrderID(){
    return orderID;
  }
  public int getCakeOrderID(){
    return cakeOrderID;
  }
  public int getOrderCustomerID(){
    return customerOrderID;
  }
  public String getFormattedDate(){
    return String.format("%02d/%02d/%04d", day, month, year);
  }

  public static String[][] OrderCustomer (Scanner input, String[][] customer, String[][] cake, String[][] order) {
  while (true) {
    System.out.println("\n***Order Menu***\n1. Make an Order\n2. Cancel an Order\n3. View all Orders\n4. Back to the Main menu\n");
    System.out.print("Enter option: ");
    int option = input.nextInt();
    input.nextLine();
    switch (option) {
      case 1:
      try {
        System.out.print("Enter Order date (dd//mm/yyyy): ");
        String date = input.nextLine();
        
        if (isValidDate(date) == false){
          System.out.println("Error: Invalid date");
          break;
        }
        if (checkOrderLogic(order, date) == cake.length){
          System.out.println("No more Cake");
          break;
        }
        System.out.print("\nEnter Customer's ID: ");
        int customerID = input.nextInt();
        input.nextLine();
        if (Customer.checkIDExistence(customer, customerID) == false){
          System.out.println("Error: No Customer ID found");
          break;
        }
        System.out.print("\nEnter Cake's ID: ");
        int cakeOrderID = input.nextInt();
        input.nextLine();
        if (Cake.checkCakeIDExistence(cake, cakeOrderID) == false){
          System.out.println("Error: No Cake ID found");
          break;
        }
        System.out.print("\nEnter Order ID: ");
        int newOrderID = input.nextInt();
        input.nextLine();
        if (checkOrderExistence(order, newOrderID)){
          System.out.println("Error: Order ID already existed");
          break;
        }
        else{
          String[][] newOrder = new String[order.length+1][];
          System.arraycopy(order, 0, newOrder, 0, order.length);
          newOrder [order.length] = new String[]{String.valueOf(cakeOrderID), date, String.valueOf(newOrderID), String.valueOf(customerID)};
          order = newOrder;
          System.out.print("\nCake"+" "+ cakeOrderID+" "+"ordered on"+" "+date+""+", Order ID is"+" "+newOrderID);
        }
      } catch (InputMismatchException e){
          System.out.println("Error: Invalid inputs!");
      }
        break;
      case 2:
      try{
        System.out.println("Enter Order ID: ");
        int oID = input.nextInt();
        if (checkOrderExistence(order, oID)){
          String[][] newOrderArray = new String[order.length-1][];
          int index = 0;
          for (int i = 0; i < order.length; i++) {
              if (Integer.parseInt(order[i][0]) != oID) {
                  newOrderArray[index++] = order[i];
              }
          }
          order = newOrderArray;
          System.out.printf("Order ID %d is cancelled", oID);
        }
        else{
          System.out.println("Error: No Order ID: found");
          break;
        }
      } catch (InputMismatchException e){
        System.out.println("Error: Invalid inputs!");
      }
        break;
      case 3:
        if (order.length == 0) {
          System.out.println("No orders to display.");
        } 
        else {
          System.out.println("Viewing all orders");
          for (int i = 0; i < order.length; i++) {
            System.out.println("Cake Code: " + order[i][0]);
            System.out.println("Date: " + order[i][1]);
            System.out.println("Order ID: " + order[i][2]);
            System.out.println("Customer ID: "+ order[i][3]);
            System.out.println();
          }
      }
        break;
      case 4:
        System.out.println("Returning to the main menu");
        return order;
      default:
        System.out.println("Error: Invalid option");
        break;
      }
    }
  }
  public static boolean checkOrderExistence(String[][] order, int orderID) {
    for (int i = 0; i < order.length; i++) {
        if (Integer.parseInt(order[i][0]) == orderID) {
            return true;
        }
    }
    return false;
  }
  public static boolean isValidDate(String inputDate) {
    LocalDate currentDate = LocalDate.now();
    int currentYear = currentDate.getYear();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date = LocalDate.parse(inputDate, formatter);

    if (date.getYear() != currentYear) {
        return false;
    }
    return !date.isBefore(currentDate); 
  }
  public static int checkOrderLogic(String [][] array, String date){
    int count = 0;
    for (String[] i : array){
      if (i[1].equals(date)){
        count++;
      }
    }
    return count;
  }
}
