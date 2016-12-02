

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;


@SuppressWarnings("serial")
public class Form2 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(session.getAttribute("languages") == null){
			PrintValues(out);
		}
		else{
			PrintCreatedForm(out , session );
		}
	}

	
	private void PrintValues(PrintWriter out) {
		out.println("<html");
		out.println("<head>");
		out.println("<title>Form2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Second Page</h1>");
		out.println("<form action = \"Form3\" method = \"post\">");
		out.println("<label>Languages known</label>");
		out.println("<ul>");
		out.println("<li><label>C</label> <input type =\"checkbox\" value = \"C\" name = \"languages\"></li>");
		out.println("<li><label>C++</label> <input type =\"checkbox\" value = \"C++\" name = \"languages\"></li>");
		out.println("<li><label>PHP</label> <input type =\"checkbox\" value = \"PHP\" name = \"languages\"></li>");
		out.println("<li><label>PYTHON</label> <input type =\"checkbox\" value = \"PYTHON\" name = \"languages\"></li>");
		out.println("<li><label>JAVA</label> <input type =\"checkbox\" value = \"JAVA\" name = \"languages\"></li>");
		out.println("</ul>");
		out.println("<input type =\"submit\" value = \"next\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	private void PrintCreatedForm(PrintWriter out, HttpSession session) {
		String[] languages= session.getAttribute("languages").toString().split(",\\s");
		Set<String> set = new HashSet<String>();
		for(String s:languages){
			set.add(s);
		}
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Form 1</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> SECOND Page </h1>");
		out.println("<form action = \"Form3\" method = \"post\">");
		out.println("<label>Languages known</label>");
		out.println("<ul>");
		String check = (set.contains("C"))?"checked":"";
		out.println("<li><label>C</label><input type =\"checkbox\"value=\"C\" name =\"languages\" "+ check + "/></li>");
		check = (set.contains("C++"))?"checked":"";
		out.println("<li><label>C++</label><input type =\"checkbox\"value=\"C++\" name =\"languages\""+ check + "/></li>");
		check = (set.contains("PHP"))?"checked":"";
		out.println("<li><label>PHP</label><input type =\"checkbox\"value=\"PHP\" name =\"languages\""+ check + "/></li>");
		check = (set.contains("PYTHON"))?"checked":"";
		out.println("<li><label>PYTHON</label><input type =\"checkbox\"value=\"PYTHON\" name =\"languages\""+ check + "/></li>");
		check = (set.contains("JAVA"))?"checked":"";
		out.println("<li><label>JAVA</label><input type =\"checkbox\"value=\"JAVA\" name =\"languages\""+ check + "/></li>");

		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (request.getParameter("firstname").equals("")){
			request.getRequestDispatcher("Form1").forward(request , response);
			return;
		}
		session.setAttribute("firstname",request.getParameter("firstname"));
		session.setAttribute("lastname", request.getParameter("lastname"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (session.getAttribute("languages")== null){
			PrintValues(out);
		}
		else{
			PrintCreatedForm(out , session );
		}
	}
	
	
}
