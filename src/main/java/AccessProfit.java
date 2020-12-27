
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/accessProfit"},loadOnStartup = 1)
public class AccessProfit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //SqlSetup tables = new SqlSetup();
        String str="2020-12-27";
        Date date=Date.valueOf(str);//converting string into sql date
        System.out.println(date);
        ProfitRequest profitRequest = new ProfitRequest(date);
        resp.getWriter().write("<html> <head> <title>CMDMC</title> </head><body> <h1>Profit Accessed " + profitRequest.profit + "</h1> </body> </html>");
        resp.getWriter().write(req.getServletPath());
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Date date=Date.valueOf(reqBody);
        ProfitRequest profitRequest = new ProfitRequest(date);
        resp.setContentType("text/html");
        String profit = new String(String.valueOf(profitRequest.profit));
        resp.getWriter().write(profit);


    }

}