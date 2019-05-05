package DAOProject.application;

import DAOProject.model.dao.DAO;
import DAOProject.model.dao.DAOFactory;
import DAOProject.model.entities.Department;
import DAOProject.model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        DAO<Seller> sellerDAO = DAOFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        System.out.println("\n===TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellerList = sellerDAO.findByDepartment(department);
        sellerList.forEach(System.out::println);

        System.out.println("\n===TEST 3: seller findAll ===");
        sellerList = sellerDAO.findAll();
        sellerList.forEach(System.out::println);

        System.out.println("\n===TEST 3: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDAO.insert(newSeller);
        System.out.println("Insert! New id: "+newSeller.getId());
    }
}
