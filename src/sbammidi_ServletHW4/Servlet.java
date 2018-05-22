/*
 * Author: sbammidi
 * This class  acts as a front controller in the MVC implementation and receives and handles all requests from the client,
 * performs business logic via business delegate classes, stores the beans into a session object, 
 * and then forwards the request to appropriate JSP to present the data to the user using a RequestDispatcher object.
 */
package sbammidi_ServletHW4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4878481519222802094L;

	public Servlet()
	{
		super();
	}

	public void init(ServletConfig config) throws ServletException 
	{

	}

	public void destroy() 
	{

	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Got to do post");
		if(request != null)
			System.out.println("Got the request");
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.saveForm(request);
		System.out.println("Got out of StudentDAO");
		// StudentBean studentBean = new StudentBean();
		// studentBean.setFirstName(request.getParameter("firstName"));
		// studentBean.setLastName(request.getParameter("lastName"));
		String dataValues = request.getParameter("data");
		DataProcessor dataProcessor = new DataProcessor();
		double mean = dataProcessor.getMean(dataValues);
		double standardDeviation = dataProcessor.getStandardDeviation(dataValues);
		DataBean dataBean = new DataBean();
		dataBean.setMean(mean);
		dataBean.setStandardDeviation(standardDeviation);

		String id = "";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g", "sbammidi", "ofampe");
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("select studentId from Student");
			while (result.next())
			{
				id = id + result.getString(1) + ",";
			}
			connection.close();
		}
		catch (Exception e)
		{
			// Do nothing
		}
		
		String[] idTokens = id.split(",");

		request.setAttribute("ackId", idTokens);
		HttpSession session = request.getSession();
		session.setAttribute("dataBean", dataBean);
		//session.setAttribute("studentBean", studentBean);

		RequestDispatcher rd;
		String address;
		// Return a string containing the result page name.
		if (dataBean.getMean() >= 90)
		{
			address = "WinnerAcknowledgement.jsp";
		}
		else
		{
			address = "SimpleAcknowledgement.jsp";
		}

		rd = request.getRequestDispatcher(address);
		rd.forward(request, response);
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Got to do get");
		if(request != null)
			System.out.println("Got the request");
		StudentDAO studentDao = new StudentDAO();
		List<String> parameterNames = new ArrayList<String>(request.getParameterMap().keySet());
		System.out.println("All parameters: "+parameterNames); 
		String id = request.getParameter("id");		
		System.out.println("doGetStudent id:" + id);
		StudentBean studentBean = studentDao.retrieveForm(id);
		HttpSession session = request.getSession();
		session.setAttribute("studentdata", studentBean);
		request.setAttribute("pid" , id);
		
		String jspPage = "StudentJSP.jsp";
		
		if (studentBean == null)
		{  
			jspPage = "NoSuchStudentJSP.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(jspPage);
		rd.forward(request, response);
	}
}
