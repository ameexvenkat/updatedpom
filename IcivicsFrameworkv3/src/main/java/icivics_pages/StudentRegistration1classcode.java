package icivics_pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class StudentRegistration1classcode extends ProjectSpecificMethods {
	public String gpropname1 = "StudentRegistration/studentregistration1Email";
	public String gpropname2 = "StudentRegistration/studentregistration1classcode";

	public StudentRegistration1classcode(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis Studentregistration email URL")
	public StudentRegistration1classcode launchstudentURL(String URL) {
		navigateto(URL);
		return this;

	}

	@When("Click on Wait, I have a class code! link, class code page should open in the same tab")
	public StudentRegistration1classcode Clickonwaitihaveaclasscodelink() {
		scrollToTheGivenWebElement(getPropfile(gpropname1, "classcodelink"));
		WebElement classcodelink = propElement(getPropfile(gpropname1, "classcodelink"));
		if (classcodelink.isDisplayed()) {
			reportStep("class code link is displayed and clicked, opened in the same tab", "Pass");
			classcodelink.click();
			waitTime(3000);
		}
		return this;
	}

	public StudentRegistration1classcode clickOptionallink() {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Link"));
		WebElement link = propElement(getPropfile(gpropname2, "Link"));
		link.click();
		return this;
	}

	@Then("Click link Optional, Click here to enter your email address")
	public StudentRegistration1classcode verifyOptionallink() {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Link"));
		WebElement link = propElement(getPropfile(gpropname2, "Link"));
		link.click();
		WebElement Emailaddresslabel = propElement(getPropfile(gpropname2, "Emailaddresslabel"));
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Emailaddresslabel"));
		if (Emailaddresslabel.isDisplayed()) {
			reportStep("Emailaddress label is displayed", "Pass");
		} else {
			reportStep("Emailaddress label box is not displayed", "Fail");
		}

		WebElement email = propElement(getPropfile(gpropname1, "Emailaddress"));
		if (email.isDisplayed()) {

			reportStep("email field is displayed", "Pass");
		} else {
			reportStep("email field is not displayed", "Fail");
		}

		WebElement VerifyEmailaddresslabel = propElement(getPropfile(gpropname1, "VerifyEmailaddresslabel"));
		if (VerifyEmailaddresslabel.isDisplayed()) {
			reportStep("VerifyEmailaddress label is displayed", "Pass");
		} else {
			reportStep("VerifyEmailaddress label box is not displayed", "Fail");
		}

		WebElement verifyemail = propElement(getPropfile(gpropname1, "VerifyEmailaddress"));
		if (verifyemail.isDisplayed()) {

			reportStep("verifyemail field is displayed", "Pass");
		} else {
			reportStep("verifyemail field is not displayed", "Fail");
		}

		return this;
	}

	@Given("verify the Tooltip Text by Hovering on email field")
	public StudentRegistration1classcode hoveronemailfield() throws InterruptedException, IOException {
		WebElement link = propElement(getPropfile(gpropname2, "Link"));
		link.click();
		scrollToTheGivenWebElement(getPropfile(gpropname2, "firstname"));
		String email = getPropfile(gpropname1, "Emailaddress");
		mouseOverAction(email);
		WebElement emailtooltip = propElement(email);
		String ExpectedTooltip = getPropfile(gpropname2, "EmailTooltip");
		String actualTooltip = emailtooltip.getAttribute("data-original-title");
		if (actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}
		return this;
	}

	@Then("verify the Tooltip Text by Hovering on verify email field")
	public StudentRegistration1classcode hoveronverifyemailfield() throws InterruptedException, IOException {
		mouseOverAction(getPropfile(gpropname1, "VerifyEmailaddress"));
		reportStep("No Tool Tip present for Verifyemail text box", "Pass");
		return this;
	}

	@When("Click on Click here to remove the email address")
	public StudentRegistration1classcode clickonremovelink() {
		WebElement link = propElement(getPropfile(gpropname2, "Link"));
		link.click();
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Emailaddresslabel"));
		waitTime(5000);
		clickWithNoSnap(propElement(getPropfile(gpropname2, "Link1")));
		
		waitTime(5000);
		reportStep("Emailaddress/Verify EmailAddress label and Field is not displayed", "Pass");
		waitTime(5000);
		return this;
	}

	@Given("Go to register as student class code page")
	public StudentRegistration1classcode usernamepregenerated() {

		WebElement username = propElement(getPropfile(gpropname1, "username"));
		waitTime(6000);
		String username1 = username.getText();

		if (!username1.isEmpty()) {
			reportStep(
					"Username field is not empty,it is pregenerated with " + username1 + " and Verified successfully",
					"Pass");
		} else {
			reportStep("Username field is empty", "Fail");
		}
		return this;
	}

	@When("Verify New username is randomly generated and appears in the box")
	public StudentRegistration1classcode usernamegeneratedrandomly() throws InterruptedException, IOException {

		WebElement username = propElement(getPropfile(gpropname1, "username"));
		waitTime(6000);
		String username1 = username.getText();
		reportStep("Username before clicking reload button is " + username1, "Pass");
		propElement(getPropfile(gpropname1, "reloadicon")).click();
		waitTime(6000);
		String username2 = username.getText();
		reportStep("Username after clicking reload button is " + username2, "Pass");
		if (!username1.equals(username2)) {
			reportStep(username1 + " & " + username2
					+ " are not same, username is newly generated & Verified successfully", "Pass");
		} else {
			reportStep(username1 + " is same as " + username2 + " username is not generated", "Fail");
		}
		return this;
	}

	@Given("Verify username is enabled and user able to enter text in username field")
	public StudentRegistration1classcode entertextinusernamefield() throws InterruptedException, IOException {
		WebElement username = propElement(getPropfile(gpropname2, "username"));
		try {
			clearAndType(username, getPropfile(gpropname2, "UserName"));
		} catch (InvalidElementStateException e) {
			reportStep("The Element is not Interactable", "Pass");
		}
		if (!username.getText().isEmpty()) {
			reportStep("Username will not allow to enter text", "Pass");
		} else {
			reportStep("Username is enabled it will allow to enter text", "Fail");
		}
		return this;
	}

	@Then("Verify typing text allowed in classcode field")
	public StudentRegistration1classcode entertextinclasscodefield() throws InterruptedException, IOException {
		WebElement classcode = propElement(getPropfile(gpropname2, "classcode"));
		clearAndType(classcode, getPropfile(gpropname2, "ClassCode"));
		return this;
	}

	@And("Verify typing text allowed in firstname field")
	public StudentRegistration1classcode entertextinfirstnamefield() throws InterruptedException, IOException {
		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));
		clearAndType(firstname, getPropfile(gpropname2, "FirstName"));
		return this;
	}

	@And("Verify typing text allowed in lastname field")
	public StudentRegistration1classcode entertextinlastnamefield() throws InterruptedException, IOException {
		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));
		clearAndType(lastname, getPropfile(gpropname2, "LastName"));
		return this;
	}

	@And("Verify typing text allowed in email field")
	public StudentRegistration1classcode entertextinemailfield() throws InterruptedException, IOException {
		String EmailId = getPropfile(gpropname2, "EmailID");

		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		String[] data = EmailId.split("@");
		String name = data[0];
		String host = data[1];
		String emailId = name + number + "@" + host;

		writePropfile("StudentRegistration/email", "email", emailId);
		WebElement emailele = propElement(getPropfile(gpropname2, "Emailaddress"));
		clearAndType(emailele, emailId);
		return this;
	}

	@And("Verify typing text allowed in Verify email field")
	public StudentRegistration1classcode entertextinverifyemailfield() throws InterruptedException, IOException {
		String email1 = getPropfile("StudentRegistration/email", "email");
		WebElement verifyemail = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));
		clearAndType(verifyemail, email1);
		return this;

	}

	@And("Click on Next Button")
	public StudentRegistration1classcode clicknext() throws InterruptedException, IOException {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "nextbutton"));
		reportStep("Next Button is clicked", "Pass");
		click(propElement(getPropfile(gpropname2, "nextbutton")));
		waitTime(3000);

		WebElement page2 = propElement(getPropfile(gpropname2, "passwordlabel"));
		if (page2.isDisplayed()) {
			reportStep("Page 2 is displayed", "Pass");
		} else {
			reportStep("Page 2 is not displayed", "Fail");
		}

		return this;

	}

	@Given("Verify username is not marked with an asterisk")
	public StudentRegistration1classcode usernameAsteriks() throws IOException {

		WebElement usernamelabel = propElement(getPropfile(gpropname2, "usernamelabel"));
		if (!usernamelabel.getText().contains("*")) {
			reportStep("* is not present in the username label", "Pass");
		} else {
			reportStep("* is present in the username label", "Fail");
		}
		return this;
	}

	@Then("Verify classcode is marked with an asterisk")
	public StudentRegistration1classcode classcodeAsteriks() throws IOException {
		WebElement webElement = driver.findElement(By.xpath(getPropfile(gpropname2, "classcode*")));
		String script = "return window.getComputedStyle(arguments[0],':after').getPropertyValue('content')";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String content = (String) js.executeScript(script, webElement);

		if (content.contains("*")) {
			reportStep("Asteriks * is present in the Class Code label", "Pass");
		} else {
			reportStep("* is not present in the Class Code label", "Pass");
		}
		return this;
	}

	@And("Verify firstname is marked with an asterisk")
	public StudentRegistration1classcode firstnameAsteriks() throws IOException {
		WebElement webElement = driver.findElement(By.xpath(getPropfile(gpropname2, "firstname*")));
		String script = "return window.getComputedStyle(arguments[0],':after').getPropertyValue('content')";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String content = (String) js.executeScript(script, webElement);

		if (content.contains("*")) {
			reportStep("Asteriks * is present in the firstname label", "Pass");
		} else {
			reportStep("* is not present in the firstname label", "Pass");
		}
		return this;
	}

	@And("Verify lastname is marked with an asterisk")
	public StudentRegistration1classcode lastnameAsteriks() throws IOException {
		WebElement webElement = driver.findElement(By.xpath(getPropfile(gpropname2, "lastname*")));
		String script = "return window.getComputedStyle(arguments[0],':after').getPropertyValue('content')";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String content = (String) js.executeScript(script, webElement);

		if (content.contains("*")) {
			reportStep("Asteriks * is present in the lastname label", "Pass");
		} else {
			reportStep("* is not present in the lastname label", "Pass");
		}
		return this;
	}

	@And("Verify email is marked with an asterisk")
	public StudentRegistration1classcode emailAsteriks() throws IOException {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Emailaddresslabel"));
		WebElement webElement = driver.findElement(By.xpath(getPropfile(gpropname2, "email*")));
		String script = "return window.getComputedStyle(arguments[0],':after').getPropertyValue('content')";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String content = (String) js.executeScript(script, webElement);

		if (content.contains("*")) {
			reportStep("Asteriks * is present in the email label", "Pass");
		} else {
			reportStep("* is not present in the email label", "Pass");
		}
		return this;
	}

	@And("Verify verify email is marked with an asterisk")
	public StudentRegistration1classcode verifyemailAsteriks() throws IOException {
		WebElement webElement = driver.findElement(By.xpath(getPropfile(gpropname2, "vemail*")));
		String script = "return window.getComputedStyle(arguments[0],':after').getPropertyValue('content')";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String content = (String) js.executeScript(script, webElement);

		if (content.contains("*")) {
			reportStep("Asteriks * is present in the verifyemail label", "Pass");
		} else {
			reportStep("* is not present in the verify email label", "Pass");
		}
		return this;
	}

	@Given("Verify on entering invalid class code and improper email address error msg should display")
	public StudentRegistration1classcode verifyinvaliderrormsg() throws InterruptedException {
		WebElement link = propElement(getPropfile(gpropname2, "Link"));
		link.click();
		WebElement classcode = propElement(getPropfile(gpropname2, "classcode"));
		classcode.clear();
		classcode.sendKeys("12345");

		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));
		firstname.clear();
		firstname.sendKeys("14344433%");

		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));
		lastname.clear();
		lastname.sendKeys("%ttt#12");

		WebElement email = propElement(getPropfile(gpropname2, "Emailaddress"));
		email.clear();
		email.sendKeys("GHDGFH!#!#!");

		WebElement verifyemail = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));
		verifyemail.clear();
		verifyemail.sendKeys("GHDGFH!#!#!");

		WebElement nextbutton = propElement(getPropfile(gpropname2, "nextbutton"));
		nextbutton.click();
		waitTime(5000);
		WebElement alertmsg = propElement(getPropfile(gpropname2, "alertpopup1"));
		String Actualerrmsg = alertmsg.getText();
		String Expectederrmsg = "The classcode isn't linked to a class.";
		verifyPartialText(alertmsg, "The classcode isn't linked to a class.");
		if (Expectederrmsg.equals(Actualerrmsg)) {
			reportStep("Error alert message is displayed", "Pass");
		}
		WebElement alertmsg2 = propElement(getPropfile(gpropname2, "alertpopup2"));
		String Actualerrmsg2 = alertmsg.getText();
		String Expectederrmsg2 = "2 errors have been found:";
		verifyPartialText(alertmsg2, "2 errors have been found:");
		if (Expectederrmsg2.equals(Actualerrmsg2)) {
			reportStep("Error alert message is displayed", "Pass");
		}
		WebElement emailerrormsg = propElement(getPropfile(gpropname2, "emailinvalidalert1"));
		if (emailerrormsg.getText().contains("The email address GHDGFH!#!#! is not valid."))
			scrollToTheGivenWebElement(getPropfile(gpropname2, "Emailaddresslabel"));
		{
			reportStep(emailerrormsg.getText() + " is displayed", "Pass");

		}
		WebElement verifyemailerrormsg = propElement(getPropfile(gpropname2, "verifyemailinvalidalert1"));
		if (verifyemailerrormsg.getText().contains("The email address GHDGFH!#!#! is not valid.")) {
			reportStep(verifyemailerrormsg.getText() + " is displayed", "Pass");

			Thread.sleep(3000);
		}
		return this;
	}

	@Given("Verify Error messages will display if any of 5 are left blank")
	public StudentRegistration1classcode verifyerrormsgblankfieldall() throws InterruptedException {

		click(propElement(getPropfile(gpropname2, "Link")));

		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));

		firstname.clear();

		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));

		lastname.clear();

		WebElement email = propElement(getPropfile(gpropname2, "Emailaddress"));

		email.clear();

		WebElement verifyemail = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));

		verifyemail.clear();

		scrollToTheGivenWebElement(getPropfile(gpropname2, "nextbutton"));

		clickOn(getPropfile(gpropname2, "nextbutton"));
		WebElement firstnamealertmsg1 = propElement(getPropfile(gpropname2, "firstnamealertmsg1"));

		verifyExactText(firstnamealertmsg1, "The classcode isn't linked to a class.");

		WebElement firstnamealertmsg = propElement(getPropfile(gpropname2, "firstnamealertmsg"));

		verifyExactText(firstnamealertmsg, "Field First Name is required");

		WebElement lastnamealertmsg = propElement(getPropfile(gpropname2, "lastnamealertmsg"));

		verifyExactText(lastnamealertmsg, "Field Last Name is required");

		WebElement alertmsg = propElement(getPropfile(gpropname2, "alertmsg1"));

		verifyPartialText(alertmsg, "3 errors have been found:");

		scrollToTheGivenWebElement(getPropfile(gpropname2, "Emailaddresslabel"));

		WebElement emailalertmsg = propElement(getPropfile(gpropname2, "emailalertmsg"));

		verifyPartialText(emailalertmsg, "Email address field is required.");

		WebElement verifyemailalertmsg = propElement(getPropfile(gpropname2, "verifyemailalertmsg"));

		verifyPartialText(verifyemailalertmsg, "Verify email address field is required.");

		return this;

	}

	@When("Verify error message by leaving the Classcode field blank and enter values in the remaining required fields and click on next button")
	public StudentRegistration1classcode verifyerrormsgclasscodeblankfield() throws InterruptedException {
		WebElement classcode = propElement(getPropfile(gpropname2, "classcode"));
		classcode.clear();

		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));

		firstname.clear();
		firstname.sendKeys(getPropfile(gpropname2, "FirstName"));

		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));

		lastname.clear();

		lastname.sendKeys(getPropfile(gpropname2, "LastName"));

		WebElement email = propElement(getPropfile(gpropname2, "Emailaddress"));

		email.clear();

		email.sendKeys(getPropfile("StudentRegistration/email", "email"));

		WebElement verifyemailele = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));

		verifyemailele.clear();

		verifyemailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		scrollToTheGivenWebElement(getPropfile(gpropname2, "nextbutton"));

		clickOn(getPropfile(gpropname2, "nextbutton"));
		waitTime(3000);
		WebElement codeclassalertmsg = propElement(getPropfile(gpropname2, "alertpopup1"));

		verifyExactText(codeclassalertmsg, "The classcode isn't linked to a class.");
		WebElement codeclassalertmsg1 = propElement(getPropfile(gpropname2, "classcodemsg"));

		verifyExactText(codeclassalertmsg1, "Class Code field is required.");

		return this;

	}

	@And("Verify error message by leaving the Firstname field blank and enter values in the remaining required fields and click on next button")
	public StudentRegistration1classcode verifyerrormsgfirstnameblankfield() throws InterruptedException {

		waitTime(3000);
		WebElement classcode = propElement(getPropfile(gpropname2, "classcode"));
		classcode.clear();
		classcode.sendKeys(getPropfile(gpropname2, "ClassCode"));

		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));

		firstname.clear();

		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));

		lastname.clear();

		lastname.sendKeys(getPropfile(gpropname2, "LastName"));

		WebElement email = propElement(getPropfile(gpropname2, "Emailaddress"));

		email.clear();

		email.sendKeys(getPropfile("StudentRegistration/email", "email"));

		WebElement verifyemailele = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));

		verifyemailele.clear();

		verifyemailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		scrollToTheGivenWebElement(getPropfile(gpropname2, "nextbutton"));

		clickOn(getPropfile(gpropname2, "nextbutton"));

		WebElement firstnamealertmsg = propElement(getPropfile(gpropname2, "alertpopup6"));

		verifyExactText(firstnamealertmsg, "Field First Name is required");

		return this;

	}

	@And("Verify error message by leaving the Lastname field blank and enter values in the remaining required fields and click on next button")

	public StudentRegistration1classcode verifyerrormsglastnameblankfield() throws InterruptedException {

		WebElement classcode = propElement(getPropfile(gpropname2, "classcode"));
		classcode.clear();
		classcode.sendKeys(getPropfile(gpropname2, "ClassCode"));

		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));

		firstname.clear();

		firstname.sendKeys(getPropfile(gpropname2, "FirstName"));

		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));

		lastname.clear();

		WebElement emailele = propElement(getPropfile(gpropname2, "Emailaddress"));

		emailele.clear();

		emailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		WebElement verifyemailele = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));

		verifyemailele.clear();

		verifyemailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		scrollToTheGivenWebElement(getPropfile(gpropname2, "nextbutton"));

		clickOn(getPropfile(gpropname2, "nextbutton"));

		WebElement lastnamealertmsg = propElement(getPropfile(gpropname2, "alertpopup7"));

		verifyExactText(lastnamealertmsg, "Field Last Name is required");

		return this;

	}

	@And("Verify error message by leaving the email field blank and enter values in the remaining required fields and click on next button")

	public StudentRegistration1classcode verifyerrormsgemailblankfield() throws InterruptedException {

		WebElement classcode = propElement(getPropfile(gpropname2, "classcode"));
		classcode.clear();
		classcode.sendKeys(getPropfile(gpropname2, "ClassCode"));

		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));

		firstname.clear();

		firstname.sendKeys(getPropfile(gpropname2, "FirstName"));

		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));

		lastname.clear();

		lastname.sendKeys(getPropfile(gpropname2, "LastName"));

		WebElement email = propElement(getPropfile(gpropname2, "Emailaddress"));

		email.clear();

		WebElement verifyemailele = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));

		verifyemailele.clear();

		verifyemailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		scrollToTheGivenWebElement(getPropfile(gpropname2, "nextbutton"));

		clickOn(getPropfile(gpropname2, "nextbutton"));
		waitTime(5000);

		WebElement alertmsg = propElement(getPropfile(gpropname2, "verifyemailalerterrormsg"));

		verifyPartialText(alertmsg, "2 errors have been found:");

		scrollToTheGivenWebElement(getPropfile(gpropname2, "Emailaddresslabel"));

		WebElement emailalertmsg = propElement(getPropfile(gpropname2, "emailalertmsg"));

		verifyPartialText(emailalertmsg, "Email address field is required.");

		WebElement verifyemailalertmsg = propElement(getPropfile(gpropname2, "verifyemailalertmsg1"));

		verifyPartialText(verifyemailalertmsg, "Your e-mail address and confirmed e-mail address must match.");

		return this;

	}

	@And("Verify error message by leaving the verify email field blank and enter values in the remaining required fields and click on next button")

	public StudentRegistration1classcode verifyerrormsgverifyemailblankfield() throws InterruptedException {

		WebElement classcode = propElement(getPropfile(gpropname2, "classcode"));
		classcode.clear();
		classcode.sendKeys(getPropfile(gpropname2, "ClassCode"));

		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));

		firstname.clear();

		firstname.sendKeys(getPropfile(gpropname2, "FirstName"));

		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));

		lastname.clear();

		lastname.sendKeys(getPropfile(gpropname2, "LastName"));

		waitTime(5000);

		WebElement emailele = propElement(getPropfile(gpropname2, "Emailaddress"));

		emailele.clear();

		emailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		WebElement verifyemail = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));

		verifyemail.clear();

		waitTime(5000);

		scrollToTheGivenWebElement(getPropfile(gpropname2, "nextbutton"));

		waitTime(3000);

		clickOn(getPropfile(gpropname2, "nextbutton"));
		waitTime(5000);

		WebElement alertmsg = propElement(getPropfile(gpropname2, "verifyemailalerterrormsg1"));

		verifyPartialText(alertmsg, "1 error has been found:");

		scrollToTheGivenWebElement(getPropfile(gpropname2, "Emailaddresslabel"));

		WebElement verifyemailalertmsg2 = propElement(getPropfile(gpropname2, "verifyemailalertmsg2"));
		verifyPartialText(verifyemailalertmsg2, "Verify email address field is required.");

		return this;

	}

	@Given("Verify on entering invalid or blank info and hit next")
	public StudentRegistration1classcode verifyinvaliderrormsg2() throws InterruptedException {
		WebElement link = propElement(getPropfile(gpropname2, "Link"));
		link.click();
		WebElement classcode = propElement(getPropfile(gpropname2, "classcode"));
		classcode.clear();
		classcode.sendKeys("12345");

		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));
		firstname.clear();

		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));
		lastname.clear();

		WebElement email = propElement(getPropfile(gpropname2, "Emailaddress"));
		email.clear();
		email.sendKeys("GHDGFH!#!#!");

		WebElement verifyemail = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));
		verifyemail.clear();
		verifyemail.sendKeys(" ");

		WebElement nextbutton = propElement(getPropfile(gpropname2, "nextbutton"));
		nextbutton.click();

		WebElement alertmsg = propElement(getPropfile(gpropname2, "alertpopup1"));
		String Actualerrmsg = alertmsg.getText();
		String Expectederrmsg = "The classcode isn't linked to a class.";
		verifyPartialText(alertmsg, "The classcode isn't linked to a class.");
		if (Expectederrmsg.equals(Actualerrmsg)) {
			reportStep("Error alert message is displayed", "Pass");
		}
		WebElement alertmsg2 = propElement(getPropfile(gpropname2, "alertpopup2"));
		String Actualerrmsg2 = alertmsg.getText();
		String Expectederrmsg2 = "Field First Name is required";
		verifyPartialText(alertmsg2, "Field First Name is required");
		if (Expectederrmsg2.equals(Actualerrmsg2)) {
			reportStep("Error alert message is displayed", "Pass");
		}
		WebElement alertmsg3 = propElement(getPropfile(gpropname2, "alertpopup3"));
		String Actualerrmsg3 = alertmsg.getText();
		String Expectederrmsg3 = "Field Last Name is required";
		verifyPartialText(alertmsg3, "Field Last Name is required");
		if (Expectederrmsg3.equals(Actualerrmsg3)) {
			reportStep("Error alert message is displayed", "Pass");
		}
		WebElement alertmsg4 = propElement(getPropfile(gpropname2, "alertpopup4"));
		String Actualerrmsg4 = alertmsg.getText();
		String Expectederrmsg4 = "2 errors have been found:";
		verifyPartialText(alertmsg4, "2 errors have been found:");
		if (Expectederrmsg4.equals(Actualerrmsg4)) {
			reportStep("Error alert message is displayed", "Pass");
		}

		scrollToTheGivenWebElement(getPropfile(gpropname2, "Emailaddresslabel"));
		WebElement emailalertmsg1 = propElement(getPropfile(gpropname2, "emailalertmsg"));
		verifyPartialText(emailalertmsg1, "The email address GHDGFH!#!#! is not valid.");

		WebElement verifyemailalertmsg2 = propElement(getPropfile(gpropname2, "verifyemailalertmsg"));
		verifyPartialText(verifyemailalertmsg2, "Verify email address field is required.");

		return this;
	}

	@Given("Enter valid firstname, lastname, email, verifyemail and click on next and verify page 2 is loaded")
	public StudentRegistration1classcode verifyregistrationwithvalidvalue() throws InterruptedException, IOException {
		waitTime(5000);

		clickWithNoSnap(propElement(getPropfile(gpropname2, "Link")));
		WebElement classcode = propElement(getPropfile(gpropname2, "classcode"));
		classcode.clear();
		classcode.sendKeys(getPropfile(gpropname2, "ClassCode"));
		reportStep(getPropfile(gpropname2, "ClassCode") + " is entered as ClassCode", "Pass");

		WebElement username = propElement(getPropfile(gpropname2, "username"));
		String username1 = username.getText();
		writePropfile("EducatorRegistration/username", "username", username1);
		reportStep("User name is " + username1, "Pass");

		WebElement firstname = propElement(getPropfile(gpropname2, "firstname"));
		firstname.clear();
		firstname.sendKeys(getPropfile(gpropname2, "FirstName"));
		reportStep(getPropfile(gpropname2, "FirstName") + " is entered as Firstname", "Pass");

		WebElement lastname = propElement(getPropfile(gpropname2, "Lastname"));
		lastname.clear();
		lastname.sendKeys(getPropfile(gpropname2, "LastName"));
		reportStep(getPropfile(gpropname2, "LastName") + " is entered as Lastname", "Pass");

		WebElement emailele = propElement(getPropfile(gpropname2, "Emailaddress"));
		emailele.clear();
		emailele.sendKeys(getPropfile(gpropname2, "EmailID"));
		reportStep(getPropfile(gpropname2, "EmailID") + " is entered as Email", "Pass");

		WebElement verifyemailele = propElement(getPropfile(gpropname2, "VerifyEmailaddress"));
		verifyemailele.clear();
		verifyemailele.sendKeys(getPropfile(gpropname2, "VerifyEmailID"));
		reportStep(getPropfile(gpropname2, "VerifyEmailID") + " is entered as Verify email", "Pass");

		scrollToTheGivenWebElement(getPropfile(gpropname2, "nextbutton"));
		reportStep("Next Button is clicked", "Pass");
		click(propElement(getPropfile(gpropname2, "nextbutton")));
		waitTime(3000);

		WebElement page2 = propElement(getPropfile(gpropname1, "Page2StudentReglabel"));
		if (page2.isDisplayed()) {
			reportStep("Page 2 is displayed", "Pass");
		} else {
			reportStep("Page 2 is not displayed", "Fail");
		}

		return this;
	}

}
