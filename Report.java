import java.util.InputMismatchException;
import java.util.Scanner;

public class Report {
  public static String[][] GenerateReport (Scanner input, String[][] cake, String[][] customer, String[][] order) {
    while (true) {    
      System.out.println("\n***Report Menu***\n1. Generate Orders report by Date \n2. Generate Orders report by Cake\n3. Generate Orders report by Customer\n4. Generate total number of Orders \n5. Back to the Main menu\n");
      System.out.print("Enter option: ");
      int option = input.nextInt();
      switch (option) {
        case 1:
        try{
          boolean found = false;
          System.out.print("\nEnter date (dd/mm/yyyy): ");
          input.nextLine();
          String date = input.nextLine();
          if (Order.isValidDate(date) == false){
            System.out.println("Error: Invalid date input");
            break;
          }
          for (int i = 0; i<order.length; i++){
            if (order[i][1].equals(date)){
              System.out.println("Order ID: "+order[i][0]);
              System.out.println("Cake Code: "+order[i][2]);
              System.out.println("Customer ID: "+order[i][3]);
              found = true;
              System.out.println();
            }
          }
          if (!found){
            System.out.println("\nNo date found");
          }
          
        } catch (InputMismatchException e){
          System.out.println("Error: Invalid inputs!");
        }
          break;
        case 2:
        try{
          boolean found1 = false;
          System.out.print("\nEnter Cake code: ");
          int cakeCode = input.nextInt();
          if (Cake.checkCakeIDExistence(cake, cakeCode) == false){
            System.out.println("\nError: No Cake code found");
            break;
          }
          for (int i = 0; i<order.length; i++){
            if (order[i][0].equals(String.valueOf(cakeCode)) ){
              System.out.println("Order ID: "+order[i][2]);
              System.out.println("Date: "+order[i][1]);
              System.out.println("Customer ID: "+order[i][3]);
              found1 = true;
              System.out.println();
            }
          }
          if (!found1){
            System.out.println("\nCake has not been ordered");
            break;
          }
        } catch (InputMismatchException e){
          System.out.println("\nError: Invalid inputs!");
        }
          break;
        case 3:
        try{
          boolean found2 = false;
          System.out.print("\nEnter Customer ID: ");
          int customerID = input.nextInt();
          input.nextLine();
          if (Customer.checkIDExistence(customer, customerID) == false){
            System.out.println("\nErrors: No Customer ID found");
            break;
          }
          for (int i = 0; i<order.length; i++){
            if (order[i][3].equals(String.valueOf(customerID))){
              System.out.println("Order ID: "+order[i][2]);
              System.out.println("Date: "+order[i][1]);
              System.out.println("Cake Code: "+order[i][0]);
              found2 = true;
              System.out.println();
            }
          }
          if (!found2){
            System.out.println("\nNo Customer Record");
          }
        } catch (InputMismatchException e){
          System.out.println("\nError: Invalid inputs!");
        }
          break;
        case 4:
          if (order.length == 0){
            System.out.println("\nNo order at the moment");
          }
          System.out.printf("%nTotal number of Orders: %d%n", order.length);
          break;
        case 5:
          System.out.println("\nReturning to the main menu.");
          return null;
        default:
          System.out.println("\nError: Invalid option");
          break;
      }
    }
  }
}
