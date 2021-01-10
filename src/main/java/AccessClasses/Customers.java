package AccessClasses;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customers implements Serializable {
    List<Customer> customers;
    public Customers(){
        customers = new ArrayList<>();
    }
    public void addCustomers(Customer customer) {
        this.customers.add(customer);
    }
}
