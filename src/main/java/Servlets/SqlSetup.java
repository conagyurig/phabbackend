package Servlets;

import java.sql.Connection;
import java.sql.*;

public class SqlSetup {
    public SqlSetup(){
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection(dbUrl);
            Statement stmt = db.createStatement();
            stmt.execute("CREATE TABLE branch " +
                    "            (id SERIAL PRIMARY KEY NOT NULL," +
                    "            name VARCHAR(36) NOT NULL)");
            stmt.execute("INSERT INTO branch(name) VALUES('Paddington');");
            stmt.execute("INSERT INTO branch(name) VALUES('Green Park');" +
                    "INSERT INTO branch(name) VALUES('East End');");
            stmt.execute("CREATE TABLE shop_product (" +
                    "    id SERIAL PRIMARY KEY NOT NULL," +
                    "    category VARCHAR(36) NOT NULL," +
                    "    brand VARCHAR(36) NOT NULL," +
                    "    name VARCHAR(36) NOT NULL," +
                    "    amount VARCHAR(36)," +
                    "    sell_price DECIMAL(10,2) NOT NULL," +
                    "    buy_price DECIMAL(10,2) NOT NULL," +
                    "    quantity SMALLINT NOT NULL," +
                    "    full_stock SMALLINT NOT NULL," +
                    "    limit_of_1 SMALLINT," +
                    "    soft_min DECIMAL(10,2)," +
                    "    hard_min DECIMAL(10,2)," +
                    "" +
                    "    branch_id INT REFERENCES branch (id)" +
                    ");");
            stmt.execute("CREATE TABLE daily_profit (" +
                    "    id SERIAL PRIMARY KEY," +
                    "    date DATE NOT NULL," +
                    "    profit DECIMAL(10,2)," +
                    "" +
                    "    branch_id INT REFERENCES branch (id)" +
                    ");");
            stmt.execute("INSERT INTO shop_product(category,brand,name,amount,sell_price,buy_price,quantity,full_stock,limit_of_1) VALUES('Cold and Flu','Vicks','Vaporub','100g',4.5,3.7,15,15,null)," +
                    "      ('Cold and Flu','Vicks','First Defence','15ml',6.8,5,20,20,null)," +
                    "      ('Cold and Flu','Gsk','Night Nurse','160ml',8.5,7,30,30,null)," +
                    "      ('Cold and Flu','Gsk','Night Nurse','160ml',9,7.5,30,30,null)," +
                    "      ('Cold and Flu','Lemsip','Max','16 caps',4.2,3.7,25,25,null)," +
                    "      ('Cold and Flu','Lemsip','Standard','10 sachets',4.5,3.5,25,25,null)," +
                    "      ('Cold and Flu','Sudafed','Day and Night','16 caps',4.5,3.2,30,30,1)," +
                    "      ('Cold and Flu','Sudafed','Max','16 caps',4.2,3.2,30,30,1)," +
                    "      ('Cold and Flu','Benylin','Mucus relief','16 caps',4.8,3.2,20,20,null)," +
                    "      ('Cold and Flu','Benylin','4 flu','24 caps',6,4.9,20,20,null)," +
                    "" +
                    "      ('Skincare','E45','Psoriasis cream','50ml',20,16,15,15,null)," +
                    "      ('Skincare','Eurax','Skin cream','100g',5.7,4.2,15,15,null)," +
                    "      ('Skincare','Eucerin','Skin relief cream','50ml',9,7,20,20,null)," +
                    "      ('Skincare','Eucerin','Face scrub','100ml',7.5,6,20,20,null)," +
                    "      ('Skincare','Dermalex','Psoriasis cream','150ml',30,25,10,10,null)," +
                    "      ('Skincare','Dermalex','Repair and Restore','100g',12,10,10,10,null)," +
                    "      ('Skincare','Dermalex','Eczema cream','100g',25,22.2,5,5,null)," +
                    "      ('Skincare','Cetaphil','Moisturising cream','50ml',10,7.6,20,20,null)," +
                    "      ('Skincare','Cetaphil','Exfoliating cleanser','180ml',12,10.1,20,20,null)," +
                    "" +
                    "      ('Headaches and pain relief','Nurofen','Meltlets','16 caps',4,3.7,40,40,null)," +
                    "      ('Headaches and pain relief','Nurofen','Express','16 caps',4,3.5,30,30,null)," +
                    "      ('Headaches and pain relief','Nurofen','Max strength','32 caps',7,6.2,25,25,null)," +
                    "      ('Headaches and pain relief','Nurofen','Standard','16 caps',4,3.2,30,30,null)," +
                    "      ('Headaches and pain relief','Cuprofen ','Max strength','96 caps',11,9,20,20,1)," +
                   "      ('Headaches and pain relief','Solpadeine','Headache','16 caps',2,1.6,20,20,1)," +
                    "      ('Headaches and pain relief','Anadin','Extra','16 caps',2.3,2,30,30,1)," +
                    "      ('Headaches and pain relief','Anadin','Triple action','12 caps',2,1.9,30,30,1)," +
                    "      ('Headaches and pain relief','Anadin','Original','16 caps',1.8,1.5,30,30,1)," +
                    "      ('Headaches and pain relief','Disprin','Soluble','32 tablets',3.6,2.8,20,20,1)," +
                    "" +
                    "      ('Digestion','Dioralyte','Blackcurrant','12 sachets',8,7.3,20,20,null)," +
                    "      ('Digestion','Dioralyte','Lemon','12 sachets',8,7.3,20,20,null)," +
                    "      ('Digestion','Gaviscon','Chewable','24 tablets',4.2,3.5,25,25,null)," +
                    "      ('Digestion','Senokot','Max','10 tablets',3,2.7,10,10,null)," +
                    "      ('Digestion','Gaviscon','Advance','300ml',10,8.1,10,10,null)," +
                    "" +
                    "      ('Allergy','Benadryl','Relief','24 caps',9,7.1,20,20,null)," +
                    "      ('Allergy','Piriteze','tabs','7 tablets',3,2.3,20,20,null)," +
                    "      ('Allergy','Beconase','Relief','100 sprays',6,4,20,20,null)," +
                    "" +
                    "      ('First aid','Dettol','Antiseptic','500ml',3.2,3,20,20,null)," +
                    "      ('First aid','Dettol','Hand sanitizer','500ml',7,6.3,50,50,null)," +
                    "      ('First aid','Elastoplast','plasters','20 plasters',3,2,30,30,null)," +
                    "      ('First aid','TCP','Liquid','200ml',4,3.2,20,20,null);" +
                    "UPDATE shop_product SET branch_id = 1;");
            stmt.execute("CREATE TABLE customer (" +
                    "      id SERIAL PRIMARY KEY NOT NULL," +
                    "      first_name VARCHAR(36) NOT NULL," +
                    "      last_name VARCHAR(36) NOT NULL," +
                    "      email VARCHAR(256) NOT NULL," +
                    "      postcode VARCHAR(8) NOT NULL," +
                    "      address VARCHAR(128)," +
                    "      phone_no VARCHAR(12)" +
                    ");" +
                    "INSERT INTO customer(first_name,last_name,email,postcode) VALUES('CW','Yip','y@gmail.com','SW7 2AZ');" +
                    "" +
                    "CREATE TABLE orders (" +
                    "    id SERIAL PRIMARY KEY NOT NULL," +
                    "    date TIMESTAMP NOT NULL," +
                    "    customer_id INT REFERENCES customer (id)" +
                    ");" +
                    "INSERT INTO orders(date,customer_id) VALUES('2020-11-14 16:00:00',1);" +
                    "" +
                    "CREATE TABLE ordered_product (" +
                    "     barcode SERIAL PRIMARY KEY NOT NULL," +
                    "     name VARCHAR(32) NOT NULL," +
                    "     quantity INTEGER NOT NULL," +
                    "     sell_price DECIMAL(10,2) NOT NULL," +
                    "     orders_id INT REFERENCES orders (id)" +
                    ");" +
                    "INSERT INTO ordered_product(name,quantity,sell_price,orders_id) VALUES('Cold and Flu Vicks First Defence',3,6.8,1);" +
                    "" +
                    "CREATE TABLE card_details (" +
                    "      id SERIAL PRIMARY KEY," +
                    "      card_no VARCHAR(16)," +
                    "      cvv VARCHAR(3)," +
                    "      sort_code VARCHAR(6)," +
                    "      account_no VARCHAR(8)," +
                    "      customer_id INT REFERENCES customer (id)" +
                    ");" +
                    "INSERT INTO card_details(card_no,cvv,sort_code,account_no,customer_id) VALUES('4638563856739684','313','600807','36559684',1);" +
                    "");
            stmt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("connected successfully");



    }
}
