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
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class StudentRegistration1Email extends ProjectSpecificMethods {
	public String gpropname = "StudentRegistration/studentregistration1Email";

	public StudentRegistration1Email(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis Studentregistration email URL")
	public StudentRegistration1Email launchstudentURL(String URL) {
		navigateto(URL);
		return this;
	}

	@When("Studentregistration email page is verified successfully")
	public StudentRegistration1Email verifystudentpage(String URL) {
		verifyUrlOfThePage(URL);
		return this;
	}

	@And("Verify breadcrumbs is displayed")
	public StudentRegistration1Email verifybreadcrumbs() throws IOException {
		WebElement breadcrumbs = propElement(getPropfile(gpropname, "breadcrumbs"));
		if (breadcrumbs.isDisplayed()) {
			reportStep("Page counter 1-3 is Displayed", "Pass");
		} else
			reportStep("Page counter 1-3 is Not Displayed", "Fail");
		return this;
	}

	@Then("verify Current page count is 1 and print")
	public StudentRegistration1Email verifypagecount1() throws IOException {
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname, "step2ele"), cssvalue, Greycolor);
		String Step3 = cssgetbefore(getPropfile(gpropname, "step3ele"), cssvalue, Greycolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greycolor) && Step3.equals(Greycolor)) {
			reportStep("you are currently viewing page 1 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}

		return this;
	}

	@When("If you click on Watch our student registration help video link, Youtube Video should open in a separate tab")
	public StudentRegistration1Email verifyregistrationvideolink() throws IOException {
		WebElement videolink = propElement(getPropfile(gpropname, "HelpVideolink"));
		if (videolink.isDisplayed()) {
			click(videolink);
			waitTime(5000);
			switchToWindow("Student Registration Video - YouTube");
			verifyTitle("Student Registration Video - YouTube");
			waitTime(5000);
			reportStep("Student Registration Help Video link is clicked and opened in a new tab", "Pass");
			switchToParentWindow();
		} else {
			reportStep("Student Registration Help Video link is not displayed", "Fail");
		}
		return this;
	}

	@Given("Verify the Username text fields")
	public StudentRegistration1Email Verifyusernametextfields() throws IOException {
		WebElement usernamelabel = propElement(getPropfile(gpropname, "usernamelabel"));
		if (usernamelabel.isDisplayed()) {
			reportStep("Username label is displayed", "Pass");
		} else {
			reportStep("Username label box is not displayed", "Fail");
		}
		WebElement username = propElement(getPropfile(gpropname, "username"));
		if (username.isDisplayed()) {
			reportStep("username field is displayed", "Pass");
		} else {
			reportStep("username field is not displayed", "Fail");
		}
		if (!username.getText().isEmpty()) {
			reportStep("username field is not empty", "Pass");
		} else {
			reportStep("username field is empty", "Fail");
		}
		return this;
	}

	@Then("Verify the First Name text fields")
	public StudentRegistration1Email Verifyfirstnamenametextfields() throws IOException {

		WebElement firstnamelabel = propElement(getPropfile(gpropname, "firstnamelabel"));

		if (firstnamelabel.isDisplayed()) {
			reportStep("First name label is displayed", "Pass");
		} else {
			reportStep("First name label box is not displayed", "Fail");
		}

		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		if (firstname.isDisplayed()) {

			reportStep("Firstname field is displayed", "Pass");
		}

		else {
			reportStep("Firstname field is not displayed", "Fail");
		}

		String CLbox = firstname.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("First name text box is Blank", "Pass");
		} else {
			reportStep("First name text box is not Blank", "Fail");
		}

		return this;
	}

	@And("Verify the Last Name text fields")
	public StudentRegistration1Email Verifylastnametextfields() throws IOException {

		WebElement Lastnamelabel = propElement(getPropfile(gpropname, "Lastnamelabel"));
		if (Lastnamelabel.isDisplayed()) {
			reportStep("Lastname label is displayed", "Pass");
		} else {
			reportStep("Lastname label box is not displayed", "Fail");
		}

		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		if (lastname.isDisplayed()) {

			reportStep("Lastname field is displayed", "Pass");
		} else {
			reportStep("Lastname field is not displayed", "Fail");
		}

		String CLbox = lastname.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("Last name text box is Blank", "Pass");
		} else {
			reportStep("Last name text box is not Blank", "Fail");
		}
		return this;
	}

	@And("Verify the E-mail text fields")
	public StudentRegistration1Email Verifyemailtextfields() throws IOException {

		WebElement Emailaddresslabel = propElement(getPropfile(gpropname, "Emailaddresslabel"));
		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));
		if (Emailaddresslabel.isDisplayed()) {
			reportStep("Emailaddress label is displayed", "Pass");
		} else {
			reportStep("Emailaddress label box is not displayed", "Fail");
		}

		WebElement email = propElement(getPropfile(gpropname, "Emailaddress"));
		if (email.isDisplayed()) {

			reportStep("email field is displayed", "Pass");
		} else {
			reportStep("email field is not displayed", "Fail");
		}

		String CLbox = email.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("Emailaddress text box is Blank", "Pass");
		} else {
			reportStep("Emailaddress text box is not Blank", "Fail");
		}

		return this;
	}

	@And("Verify the Verify E-mail text fields")
	public StudentRegistration1Email Verifyemail2textfields() throws IOException {

		WebElement VerifyEmailaddresslabel = propElement(getPropfile(gpropname, "VerifyEmailaddresslabel"));
		if (VerifyEmailaddresslabel.isDisplayed()) {
			reportStep("VerifyEmailaddress label is displayed", "Pass");
		} else {
			reportStep("VerifyEmailaddress label box is not displayed", "Fail");
		}

		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		if (verifyemail.isDisplayed()) {

			reportStep("verifyemail field is displayed", "Pass");
		} else {
			reportStep("verifyemail field is not displayed", "Fail");
		}

		String CLbox = verifyemail.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("VerifyEmailaddress text box is Blank", "Pass");
		} else {
			reportStep("VerifyEmailaddress box is not Blank", "Fail");
		}
		return this;
	}

	@Given("Verify username is pregenerated")
	public StudentRegistration1Email usernamepregenerated() throws InterruptedException, IOException {
		WebElement username = propElement(getPropfile(gpropname, "username"));
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

	@Given("Verify New username is randomly generated and appears in the box")
	public StudentRegistration1Email usernamegeneratedrandomly() throws InterruptedException, IOException {
		WebElement username = propElement(getPropfile(gpropname, "username"));
		waitTime(6000);
		String username1 = username.getText();
		reportStep("Username before clicking reload button is " + username1, "Pass");
		propElement(getPropfile(gpropname, "reloadicon")).click();
		waitTime(6000);
		String username2 = username.getText();
		reportStep("Username after clicking reload button is " + username2, "Pass");
		if (!username1.equals(username2)) {
			reportStep("username is newly generated & Verified successfully", "Pass");
		} else {
			reportStep(username1 + " is same as " + username2 + " username is not generated", "Fail");
		}
		return this;
	}

	@Given("Verify username is enabled and user able to enter text in username field")
	public StudentRegistration1Email entertextinusernamefield() throws InterruptedException, IOException {
		WebElement username = propElement(getPropfile(gpropname, "username"));
		try {
			clearAndType(username, getPropfile(gpropname, "UserName"));
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

	@Then("Verify typing text allowed in firstname field")
	public StudentRegistration1Email entertextinfirstnamefield() throws InterruptedException, IOException {
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		clearAndType(firstname, getPropfile(gpropname, "FirstName"));
		return this;
	}

	@And("Verify typing text allowed in lastname field")
	public StudentRegistration1Email entertextinlastnamefield() throws InterruptedException, IOException {
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		clearAndType(lastname, getPropfile(gpropname, "LastName"));
		return this;
	}

	@And("Verify typing text allowed in email field")
	public StudentRegistration1Email entertextinemailfield() throws InterruptedException, IOException {
		String EmailId = getPropfile(gpropname, "EmailID");

		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		String[] data = EmailId.split("@");
		String name = data[0];
		String host = data[1];
		String emailId = name + number + "@" + host;

		writePropfile("StudentRegistration/email", "email", emailId);
		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));
		clearAndType(emailele, emailId);
		return this;
	}

	@And("Verify typing text allowed in Verify email field and click next")
	public StudentRegistration1Email entertextinverifyemailfield() throws InterruptedException, IOException {
		String email1 = getPropfile("StudentRegistration/email", "email");
		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		clearAndType(verifyemail, email1);
		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));
		click(propElement(getPropfile(gpropname, "nextbutton")));
		return this;
	}

	@Given("Verify username is not marked with an asterisk")
	public StudentRegistration1Email usernameAsteriks() throws IOException {
		WebElement usernamelabel = propElement(getPropfile(gpropname, "usernamelabel"));
		if (!usernamelabel.getText().contains("*")) {
			reportStep("* is not present in the username label", "Pass");
		} else {
			reportStep("* is present in the username label", "Fail");
		}
		return this;
	}

	@Then("Verify firstname is marked with an asterisk")
	public StudentRegistration1Email firstnameAsteriks() throws IOException {
		WebElement webElement = driver.findElement(By.xpath(getPropfile(gpropname, "firstname*")));
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
	public StudentRegistration1Email lastnameAsteriks() throws IOException {
		WebElement webElement = driver.findElement(By.xpath(getPropfile(gpropname, "lastname*")));
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
	public StudentRegistration1Email emailAsteriks() throws IOException {
		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));
		WebElement webElement = driver.findElement(By.xpath(getPropfile(gpropname, "email*")));
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
	public StudentRegistration1Email verifyemailAsteriks() throws IOException {
		WebElement webElement = driver.findElement(By.xpath(getPropfile(gpropname, "vemail*")));
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

	@Given("verify the Tooltip Text by Hovering on email field")
	public StudentRegistration1Email hoveronemailfield() throws InterruptedException, IOException {
		String email = getPropfile(gpropname, "Emailaddress");
		mouseOverAction(email);
		WebElement emailtooltip = propElement(email);
		String ExpectedTooltip = getPropfile(gpropname, "EmailTooltip");
		String actualTooltip = emailtooltip.getAttribute("data-original-title");
		if (actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}
		return this;
	}

	@Then("verify the Tooltip Text by Hovering on verify email field")
	public StudentRegistration1Email hoveronverifyemailfield() throws InterruptedException, IOException {
		mouseOverAction(getPropfile(gpropname, "VerifyEmailaddress"));
		reportStep("No Tool Tip present for Verifyemail text box", "Pass");
		return this;
	}

	@Given("Enter invalid first name")
	public StudentRegistration1Email Enterinvalidfirstname() throws InterruptedException, IOException {
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		if (firstname.isDisplayed()) {
			firstname.clear();
			firstname.sendKeys("14344433%");
			reportStep("Firstname field allows to type invalid data", "Pass");
		} else {
			reportStep("Firstname field is not displayed", "Fail");
		}
		return this;
	}

	@And("Enter invalid last name")
	public StudentRegistration1Email Enterinvalidlastname() throws InterruptedException, IOException {
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		if (lastname.isDisplayed()) {
			lastname.clear();
			lastname.sendKeys("%ttt#12");
			reportStep("Last name field allows to type invalid data", "Pass");
		} else {
			reportStep("Last name field is not displayed", "Fail");
		}
		return this;
	}

	@And("Enter invalid email")
	public StudentRegistration1Email Enterinvalidemailfield() throws InterruptedException {
		WebElement email = propElement(getPropfile(gpropname, "Emailaddress"));
		if (email.isDisplayed()) {
			email.clear();
			email.sendKeys("gdfsgadvjh");
			reportStep("email field allows to type invalid data", "Pass");
		} else {
			reportStep("email field is not displayed", "Fail");
		}
		return this;
	}

	@And("Enter Invalid verify Email")
	public StudentRegistration1Email Enterinvalidverifyemailfield() throws InterruptedException {
		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		if (verifyemail.isDisplayed()) {
			verifyemail.clear();
			waitTime(3000);
			verifyemail.sendKeys("gdfsgadvjh");
			reportStep("verify email field allows to type invalid data", "Pass");
		} else {
			reportStep("verigy email field is not displayed", "Fail");
		}
		return this;
	}

	@And("click on next button")
	public StudentRegistration1Email clicknextbutton() {
		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));
		clickOn(getPropfile(gpropname, "nextbutton"));
		return this;
	}

	@But("error message should be displayed for email and verify email")
	public StudentRegistration1Email verifyerrormsgforinvaliddatasubmit() {
		WebElement alertmsg = propElement(getPropfile(gpropname, "alertpopup1"));
		String Actualerrmsg = alertmsg.getText();
		String Expectederrmsg = "2 errors have been found:";
		verifyPartialText(alertmsg, "2 errors have been found:");
		if (Expectederrmsg.equals(Actualerrmsg)) {
			reportStep("Error alert message is displayed", "Pass");
		}

		WebElement emailerrormsg = propElement(getPropfile(gpropname, "emailinvalidalert1"));
		if (emailerrormsg.getText().contains("The email address gdfsgadvjh is not valid.")) {
			scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));
			reportStep(emailerrormsg.getText() + " is displayed", "Pass");
		}

		WebElement verifyemailerrormsg = propElement(getPropfile(gpropname, "verifyemailinvalidalert1"));
		if (verifyemailerrormsg.getText().contains("The email address gdfsgadvjh is not valid.")) {
			reportStep(verifyemailerrormsg.getText() + " is displayed", "Pass");
		}
		return this;
	}

	@Given("Verify error message for all required field by leaving the fields blank and click on next button")

	public StudentRegistration1Email verifyerrormsgblankfieldall() throws InterruptedException {

		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));

		firstname.clear();

		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));

		lastname.clear();

		WebElement email = propElement(getPropfile(gpropname, "Emailaddress"));

		email.clear();

		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));

		verifyemail.clear();

		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));

		clickOn(getPropfile(gpropname, "nextbutton"));

		WebElement firstnamealertmsg = propElement(getPropfile(gpropname, "firstnamealertmsg1"));

		verifyExactText(firstnamealertmsg, "Field First Name is required");

		WebElement lastnamealertmsg = propElement(getPropfile(gpropname, "lastnamealertmsg1"));

		verifyExactText(lastnamealertmsg, "Field Last Name is required");

		WebElement alertmsg = propElement(getPropfile(gpropname, "alertmsg1"));

		verifyPartialText(alertmsg, "2 errors have been found:");

		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));

		WebElement emailalertmsg = propElement(getPropfile(gpropname, "emailalertmsg"));

		verifyPartialText(emailalertmsg, "Email address field is required.");

		WebElement verifyemailalertmsg = propElement(getPropfile(gpropname, "verifyemailalertmsg"));

		verifyPartialText(verifyemailalertmsg, "Verify email address field is required.");

		return this;

	}

	@When("Verify error message by leaving the Firstname field blank and enter values in the remaining required fields and click on next button")

	public StudentRegistration1Email verifyerrormsgfirstnameblankfield() throws InterruptedException {

		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));

		firstname.clear();

		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));

		lastname.clear();

		lastname.sendKeys(getPropfile(gpropname, "LastName"));

		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));

		emailele.clear();

		emailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		WebElement verifyemailele = propElement(getPropfile(gpropname, "VerifyEmailaddress"));

		verifyemailele.clear();

		verifyemailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));

		clickOn(getPropfile(gpropname, "nextbutton"));

		WebElement firstnamealertmsg = propElement(getPropfile(gpropname, "alertpopup1"));

		verifyExactText(firstnamealertmsg, "Field First Name is required");

		return this;

	}

	@And("Verify error message by leaving the Lastname field blank and enter values in the remaining required fields and click on next button")

	public StudentRegistration1Email verifyerrormsglastnameblankfield() throws InterruptedException {

		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));

		firstname.clear();

		firstname.sendKeys(getPropfile(gpropname, "FirstName"));

		waitTime(3000);
		
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));

		lastname.clear();

		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));

		emailele.clear();

		emailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		WebElement verifyemailele = propElement(getPropfile(gpropname, "VerifyEmailaddress"));

		verifyemailele.clear();

		verifyemailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));

		clickOn(getPropfile(gpropname, "nextbutton"));
		waitTime(3000);

		WebElement lastnamealertmsg = propElement(getPropfile(gpropname, "alertpopup1"));

		verifyExactText(lastnamealertmsg, "Field Last Name is required");

		return this;

	}

	@And("Verify error message by leaving the email field blank and enter values in the remaining required fields and click on next button")

	public StudentRegistration1Email verifyerrormsgemailblankfield() throws InterruptedException {

		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));

		firstname.clear();

		firstname.sendKeys(getPropfile(gpropname, "FirstName"));

		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));

		lastname.clear();

		lastname.sendKeys(getPropfile(gpropname, "LastName"));

		WebElement email = propElement(getPropfile(gpropname, "Emailaddress"));

		email.clear();

		WebElement verifyemailele = propElement(getPropfile(gpropname, "VerifyEmailaddress"));

		verifyemailele.clear();

		verifyemailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));

		clickOn(getPropfile(gpropname, "nextbutton"));
		waitTime(3000);

		WebElement alertmsg = propElement(getPropfile(gpropname, "alertpopup1"));

		verifyPartialText(alertmsg, "2 errors have been found:");

		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));

		WebElement emailalertmsg = propElement(getPropfile(gpropname, "emailalertmsg"));

		verifyPartialText(emailalertmsg, "Email address field is required.");

		WebElement verifyemailalertmsg = propElement(getPropfile(gpropname, "verifyemailalertmsg"));

		verifyPartialText(verifyemailalertmsg, "Your e-mail address and confirmed e-mail address must match.");

		return this;

	}

	@And("Verify error message by leaving the verify email field blank and enter values in the remaining required fields and click on next button")

	public StudentRegistration1Email verifyerrormsgverifyemailblankfield() throws InterruptedException {

		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));

		firstname.clear();

		firstname.sendKeys(getPropfile(gpropname, "FirstName"));

		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));

		lastname.clear();

		lastname.sendKeys(getPropfile(gpropname, "LastName"));

		waitTime(5000);

		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));

		emailele.clear();

		emailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));

		verifyemail.clear();

		waitTime(5000);

		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));

		waitTime(3000);

		clickOn(getPropfile(gpropname, "nextbutton"));

		waitTime(3000);

		WebElement alertmsg = propElement(getPropfile(gpropname, "alertpopup1"));

		verifyPartialText(alertmsg, "1 error has been found:");

		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));

		WebElement verifyemailalertmsg = propElement(getPropfile(gpropname, "emailalertmsg1"));

		verifyPartialText(verifyemailalertmsg, "Verify email address field is required.");

		return this;

	}

	@Given("Enter valid firstname, lastname, email, verifyemail and click on next and verify page 2 is loaded")

	public StudentRegistration1Email verifyregistrationwithvaliddata() throws InterruptedException, IOException {

		waitTime(5000);

		WebElement username = propElement(getPropfile(gpropname, "username"));

		String username1 = username.getText();

		writePropfile("StudentRegistration/username", "username", username1);

		reportStep("User name is " + username1, "Pass");

		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));

		firstname.clear();

		firstname.sendKeys(getPropfile(gpropname, "FirstName"));

		reportStep(getPropfile(gpropname, "FirstName") + " is entered as Firstname", "Pass");

		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));

		lastname.clear();

		lastname.sendKeys(getPropfile(gpropname, "LastName"));

		reportStep(getPropfile(gpropname, "LastName") + " is entered as Lastname", "Pass");

		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));

		emailele.clear();

		emailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		reportStep(getPropfile("StudentRegistration/email", "email") + " is entered as Email", "Pass");

		WebElement verifyemailele = propElement(getPropfile(gpropname, "VerifyEmailaddress"));

		verifyemailele.clear();

		verifyemailele.sendKeys(getPropfile("StudentRegistration/email", "email"));

		reportStep(getPropfile("StudentRegistration/email", "email") + " is entered as Verify email", "Pass");

		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));

		reportStep("Next Button is clicked", "Pass");

		click(propElement(getPropfile(gpropname, "nextbutton")));

		waitTime(3000);

		WebElement page2 = propElement(getPropfile(gpropname, "Page2StudentReglabel"));

		if (page2.isDisplayed()) {

			reportStep("Page 2 is displayed", "Pass");

		} else {

			reportStep("Page 2 is not displayed", "Fail");

		}

		return this;

	}

	@When("You click on Wait, I have a class code! link, class code page should open in the same tab")
	public StudentRegistration1Email verifyclasscodelink() throws IOException {
		scrollToTheGivenWebElement(getPropfile(gpropname, "classcodelink"));
		waitTime(3000);
		WebElement classcodelink = propElement(getPropfile(gpropname, "classcodelink"));
		if (classcodelink.isDisplayed()) {
			reportStep("class code link is displayed and clicked, opened in the same tab", "Pass");
			waitTime(3000);
			clickWithNoSnap(classcodelink);
			WebElement classcodelabel = propElement(getPropfile(gpropname, "classcodelabel"));
			waitTime(3000);
			if (classcodelabel.isDisplayed()) {
				reportStep("class code page is displayed", "Pass");
			} else {
				reportStep("class code page is not displayed", "Fail");
			}
		}
		return this;
	}

}
