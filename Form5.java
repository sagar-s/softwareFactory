

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class Form5 extends HttpServlet {
	public static File f = new File("Web.xml");
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		if(	session.getAttribute("firstname")==null ||
				session.getAttribute("lastname")==null ||
				session.getAttribute("languages")==null ||
				session.getAttribute("days")==null){
			response.sendError(400);
		}
		PrintValues(out, session);
	}

	
	private void PrintValues(PrintWriter out, HttpSession session) {
		
		out.println("<html");
		out.println("<head>");
		out.println("<title>Form4</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Fourth Page</h1>");
		out.println("<form action = \"SubmitForm\" method = \"post\">");
		out.println("<ul>");
		out.println("<li>firstname: "+ session.getAttribute("firstname")+ "</li>");
		out.println("<li>lasttname: "+ session.getAttribute("lastname")+ "</li>");
		out.println("<li>languages: "+ session.getAttribute("languages")+ "</li>");
		out.println("<li>days: "+ session.getAttribute("days")+ "</li>");
		out.println("<li>comments: "+ session.getAttribute("comments")+ "</li>");
		out.println("<ul>");
		out.println("</li>");
		
		out.println("<a href = \"Form4\"><input type =\"button\" value = \"Prev\"></a>");
		out.println("<input type =\"submit\" value = \"next\">");
		out.println("<a href = \"CancelForm\"><input type =\"button\" value = \"Cancel\"></a>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session ==null){
			request.getRequestDispatcher("Form1").forward(request , response);
		}	
			
		response.setContentType("text/html");
		session.setAttribute("comments", request.getParameter("comments"));
		PrintWriter out = response.getWriter();
		if(session.getAttribute("comments")==null || 
				session.getAttribute("firstname")==null ||
				session.getAttribute("lastname")==null ||
				session.getAttribute("languages")==null ||
				session.getAttribute("days")==null){
			response.sendError(400);
		}
		PrintValues(out, session);
		
	}
	
	
}

