import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable {
    public String name;
    public String brand;
    public int change;
    String saleLimit;
    float unitPrice;
    public Product(String name,String brand, int change){
        this.name = name;
        this.brand = brand;
        this.change = change;
    }
    public Product(String name, String brand, String saleLimit, float unitPrice){
        this.name = name;
        this.brand = brand;
        this.saleLimit = saleLimit;
        this.unitPrice = unitPrice;
    }
}
