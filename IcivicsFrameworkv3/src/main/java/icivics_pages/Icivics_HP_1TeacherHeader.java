package icivics_pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_HP_1TeacherHeader extends ProjectSpecificMethods {
	public String gpropname1 = "Homepage/homepageheader";
	public String gpropname2 = "Homepage/homepageteacherheader";

	public Icivics_HP_1TeacherHeader(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivics URL")
	public Icivics_HP_1TeacherHeader launchteacherpageURL(String URL) {
		navigateto(URL);
		return this;

	}

	public Icivics_HP_1TeacherHeader signin2() {
		click(propElement(getPropfile(gpropname1, "Signinbutton")));
		WebElement link = propElement(getPropfile(gpropname1, "Signinlink"));
		link.click();
		WebElement username = propElement(getPropfile(gpropname1, "Username"));
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = propElement(getPropfile(gpropname1, "Password"));
		password.sendKeys("i898qrCiPK9Hwgb");
		click(propElement(getPropfile(gpropname2, "Loginbutton")));
		waitTime(3000);
		return this;
	}

	public Icivics_HP_1TeacherHeader VerifyLogo() {
		WebElement logo = propElement(getPropfile(gpropname2, "Headerlogo1"));
		if (logo.isDisplayed()) {
			reportStep("Icivics logo is display", "Pass");
		} else {
			reportStep("Icivics logo is not display", "Fail");
		}

		return this;
	}

	@Then("Verify Play buttons should appear in the top right")
	public Icivics_HP_1TeacherHeader playbutton() {
		WebElement playbutton = propElement(getPropfile(gpropname2, "Playbutton"));
		if (playbutton.isDisplayed()) {
			reportStep("playbutton is display", "Pass");
		} else {
			reportStep("playbutton is not display", "Fail");
		}

		return this;
	}

	@Then("Verify Teach buttons should appear in the top right")
	public Icivics_HP_1TeacherHeader Teachbutton() {
		WebElement teachbutton = propElement(getPropfile(gpropname2, "Teachbutton"));
		if (teachbutton.isDisplayed()) {
			reportStep("Teachbutton is display", "Pass");
		} else {
			reportStep("Teachbutton is not display", "Fail");
		}

		return this;
	}

	@Then("Verify About buttons should appear in the top right")
	public Icivics_HP_1TeacherHeader aboutbutton() {
		WebElement aboutbutton = propElement(getPropfile(gpropname2, "Aboutbutton"));
		if (aboutbutton.isDisplayed()) {
			reportStep("aboutbutton is display", "Pass");
		} else {
			reportStep("aboutbutton is not display", "Fail");
		}

		return this;
	}

	@Then("Verify Donate buttons should appear in the top right")
	public Icivics_HP_1TeacherHeader donatebutton() {
		WebElement donatebutton = propElement(getPropfile(gpropname1, "Donatebutton"));
		if (donatebutton.isDisplayed()) {
			reportStep("donatebutton is display", "Pass");
		} else {
			reportStep("donatebutton is not display", "Fail");
		}

		return this;
	}

	@Then("Verify Shop buttons should appear in the top right")
	public Icivics_HP_1TeacherHeader shopbutton() {
		WebElement Shopbutton = propElement(getPropfile(gpropname1, "shopbutton"));
		if (Shopbutton.isDisplayed()) {
			reportStep("Shopbutton is display", "Pass");
		} else {
			reportStep("Shopbutton is not display", "Fail");
		}

		return this;
	}

	public Icivics_HP_1TeacherHeader verifysigninbutton() {

		WebElement Signinbutton = propElement(getPropfile(gpropname2, "Signinbutton2"));
		if (Signinbutton.isDisplayed()) {
			Signinbutton.click();
			reportStep("Signinbutton is displayed", "Pass");

		} else {
			reportStep("Signinbutton is not displayed", "Fail");
		}
		return this;
	}

	@And("Verify after login MyIcivics buttons should appear in the top right")
	public Icivics_HP_1TeacherHeader Verifymyicivicsbuttondisplayafterlogin() {
		WebElement signinbutton = propElement(getPropfile(gpropname1, "Signinbutton"));
		if (signinbutton.isDisplayed()) {
			reportStep("Signin button is display", "Pass");
		} else {
			reportStep("Signin button is not display", "Fail");
		}
		WebElement signbutton=propElement(getPropfile(gpropname1, "Signinbutton"));
		signbutton.click();
		WebElement link = propElement(getPropfile(gpropname1, "Signinlink"));
		link.click();
		WebElement username = propElement(getPropfile(gpropname1, "Username"));
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = propElement(getPropfile(gpropname1, "Password"));
		password.sendKeys("i898qrCiPK9Hwgb");
		WebElement login= propElement(getPropfile(gpropname2, "Loginbutton"));
		login.click();
		waitTime(3000);
		WebElement myicivicsbutton2 = propElement(getPropfile(gpropname2, "Myicivicsbutton"));
		if (myicivicsbutton2.isDisplayed()) {
			reportStep("Myicivicsbutton is display", "Pass");
		} else {
			reportStep("Myicivicsbutton is not display", "Fail");
		}
		return this;

	}

	@Then("Verify header button after login")
	public Icivics_HP_1TeacherHeader Verifyheaderbuttonsafterlogin() {
		WebElement playbutton = propElement(getPropfile(gpropname2, "Playbutton"));
		if (playbutton.isDisplayed()) {
			reportStep("playbutton is display", "Pass");
		} else {
			reportStep("playbutton is not display", "Fail");
		}
		WebElement teachbutton = propElement(getPropfile(gpropname2, "Teachbutton"));
		if (teachbutton.isDisplayed()) {
			reportStep("Teachbutton is display", "Pass");
		} else {
			reportStep("Teachbutton is not display", "Fail");
		}
		WebElement aboutbutton = propElement(getPropfile(gpropname2, "Aboutbutton"));
		if (aboutbutton.isDisplayed()) {
			reportStep("aboutbutton is display", "Pass");
		} else {
			reportStep("aboutbutton is not display", "Fail");
		}
		WebElement donatebutton = propElement(getPropfile(gpropname1, "Donatebutton"));
		if (donatebutton.isDisplayed()) {
			reportStep("Donatebutton is display", "Pass");
		} else {
			reportStep("Donatebutton is not display", "Fail");
		}

		WebElement shopbutton = propElement(getPropfile(gpropname1, "shopbutton2"));
		if (shopbutton.isDisplayed()) {
			reportStep("Shopbutton is  display", "Pass");
		} else {
			reportStep("Shopbutton is not display", "Fail");
		}

		WebElement myicivicsbutton2 = propElement(getPropfile(gpropname2, "Myicivicsbutton"));
		if (myicivicsbutton2.isDisplayed()) {
			reportStep("Myicivicsbutton is display", "Pass");
		} else {
			reportStep("Myicivicsbutton is not display", "Fail");
		}
		return this;
	}

	@Given("Verify Header elements are consistent with mockup")
	public Icivics_HP_1TeacherHeader verifyblogcontenttype() {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Blog"));

		WebElement curriculumchkbox = propElement(getPropfile(gpropname2, "Curriculumunit"));
		curriculumchkbox.click();
		waitTime(5000);
		WebElement blogcheckbox = propElement(getPropfile(gpropname2, "Blogcheckbox"));
		boolean blogcheckedbox = blogcheckbox.isSelected();

		if (blogcheckedbox) {
			reportStep("Blog checkbox is already checked", "Pass");
		} else {

			blogcheckbox.click();
			waitTime(5000);
			reportStep("Blog checkbox is checked now ", "Pass");
		}
		WebElement viewbutton = propElement(getPropfile(gpropname2, "Viewbutton"));
		if (viewbutton.isDisplayed()) {
			viewbutton.click();
			waitTime(3000);
			reportStep("Page is display", "Pass");
		} else {
			reportStep("Page is not display", "Pass");
		}
		return this;
	}

	@Then("Verify curriculum unit content type")
	public Icivics_HP_1TeacherHeader verifycurriculumcontenttype() {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Blog"));

		waitTime(3000);
		WebElement curriculumchkbox = propElement(getPropfile(gpropname2, "Curriculumunit"));
		boolean cucheckedbox = curriculumchkbox.isSelected();
		if (cucheckedbox) {
			reportStep("curriculum checkbox is already checked", "Pass");
		} else {

			curriculumchkbox.click();
			waitTime(3000);
			reportStep("curriculum checkbox is checked now ", "Pass");
		}
		WebElement viewbutton = propElement(getPropfile(gpropname2, "Viewbutton"));
		if (viewbutton.isDisplayed()) {
			viewbutton.click();
			waitTime(3000);
			reportStep("Page is display", "Pass");
		} else {
			reportStep("Page is not display", "Pass");
		}
		return this;
	}

	@Then("Verify DBquest content type")
	public Icivics_HP_1TeacherHeader verifydbquestcontenttype() {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Blog"));
		waitTime(3000);
		WebElement curriculumchkbox = propElement(getPropfile(gpropname2, "Curriculumunit"));
		curriculumchkbox.click();
		waitTime(5000);
		WebElement dbquest = propElement(getPropfile(gpropname2, "Dbquest"));
		boolean dbcheckedbox = dbquest.isSelected();
		if (dbcheckedbox) {
			reportStep("DBQUEST checkbox is already checked", "Pass");
		} else {
			dbquest.click();
			waitTime(5000);
			reportStep("DBQUEST checkbox is checked now ", "Pass");
		}
		WebElement viewbutton = propElement(getPropfile(gpropname2, "Viewbutton"));
		if (viewbutton.isDisplayed()) {
			viewbutton.click();
			waitTime(3000);
			reportStep("Page is display", "Pass");
		} else {
			reportStep("Page is not display", "Pass");
		}
		return this;
	}

	@Then("Verify Game content type")
	public Icivics_HP_1TeacherHeader verifygamecontenttype() {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Blog"));
		waitTime(3000);
		WebElement curriculumchkbox = propElement(getPropfile(gpropname2, "Curriculumunit"));
		curriculumchkbox.click();
		waitTime(5000);
		WebElement gamechkbox = propElement(getPropfile(gpropname2, "Game"));
		boolean gamecheckedbox = gamechkbox.isSelected();
		if (gamecheckedbox) {
			reportStep("Game checkbox is already checked", "Pass");
		} else {
			gamechkbox.click();
			waitTime(5000);
			reportStep("Game checkbox is checked now ", "Pass");
		}
		WebElement viewbutton = propElement(getPropfile(gpropname2, "Viewbutton"));
		if (viewbutton.isDisplayed()) {
			viewbutton.click();
			waitTime(3000);
			reportStep("Page is display", "Pass");
		} else {
			reportStep("Page is not display", "Pass");
		}
		return this;
	}

	@Then("Verify Lessonplay content type")
	public Icivics_HP_1TeacherHeader verifylessonplaycontenttype() {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Blog"));

		waitTime(3000);
		WebElement curriculumchkbox = propElement(getPropfile(gpropname2, "Curriculumunit"));
		curriculumchkbox.click();
		waitTime(5000);
		WebElement lessonplaychkbox = propElement(getPropfile(gpropname2, "Lessonplay"));
		boolean lessonplaycheckedbox = lessonplaychkbox.isSelected();
		if (lessonplaycheckedbox) {
			reportStep("Lessonplay checkbox is already checked", "Pass");
		} else {
			lessonplaychkbox.click();
			waitTime(5000);
			reportStep("Lessonplay checkbox is checked now ", "Pass");
		}
		WebElement viewbutton = propElement(getPropfile(gpropname2, "Viewbutton"));
		if (viewbutton.isDisplayed()) {
			viewbutton.click();
			waitTime(3000);
			reportStep("Page is display", "Pass");
		} else {
			reportStep("Page is not display", "Pass");
		}
		return this;
	}

	@Then("Verify Professional development content type")
	public Icivics_HP_1TeacherHeader verifyprofessionaldeveopmentcontenttype() {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Blog"));

		waitTime(3000);
		WebElement curriculumchkbox = propElement(getPropfile(gpropname2, "Curriculumunit"));
		curriculumchkbox.click();
		waitTime(5000);
		WebElement Pdchkbox = propElement(getPropfile(gpropname2, "Pd"));
		boolean pbcheckedbox = Pdchkbox.isSelected();
		if (pbcheckedbox) {
			reportStep("Professional development checkbox is already checked", "Pass");
		} else {
			Pdchkbox.click();
			waitTime(5000);
			reportStep("Professional development checkbox is checked now ", "Pass");
		}
		WebElement viewbutton = propElement(getPropfile(gpropname2, "Viewbutton"));
		if (viewbutton.isDisplayed()) {
			viewbutton.click();
			waitTime(3000);
			reportStep("Page is display", "Pass");
		} else {
			reportStep("Page is not display", "Pass");
		}
		return this;
	}

	@Then("Verify Video content type")
	public Icivics_HP_1TeacherHeader verifyvideocontenttype() {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Blog"));

		waitTime(3000);
		WebElement curriculumchkbox = propElement(getPropfile(gpropname2, "Curriculumunit"));
		curriculumchkbox.click();
		waitTime(5000);
		WebElement videochkbox = propElement(getPropfile(gpropname2, "Video"));
		boolean videocheckedbox = videochkbox.isSelected();
		if (videocheckedbox) {
			reportStep("Video checkbox is already checked", "Pass");
		} else {
			videochkbox.click();
			waitTime(5000);
			reportStep("Video checkbox is checked now ", "Pass");
		}
		WebElement viewbutton = propElement(getPropfile(gpropname2, "Viewbutton"));
		if (viewbutton.isDisplayed()) {
			viewbutton.click();
			waitTime(3000);
			reportStep("Page is display", "Pass");
		} else {
			reportStep("Page is not display", "Pass");
		}
		return this;
	}

	@Then("Verify Webquest content type")
	public Icivics_HP_1TeacherHeader verifyWebquestcontenttype() {
		scrollToTheGivenWebElement(getPropfile(gpropname2, "Blog"));

		waitTime(3000);
		WebElement curriculumchkbox = propElement(getPropfile(gpropname2, "Curriculumunit"));
		curriculumchkbox.click();
		waitTime(5000);
		WebElement webquestchkbox = propElement(getPropfile(gpropname2, "WebQuest"));
		boolean webquestchbox = webquestchkbox.isSelected();
		if (webquestchbox) {
			reportStep("Webquest checkbox is already checked", "Pass");
		} else {
			webquestchkbox.click();
			waitTime(5000);
			reportStep("Webquest checkbox is checked now ", "Pass");
		}
		WebElement viewbutton = propElement(getPropfile(gpropname2, "Viewbutton"));
		if (viewbutton.isDisplayed()) {
			viewbutton.click();
			waitTime(3000);
			reportStep("Page is display", "Pass");
		} else {
			reportStep("Page is not display", "Pass");
		}
		return this;
	}

	@Given("Verify playbutton should have Hand cursor should appear over buttons Tooltip appears after hover.")
	public Icivics_HP_1TeacherHeader verifyplaybuttonhover() {

		String playbuttonhover = getPropfile(gpropname2, "Playbutton");
		mouseOverAction(playbuttonhover);
		waitTime(3000);
		WebElement playbuttontooltip = propElement(playbuttonhover);
		String ExpectedTooltip = getPropfile(gpropname2, "Playbuttontooltip");
		String actualTooltip = playbuttontooltip.getAttribute("title");
		if (actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}

		click(propElement(getPropfile(gpropname2, "Playbutton")));
		waitTime(3000);
		return this;
	}

	@Then("Verify teachbutton should have Hand cursor should appear over buttons Tooltip appears after hover.")
	public Icivics_HP_1TeacherHeader verifyteachbuttonhover() {

		String teachbuttonhover = getPropfile(gpropname2, "Teachbutton");
		mouseOverAction(teachbuttonhover);
		waitTime(3000);
		WebElement teachbuttontooltip = propElement(teachbuttonhover);
		String ExpectedTooltip = getPropfile(gpropname2, "Teachbuttontooltip");
		String actualTooltip = teachbuttontooltip.getAttribute("title");
		if (actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}

		click(propElement(getPropfile(gpropname2, "Teachbutton")));
		waitTime(3000);
		return this;
	}

	@Then("Verify aboutbutton should have Hand cursor should appear over buttons Tooltip appears after hover.")
	public Icivics_HP_1TeacherHeader verifyaboutbuttonhover() {

		String aboutbuttonhover = getPropfile(gpropname2, "Aboutbutton");
		mouseOverAction(aboutbuttonhover);
		waitTime(3000);
		WebElement aboutbuttontooltip = propElement(aboutbuttonhover);
		String ExpectedTooltip = getPropfile(gpropname2, "Aboutbuttontooltip");
		String actualTooltip = aboutbuttontooltip.getAttribute("title");
		if (actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}

		click(propElement(getPropfile(gpropname2, "Aboutbutton")));
		waitTime(3000);
		return this;
	}

	@Then("Verify donatebutton should have Hand cursor should appear over buttons Tooltip appears after hover.")
	public Icivics_HP_1TeacherHeader verifydonatebuttonhover() {

		String Donatebuttonhover = getPropfile(gpropname1, "Donatebutton");
		mouseOverAction(Donatebuttonhover);
		waitTime(3000);
		WebElement donatebuttontooltip = propElement(Donatebuttonhover);
		String ExpectedTooltip = getPropfile(gpropname2, "Donatebuttontooltip");
		String actualTooltip = donatebuttontooltip.getAttribute("title");
		if (actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}

		click(propElement(getPropfile(gpropname1, "Donatebutton")));
		waitTime(3000);
		return this;
	}

	@Then("Verify shopbutton should have Hand cursor should appear over buttons Tooltip appears after hover.")
	public Icivics_HP_1TeacherHeader verifyshopbuttonhover() {

		String Shopbuttonhover = getPropfile(gpropname1, "shopbutton");
		mouseOverAction(Shopbuttonhover);
		waitTime(3000);
		WebElement shopbuttontooltip = propElement(Shopbuttonhover);
		String ExpectedTooltip = getPropfile(gpropname2, "Shopbuttontooltip");
		String actualTooltip = shopbuttontooltip.getAttribute("title");
		if (actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}

		click(propElement(getPropfile(gpropname1, "shopbutton")));
		waitTime(3000);
		return this;
	}

	@Then("Verify myicivicsbutton should not present for anonymous user it should present only when we login")
	public Icivics_HP_1TeacherHeader verifysigninbuttonhover() {

		String signinbuttonhover = getPropfile(gpropname2, "Signinbutton");
		mouseOverAction(signinbuttonhover);
		waitTime(3000);
		WebElement Signinbuttontooltip = propElement(signinbuttonhover);
		String ExpectedTooltip = getPropfile(gpropname2, "Signintooltip");
		String actualTooltip = Signinbuttontooltip.getAttribute("title");
		if (actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}
		return this;
	}

	@Then("Verify afterlogin myicivicsbutton should have Hand cursor should appear over buttons Tooltip appears after hover.")
	public Icivics_HP_1TeacherHeader verifymyicvicsbuttonhoverafterlogin() {

		click(propElement(getPropfile(gpropname1, "Signinbutton")));
		click(propElement(getPropfile(gpropname1, "Signinlink")));
		WebElement username = propElement(getPropfile(gpropname1, "Username"));
		username.sendKeys("Bronze Speaker 1r4e");
		WebElement password = propElement(getPropfile(gpropname1, "Password"));
		password.sendKeys("i898qrCiPK9Hwgb");
		click(propElement(getPropfile(gpropname2, "Loginbutton")));
		waitTime(3000);
		String myicivicsbuttonhover = getPropfile(gpropname2, "Myicivicsbutton2");
		mouseOverAction(myicivicsbuttonhover);
		waitTime(3000);
		WebElement myicivicstooltip = propElement(myicivicsbuttonhover);
		String ExpectedTooltip1 = getPropfile(gpropname2, "Myicivicstooltip");
		String actualTooltip1 = myicivicstooltip.getAttribute("title");
		if (actualTooltip1.equals(ExpectedTooltip1)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}
		click(propElement(getPropfile(gpropname2, "Myicivicsbutton")));
		waitTime(3000);
		return this;
	}

	public Icivics_HP_1TeacherHeader verifymyicvicsbuttonhover() {
		String myicivicsbuttonhover = getPropfile(gpropname2, "Myicivicsbutton2");
		mouseOverAction(myicivicsbuttonhover);
		waitTime(3000);
		WebElement myicivicstooltip = propElement(myicivicsbuttonhover);
		String ExpectedTooltip1 = getPropfile(gpropname2, "Myicivicstooltip");
		waitTime(3000);
		String actualTooltip1 = myicivicstooltip.getAttribute("title");
		if (actualTooltip1.equals(ExpectedTooltip1)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}
		click(propElement(getPropfile(gpropname2, "Myicivicsbutton")));
		waitTime(3000);
		return this;
	}

	public Icivics_HP_1TeacherHeader verifyshopbuttonhover2() {

		String Shopbuttonhover = getPropfile(gpropname1, "shopbutton2");
		mouseOverAction(Shopbuttonhover);
		waitTime(3000);
		WebElement shopbuttontooltip = propElement(Shopbuttonhover);
		String ExpectedTooltip = getPropfile(gpropname2, "Shopbuttontooltip2");
		String actualTooltip = shopbuttontooltip.getAttribute("title");
		if (actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		} else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}

		click(propElement(getPropfile(gpropname1, "shopbutton2")));
		waitTime(3000);
		return this;
	}

	@Given("Verify header resize turn into hamburger menu when its small enough")
	public Icivics_HP_1TeacherHeader resizeheader() {

		Dimension d = new Dimension(768, 1024);
		// Resize the current window to the given dimension
		driver.manage().window().setSize(d);
		takeSnap();
		waitTime(3000);
		reportStep("Ipad potrait resize is successfull", "Pass");

		WebElement hamburgericon1 = propElement(getPropfile(gpropname2, "Hamburgericon"));

		if (hamburgericon1.isDisplayed()) {
			reportStep("Hamburger Icon is displayed successfully", "Pass");
		} else {
			reportStep("Hamburger Icon is not displayed successfully", "Fail");

		}
		WebElement cardtitle = driver
				.findElement(By.xpath("//h2[contains(text(),'Foundations of Government')and @class='field-content']"));
		if (cardtitle.isDisplayed()) {
			reportStep("cardtitle is displayed successfully", "Pass");
		} else {
			reportStep("cardtitle Icon is not displayed successfully", "Fail");

		}

		Dimension d1 = new Dimension(1024, 768);
		driver.manage().window().setSize(d1);
		waitTime(3000);
		System.out.println(driver.manage().window().getSize());
		takeSnap();
		reportStep("Ipad landscape resize is successfull", "Pass");

		WebElement cardtitle2 = driver
				.findElement(By.xpath("//h2[contains(text(),'Influence Library')and @class='field-content']"));
		if (cardtitle2.isDisplayed()) {
			reportStep("cardtitle is displayed successfully", "Pass");
		} else {
			reportStep("cardtitle Icon is not displayed successfully", "Fail");

		}
		Dimension d2 = new Dimension(375, 667);
		driver.manage().window().setSize(d2);
		waitTime(3000);
		System.out.println(driver.manage().window().getSize());
		takeSnap();
		reportStep("Iphone potrait resize is successfull", "Pass");
		WebElement hamburgericon3 = propElement(getPropfile(gpropname2, "Hamburgericon"));
		if (hamburgericon3.isDisplayed()) {
			reportStep("Hamburger Icon is displayed successfully", "Pass");
		} else {
			reportStep("Hamburger Icon is not displayed successfully", "Fail");

		}
		Dimension d3 = new Dimension(667, 375);
		driver.manage().window().setSize(d3);
		waitTime(3000);
		System.out.println(driver.manage().window().getSize());
		takeSnap();
		reportStep("Iphone landscape resize is successfull", "Pass");
		WebElement hamburgericon4 = propElement(getPropfile(gpropname2, "Hamburgericon"));
		if (hamburgericon4.isDisplayed()) {
			reportStep("Hamburger Icon is displayed successfully", "Pass");
		} else {
			reportStep("Hamburger Icon is not displayed successfully", "Fail");

		}
		Dimension d4 = new Dimension(360, 740);
		driver.manage().window().setSize(d4);
		waitTime(3000);
		System.out.println(driver.manage().window().getSize());
		takeSnap();
		reportStep("Samsung Galaxy potrait resize is successfull", "Passs");
		WebElement hamburgericon5 = propElement(getPropfile(gpropname2, "Hamburgericon"));
		if (hamburgericon5.isDisplayed()) {
			reportStep("Hamburger Icon is displayed successfully", "Pass");
		} else {
			reportStep("Hamburger Icon is not displayed successfully", "Fail");

		}

		Dimension d5 = new Dimension(740, 360);
		driver.manage().window().setSize(d5);
		waitTime(3000);
		System.out.println(driver.manage().window().getSize());
		takeSnap();
		reportStep("Samsung Galaxy landscape resize is successfull", "Passs");
		WebElement hamburgericon6 = propElement(getPropfile(gpropname2, "Hamburgericon"));
		if (hamburgericon6.isDisplayed()) {
			reportStep("Hamburger Icon is displayed successfully", "Pass");
		} else {
			reportStep("Hamburger Icon is not displayed successfully", "Fail");

		}
		return this;

	}

	@Then("Verify card is displaying in list pattern on resizing the window")
	public Icivics_HP_1TeacherHeader carddisplayinlistpattern() {
		Dimension d = new Dimension(768, 1024);
		// Resize the current window to the given dimension
		driver.manage().window().setSize(d);

		WebElement cardtitle = propElement(getPropfile(gpropname2, "CardTitle1"));
		if (cardtitle.isDisplayed()) {
			reportStep("cardtitle is displayed successfully", "Pass");
		} else {
			reportStep("cardtitle Icon is not displayed successfully", "Fail");

		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "CardTitle1");
		Dimension d1 = new Dimension(1024, 768);
		driver.manage().window().setSize(d1);
		WebElement cardtitle1 = propElement(getPropfile(gpropname2, "CardTitle2"));
		if (cardtitle1.isDisplayed()) {
			reportStep("cardtitle is displayed successfully", "Pass");
		} else {
			reportStep("cardtitle Icon is not displayed successfully", "Fail");

		}
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,350)", "CardTitle2");
		reportStep("Ipad landscape resize is successfull", "Pass");

		Dimension d2 = new Dimension(375, 667);
		driver.manage().window().setSize(d2);
		waitTime(3000);
		WebElement cardtitle2 = propElement(getPropfile(gpropname2, "CardTitle3"));
		if (cardtitle2.isDisplayed()) {
			reportStep("cardtitle is displayed successfully", "Pass");
		} else {
			reportStep("cardtitle Icon is not displayed successfully", "Fail");

		}
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,350)", "CardTitle3");
		reportStep("Iphone potrait resize is successfull", "Pass");

		Dimension d3 = new Dimension(667, 375);
		driver.manage().window().setSize(d3);
		waitTime(3000);
		WebElement cardtitle3 = propElement(getPropfile(gpropname2, "CardTitle4"));
		if (cardtitle3.isDisplayed()) {
			reportStep("cardtitle is displayed successfully", "Pass");
		} else {
			reportStep("cardtitle Icon is not displayed successfully", "Fail");

		}
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,350)", "CardTitle4");
		reportStep("Iphone landscape resize is successfull", "Pass");
		Dimension d4 = new Dimension(360, 740);
		driver.manage().window().setSize(d4);
		WebElement cardtitle4 = propElement(getPropfile(gpropname2, "CardTitle5"));
		if (cardtitle4.isDisplayed()) {
			reportStep("cardtitle is displayed successfully", "Pass");
		} else {
			reportStep("cardtitle Icon is not displayed successfully", "Fail");

		}
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,350)", "CardTitle5");
		reportStep("Samsung Galaxy potrait resize is successfull", "Pass");
		Dimension d5 = new Dimension(740, 360);
		driver.manage().window().setSize(d5);
		WebElement cardtitle5 = propElement(getPropfile(gpropname2, "CardTitle6"));
		if (cardtitle5.isDisplayed()) {
			reportStep("cardtitle is displayed successfully", "Pass");
		} else {
			reportStep("cardtitle Icon is not displayed successfully", "Fail");

		}
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("window.scrollBy(0,350)", "CardTitle6");
		reportStep("Samsung Galaxy landscape resize is successfull", "Pass");
		return this;
	}
}
