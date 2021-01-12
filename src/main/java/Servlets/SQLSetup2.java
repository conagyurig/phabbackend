package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSetup2 {
    public SQLSetup2(){
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection(dbUrl);
            Statement stmt = db.createStatement();
            stmt.execute("INSERT INTO customer(first_name,last_name,email,postcode) VALUES('Craig','Young','cyy@gmail.com','SW6 2BZ');");
            //stmt.execute("ALTER TABLE ordered_product " +
             //       "ADD COLUMN brand VARCHAR;");
            stmt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
