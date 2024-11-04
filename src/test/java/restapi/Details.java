package restapi;

public class Details {
	
	private String companyName;
	private String emailId;
	

	public Details(String companyname, String emailId) {
		
		this.companyName= companyname;
		this.emailId=emailId;
	  
	
	}


	public String getcompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
