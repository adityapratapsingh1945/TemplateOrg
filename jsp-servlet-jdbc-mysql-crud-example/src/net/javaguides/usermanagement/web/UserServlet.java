package net.javaguides.usermanagement.web;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	int ids = 10;

	public void init() {
		userDAO = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/upload":
				upload(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("us", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
	{
//			throws SQLException, ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		User existingUser = userDAO.selectUser(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//		request.setAttribute("user", existingUser);
//		dispatcher.forward(request, response);

	}

//	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String country = request.getParameter("country");
//		User newUser = new User(name, email, country);
//		userDAO.insertUser(newUser);
//		response.sendRedirect("list");
//	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String dateOfBirth = request.getParameter("country");

		User book = new User(id, name, email, country, dateOfBirth);
		userDAO.updateUsers(book);
		response.sendRedirect("list");
	}

	private void upload(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, SAXException, ParserConfigurationException {
		// int id = Integer.parseInt(request.getParameter("id"));
		ids = ids + 1;
		String email = "";
		String name = "";
		String country = "";
		String dateOfBirth = "";

		File file = new File(request.getParameter("file"));
//		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//		Document document = documentBuilder.parse(file);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("student");
		// nodeList is not iterable, so we are using for loop
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			System.out.println("\nNode Name :" + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				System.out.println("Student id: " + eElement.getElementsByTagName("id").item(0).getTextContent());
				System.out
						.println("First Name: " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Last Name: " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Subject: " + eElement.getElementsByTagName("country").item(0).getTextContent());
				System.out.println("Marks: " + eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent());

				// eElement.getElementsByTagName("id").item(0).getTextContent();
				name = eElement.getElementsByTagName("firstname").item(0).getTextContent();
				email = eElement.getElementsByTagName("lastname").item(0).getTextContent();
				country = eElement.getElementsByTagName("country").item(0).getTextContent();
				dateOfBirth = eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();

			}

//		String name = document.getElementsByTagName("FirstName").item(0).getTextContent();
//		String email = document.getElementsByTagName("LastName").item(0).getTextContent();
//		String country = document.getElementsByTagName("DateOfBrth").item(0).getTextContent();

			User book = new User(ids, name, email, country, dateOfBirth);
			userDAO.updateUsers(book);
			response.sendRedirect("list");
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");
	}
}
