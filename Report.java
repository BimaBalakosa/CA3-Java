import java.util.Scanner;

public class Report {
    public void GenerateReport (Scanner input) {
    while (true) {
      
      int cake = input.nextInt();
      switch (cake) {
        case 1:
        System.out.println();
        break;
        case 2:
        System.out.print("Enter Cake code: ");
        int cakeCode = input.nextInt();
        break;
        case 3:
        System.out.println();
        break;
        case 4:
        System.out.printf("Total number of Orders: ");
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
