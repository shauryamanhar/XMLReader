package org.controller;

import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;





import org.bean.User;

@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static User getUser(String rollNo){
    	User user = new User();
    	try {
    		File fXmlFile = new File("D:\\MyProject\\workspace-new-mar-2018\\16XMLReader\\WebContent\\user.xml");
    		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    		Document doc = dBuilder.parse(fXmlFile);
    		doc.getDocumentElement().normalize();

    		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

    		NodeList nList = doc.getElementsByTagName("student");
    		
    		for (int temp = 0; temp < nList.getLength(); temp++) {

    			Node nNode = nList.item(temp);

    			System.out.println("\nCurrent Element :" + nNode.getNodeName());

    			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    				Element eElement = (Element) nNode;
    				System.out.println(eElement.getAttribute("id"));
    				if(eElement.getAttribute("rollno").equals(rollNo)){
    					user.setRollno(eElement.getElementsByTagName("firstname").item(0).getTextContent());
    					user.setFirstName(eElement.getElementsByTagName("firstname").item(0).getTextContent());
    					user.setLastName(eElement.getElementsByTagName("lastname").item(0).getTextContent());
    					user.setNickName(eElement.getElementsByTagName("nickname").item(0).getTextContent());
    					user.setMarks(eElement.getElementsByTagName("marks").item(0).getTextContent());
    					
    					return user;
    				}
    			}
    		}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    	return null;
    }
    public ShowStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rollNo=request.getParameter("rollno");
		User user = getUser(rollNo);
		HttpSession session = request.getSession();
		if(user!=null){
			session.setAttribute("user", user);
			response.sendRedirect("show_student.jsp");
		}
		else{
			System.out.println("user is null");
			session.setAttribute("error", true);
			response.sendRedirect("index.jsp");
		}
	}

}
