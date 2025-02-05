import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Order {
  private int month;
  private int day;
  private int year;
  private int orderID;
  private int cakeOrder;
  public Order(int day, int month, int year, int orderID, int cakeOrder){
    this.month = month;
    this.day = day;
    this.year = year;
    this.orderID = orderID;
    this.cakeOrder = cakeOrder;
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
  public void setCakeOrder(int cakeOrder){
    this.cakeOrder = cakeOrder;
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
  public int getCakeOrder(){
    return cakeOrder;
  }
  public String getFormattedDate(){
    return String.format("%02d/%02/%04", day, month, year);
  }

  public static String[][] OrderCustomer (Scanner input, String[][] order) {
  while (true) {
    System.out.println("\n***Order Menu***\n1. Make an Order\n2. Cancel an Order\n3. View all Orders\n4. Back to the Main menu\n");
    System.out.print("Enter option: ");
    int cake = input.nextInt();
    input.nextLine();
    switch (cake) {
      case 1:
        System.out.print("Enter Order date (dd//mm/yyyy): ");
        String date = input.nextLine();
        if (isValidDate(date) == false){
          System.out.println("Error: Invalid date");
          break;
        }
        System.out.print("\nEnter Customer's ID: ");
        int customerID = input.nextInt();
        input.nextLine();
        System.out.print("\nEnter Cake's ID: ");
        int cakeOrder = input.nextInt();
        input.nextLine();
        System.out.print("\nEnter Order ID: ");
        int orderID = input.nextInt();
        input.nextLine();
        if (checkOrderExistence(order, orderID)){
          System.out.println("Error: Order ID already existed");
          break;
        }
        else{
          String[][] newOrder = new String[order.length+1][];
          System.arraycopy(order, 0, newOrder, 0, order.length);
          newOrder [order.length] = new String[]{String.valueOf(orderID), date, String.valueOf(cakeOrder), String.valueOf(customerID)};
          order = newOrder;
          System.out.print("\nCake"+" "+ cakeOrder+" "+"ordered on"+" "+date+""+", Order ID is"+" "+orderID);
        }
        break;
      case 2:
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
        break;
      case 3:
        if (order.length == 0) {
          System.out.println("No orders to display.");
        } 
        else {
          System.out.println("Viewing all orders");
          for (int i = 0; i < order.length; i++) {
            System.out.println("Order ID: " + order[i][0]);
            System.out.println("Date: " + order[i][1]);
            System.out.println("Cake Code: " + order[i][2]);
            System.out.println("Customer ID: "+ order[i][3]);
            System.out.println();
          }
      }
        break;
      case 4:
        System.out.println("Returning to the main menu");
        return order;
      default:
        System.out.println("Invalid option");
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
}
