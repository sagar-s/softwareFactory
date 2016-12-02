import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class CancelForm extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		PrintWriter out =response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Form Cancel</title>");
		out.println("</head>");
		out.println("FORM IS CANCELLED<br/>");
		out.println("<body>");
		out.println("<a href=\"Form1\"Home page</a>");
		out.println("</body>");
		out.println("</html>");
	}
	}