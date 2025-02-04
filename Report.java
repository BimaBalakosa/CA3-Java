import java.util.Scanner;

public class Report {
  public static String[][] GenerateReport (Scanner input, String[][] cake, String[][] order, String[][] customer) {
    while (true) {    
      System.out.println("\n***Report Menu***\n1. Generate Orders report by Date \n2. Generate Orders report by Cake\n3. Generate Orders report by Customer\n4. Generate total number of Orders \n5. Back to the Main menu\n");
      System.out.print("Enter option: ");
      int option = input.nextInt();
      switch (option) {
        case 1:
          System.out.print("Enter date (dd/mm/yyyy): ");
          input.nextLine();
          String date = input.nextLine();
          for (int i = 0; i<order.length; i++){
            if (order[i][1].equals(date)){
              System.out.println("Order ID: "+order[i][0]);
              System.out.println("Cake Code: "+order[i][2]);
              System.out.println("Customer ID: "+order[i][3]);
            }
          }
          break;
        case 2:
          System.out.print("Enter Cake code: ");
          int cakeCode = input.nextInt();
          for (int i = 0; i<order.length; i++){
            if (order[i][2].equals(String.valueOf(cakeCode)) ){
              System.out.println("Order ID: "+order[i][0]);
              System.out.println("Date: "+order[i][1]);
              System.out.println("Customer ID: "+order[i][3]);
            }
          }
          break;
          case 3:
          System.out.print("Enter Customer ID: ");
          int customerID = input.nextInt();
          input.nextLine();
          for (int i = 0; i<order.length; i++){
            if (order[i][3].equals(String.valueOf(customerID))){
              System.out.println("Order ID: "+order[i][0]);
              System.out.println("Date: "+order[i][1]);
              System.out.println("Cake Code: "+order[i][2]);
            }
          }
          break;
        case 4:
          System.out.printf("Total number of Orders: %d", order.length);
          break;
        case 5:
          System.out.println("Returning to the main menu.");
          return null;
        default:
          System.out.println("Invalid option");
          break;
      }
    }
  }
}
