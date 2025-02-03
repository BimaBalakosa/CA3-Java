import java.util.Scanner;

public class Order {
    public void OrderCustomer (Scanner input) {
    while (true) {
      
      int cake = input.nextInt();
      switch (cake) {
        case 1:
        System.out.println();
        break;
        case 2:
        System.out.println();
        break;
        case 3:
        System.out.println();
        break;
        case 4:
        System.out.println();
        return;
        default:
        System.out.println("Invalid option");
        return;
      }
    }
  }


    import java.util.Scanner;
import java.time.LocalDate;
public class Order {
  private int month;
  private int day;
  private int year;
  private int orderID;
  private String cakeOrder;
  public void setMonth(int month){
    this.month = month;
  }
  public void setDay(int day){
    this.day = day;
  }
  public void setYear(int year){
    this.year = year;
  }
  public void setCustomerID(int customerID){
    this.orderID = customerID;
  }
  public void setCakeOrder(String cakeOrder){
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
  public int getCustomerID(){
    return orderID;
  }
  public String getCakeOrder(){
    return cakeOrder;
  }
  public String getFormattedDate(){
    return String.format("%02d/%02/%04",day ,month, year);
  }
  public String toString(){
    return "Order{"+"Date ="+ getFormattedDate() + ", Customer ID =" + orderID + ", Cake Order=" + cakeOrder +"}";
  }
  public void OrderCustomer (Scanner input) {
  while (true) {
    int cake = input.nextInt();
    switch (cake) {
      case 1:
        System.out.println("Enter Order date (dd//mm/yyyy): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();
        input.nextLine();
        LocalDate dateOrder = LocalDate.of(year, month,day);
        System.out.println("Enter Customer's ID: ");
        int customerID = input.nextInt();
        input.nextLine();
        System.out.println("Enter cake's name:");
        String cakeOrder = input.nextLine();
        System.out.printf("Cake %s ordered on %s, Order ID is %d%n", cakeOrder, dateOrder, customerID);
        break;
      case 2:
        System.out.println("Enter Order ID: ");
        int oID = input.nextInt();
        System.out.printf("Order ID %d is cancelled", oID);
        break;
      case 3:
        System.out.println("Viewing all orders");
        break;
      case 4:
        System.out.println();
        return;
      default:
        System.out.println("Invalid option");
        return;
      }
    }
  }
}

}
