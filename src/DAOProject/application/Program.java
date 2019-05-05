package DAOProject.application;

import DAOProject.model.dao.DAO;
import DAOProject.model.dao.DAOFactory;
import DAOProject.model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        DAO<Seller> sellerDAO = DAOFactory.createSellerDao();
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);
    }
}
