

import java.io.*;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class Form3 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(session.getAttribute("days") == null){
			PrintValues(out);
		}
		else{
			PrintCreatedForm(out , session );
		}
	}

	
	private void PrintValues(PrintWriter out) {
		out.println("<html");
		out.println("<head>");
		out.println("<title>Form3</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Third Page</h1>");
		out.println("<form action = \"Form4\" method = \"post\">");
		out.println("<label>DAYS AVAILABLE</label>");
		out.println("<ul>");
		out.println("<li><label>MONDAY</label> <input type =\"checkbox\" value = \"MONDAY\" name = \"languages\"><li>");
		out.println("<li><label>TUESDAY</label> <input type =\"checkbox\" value = \"TUESDAY\" name = \"languages\"><li>");
		out.println("<li><label>WEDNESDAY</label> <input type =\"checkbox\" value = \"WEDNESDAY\" name = \"languages\"><li>");
		out.println("<li><label>THURSDAY</label> <input type =\"checkbox\" value = \"THURSDAY\" name = \"languages\"><li>");
		out.println("<li><label>FRIDAY</label> <input type =\"checkbox\" value = \"FRIDAY\" name = \"languages\"><li>");
		out.println("<li><label>SATURDAY</label> <input type =\"checkbox\" value = \"SATURDAY\" name = \"languages\"><li>");
		out.println("<li><label>SUNDAY</label> <input type =\"checkbox\" value = \"SUNDAY\" name = \"languages\"><li>");
		out.println("</ul>");
		out.println("<a href = \"Form2\"><input type =\"button\" value = \"Prev\"></a>");
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
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Form 3</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Third Page </h1>");
		out.println("<form action = \"Form4\" method = \"post\">");
		out.println("<label>DAYS AVAILABLE</label>");
		out.println("<ul>");
		String check = (set.contains("MONDAY"))?"checked":"";
		out.println("<li><label>MONDAY</label><input type =\"checkbox\"value=\"MONDAY\" name =\"languages\" "+ check + "></li>");
		check = (set.contains("TUESDAY"))?"checked":"";
		out.println("<li><label>TUESDAY</label><input type =\"checkbox\"value=\"TUESDAY\" name =\"languages\" "+ check + "></li>");
		check = (set.contains("WEDNESDAY"))?"checked":"";
		out.println("<li><label>WEDNESDAY</label><input type =\"checkbox\"value=\"WEDNESDAY\" name =\"languages\" "+ check + "></li>");
		check = (set.contains("THURSDAY"))?"checked":"";
		out.println("<li><label>THURSDAY</label><input type =\"checkbox\"value=\"THURSDAY\" name =\"languages\" "+ check + "></li>");
		check = (set.contains("FRIDAY"))?"checked":"";
		out.println("<li><label>FRIDAY</label><input type =\"checkbox\"value=\"FRIDAY\" name =\"languages\" "+ check + "></li>");
		check = (set.contains("SATURDAY"))?"checked":"";
		out.println("<li><label>SATURDAY</label><input type =\"checkbox\"value=\"SATURDAY\" name =\"languages\" "+ check + "></li>");
		check = (set.contains("SUNDAY"))?"checked":"";
		out.println("<li><label>SUNDAY</label><input type =\"checkbox\"value=\"SUNDAY\" name =\"languages\" "+ check + "></li>");
		out.println("<a href = \"Form2\"><input type =\"button\" value = \"Prev\"></a>");
		out.println("<input type =\"submit\" value = \"next\">");

		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null){
			request.getRequestDispatcher("Form1").forward(request , response);
			return;
		}
		
		if(	session.getAttribute("firstname")==null ||
				session.getAttribute("lastname")==null){
			response.sendError(400);
		}
		String res = "";
		if (request.getParameterValues("languages") == null){
			session.setAttribute("languages", res);
		}
		else{
			String[] temp = request.getParameterValues("languages");
			for(int i=0; i<temp.length; i++){
				if (i == temp.length -1){
					res += temp[i];
				}
				res += temp[i] + "&";
			}
			session.setAttribute("languages", res);
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(session.getAttribute("days")== null){
			PrintValues(out);
		}
		else{
			PrintCreatedForm(out, session);
		}
		
		}
	}
	
	
