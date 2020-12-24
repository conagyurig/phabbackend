
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/tables"},loadOnStartup = 1)
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //SqlSetup tables = new SqlSetup();
        SelectProduct quantity = new SelectProduct("'4 flu'");
        resp.getWriter().write("<html> <head> <title>CMDMC</title> </head><body> <h1>Webpage Established " + quantity.quant + "</h1> </body> </html>");
        resp.getWriter().write(req.getServletPath());
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        SelectProduct quantity = new SelectProduct("'4 flu'");
        resp.setContentType("text/html");
        String quant = new String(String.valueOf(quantity.quant));
        resp.getWriter().write(quant + reqBody);


    }

}