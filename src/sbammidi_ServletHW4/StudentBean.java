package sbammidi_ServletHW4;
// Sameera Bammidi
// This class has all the matching fields to the index.xhtml

import java.util.ArrayList;
import java.util.List;

public class StudentBean
{
	private String studentId;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	private String telephoneNumber;
	private String email;
	private String url;
	private String data;
	private String interestSelectOneRadio;
	private String likelihoodSelectOneMenu;
	private String graduationMonth;
    private String graduationYear;
	private String additionalComments;

	public String choice = "VeryLikely,Likely,UnLikely";
	public String[] choicearray = choice.split(",");

	public List<String> completeText(String query)
	{
		List<String> queried = new ArrayList<String>(); 
		for(String i: choicearray)
		{
			if(i.toUpperCase() .startsWith(query.toUpperCase()))
			{
				queried.add(i);
			}
		}
		return queried;
	}

	public StudentBean()
	{}

	public String getStudentId()
	{
		return studentId;
	}

	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return zip;
	}
	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephone)
	{
		this.telephoneNumber = telephone;
	}

	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
	
	public String getInterestSelectOneRadio()
	{
		return interestSelectOneRadio;
	}
	public void setInterestSelectOneRadio(String interestSelectOneRadio)
	{
		this.interestSelectOneRadio = interestSelectOneRadio;
	}

	public String getLikelihoodSelectOneMenu()
	{
		return likelihoodSelectOneMenu;
	}
	public void setLikelihoodSelectOneMenu(String likelihoodSelectOneMenu)
	{
		this.likelihoodSelectOneMenu = likelihoodSelectOneMenu;
	}

	public String getData()
	{
		return data;
	}
	public void setData(String raffle)
	{
		this.data = raffle;
	}

	public String getGraduationMonth()
	{
		return graduationMonth;
	}

	public void setGraduationMonth(String graduationMonth)
	{
		this.graduationMonth = graduationMonth;
	}

	public String getGraduationYear()
	{
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear)
	{
		this.graduationYear = graduationYear;
	}

	public String getAdditionalComments()
	{
		return additionalComments;
	}
	public void setAdditionalComments(String comments)
	{
		this.additionalComments = comments;
	}

	private DataBean winner = new DataBean();

	public DataBean getWinner()
	{
		return winner;
	}

	public void setWinner(DataBean winner)
	{
		this.winner = winner;
	}
}
