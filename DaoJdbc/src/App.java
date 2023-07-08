import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 01: SELLER FINDBY ID ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TESTE02 SELLER findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n === TESTE03: SELLER FINDALL ====");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }


         System.out.println("\n === TESTE04: SELLER INSERT ====");
         Seller newseller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
         sellerDao.insert(newseller);
         System.out.println("Insert new id = " + newseller.getId());
    }
}
