import java.util.Scanner;

public class project{
  public static void main (String[] args){
    String[][] cake = new String[2][];
    String[][] customer = new String[2][];
    String [][] order = new String[2][];
    Cake choco = new Cake(1001, "Chocolate", 30.4);
    Cake straw = new Cake(1002, "Strawberry", 25.1);
    Customer guest1 = new Customer(101, "Jerry", "Bukit Panjang", 999);
    Customer guest2 = new Customer(102, "Yin Xuan", "Malay", 991);
    Order order1 = new Order(04, 02, 2025, 1, 1001);
    Order order2 = new Order(05, 03, 2025, 2, 1002);
    cake[0] = new String[]{String.valueOf(choco.getCakeCode()), choco.getCakeName(), String.valueOf(choco.getCakePrice())};
    cake[1] = new String[]{String.valueOf(straw.getCakeCode()), straw.getCakeName(), String.valueOf(straw.getCakePrice())};
    customer[0] = new String[]{String.valueOf(guest1.getCustomerID()), guest1.getCustomerName(), guest1.getCustomerAddress(), String.valueOf(guest1.getCustomerContact())};
    customer[1] = new String[]{String.valueOf(guest2.getCustomerID()), guest2.getCustomerName(), guest2.getCustomerAddress(), String.valueOf(guest2.getCustomerContact())};
    order[0] = new String[]{String.valueOf(order1.getDay()), String.valueOf(order1.getMonth()), String.valueOf(order1.getYear()),String.valueOf(order1.getOrderID()), String.valueOf(order1.getCakeOrder())};
    order[1] = new String[]{String.valueOf(order2.getDay()), String.valueOf(order2.getMonth()), String.valueOf(order2.getYear()),String.valueOf(order2.getOrderID()), String.valueOf(order2.getCakeOrder())};
    Scanner input = new Scanner(System.in); 
    while (true) {
      System.out.print("***Main Menu***\n1. Manage Cakes\n2. Manage Customers\n3. Manage Orders\n4. Generate Report\n0. Exit\n"); 
      System.out.print("Enter option: ");
      int option = input.nextInt();
      switch (option) {
      case 0:
        input.close();
        System.out.println("Thank you for using the Cake Ordering System.");
        return;
      case 1:
        cake = Cake.CakeMenu(input, cake);
        break;
      case 2:
        customer = Customer.CustomerMenu(input, customer);
        break;
      case 3:
        order = Order.OrderCustomer(input, order);        
        break;
      case 4:
        Report.GenerateReport(input, cake, order, customer);
        break;
      default:
        System.out.println("Invalid input");
        return;
      }
    }
  } 
}

