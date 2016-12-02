import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.*;

@SuppressWarnings("serial")
public class SubmitForm extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		if(session == null){
			response.sendError(400);
		}
		if(session.getAttribute("comments")==null || 
				session.getAttribute("firstname")==null ||
				session.getAttribute("lastname")==null ||
				session.getAttribute("languages")==null ||
				session.getAttribute("days")==null){
			response.sendError(400);
		}
		PrintWriter out = response.getWriter();
		File f = new File(getServletContext().getRealPath("Form.xml"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("firstname", session.getAttribute("firstname").toString());
		map.put("lastname", session.getAttribute("lastname").toString());			
		map.put("languages", session.getAttribute("languages").toString());
		map.put("days", session.getAttribute("days").toString());
		map.put("comments", session.getAttribute("comments").toString());
		boolean flag = save(map, f);
		if (flag == true){
			out.println("Record Saved<br/>");
		}
		else{

			out.println("Error<br/>");
		}
		out.println("<a href=\"\"> Go Back to Form</a><br/>");		
	}
	
	public void newFile(File f){
		try{
			if (f.exists()){
				throw new Exception("File Already Exists");
			}
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element form = doc.createElement( "form" );
	        doc.appendChild(form);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileOutputStream(f));
			transformer.transform(source, result);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean save(Map<String, String> map, File f){
		try{
			if (!f.exists()){
				newFile(f);
			}
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(f);
			Element form = (Element)doc.getFirstChild();
			Element item = doc.createElement("item");
			form.appendChild(item);
			for (String key : map.keySet()){
				Element ele = doc.createElement(key);
				item.appendChild(ele);
				ele.setTextContent(map.get(key));
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileOutputStream(f));
			transformer.transform(source, result);
			
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;	
	}
}
