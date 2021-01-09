package Transactions;

import AccessClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class Transaction {
    float price;

    public Transaction(List<Product> products) {
        this.price = 0;
        for (int i = 0; i < products.size(); i++) {
            this.price = this.price + products.get(i).getUnitPrice();
        }
        URL myURL = null;
        try {
            myURL = new URL("https://pharmacyserve.herokuapp.com/bank/transfer?from=" + 1234 + "&to=" + 4321 + "&amount=" + price);
            HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("charset", "utf-8");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(myURL.openStream()));
            String inputLine;
// Read the body of the response
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
