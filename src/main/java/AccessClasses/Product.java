package AccessClasses;

import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable {
    public String name;
    public String brand;
    public int change;
    public String saleLimit;
    float unitPrice;
    public String amount;
    public Product(String name,String brand, int change){
        this.name = name;
        this.brand = brand;
        this.change = change;
    }
    public Product(String name, String brand, String saleLimit, float unitPrice, String amount){
        this.name = name;
        this.brand = brand;
        this.saleLimit = saleLimit;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }
    public Product(String name,String brand, int change, float unitPrice) {
        this.name = name;
        this.brand = brand;
        this.change = change;
        this.unitPrice = unitPrice;
    }
    public String getName() {
        return name;
    }
    public String getBrand() {
        return brand;
    }
    public int getChange() {
        return change;
    }
    public String getSaleLimit() {
        return saleLimit;
    }
    public float getUnitPrice() {
        return unitPrice;
    }
    public String getAmount() {
        return amount;
    }
}
