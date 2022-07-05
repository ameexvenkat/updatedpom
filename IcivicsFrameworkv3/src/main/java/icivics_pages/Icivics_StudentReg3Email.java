package icivics_pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_StudentReg3Email extends ProjectSpecificMethods {
	public String gpropname1 = "StudentRegistration/studentregistration1Email";
	public String gpropname2 = "StudentRegistration/studentregistration1classcode";
	public String gpropname3 = "StudentRegistration/studentregistration2Email";
	public String gpropname4 = "StudentRegistration/studentregistration2classcode";
	public String gpropname5 = "StudentRegistration/studentregistration3Email";

	public Icivics_StudentReg3Email(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis Studentregistration email URL")
	public Icivics_StudentReg3Email launchstudentURL(String URL) {
		navigateto(URL);
		return this;
	}

	public Icivics_StudentReg3Email verifywithvaliddata() throws IOException {
		WebElement username = propElement(getPropfile(gpropname2, "username"));
		String username1 = username.getText();
		writePropfile("StudentRegistration/username", "username", username1);

		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));
		firstname.clear();
		firstname.sendKeys(getPropfile(gpropname2, "FirstName"));

		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));
		lastname.clear();
		lastname.sendKeys(getPropfile(gpropname2, "LastName"));

		String EmailId = getPropfile(gpropname2, "EmailID");

		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		String[] data = EmailId.split("@");
		String name = data[0];
		String host = data[1];
		String emailId = name + number + "@" + host;

		writePropfile("StudentRegistration/email3", "email3", emailId);
		WebElement email = propElement(getPropfile(gpropname2, "Emailaddress"));
		email.clear();
		email.sendKeys(emailId);

		WebElement verifyemailele = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));
		verifyemailele.clear();
		verifyemailele.sendKeys(emailId);

		scrollToTheGivenWebElement(getPropfile(gpropname2, "nextbutton"));

		WebElement nextbuttonclick = propElement(getPropfile(gpropname2, "nextbutton"));
		nextbuttonclick.click();
		waitTime(3000);
		String pwd = "Test@12345";
		String cpwd = "Test@12345";
		WebElement password = propElement(getPropfile(gpropname3, "password1"));
		password.clear();
		password.sendKeys(pwd);

		WebElement confirmpassword = propElement(getPropfile(gpropname3, "confirmpassword1"));
		confirmpassword.clear();
		confirmpassword.sendKeys(cpwd);

		WebElement agreechkbox = propElement(getPropfile(gpropname3, "agreechkbox"));
		agreechkbox.click();
		waitTime(3000);
		WebElement finishbuttonclick = propElement(getPropfile(gpropname3, "finishbutton"));
		finishbuttonclick.click();
		waitTime(5000);

		return this;
	}

	@And("View page 3 of student registration")
	public Icivics_StudentReg3Email verifypagecount3() throws IOException {

		String cssvalue = "background-color";

		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname5, "step1"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname5, "step2"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(gpropname5, "step3"), cssvalue, Greencolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greencolor) && Step3.equals(Greencolor)) {
			reportStep("you are currently viewing page 3 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}
		return this;
	}

	@Given("verify Message says check your inbox")
	public Icivics_StudentReg3Email verifycheckmsgdisplay() throws IOException {
		WebElement emailmsg = propElement(getPropfile(gpropname5, "confirmationemailheadermsg"));
		if (emailmsg.getText()
				.equals("A welcome message with further instructions has been sent to your email address.")
				&& emailmsg.isDisplayed()) {
			reportStep("'A welcome message' is displayed as notification", "Pass");
		} else {
			reportStep("'A welcome message' is not displayed", "Fail");
		}

		return this;
	}

	@Given("Verify Message says confirmation email is on its way")
	public Icivics_StudentReg3Email verifyemailheaderlabel() {
		WebElement emailheadermsg = propElement(getPropfile(gpropname5, "emailheadermsg"));
		if (emailheadermsg.isDisplayed() && emailheadermsg.getText().equals("Your confirmation email is on the way!")) {
			reportStep(emailheadermsg.getText() + " email header msg is displayed and label text verified", "Pass");
		} else {
			reportStep("email header msg is not displayed and label text is not verified", "Fail");
		}

		return this;
	}

	@Given("Message has correct email from what was registered")
	public Icivics_StudentReg3Email verifyregisteredemaildisplay() throws IOException {
		String emailID = propElement(getPropfile(gpropname5, "emailID")).getText();
		String email1 = getPropfile("StudentRegistration/email3", "email3");
		if (email1.equals(emailID)) {
			reportStep("Message has correct email from what was registered is displayed", "Pass");
		} else {
			reportStep("Message has correct email from what was registered is not displayed", "Fail");
		}
		return this;
	}

	@Given("Verify resend button is clickable")
	public Icivics_StudentReg3Email verifyresendbutton() {
		WebElement resendbutton = propElement(getPropfile(gpropname5, "resendbutton"));
		if (resendbutton.isDisplayed()) {

			resendbutton.click();
			scrollToTheGivenWebElement(getPropfile(gpropname5, "resendbutton"));

			reportStep("resend button is clicked successfully", "Pass");
		} else {
			reportStep("resend button is not clicked", "Fail");
		}
		scrollToTheGivenWebElement(getPropfile(gpropname5, "resendbutton"));
		waitTime(3000);
		return this;
	}

	@Given("Verify Screen shows confirmation email has been sent")
	public Icivics_StudentReg3Email verifyconfirmationemail() {
		scrollToTheGivenWebElement(getPropfile(gpropname5, "resendbutton"));
		WebElement resendbutton = propElement(getPropfile(gpropname5, "resendbutton"));
		resendbutton.click();
		waitTime(3000);

		WebElement confirmationemailheadermsg = propElement(getPropfile(gpropname5, "confirmationemailheadermsg"));
		if (confirmationemailheadermsg.isDisplayed()
				&& confirmationemailheadermsg.getText().equals("Confirmation email has been resent.")) {
			reportStep(confirmationemailheadermsg.getText() + " conformation email msg is displayed and text verified",
					"Pass");
		} else {
			reportStep("confirmation email msg is not displayed and text is not verified", "Fail");
		}
		return this;
	}

}
