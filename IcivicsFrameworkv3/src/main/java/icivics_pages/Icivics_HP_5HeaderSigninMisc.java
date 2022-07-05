package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_HP_5HeaderSigninMisc extends ProjectSpecificMethods {
	public String gpropname1 = "Homepage/homepageheader";
	public String gpropname2 = "Homepage/homepageteacherheader";
	public String gpropname3 = "Homepage/homepageheaderplay";
	public String gpropname4 = "Homepage/homepageheaderteach";
	public String gpropname5 = "Homepage/homepageheaderabout";
	public String gpropname6 = "Homepage/homepageheadersigninmisc";

	public Icivics_HP_5HeaderSigninMisc(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivics URL")
	public Icivics_HP_5HeaderSigninMisc launchURL(String URL) {
		navigateto(URL);
		return this;

	}

	@Then("Verify Donate button is display")
	public Icivics_HP_5HeaderSigninMisc VerifyDonatebutton() {
		WebElement donatebutton = propElement(getPropfile(gpropname1, "Donatebutton"));
		if (donatebutton.isDisplayed()) {
			reportStep("Donatebutton is displayed", "Pass");
		} else {
			reportStep("Donatebutton is not displayed", "Fail");
		}

		return this;
	}

	@Given("click on donate button and verify the URL")
	public Icivics_HP_5HeaderSigninMisc VerifyDonateclick() throws IOException {
		waitTime(3000);
		reportStep("Donatebutton is clicked ", "Pass");
		WebElement donatebutton = propElement(getPropfile(gpropname1, "Donatebutton"));
		donatebutton.click();
		waitTime(3000);
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		reportStep("'Donatebutton is clicked'" + "redirect to corresponding page" + driver.getCurrentUrl(), "Pass");
		return this;

	}

	@Given("Verify Shop button display")
	public Icivics_HP_5HeaderSigninMisc VerifyShopbutton() {
		WebElement Shopbutton = propElement(getPropfile(gpropname1, "shopbutton"));
		if (Shopbutton.isDisplayed()) {
			reportStep("Shopbutton is displayed", "Pass");
		} else {
			reportStep("Shopbutton is not displayed", "Fail");
		}

		return this;
	}

	@Given("Verify click on shop button and redirct to corresponding page")
	public Icivics_HP_5HeaderSigninMisc VerifyShopbuttonclick() throws IOException {
		reportStep("Shopbutton is clicked ", "Pass");
		WebElement shopbutton = propElement(getPropfile(gpropname6, "shopbuttonele"));
		shopbutton.click();
		waitTime(3000);
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		reportStep("'Shopbutton is clicked'" + "redirect to corresponding page" + driver.getCurrentUrl(), "Pass");
		return this;

	}

	@Given("Verify Sign in button appears in top right for an anonymous user")
	public Icivics_HP_5HeaderSigninMisc verifysigninbutton() {

		WebElement Signinbutton = propElement(getPropfile(gpropname6, "Signinbutton2"));
		if (Signinbutton.isDisplayed()) {
			Signinbutton.click();
			reportStep("Signinbutton is displayed", "Pass");

		} else {
			reportStep("Signinbutton is not displayed", "Fail");
		}
		return this;
	}

	@Given("Verify click on signin button and submenu list")
	public Icivics_HP_5HeaderSigninMisc verifysigninbuttonsubmenulist() {
		WebElement signinbutton = propElement(getPropfile(gpropname1, "Signinbutton"));
		if (signinbutton.isDisplayed()) {
			signinbutton.click();
			reportStep("signinbutton is clicked and submenu is displayed", "Pass");
		} else {
			reportStep("signinbutton is not displayed", "Fail");
		}
		String locatorvalue = getPropfile(gpropname6, "Dropdownlist");
		List<WebElement> allOptions = propElement1(locatorvalue);

		System.out.println(allOptions.size());
		reportStep("signinbutton submenu count is" + " " + allOptions.size(), "Pass");
		for (int i = 0; i < allOptions.size(); i++) {
			WebElement optionelement = allOptions.get(i);
			String optionsText = optionelement.getText();
			System.out.println(optionsText);
			reportStep("signinbutton submenu is " + " " + optionsText, "Pass");

		}
		return this;

	}

	@Given("Click on the submenu links of signinbutton  and verify it redirects to corresponding page")
	public Icivics_HP_5HeaderSigninMisc Signinbuttonelementsverification(String URL) throws IOException {
		String propname = "Homepage/signindropdown";
		String SigninButton = getPropfile(propname, "SigninButtonElement");
		navigateto(URL);

		// Signin
		mouseOverAndClickAction(SigninButton);
		Verifylinks(getprop(propname, "signinElement"), getpropstring(propname, "signinText"),
				getpropstring(propname, "signinUrL"), getpropstring(propname, "signinTitle"));
		verifyPartialText(getprop(propname, "signinheaderele"), getpropstring(propname, "signinheader"));
		System.out.println(driver.getCurrentUrl());
		// Register As a Student
		mouseOverAndClickAction(SigninButton);
		Verifylinks(getprop(propname, "stuElement"), getpropstring(propname, "stuText"),
				getpropstring(propname, "stuUrL"), getpropstring(propname, "stuTitle"));
		verifyPartialText(getprop(propname, "stuheaderele"), getpropstring(propname, "stuheader"));
		System.out.println(driver.getCurrentUrl());
		// Register As a Teacher
		mouseOverAndClickAction(SigninButton);
		Verifylinks(getprop(propname, "teaElement"), getpropstring(propname, "teaText"),
				getpropstring(propname, "teaUrL"), getpropstring(propname, "teaTitle"));
		verifyPartialText(getprop(propname, "teaheaderele"), getpropstring(propname, "teaheader"));
		System.out.println(driver.getCurrentUrl());
		return this;
	}

	@Given("Verify the signin link is underlined.")
	public Icivics_HP_5HeaderSigninMisc verifyselectedsigninunderlined() {

		waitTime(3000);
		WebElement signinlink = propElement(getPropfile(gpropname6, "Signinlink"));
		signinlink.click();
		waitTime(3000);
		WebElement signinbutton = propElement(getPropfile(gpropname6, "Signinbutton2"));
		signinbutton.click();
		waitTime(3000);
		String cssValue = propElement(getPropfile(gpropname6, "Signinlink")).getCssValue("text-decoration-line");
		System.out.println(cssValue);
		if (cssValue.contains("underline")) {

			reportStep("Selected page is underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}

		return this;
	}

	@Then("Verify register as my student link is underlined.")
	public Icivics_HP_5HeaderSigninMisc verifyselectedregasmystuunderlined() {
		waitTime(3000);
		WebElement regasmystudentlink = propElement(getPropfile(gpropname6, "Studentlink"));
		regasmystudentlink.click();
		waitTime(3000);
		WebElement signinbutton = propElement(getPropfile(gpropname6, "Signinbutton2"));
		signinbutton.click();
		waitTime(3000);
		String cssValue = propElement(getPropfile(gpropname6, "Studentlink")).getCssValue("text-decoration-line");
		System.out.println(cssValue);
		if (cssValue.contains("underline")) {

			reportStep("Selected page is underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}

		return this;
	}

	@And("Verify register as my teacherlink is underlined.")
	public Icivics_HP_5HeaderSigninMisc verifyselectedregzasmyteacherunderlined() {
		waitTime(3000);
		WebElement regasmyteacherlink = propElement(getPropfile(gpropname6, "Teacherlink"));
		regasmyteacherlink.click();
		waitTime(3000);
		WebElement signinbutton = propElement(getPropfile(gpropname6, "Signinbutton2"));
		signinbutton.click();
		waitTime(5000);
		String cssValue = propElement(getPropfile(gpropname6, "Teacherlink")).getCssValue("text-decoration-line");
		System.out.println(cssValue);
		if (cssValue.contains("underline")) {

			reportStep("Selected page is underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}

		return this;
	}

	@Given("Verify Click on signin button submenu is display and click again submenu is close")
	public Icivics_HP_5HeaderSigninMisc Clickonsigninbuttonagain() {

		WebElement signinbutton = propElement(getPropfile(gpropname1, "Signinbutton"));
		if (signinbutton.isDisplayed()) {
			click(propElement(getPropfile(gpropname1, "Signinbutton")));
			reportStep("signin submenu is close after clicking again", "Pass");
		} else {
			reportStep("Myicivicssubmenu is not display", "Fail");
		}
		return this;

	}

}
