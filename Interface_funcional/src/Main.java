import entities.Product;
import util.ProdcutPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.00));
        list.add(new Product("HD Case", 80.00));


        /* Predicate
        list.removeIf( new ProdcutPredicate());
        */

        /* Static Predicate
        list.removeIf(Product::staticProductPredicate);
        */

        //Non static predicate
        list.removeIf(Product::nonstaticProductPredicate);

        for(Product p : list) {
            System.out.println(p);
        }
    }
}