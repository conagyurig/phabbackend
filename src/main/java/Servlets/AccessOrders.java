package Servlets;

import com.google.gson.Gson;
import AccessClasses.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/accessOrders"},loadOnStartup = 1)
public class AccessOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //SqlSetup tables = new SqlSetup();
        String str="'2020-12-27'";
        ProfitRequest profitRequest = new ProfitRequest(str);
        resp.getWriter().write("<html> <head> <title>CMDMC</title> </head><body> <h1>Profit Accessed " + profitRequest.profit + "</h1> </body> </html>");
        resp.getWriter().write(req.getServletPath());
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        OrderRequest query = new OrderRequest(Integer.parseInt(reqBody));
        Order order = new Order(query.getOrder(),1);
        Gson gson = new Gson();
        String jsonString = gson.toJson(order);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonString);


    }

}