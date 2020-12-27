import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable {
    public String name;
    public String brand;
    public int change;
    public Product(String name,String brand, int change){
        this.name = name;
        this.brand = brand;
        this.change = change;
    }
}
