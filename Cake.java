import java.util.Scanner;
import java.util.Arrays;
public class Cake {
  private int cakeCode;
  private String cakeName;
  private double cakePrice;
  public Cake(int cakeCode, String cakeName, double cakePrice){
    this.cakeCode = cakeCode;
    this.cakeName = cakeName;
    this.cakePrice = cakePrice;
  }
  public void setCakeCode(int cakeCode){
    this.cakeCode = cakeCode;
    }
  public void setCakeName(String cakeName){
    this.cakeName = cakeName;
  }
  public void setCakePrice(double cakePrice){
    this.cakePrice = cakePrice;
  }
  public int getCakeCode(){
    return cakeCode;
  }
  public String getCakeName(){
    return cakeName;
  }
  public double getCakePrice(){
    return cakePrice;
  }
  public static String[][] CakeMenu (Scanner input, String[][] cake) {
  while (true) {
    System.out.println("\n***Cake Menu***\n1. Create Cake\n2. Update Cake\n3. Delete Cake\n4. View all Cakes\n5. Back to the Main Menu\n");
    System.out.print("Enter option: ");
    int option = input.nextInt();
    switch (option) {
      case 1: 
        System.out.print("\nEnter Cake's Name:");
        String newCakeName = input.nextLine();
        input.nextLine();
        System.out.print("\nEnter Cake Code: ");
        int newCakeCode = input.nextInt();  
        input.nextLine();  
        System.out.print("\nEnter Cake Price: ");
        double newCakePrice = input.nextDouble();  
        input.nextLine(); 
        
        String[][] newCake = new String[cake.length+1][];
        System.arraycopy(cake,0,newCake,0, cake.length);
        newCake [cake.length] = new String[]{String.valueOf(newCakeCode), newCakeName, String.valueOf(newCakePrice)};
        cake = newCake;
        break;
      case 2:
        System.out.print("Enter Cake Code to update: ");
        int updateCakeCode = input.nextInt();
        if (checkCakeIDExistence(cake, updateCakeCode) == false){
          System.out.print("\nError: No cake code found");
          break;
        }
        else{
          for (int i = 0; i<cake.length; i++){
            if (Integer.parseInt(cake[i][0]) == updateCakeCode){
              System.out.println("Error: Cake Code already exists");
            }
            else{
              System.out.print("Enter new Cake Code: ");
              int updateCode = input.nextInt();
              input.nextLine();
              System.out.print("\nUpdate Cake name: ");
              String updateName = input.nextLine();
              System.out.print("\nUpdate Cake price: ");
              double updatePrice = input.nextDouble();
              input.nextLine();
              cake [i] = new String[]{String.valueOf(updateCode), updateName, String.valueOf(updatePrice)};
            }
          } 
        }
        break;
      case 3:
        System.out.println("Enter Cake Code to delete: ");
        int deleteCakeCode = input.nextInt();
        input.nextLine();
        if (checkCakeIDExistence(cake, deleteCakeCode)) {
          String[][] newCakeArray = new String[cake.length - 1][];
          int index = 0;
          for (int i = 0; i < cake.length; i++) {
            if (Integer.parseInt(cake[i][0]) != deleteCakeCode) {
              newCakeArray[index++] = cake[i];
            }
          }
          cake = newCakeArray;
          System.out.printf("Cake %d is removed", deleteCakeCode);
        } else {
          System.out.println("Error: No cake code found");
        }
        break;
      case 4:
        System.out.println("All Cakes: ");
        
        for (int i = 0; i < cake.length; i++) {
          System.out.println("Cake Code: " + cake[i][0] + ", Name: " + cake[i][1] + ", Price: " + cake[i][2]);
        }
        break;
      case 5:
        System.out.println("Returning to the main menu.");
        return cake;
      default:
        System.out.println("Invalid option");
        break;
      }
    }
  }
  public static boolean checkCakeIDExistence(String[][] cake, int cakeID){
    for (int i =0; i<cake.length; i++){
      if (Integer.parseInt(cake[i][0]) == cakeID){
        return true;
      }
    }
    return false;
  }
}


