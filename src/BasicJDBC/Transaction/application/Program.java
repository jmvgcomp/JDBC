package BasicJDBC.Transaction.application;

import db.DB;
import db.DbExeception;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        Connection connection = null;
        Statement ps = null;

        try{
            connection = DB.getConnection();
            connection.setAutoCommit(false);
            ps = connection.createStatement();
            int row1 = ps.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            /*
            int x = 1;
            if(x < 2) throw new SQLException("fake error");
            simulação de exceção para verificar o real funcionamento da transação
             */

            int row2 = ps.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
            connection.commit();
            System.out.println("Rows1 "+row1);
            System.out.println("Rows2 "+row2);
        }catch (SQLException e){
            try {
                connection.rollback();
                throw new DbExeception("Transaction rolled back! Caused by: "+e.getMessage());
            } catch (SQLException ex) {
                throw new DbExeception("Error trying to rollback. Caused by: "+e.getMessage());

            }
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
