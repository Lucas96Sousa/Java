package model.dao;

import db.DB;
import java.sql.SQLException;
import model.dao.impl.SellerDaoJDBC;



public class DaoFactory {
    
    public static SellerDao createSellerDao() throws ClassNotFoundException, SQLException {
        return new SellerDaoJDBC(DB.getConnection());
    }
}
