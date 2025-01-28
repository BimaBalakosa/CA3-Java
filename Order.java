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
}
