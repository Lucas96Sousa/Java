import java.util.Locale;
import java.util.Scanner;

import entities.OrderItem;
import entities.Product;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        
        Product p = new Product("TV", 1000.0);

        OrderItem ord = new OrderItem(1, 1000.0, p);// faz a associação ao produto

        System.out.println(ord);

        sc.close();
    }
}