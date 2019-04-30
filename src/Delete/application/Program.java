package Delete.application;

import db.DB;
import db.DbIntegrityException;

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
                    "DELETE FROM department "+
                            "WHERE "+
                            "Id = ?"
            );

            ps.setInt(1, 5);
            int rowsAffected = ps.executeUpdate();
            System.out.println("Done! Rows affected: "+rowsAffected);
        }catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
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
