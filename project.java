import java.util.Scanner;
public class project{
  public static void main (String[] args){
    Cake menu1 = new Cake();
    
    Order menu3 = new Order();
    Report menu4 = new Report();
    Scanner input = new Scanner(System.in); 
    while (true) {
      System.out.print("***Main Menu***\n1. Manage Cakes\n2. Manage Customers\n3. Manage Orders\n4. Generate Report\n0. Exit\n"); 
      System.out.print("Enter option: ");
      int option = input.nextInt();
      switch (option) {
      case 0:
        input.close();
        System.out.println("You have exited");
        return;
      case 1:
        System.out.println("\n***Cake Menu***\n1. Create Cake\n2. Update Cake\n3. Delete Cake\n4. View all Cakes\n5. Back to the Main Menu\n");
        System.out.print("Enter option: ");
        
        menu1.CakeMenu(input);
        break;
      case 2:
        System.out.println("\n***Customer Menu***\n1. Add Customer\n2. Edit Customer\n3. Remove Customer\n4. View all Customers\n5. Back to the Main menu\n");
        System.out.print("Enter option: ");
        break;
      case 3:
        System.out.println("\n***Order Menu***\n1. Make an Order\n2. Cancel an Order\n3. View all Orders\n4. Back to the Main menu\n");
        System.out.print("Enter option: ");
        menu3.OrderCustomer(input);  
        break;
      case 4:
        System.out.println("\n***Report Menu***\n1. Generate Orders report by Date \n2. Generate Orders report by Cake\n3. Generate Orders report by Customer\n4. Generate total number of Orders \n5. Back to the Main menu\n");
        System.out.print("Enter option: ");
        menu4.GenerateReport(input);
        break;
      default:
        System.out.println("Invalid input");
        return;
      }
    }
  } 
}

