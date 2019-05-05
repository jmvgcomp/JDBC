package DAOProject.model.dao;

import DAOProject.model.dao.Impl.SellerJDBC;
import DAOProject.model.entities.Seller;
import db.DB;

public class DAOFactory {
    public static DAO<Seller> createSellerDao(){
        return new SellerJDBC(DB.getConnection());
    }
}
