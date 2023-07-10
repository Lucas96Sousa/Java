import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 01: SELLER FINDBYID ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 02 SELLER FINDBYDEPARTMENT ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n === TEST 03: SELLER FINDALL ====");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println("\n" + obj);
        }

        System.out.println("\n === TEST 04: SELLER INSERT ====");
        Seller newseller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newseller);
        System.out.println("Insert new id = " + newseller.getId());

        System.out.println("\n === TEST 05: SELLER UPDATE ====");
        seller = sellerDao.findById(1);
        seller.setName("Maria Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n === TEST 06: SELLER DELETE ====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
    }
}
