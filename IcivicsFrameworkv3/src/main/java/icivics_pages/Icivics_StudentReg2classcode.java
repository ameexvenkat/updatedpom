package icivics_pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_StudentReg2classcode extends ProjectSpecificMethods {
	public String gpropname1 = "StudentRegistration/studentregistration1Email";
	public String gpropname2 = "StudentRegistration/studentregistration1classcode";
	public String gpropname3 = "StudentRegistration/studentregistration2Email";
	public String gpropname4 = "StudentRegistration/studentregistration2classcode";

	public Icivics_StudentReg2classcode(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis Studentregistration email URL")
	public Icivics_StudentReg2classcode launchstudentURL(String URL) {
		navigateto(URL);
		return this;
	}

	public Icivics_StudentReg2classcode verifyregistrationwithvaliddata() throws InterruptedException, IOException {
		WebElement link = propElement(getPropfile(gpropname2, "Link"));
		link.click();

		WebElement classcode = propElement(getPropfile(gpropname2, "classcode"));
		classcode.clear();
		classcode.sendKeys(getPropfile(gpropname2, "ClassCode"));

		WebElement username = propElement(getPropfile(gpropname2, "username"));
		String username1 = username.getText();
		writePropfile("EducatorRegistration/username", "username", username1);

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

		return this;
	}

	@Then("Verify Breadcrumb indicator is on page 2")
	public Icivics_StudentReg2classcode verifypagecount2() throws IOException {

		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname1, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname1, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(gpropname1, "step3ele"), cssvalue, Greycolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greencolor) && Step3.equals(Greycolor)) {
			reportStep("you are currently viewing page 2 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}
		return this;
	}

	public Icivics_StudentReg2classcode Clickbackbutton() throws InterruptedException, IOException {
		WebElement backbutton = propElement(getPropfile(gpropname3, "backbutton"));
		backbutton.click();
		return this;
	}

	@Given("Verify clicking on back button will take to previous page 1")

	public Icivics_StudentReg2classcode verifyClickbackbutton() throws InterruptedException, IOException {
		WebElement backbutton = propElement(getPropfile(gpropname3, "backbutton"));
		backbutton.click();
		waitTime(3000);
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname1, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname1, "step2ele"), cssvalue, Greycolor);
		String Step3 = cssgetbefore(getPropfile(gpropname1, "step3ele"), cssvalue, Greycolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greycolor) && Step3.equals(Greycolor)) {
			reportStep("Back button is clicked page Goes back to page 1", "Pass");
		} else {
			reportStep("Back button is not clicked ", "Fail");
		}
		return this;
	}

	@Given("Verify classcode is remembered.")
	public Icivics_StudentReg2classcode verifyclasscoderemembered() throws IOException {

		String classcodevalue = propElement(getPropfile(gpropname2, "classcode")).getAttribute("value");
		if (classcodevalue.equals(getPropfile(gpropname2, "ClassCode"))) {
			reportStep("Classcode value " + classcodevalue + " is remembered ", "Pass");
		} else {
			reportStep("Classcode value " + classcodevalue + " is not remembered ", "Fail");
		}
		return this;
	}

	@And("Verify Username is regenerated.")
	public Icivics_StudentReg2classcode verifyusernameisnotremembered() throws IOException {

		WebElement username = propElement(getPropfile(gpropname1, "username"));
		String username2 = username.getText();
		String username1 = getPropfile("StudentRegistration/username", "username");
		if (!username1.equals(username2)) {
			reportStep("Username is regenerated " + username1 + " & " + username2 + " are not same", "Pass");
		} else {
			reportStep("Username is not regenerated" + username1 + " & " + username2 + " are same", "Fail");
		}
		return this;
	}

	@And("Verify firstname is remembered.")
	public Icivics_StudentReg2classcode verifyfirstnameremembered() throws IOException {

		String firstnamevalue = propElement(getPropfile(gpropname2, "firstname")).getAttribute("value");
		if (firstnamevalue.equals(getPropfile(gpropname2, "FirstName"))) {
			reportStep("Firstname value " + firstnamevalue + " is remembered ", "Pass");
		} else {
			reportStep("Firstname value " + firstnamevalue + " is not remembered ", "Fail");
		}
		return this;
	}

	@And("Verify lastname is remembered.")
	public Icivics_StudentReg2classcode verifylastnameremembered() {
		String lastnamevalue = propElement(getPropfile(gpropname2, "Lastname")).getAttribute("value");
		if (lastnamevalue.equals(getPropfile(gpropname2, "LastName"))) {
			reportStep("lastname value " + lastnamevalue + " is remembered ", "Pass");
		} else {
			reportStep("lastname value " + lastnamevalue + " is not remembered ", "Fail");
		}
		return this;
	}

	@And("Verify email is remembered.")
	public Icivics_StudentReg2classcode verifyemailremembered() {
		scrollToTheGivenWebElement(getPropfile(gpropname1, "Emailaddresslabel"));
		String email = propElement(getPropfile(gpropname2, "Emailaddress")).getAttribute("value");
		if (email.equals(getPropfile("StudentRegistration/email3", "email3"))) {
			reportStep("email value " + email + " is remembered ", "Pass");
		} else {
			reportStep("email value " + email + " is not remembered ", "Fail");
		}
		return this;
	}

	@And("Verifyemail is remembered.")
	public Icivics_StudentReg2classcode verifyemailfieldremembered() {
		scrollToTheGivenWebElement(getPropfile(gpropname1, "Emailaddresslabel"));
		String verifyemail = propElement(getPropfile(gpropname2, "VerifyEmailaddress")).getAttribute("value");
		if (verifyemail.equals(getPropfile("StudentRegistration/email3", "email3"))) {
			reportStep("verify email value " + verifyemail + " is remembered ", "Pass");
		} else {
			reportStep("verify email value " + verifyemail + " is not remembered ", "Fail");
		}

		return this;
	}

	@Given("Verify Terms of use page opens in new tab")
	public Icivics_StudentReg2classcode clickontermsofuselink() throws IOException {
		waitTime(5000);
		WebElement termsofuselink = propElement(getPropfile(gpropname3, "termsofuselink"));
		if (termsofuselink.isDisplayed()) {
			click(propElement(getPropfile(gpropname3, "termsofuselink")));
			waitTime(3000);
			switchToWindow(getPropfile(gpropname3, "termsofusetitle"));
			waitTime(3000);
			System.out.println(driver.getTitle());
			reportStep("verify new Tab " + driver.getTitle() + " is open successfully", "Pass");
			switchToWindow("User Profile | iCivics");
			waitTime(3000);
			reportStep("Page is switched back to default content", "Pass");
			System.out.println(driver.getTitle());
		} else {
			reportStep("verify new Tab " + driver.getTitle() + " is not open ", "Fail");
		}

		return this;

	}

	@Given("Verify Privacy policy page opens in new tab")
	public Icivics_StudentReg2classcode clickprivacypolicy() {
		WebElement privacypolicylink = propElement(getPropfile(gpropname3, "privacypolicylink"));
		if (privacypolicylink.isDisplayed()) {
			click(propElement(getPropfile(gpropname3, "privacypolicylink")));
			waitTime(3000);
			switchToWindow(getPropfile(gpropname3, "privacypolicytitle"));
			System.out.println(driver.getTitle());
			reportStep("verify new Tab " + driver.getTitle() + " is open successfully", "Pass");
			switchToWindow("User Profile | iCivics");
			waitTime(3000);
			reportStep("Page is switched back to default content", "Pass");
			System.out.println(driver.getTitle());
		} else {
			reportStep("verify new Tab " + driver.getTitle() + " is not open ", "Fail");
		}

		return this;

	}

	@Given("Verify No email subscription checkbox appears")

	public Icivics_StudentReg2classcode verifypage2noemailsubscriptioncheckbox() {
		scrollToTheGivenWebElement(getPropfile(gpropname3, "finishbutton"));
		WebElement AgreetotermsCheckbox = propElement(getPropfile(gpropname3, "Agreetotermschkbox"));
		if (AgreetotermsCheckbox.isDisplayed()) {
			click(propElement(getPropfile(gpropname3, "Agreetotermschkbox")));
			reportStep("Email subscription checkbox is not display", "Pass");
		} else {
			reportStep("Email subscription checkbox is display", "Fail");
		}
		return this;
	}

	@Given("Verify Hover over password field")
	public Icivics_StudentReg2classcode hoveronpwdfield() throws InterruptedException {
		String pwd = getPropfile(gpropname3, "password");
		mouseOverAction(pwd);
		waitTime(3000);
		WebElement pwdtooltip = propElement(pwd);
		String ExpectedTooltip = getPropfile(gpropname3, "PasswordHovertext");
		String actualTooltip = pwdtooltip.getAttribute("data-original-title");
		if (actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}
		return this;
	}

	@Given("Verify Indicator for strength should change according to pwd strength")
	public Icivics_StudentReg2classcode VerifyPasswordstrengthmeter() {
		String pwd = getPropfile(gpropname3, "Passwordvalueweak");

		WebElement password = propElement(getPropfile(gpropname3, "password1"));
		password.clear();
		password.sendKeys(pwd);
		waitTime(3000);
		WebElement passwordstrength = propElement(getPropfile(gpropname3, "passwordstrength"));
		String passwordstrengthtext = passwordstrength.getText();
		if (passwordstrengthtext.equals("Weak") || passwordstrengthtext.equals("Strong")
				|| passwordstrengthtext.equals("Fair") || passwordstrengthtext.equals("Good")) {
			reportStep("Password strength Indicator is changing as " + passwordstrengthtext
					+ " according to password strength", "Pass");
		} else {
			reportStep("Password strength Indicator is not changing according to password strength", "Fail");
		}

		WebElement passwordstrengthmeter = propElement(getPropfile(gpropname3, "passwordstrengthmeter"));
		String passwordstrengthmetertext = passwordstrengthmeter.getAttribute("style");
		if (!passwordstrengthmetertext.equals("width: 0%;")) {
			reportStep("Password strength meter is changing as " + passwordstrengthmetertext
					+ " according to password strength", "Pass");
		} else {
			reportStep("Password strength meter is not changing according to password strength", "Fail");
		}

		return this;
	}

	@Given("Verify Password match indicator says yes or no depending on match with the confirm Password")
	public Icivics_StudentReg2classcode VerifyPasswordindicatormatch() {
		String pwd = getPropfile(gpropname3, "Passwordvalue");

		WebElement password = propElement(getPropfile(gpropname3, "password1"));
		password.clear();
		password.sendKeys(pwd);
		waitTime(3000);

		WebElement confirmpassword = propElement(getPropfile(gpropname3, "confirmpassword1"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		waitTime(3000);
		WebElement passwordmatchstatus = propElement(getPropfile(gpropname3, "passwordmatchstatus"));
		String getpwdmatchtext = passwordmatchstatus.getText();
		if (getpwdmatchtext.equals("yes")) {
			reportStep("Password and Confirm password is matching and yes is displayed", "Pass");
		} else {
			reportStep("Password and Confirm password is not matching and no is displayed", "Fail");
		}
		scrollToTheGivenWebElement(getPropfile(gpropname3, "backbutton"));
		confirmpassword.clear();
		confirmpassword.sendKeys("Test@123");
		String getpwdnomatchtext = passwordmatchstatus.getText();
		if (getpwdnomatchtext.equals("no")) {
			reportStep("Password and Confirm password is not matching and no is displayed", "Pass");
		} else {
			reportStep("Password and Confirm password is matching and yes is displayed", "Fail");
		}

		return this;
	}

	@Given("Click on next without entering any valid data and verify the error messages.")
	public Icivics_StudentReg2classcode verifyblankerrormsgforpwdandcpwd() {
		scrollToTheGivenWebElement(getPropfile(gpropname3, "finishbutton"));
		String pwd = "gfgh^d$fthf&";
		WebElement password = propElement(getPropfile(gpropname3, "password1"));

		click(propElement(getPropfile(gpropname3, "finishbutton")));
		reportStep("Error msg Is displayed for password field", "Pass");
		waitTime(3000);
		clearAndType(password, pwd);
		click(propElement(getPropfile(gpropname3, "finishbutton")));
		reportStep("Error msg Is displayed for confirm password field", "Pass");
		waitTime(3000);
		return this;
	}

	@Then("Verify Error message is in pink box at the top")
	public Icivics_StudentReg2classcode verifyenterinvaliddataerror() {

		String pwd = "gfgh^d$fthf&";
		String cpwd = "gfgh^d$fthf&123";
		WebElement password = propElement(getPropfile(gpropname3, "password1"));
		clearAndType(password, pwd);

		WebElement confirmpassword = propElement(getPropfile(gpropname3, "confirmpassword1"));
		clearAndType(confirmpassword, cpwd);

		WebElement agreechkbox1 = propElement(getPropfile(gpropname3, "agreechkbox"));

		if (agreechkbox1.isSelected()) {
			agreechkbox1.click();
			reportStep("Accept terms is unchecked", "Pass");
		}

		WebElement finishbutton = propElement(getPropfile(gpropname3, "finishbutton"));
		finishbutton.click();
		String expectedcolor = "rgba(169, 68, 66, 1)";
		String expectedbgcolor = "rgba(242, 222, 222, 1)";
		WebElement Errormsgbox = propElement(getPropfile(gpropname3, "Errormsgbox"));
		String color = Errormsgbox.getCssValue("color");
		String bckgclr = Errormsgbox.getCssValue("background-color");
		if (color.contains(expectedcolor) && bckgclr.contains(expectedbgcolor)) {
			reportStep("Error msg box Is displayed in Pink Color and text in Red on the top", "Pass");
		} else {
			reportStep("Error msg box Is not displayed in Pink Color", "Fail");
		}
		return this;
	}

	@Given("Verify on Leaving terms of use and privacy checkbox unckecked Errors is displayed in red")
	public Icivics_StudentReg2classcode verifytermsofuseandprivacycheckbox() {
		String pwd = "Test@1234";
		String cpwd = "Test@1234";
		WebElement password = propElement(getPropfile(gpropname3, "password1"));
		password.clear();
		password.sendKeys(pwd);

		WebElement confirmpassword = propElement(getPropfile(gpropname3, "confirmpassword1"));
		confirmpassword.clear();
		confirmpassword.sendKeys(cpwd);
		WebElement agreechkbox1 = propElement(getPropfile(gpropname3, "agreechkbox"));

		if (agreechkbox1.isSelected()) {
			agreechkbox1.click();
			reportStep("Accept terms is unchecked", "Pass");
		}

		WebElement finishbutton = propElement(getPropfile(gpropname3, "finishbutton"));
		finishbutton.click();
		WebElement agreeerror = propElement(getPropfile(gpropname3, "agreeerror"));
		WebElement errormsgbox = propElement(getPropfile(gpropname3, "Errormsgbox1"));
		WebElement errormsg = propElement(getPropfile(gpropname3, "Errormsg1"));
		WebElement errormsg1 = propElement(getPropfile(gpropname3, "Errormsg2"));
		WebElement errormsg2 = propElement(getPropfile(gpropname3, "Errormsg3"));
		if (errormsgbox.isDisplayed() && agreeerror.isDisplayed() && errormsg.isDisplayed() && errormsg1.isDisplayed()
				&& errormsg2.isDisplayed()) {
			verifyExactText(errormsgbox, "1 error has been found:");
			verifyExactText(errormsg, "I agree to the");
			verifyExactText(errormsg1, "Terms of Use");
			verifyExactText(errormsg2, "Privacy Policy");
			scrollToTheGivenWebElement(getPropfile(gpropname3, "backbutton"));
			verifyPartialText(agreeerror, "Please agree to the terms of service and privacy policy.");
		}
		String expectedcolor = "rgba(169, 68, 66, 1)";
		String expectedbgcolor = "rgba(242, 222, 222, 1)";

		WebElement Agreeerror = propElement(getPropfile(gpropname3, "agreeerror"));
		String color = Agreeerror.getCssValue("color");
		String bckgclr = Agreeerror.getCssValue("background-color");
		if (color.contains(expectedcolor) && bckgclr.contains(expectedbgcolor)) {
			reportStep("Agreeerror box Is displayed in Pink Color and text in Red", "Pass");
		} else {
			reportStep("Agreeerror box Is not displayed in Pink Color", "Fail");
		}
		return this;
	}

	@Given("Verify Leave password or confirm password blank check error messages")
	public Icivics_StudentReg2classcode verifyblankerrormsg() {
		scrollToTheGivenWebElement(getPropfile(gpropname3, "finishbutton"));
		String pwd = "gfgh^d$fthf&";
		WebElement password = propElement(getPropfile(gpropname3, "password1"));

		WebElement finishbutton = propElement(getPropfile(gpropname3, "finishbutton"));
		finishbutton.click();
		reportStep("Error msg Is displayed for password field", "Pass");
		waitTime(3000);
		clearAndType(password, pwd);
		waitTime(3000);

		WebElement finishbutton1 = propElement(getPropfile(gpropname3, "finishbutton"));
		finishbutton1.click();
		reportStep("Error msg Is displayed for confirm password field", "Pass");

		return this;
	}

	@Given("Verify Fill out required fields, passwords match, terms of use is checked")
	public Icivics_StudentReg2classcode verifypage3loaded() throws InterruptedException, IOException {

		String pwd = "Test@12345";
		String cpwd = "Test@12345";
		WebElement password = propElement(getPropfile(gpropname3, "password1"));
		clearAndType(password, pwd);

		WebElement confirmpassword = propElement(getPropfile(gpropname3, "confirmpassword1"));
		clearAndType(confirmpassword, cpwd);

		click(propElement(getPropfile(gpropname3, "agreechkbox")));
		waitTime(3000);

		WebElement finishbutton = propElement(getPropfile(gpropname3, "finishbutton"));
		finishbutton.click();
		waitTime(5000);

		WebElement page2 = propElement(getPropfile(gpropname3, "welcomemsg"));
		if (page2.isDisplayed()) {
			reportStep("Page 3 is displayed", "Pass");
		} else {
			reportStep("Page 3 is not displayed", "Fail");
		}
		return this;
	}
}
