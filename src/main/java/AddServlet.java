import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ADDServlet", urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String number = request.getParameter("numberOne");
        Integer numberOne = Integer.parseInt(number);
        number = request.getParameter("numberTwo");
        Integer numberTwo = Integer.parseInt(number);
        Integer result = numberOne + numberTwo;
        String resultString = result.toString();
        request.setAttribute("result", resultString);

        request.getRequestDispatcher("/addApplied.jsp").forward(request, response);

    }
}

