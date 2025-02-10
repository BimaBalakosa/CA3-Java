import java.util.Scanner;
import java.util.InputMismatchException;
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
      input.nextLine();
      switch (option) {
        case 1:
        try{
          System.out.print("\nEnter Cake's Code: ");
          int newCakeCode = input.nextInt();  
          input.nextLine();  
          if (checkCakeIDExistence(cake, newCakeCode)){
            System.out.println("\nError: Cake Code already exists");
            break;
          }
          System.out.print("\nEnter Cake's Name: ");
          String newCakeName = input.nextLine();
          System.out.print("\nEnter Cake's Price: ");
          double newCakePrice = input.nextDouble();  
          input.nextLine(); 
          String[][] newCake = new String[cake.length+1][];
          System.arraycopy(cake,0,newCake,0, cake.length);
          newCake [cake.length] = new String[]{String.valueOf(newCakeCode), newCakeName, String.valueOf(newCakePrice)};
          cake = newCake;
        } catch (InputMismatchException e){
          System.out.println("Error: Invalid inputs!");
        }
          break;
        case 2:
        try{
          System.out.print("\nEnter Cake Code to update: ");
          int updateCakeCode = input.nextInt();
          System.out.println();
          if (checkCakeIDExistence(cake, updateCakeCode) == false){
            System.out.println("\nError: No cake code found");
            break;
          }
          else{
            System.out.print("Enter new Cake Code: ");
            int updateCode = input.nextInt();
            input.nextLine();
            if (checkCakeIDExistence(cake, updateCode)){
              System.out.println("\nCake code already exists");
              break;
            }
            for (int i = 0; i<cake.length; i++){
              if (cake[i][0].equals(String.valueOf(updateCakeCode))){
                System.out.print("\nUpdate Cake name: ");
                String updateName = input.nextLine();
                System.out.print("\nUpdate Cake price: ");
                double updatePrice = input.nextDouble();
                input.nextLine();
                cake [i] = new String[]{String.valueOf(updateCode), updateName, String.valueOf(updatePrice)};
                System.out.println("\nCake updated successfully");
                break;
              }
            }
          }
        }
        catch (InputMismatchException e){
            System.out.println("Error: Invalid inputs!");
        }
          break;
        case 3:
        try{
          System.out.print("\nEnter Cake Code to delete: ");
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
            System.out.printf("%nCake %d is removed%n", deleteCakeCode);
          } else {
            System.out.println("\nError: No cake code found");
          }
        } catch (InputMismatchException e){
          System.out.println("Error: Invalid inputs!");
        }
          break;
        case 4:
          if (cake.length == 0){
            System.out.println("Out of Cake");
          }
          else{         
            System.out.println("\nAll Cakes: ");
            for (int i = 0; i < cake.length; i++) {
              System.out.println("Cake Code: " + cake[i][0] + ", Name: " + cake[i][1] + ", Price: " + cake[i][2]);
            }
          }
          break;
        case 5:
          System.out.println("\nReturning to the main menu.\n");
          return cake;
        default:
          System.out.println("\nInvalid option");
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
