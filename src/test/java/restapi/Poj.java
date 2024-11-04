package restapi;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class Poj {
	
	private String name;
	private String job;
	private String[] skills;
	private Details details;
	
	public Poj(String name, String job, String[] skills, String companyname, String emailId) {
		this.name=name;
		this.job=job;
		this.skills=skills;
		this.details=new Details(companyname, emailId);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	
		
}
	
	
	


