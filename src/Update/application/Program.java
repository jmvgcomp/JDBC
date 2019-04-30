package Update.application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection = DB.getConnection();

            ps = connection.prepareStatement(
                    "UPDATE seller "+
                            "SET BaseSalary = BaseSalary + ? "+
                            "WHERE "+
                            "(DepartmentId = ?)"
            );

            ps.setDouble(1, 200.0);
            ps.setInt(2, 2);
            int rowsAffected = ps.executeUpdate();
            System.out.println("Done! Rows affected: "+rowsAffected);

        }catch (SQLException e){
           e.printStackTrace();
        }finally {
            try {
                connection.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            DB.closeConnection();
        }
    }
}
