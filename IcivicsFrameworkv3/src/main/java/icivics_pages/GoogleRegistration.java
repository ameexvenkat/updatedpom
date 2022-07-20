package icivics_pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class GoogleRegistration extends ProjectSpecificMethods {
	public String gpropname1 = "GoogleIntegration/GoogleSignOn";
	public String gpropname2 = "GoogleIntegration/GoogleRegistration";
	
	public GoogleRegistration(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis URL")
	public GoogleRegistration launchURL(String URL) {
		navigateto(URL);
		return this;

	}

	@Then("Enter credentials not registered before and select register as an Educator or parent")
	public GoogleRegistration verifyclickregisteraseducator() {

		navigateto("https://staging.d9.icivics.org/user/login");
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher26@gedu.demo.icivics.org");

		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = propElement(getPropfile(gpropname1, "Password"));

		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = propElement(getPropfile(gpropname1, "Nextbutton"));
		if (nextbutton1.isDisplayed()) {
			nextbutton1.click();
			waitTime(3000);
			reportStep("Registration page display", "Pass");
		} else {
			reportStep("Registration page not display", "Fail");
		}
		WebElement registeraseducatorbutton = propElement(getPropfile(gpropname1, "RegisterasEducator"));
		waitTime(3000);
		registeraseducatorbutton.click();
		String text=(getPropfile(gpropname2, "Headervalue"));
		WebElement header = propElement(getPropfile(gpropname2, "Header"));
		String headertext = header.getText();
		System.out.println(headertext);
		if (headertext.contains(text)) {
			reportStep("Teacher registration page 1 display ", "Pass");
		} else {
			reportStep("Teacher registration page 1 not display ", "Fail");
		}
		return this;
	}
	@Given("Start Registration without being signed in with google and verify the error message")
	public GoogleRegistration verifyregistrationwithoutsignin() {
		
		WebElement errormsg=propElement(getPropfile(gpropname2, "Errormsg"));
		String msg=errormsg.getText();
		System.out.println(msg);
		verifyText(errormsg, "Google Classroom token was not set correctly.");
		return this;
		
	}
	@Given("Start registration with already registered Id and verify the error message")
	public GoogleRegistration verifyregistrationwithalreadyregisteredID() {
		navigateto("https://staging.d9.icivics.org/user/login");
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher24@gedu.demo.icivics.org");

		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = propElement(getPropfile(gpropname1, "Password"));
		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = propElement(getPropfile(gpropname1, "Nextbutton"));
		if (nextbutton1.isDisplayed()) {
			nextbutton1.click();
			waitTime(3000);
			reportStep("Registration page display", "Pass");
		} else {
			reportStep("Registration page not display", "Fail");
		}
		navigateto("https://staging.d9.icivics.org/classroom/register");
		WebElement errormsg =propElement(getPropfile(gpropname2, "Errormsg1"));
		verifyText(errormsg, "Sorry but you do not have permission to view this page");
		return this;
	}
	@Given("Enter credentials not registered before and select register as Student")
	public GoogleRegistration verifyregisterasstudentclick() {
		navigateto("https://staging.d9.icivics.org/user/login");
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher30@gedu.demo.icivics.org");

		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = propElement(getPropfile(gpropname1, "Password"));

		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = propElement(getPropfile(gpropname1, "Nextbutton"));
		if (nextbutton1.isDisplayed()) {
			nextbutton1.click();
			waitTime(3000);
			reportStep("Registration page display", "Pass");
		} else {
			reportStep("Registration page not display", "Fail");
		}
		WebElement registerasstudentbutton = propElement(getPropfile(gpropname1, "RegisterasStudent"));
		click(registerasstudentbutton);
		waitTime(3000);
		WebElement studentpage = propElement(getPropfile(gpropname2, "Studentpage"));
		if(studentpage.isDisplayed()) {
		verifyText(studentpage, "Your registration is almost complete.");
		reportStep("Student page is display", "Pass");
		}
		else
		{
			reportStep("Student page is not display", "Fail");
		}
		return this;
	}
}
