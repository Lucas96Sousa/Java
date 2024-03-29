import entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.000));
        list.add(new Product("Laptop", 1200.00));
        list.add(new Product("Tablet", 450.00));

        //Implementação em lambda
        list.sort((p1,p2) ->
                p1.getName().toUpperCase()
                        .compareTo(p2.getName().toUpperCase()));

        for (Product p : list) {
            System.out.println(p);
        }
    }
}