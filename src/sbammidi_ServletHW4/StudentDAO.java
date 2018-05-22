/**
 * @author sbammidi
 * This class contains the implementation to persist the data into the database and retrieve data from the database when requested.
 */
package sbammidi_ServletHW4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import sbammidi_ServletHW4.StudentBean;

@WebServlet(name = "sbammidi_Servlet")
public class StudentDAO
{
	public void saveForm(HttpServletRequest request) throws ServletException, IOException
	{		
		String studentId = request.getParameter("student");
		System.out.println("StudentID:"+studentId);
		String firstName = request.getParameter("firstName");
		System.out.println("FirstName:"+firstName);
		String lastName = request.getParameter("lastName");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String telephoneNumber = request.getParameter("telephone");
		String email = request.getParameter("email");
		String url = request.getParameter("url");
		String data = request.getParameter("data");
		String likelihoodSelectOneMenu = request.getParameter("likelihoodSelectOneMenu");
		String graduationMonth = request.getParameter("month");
		String graduationYear = request.getParameter("year");
		String comments = request.getParameter("comments");

		StudentBean studentBean = new StudentBean();

		studentBean.setStudentId(studentId);
		studentBean.setFirstName(firstName);
		studentBean.setLastName(lastName);
		studentBean.setAddressLine1(addressLine1);
		studentBean.setAddressLine2(addressLine2);
		studentBean.setCity(city);
		studentBean.setState(state);
		studentBean.setZip(zip);
		studentBean.setTelephoneNumber(telephoneNumber);
		studentBean.setEmail(email);
		studentBean.setUrl(url);
		studentBean.setData(data);
		studentBean.setLikelihoodSelectOneMenu(likelihoodSelectOneMenu);
		studentBean.setGraduationMonth(graduationMonth);
		studentBean.setGraduationYear(graduationYear);
		studentBean.setAdditionalComments(comments);


		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException ex)
		{
			Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

		try
		{
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g", "sbammidi", "ofampe");
			if(connection!=null)
				System.out.println("Connection successful!");	

			String query = "insert into Student values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement dbPersist = connection.prepareStatement(query);

			dbPersist.setString(1, studentBean.getStudentId());
			System.out.println("Persisting..");
			dbPersist.setString(2, studentBean.getFirstName());
			dbPersist.setString(3, studentBean.getLastName());
			dbPersist.setString(4, studentBean.getAddressLine1());
			dbPersist.setString(5, studentBean.getAddressLine2());
			dbPersist.setString(6, studentBean.getCity());
			dbPersist.setString(7, studentBean.getState());
			dbPersist.setString(8, studentBean.getZip());
			dbPersist.setString(9, studentBean.getTelephoneNumber());
			dbPersist.setString(10, studentBean.getEmail());
			dbPersist.setString(11, studentBean.getUrl());
			dbPersist.setString(12, studentBean.getData());
			dbPersist.setString(13, studentBean.getLikelihoodSelectOneMenu());
			dbPersist.setString(14, studentBean.getGraduationMonth());
			dbPersist.setString(15, studentBean.getGraduationYear());
			dbPersist.setString(16, studentBean.getAdditionalComments());

			//Statement stmt= connection.createStatement();
			if(connection != null)
				System.out.println("connection not null");
			//String sqlStatement="insert into Student values ("+sid+","+fn+","+ln+","+a1+","+a2+","+ct+","+st+","+zp+","+tn+","+em+","+ur+","+dat+","+lk+","+gm+","+gy+","+ac+")";
			System.out.println("After setting:" + query);
			dbPersist.executeUpdate();
			dbPersist.close();

			if (connection != null)
			{
				connection.close();
			}
		}
		catch (SQLException ex)
		{
			Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public StudentBean retrieveForm(String id)
	{
		StudentBean stu = new StudentBean();

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g", "sbammidi", "ofampe");
			Statement statement = connection.createStatement();
			id = "'"+ id + "'";
			ResultSet result = statement.executeQuery("select * from Student where studentId =" + id);

			while (result.next())
			{
				stu.setStudentId(result.getString(1));
				stu.setFirstName(result.getString(2));
				stu.setLastName(result.getString(3));
				stu.setAddressLine1(result.getString(4));
				stu.setAddressLine2(result.getString(5));
				stu.setCity(result.getString(6));
				stu.setState(result.getString(7));
				stu.setZip(result.getString(8));
				stu.setTelephoneNumber(result.getString(9));
				stu.setEmail(result.getString(10));
				stu.setUrl(result.getString(11));
				stu.setData(result.getString(12));
				stu.setLikelihoodSelectOneMenu(result.getString(13));
				stu.setGraduationMonth(result.getString(14));
				stu.setGraduationYear(result.getString(15));
				stu.setAdditionalComments(result.getString(16));	                
			}
			connection.close();

		}
		catch (Exception e)
		{
			//Do nothing
		}

		return stu;
	}
}
