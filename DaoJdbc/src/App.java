import java.util.Date;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;


public class App {
    public static void main(String[] args) {

        Department obj = new Department(1, "books");
        System.out.println(obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 2000.0, obj);
        System.out.println(seller);
        
    }
}
