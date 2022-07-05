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

public class Icivics_HP_5HeaderMyicivicsMisc extends ProjectSpecificMethods {
	public String gpropname1 = "Homepage/homepageheader";
	public String gpropname2 = "Homepage/homepageteacherheader";
	public String gpropname3 = "Homepage/homepageheaderplay";
	public String gpropname4 = "Homepage/homepageheaderteach";
	public String gpropname5 = "Homepage/homepageheaderabout";
	public String gpropname6 = "Homepage/homepageheadersigninmisc";
	public String gpropname7 = "Homepage/homepageheadermyicivics";

	public Icivics_HP_5HeaderMyicivicsMisc(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivics URL")
	public Icivics_HP_5HeaderMyicivicsMisc launchURL(String URL) {
		navigateto(URL);
		return this;

	}

	@Then("login as a teacher")
	public Icivics_HP_5HeaderMyicivicsMisc verifylogin() {

		WebElement signinbutton = propElement(getPropfile(gpropname1, "Signinbutton"));
		signinbutton.click();
		WebElement signinlink = propElement(getPropfile(gpropname1, "Signinlink"));
		signinlink.click();
		WebElement username = propElement(getPropfile(gpropname1, "Username"));
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = propElement(getPropfile(gpropname1, "Password"));
		password.sendKeys("i898qrCiPK9Hwgb");
		WebElement loginbutton = propElement(getPropfile(gpropname2, "Loginbutton"));
		loginbutton.click();
		waitTime(3000);
		return this;
	}

	@And("Verify Donate button is display")
	public Icivics_HP_5HeaderMyicivicsMisc VerifyDonatebutton() {
		WebElement donatebutton = propElement(getPropfile(gpropname1, "Donatebutton"));
		if (donatebutton.isDisplayed()) {
			reportStep("Donatebutton is displayed", "Pass");
		} else {
			reportStep("Donatebutton is not displayed", "Fail");
		}

		return this;
	}

	@Given("Click on donate button and verify url")
	public Icivics_HP_5HeaderMyicivicsMisc VerifyDonateclick() throws IOException {
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

	@Given("Verify Shop button is display")
	public Icivics_HP_5HeaderMyicivicsMisc VerifyShopbutton() {
		WebElement Shopbutton = propElement(getPropfile(gpropname7, "Shopbutton"));
		if (Shopbutton.isDisplayed()) {
			reportStep("Shopbutton is displayed", "Pass");
		} else {
			reportStep("Shopbutton is not displayed", "Fail");
		}

		return this;
	}

	@Given("click on shop button and verify the URL")
	public Icivics_HP_5HeaderMyicivicsMisc VerifyShopbuttonclick() throws IOException {
		reportStep("Shopbutton is clicked", "Pass");
		WebElement shopbutton = propElement(getPropfile(gpropname7, "Shopbutton"));
		shopbutton.click();
		waitTime(3000);
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		reportStep("'Shopbutton is clicked'" + "redirect to corresponding page" + driver.getCurrentUrl(), "Pass");
		return this;

	}

	@And("Verify My iCivics button appears in top right for an authenticated user")
	public Icivics_HP_5HeaderMyicivicsMisc verifymyicvicsbuttonafterlogin() {

		WebElement myicivicsbutton = propElement(getPropfile(gpropname2, "Myicivicsbutton2"));
		if (myicivicsbutton.isDisplayed()) {
			reportStep("Myicivicsbutton is display after login instead of signin button", "Pass");
		} else {
			reportStep("Myicivicsbutton is not display ", "Fail");
		}

		return this;
	}

	@Given("Verify signin as a teacher with avatar")
	public Icivics_HP_5HeaderMyicivicsMisc verifywithavatar() {
		WebElement avatarimg = propElement(getPropfile(gpropname7, "Avatarimg"));
		waitTime(3000);

		String srcvalue = avatarimg.getAttribute("src");
		String srcimg = getPropfile(gpropname7, "Srcimgvalue");
		if (avatarimg.isDisplayed() && srcvalue.equalsIgnoreCase(srcimg)) {
			reportStep("Avatar image is displayed on the button", "Pass");
		} else

		{
			reportStep("Avatar is not displayed ", "Fail");
		}
		return this;
	}

	@Then("Verify signin as a teacher with no avatar")
	public Icivics_HP_5HeaderMyicivicsMisc verifywithnoavatar() {

		WebElement signinbutton = propElement(getPropfile(gpropname1, "Signinbutton"));
		signinbutton.click();
		WebElement signinlink = propElement(getPropfile(gpropname1, "Signinlink"));
		signinlink.click();
		WebElement username = propElement(getPropfile(gpropname1, "Username"));
		username.sendKeys("Village Supporter c7i0");
		WebElement password = propElement(getPropfile(gpropname1, "Password"));
		password.sendKeys("Tester@9090");
		WebElement loginbutton = propElement(getPropfile(gpropname2, "Loginbutton"));
		loginbutton.click();
		waitTime(3000);
		WebElement avatar = propElement(getPropfile(gpropname7, "Avatar"));
		String srcvalue = avatar.getAttribute("src");
		String value = getPropfile(gpropname7, "Srcvalue");
		if (avatar.isDisplayed() && srcvalue.equalsIgnoreCase(value)) {

			reportStep("My iCivics button has sillouette avatar ", "Pass");
		} else {
			reportStep("My iCivics button has no sillouette avatar", "Fail");
		}
		return this;
	}

	@And("Click on Myicivics button and verify submenu display")
	public Icivics_HP_5HeaderMyicivicsMisc verifymyicvicsbuttonsubmenu() {
		WebElement myicivicsbutton = propElement(getPropfile(gpropname2, "Myicivicsbutton"));
		if (myicivicsbutton.isDisplayed()) {
			myicivicsbutton.click();

			reportStep("myicivics button is clicked and submenu is display ", "Pass");
		} else {
			reportStep("myicivics button is not displayed ", "Fail");
		}

		return this;

	}

	@Given("Click on signin button and verify submenu list")
	public Icivics_HP_5HeaderMyicivicsMisc verifymyicivicssubmenulist() {
		WebElement myicivicsbutton = propElement(getPropfile(gpropname2, "Myicivicsbutton"));
		if (myicivicsbutton.isDisplayed()) {
			myicivicsbutton.click();

			reportStep("myicivics button is clicked and submenu is display ", "Pass");
		} else {
			reportStep("myicivics button is not displayed ", "Fail");
		}
		String locatorvalue = getPropfile(gpropname7, "Dropdownlist");
		List<WebElement> allOptions = propElement1(locatorvalue);

		System.out.println(allOptions.size());
		reportStep("myicivics submenu count is" + " " + allOptions.size(), "Pass");
		for (int i = 0; i < allOptions.size(); i++) {
			WebElement optionelement = allOptions.get(i);
			String optionsText = optionelement.getText();
			System.out.println(optionsText);
			reportStep("myicivcs submenu is " + " " + optionsText, "Pass");

		}
		return this;
	}

	@Then("Click on the submenu links of MyIcivicsbutton and verify it redirects to corresponding page")
	public Icivics_HP_5HeaderMyicivicsMisc Myicivicsbuttonelementsverification(String URL) throws IOException {
		String propname = "Homepage/myicivicsdropdown";
		String MyicivicsButton = getPropfile(propname, "MyicivicsButtonElement");
		navigateto(URL);

		// MyIcivics
		mouseOverAndClickAction(MyicivicsButton);
		Verifylinks(getprop(propname, "MyicivicsElement"), getpropstring(propname, "MyicivicsText"),
				getpropstring(propname, "MyicivicsUrL"), getpropstring(propname, "MyicivicsTitle"));
		verifyPartialText(getprop(propname, "Myicivicsheaderele"), getpropstring(propname, "Myicivicsheader"));
		System.out.println(driver.getCurrentUrl());
		// MyClasses
		mouseOverAndClickAction(MyicivicsButton);
		Verifylinks(getprop(propname, "MyclassesElement"), getpropstring(propname, "MyclassesText"),
				getpropstring(propname, "MyclassesUrL"), getpropstring(propname, "MyclassesTitle"));
		scrollToTheGivenWebElement(getPropfile(propname, "Myclassesheaderele"));
		verifyPartialText(getprop(propname, "Myclassesheaderele"), getpropstring(propname, "Myclassesheader"));
		System.out.println(driver.getCurrentUrl());
		// MyFavorites
		mouseOverAndClickAction(MyicivicsButton);
		Verifylinks(getprop(propname, "MyfavoritesElement"), getpropstring(propname, "MyfavoritesText"),
				getpropstring(propname, "MyfavoritesUrL"), getpropstring(propname, "MyfavoritesTitle"));
		scrollToTheGivenWebElement(getPropfile(propname, "Myfavoritesheaderele"));
		verifyPartialText(getprop(propname, "Myfavoritesheaderele"), getpropstring(propname, "Myfavoritesheader"));
		System.out.println(driver.getCurrentUrl());
		return this;
	}

	@Given("Verify myicivics link is underlined.")
	public Icivics_HP_5HeaderMyicivicsMisc verifyselectedmyicivicsunderlined() {

		waitTime(3000);

		WebElement myicivcslink = propElement(getPropfile(gpropname7, "Myicivicslink"));
		myicivcslink.click();
		waitTime(3000);
		WebElement myicivicsbutton = propElement(getPropfile(gpropname2, "Myicivicsbutton"));
		myicivicsbutton.click();
		waitTime(3000);
		String cssValue = propElement(getPropfile(gpropname7, "Myicivicslink")).getCssValue("text-decoration-line");
		System.out.println(cssValue);
		if (cssValue.contains("underline")) {

			reportStep("Selected page is underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}

		return this;
	}

	@Then("Verify myclasses link is underlined.")
	public Icivics_HP_5HeaderMyicivicsMisc verifyselectedmyclassesunderlined() {

		waitTime(3000);
		WebElement myclassesbutton = propElement(getPropfile(gpropname7, "Myclasslink"));
		myclassesbutton.click();
		waitTime(3000);
		WebElement myicivicsbutton = propElement(getPropfile(gpropname2, "Myicivicsbutton"));
		myicivicsbutton.click();
		waitTime(3000);
		String cssValue = propElement(getPropfile(gpropname7, "Myclasslink")).getCssValue("text-decoration-line");
		System.out.println(cssValue);
		if (cssValue.contains("underline")) {

			reportStep("Selected page is underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}
		return this;
	}

	@And("Verify myfavorite link is underlined.")
	public Icivics_HP_5HeaderMyicivicsMisc verifyselectedmyfavoritesunderlined() {

		waitTime(3000);
		WebElement myfavorites = propElement(getPropfile(gpropname7, "MyFavoriteslink"));
		myfavorites.click();
		waitTime(3000);
		WebElement myicivicsbutton = propElement(getPropfile(gpropname2, "Myicivicsbutton"));
		myicivicsbutton.click();
		waitTime(3000);
		String cssValue = propElement(getPropfile(gpropname7, "MyFavoriteslink")).getCssValue("text-decoration-line");
		System.out.println(cssValue);
		if (cssValue.contains("underline")) {

			reportStep("Selected page is underlined", "Pass");

		} else {
			reportStep("Selected page is not underlined", "Fail");
		}
		return this;
	}

	@Given("Verify Click on My Icivics button submenu is display and click again submenu is close")
	public Icivics_HP_5HeaderMyicivicsMisc Clickonmyicivicsbuttonagain() {

		WebElement myicivicsbutton = propElement(getPropfile(gpropname2, "Myicivicsbutton"));
		if (myicivicsbutton.isDisplayed()) {
			click(propElement(getPropfile(gpropname2, "Myicivicsbutton")));
			reportStep("Myicivics submenu is close on clicking again", "Pass");
		} else {
			reportStep("Myicivicssubmenu is not close", "Fail");
		}
		return this;

	}
}
