import java.util.Scanner;

import service.PrintService;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);

       PrintService ps = new PrintService();

       System.out.print("How many values? ");
        int n = sc.nextInt();

        for (int i=0; i < n; i++) {
            int value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        System.out.print("First: " + ps.first());

        sc.close();
    }
}
