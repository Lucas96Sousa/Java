import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
  public static void main(String[] args) {
    /*
     * method1();
     * 
     * System.out.println("End of program");
     * }
     * public static void method1() {
     * System.out.println("***METHOD1 START***");
     * method2();
     * System.out.println("***METHOD1 END***");
     * }
     * 
     * public static void method2() {
     * System.out.println("***METHOD2 START***");
     * Scanner sc = new Scanner(System.in);
     * 
     * try {
     * String[] vect = sc.nextLine().split(" ");
     * int position = sc.nextInt();
     * System.out.println(vect[position]);
     * 
     * 
     * }
     * catch(ArrayIndexOutOfBoundsException e ) {
     * System.out.println("Invalid position");
     * e.printStackTrace();
     * System.out.println();
     * 
     * }
     * catch(InputMismatchException e) {
     * System.out.println("Input error");
     * }
     * 
     * sc.close();
     * System.out.println("***METHOD2 END***");
     * 
     * }
     */

<<<<<<< Updated upstream
        System.out.println("End of program");
      }

    public static void method1() {
        System.out.println("***METHOD1 START***");
        method2();
        System.out.println("***METHOD1 END***");

    }
  
    public static void method2() {
        System.out.println("***METHOD2 START***");
        Scanner sc = new Scanner(System.in);

        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
          

        }
        catch(ArrayIndexOutOfBoundsException e ) {
            System.out.println("Invalid position");
            e.printStackTrace();
            System.out.println();
            
        }
        catch(InputMismatchException e) ear
          
            System.out.println("Input error"); 
        }
        
        sc.close();
        System.out.println("***METHOD2 END***");
        
     } */
      
=======
>>>>>>> Stashed changes
    File file = new File("/tmp/test.txt");
    Scanner sc = null;
    try {
      sc = new Scanner(file);
      while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.print("Error opening file: " + e.getMessage());
    } finally {
      if (sc != null) {
        sc.close();
      }
      System.out.println("Finally block executed !!!");
    }
  }
}
