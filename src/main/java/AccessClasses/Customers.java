package AccessClasses;
import java.io.Serializable;
import java.util.List;

public class Customers implements Serializable {
    List<Customer> customers;
    public Customers(){

    }
    public void addCustomers(Customer customer) {
        this.customers.add(customer);
    }
}
