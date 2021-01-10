package AccessClasses;

import java.io.Serializable;

public class Customer implements Serializable {
    String address;
    String email;
    String first_name;
    int id;
    String last_name;
    String phone_no;
    String postcode;
    public Customer(String address, String email, String first_name, int id, String last_name, String phone_no, String postcode){
        this.address = address;
        this.email = email;
        this.first_name = first_name;
        this.id = id;
        this.last_name = last_name;
        this.phone_no = phone_no;
        this.postcode = postcode;
    }


}
