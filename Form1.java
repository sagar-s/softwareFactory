import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class Form1 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(session.getAttribute("firstname") == null || session.getAttribute("lastname")== null){
			PrintValues(out , " ");
		}
		else{
			PrintCreatedForm(out , session , " ");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(session.getAttribute("firstname")== null && session.getAttribute("lastname")== null){
			PrintValues(out , " ");
			
		}
		else{
			PrintCreatedForm(out , session  ,"");
			
		}
	}

	private void PrintCreatedForm(PrintWriter out, HttpSession session,
			String string) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Form 1</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> First Page </h1>");
		out.println("<form action = \"Form2\" method = \"post\">");
		out.println("<label>firstname</label> <input type =\"text\" name = \"firstname\" value=\"" + session.getAttribute("firstname") + "\"><br/>");
		out.println("<label>lastname</label> <input type =\"text\" name = \"lastname\" value=\"" + session.getAttribute("lastname") + "\"><br/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

	private void PrintValues(PrintWriter out, String string) {
		out.println("<html");
		out.println("<head>");
		out.println("<title>Form1</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>First Page</h1>");
		out.println("<form action = \"Form2\" method = \"post\">");
		out.println("<label>firstname</label> <input type =\"text\" name = \"firstname\"><br/>");
		out.println("<label>lastname</label> <input type =\"text\" name = \"lastname\"><br/>");
		out.println("<input type =\"submit\" value = \"next\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
