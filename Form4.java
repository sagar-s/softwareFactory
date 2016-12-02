import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class Form4 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		if(session.getAttribute("comments")==null){
			PrintValues(out);
		}
		else{
			PrintCreatedForm(out, session);
		}
		
	}
	
	private void PrintValues(PrintWriter out) {
		out.println("<html");
		out.println("<head>");
		out.println("<title>Form4</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Fourth Page</h1>");
		out.println("<form action = \"Form5\" method = \"post\">");
		out.println("<label>Comments</label> <input type =\"text\" name=\"comments\"><br/>");
		out.println("<a href = \"Form3\"><input type =\"button\" value = \"Prev\"></a>");
		out.println("<input type =\"submit\" value = \"next\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	private void PrintCreatedForm(PrintWriter out, HttpSession session) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Form 1</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> SECOND Page </h1>");
		out.println("<form action = \"Form5\" method = \"post\">");
		if(!session.getAttribute("comments").equals("")){
			out.println("<label>comments</label><input type =\"text\" name=\"comments\"value=\"" + session.getAttribute("comments")+ "\"/><br/>");
			
		}
		else{
			out.println("<label>comments</label><input type =\"text\" name =\"comments\"/><br/>");
		}
		out.println("<a href = \"Form3\"><input type =\"button\" value = \"Prev\"></a>");
		out.println("<input type =\"submit\" value = \"next\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (session ==null){
			request.getRequestDispatcher("Form1").forward(request , response);
		}
		if(session.getAttribute("firstname")==null ||
				session.getAttribute("lastname")==null ||
				session.getAttribute("languages")==null){
			response.sendError(400);
		}
		String res = "";
		if (request.getParameterValues("days") == null){
			session.setAttribute("days", res);
		}
		else{
			String[] temp = request.getParameterValues("days");
			for(int i=0; i<temp.length; i++){
				if (i == temp.length -1){
					res += temp[i];
				}
				res += temp[i] + "&";
			}
			session.setAttribute("days", res);
		}
		response.setContentType("text/html");
		if (session.getAttribute("comments")== null){
			PrintValues(out);
		}
		else{
			PrintCreatedForm(out , session );
		}
	}
}
