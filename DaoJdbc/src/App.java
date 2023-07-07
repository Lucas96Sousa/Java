import java.sql.SQLException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;



public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        SellerDao sellerDao = DaoFactory.createSellerDao();
        

        System.out.println("=== TEST 01: SELLER FINDBY ID ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        
    }
}
