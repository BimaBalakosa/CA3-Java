import java.util.Scanner;

public class project{
  public static void main (String[] args){
    String[][] customer = new String[0][];
    String[][] cake = new String[0][];
    String [][] order = new String[0][];
    Cake choco = new Cake(1001, "Chocolate", 30.4);
    Cake straw = new Cake(1002, "Strawberry", 25.1);
    Customer guest1 = new Customer(101, "Jerry", "Bukit Panjang", 999);
    Customer guest2 = new Customer(102, "Yin Xuan", "Malay", 991);
    Order order1 = new Order(04, 02, 2025, 1, 1001);
    Order order2 = new Order(05, 03, 2025, 2, 1002);
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

