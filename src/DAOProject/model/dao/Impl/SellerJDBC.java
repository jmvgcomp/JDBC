package DAOProject.model.dao.Impl;

import DAOProject.model.dao.DAO;
import DAOProject.model.entities.Department;
import DAOProject.model.entities.Seller;
import db.DbExeception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerJDBC implements DAO<Seller> {
    private Connection conn;

    public SellerJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                    +"FROM seller INNER JOIN department "
                    +"ON seller.DepartmentId = department.Id "
                    +"WHERE seller.Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("DepartmentId"));
                department.setName(rs.getString("DepName"));
                Seller seller = new Seller();
                seller.setId(rs.getInt("Id"));
                seller.setName(rs.getString("Name"));
                seller.setEmail(rs.getString("Email"));
                seller.setBaseSalary(rs.getDouble("BaseSalary"));
                seller.setBirthDate(rs.getDate("BirthDate"));
                seller.setDepartment(department);
                return seller;
            }
            return null;
        }catch (SQLException e){
            throw new DbExeception(e.getMessage());
        }finally {
            try {
                st.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
