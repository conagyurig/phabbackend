package Servlets;
import AccessClasses.*;
import AccessClasses.*;
import AccessClasses.SelectProduct;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/details"},loadOnStartup = 1)
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //SqlSetup tables = new SqlSetup();
        SelectProduct quantity = new SelectProduct("'4 flu'", "'Benylin'");
        resp.getWriter().write("<html> <head> <title>CMDMC</title> </head><body> <h1>Value Accessed " + quantity.quant + "</h1> </body> </html>");
        resp.getWriter().write(req.getServletPath());
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        AccessDetails details = new AccessDetails(reqBody);
        Product p = new Product(details.getName(), details.getBrand(), details.getSaleLimit(), details.getUnitPrice(), details.getAmount());
        System.out.println(p.name);
        Gson gson = new Gson();
        String jsonString = gson.toJson(p);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonString);
    }

}