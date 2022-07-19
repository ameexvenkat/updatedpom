package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class Pg3TeacherRegistration extends ProjectSpecificMethods {
	public String gpropname1 = "Homepage/homepageheader";
	public String gpropname2 = "Homepage/homepageheader";
	public String gpropname3 = "GoogleIntegration/Page1TeacherRegistration";
	public String gpropname4 = "GoogleIntegration/Page2TeacherRegistration";
	public String gpropname5 = "GoogleIntegration/Page3TeacherRegistration";

	public Pg3TeacherRegistration(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis URL")
	public Pg3TeacherRegistration launchURL(String URL) {
		navigateto(URL);
		return this;

	}

	public Pg3TeacherRegistration Registrationpage() {
		WebElement signinwithgooglebutton = driver
				.findElement(By.xpath("//img[@src='/themes/custom/refresh/images/google_signin.png']"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = driver.findElement(By.xpath("//input[@type='email']"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher26@gedu.demo.icivics.org");

		WebElement nextbutton = driver.findElement(By.xpath("//span[text()='Next']"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = driver.findElement(By.xpath("//input[@type='password']"));

		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = driver.findElement(By.xpath("//span[text()='Next']"));
		if (nextbutton1.isDisplayed()) {
			nextbutton1.click();
			waitTime(3000);
			reportStep("Registration page display", "Pass");
		} else {
			reportStep("Registration page not display", "Fail");
		}
		waitTime(3000);
		WebElement registeraseducatorbutton = driver
				.findElement(By.xpath("//h4[text()='Register as an Educator or a Parent!']"));
		registeraseducatorbutton.click();
		waitTime(3000);

		String value = getPropfile(gpropname3, "Checkboxvalue");
		List<WebElement> chkBox = propElement1(getPropfile(gpropname3, "Checkboxlist"));
		int Size = chkBox.size();
		for (int i = 0; i < Size; i++) {
			String val = chkBox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				if (!chkBox.get(i).isSelected()) {
					chkBox.get(i).click();
					break;
				}
			}

		}
		WebElement role = propElement(getPropfile(gpropname3, "Roledropdown"));
		role.click();
		waitTime(3000);
		selectDropDownUsingText(role, "Home school teacher");

		waitTime(3000);
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Roledropdown"));
		WebElement nextbutton2 = propElement(getPropfile(gpropname3, "Nextbutton"));
		nextbutton2.click();
		waitTime(3000);
		String SchoolName = getPropfile(gpropname4, "Schoolname");

		WebElement Schoolfield = propElement(getPropfile(gpropname4, "School"));
		Schoolfield.sendKeys(SchoolName);

		WebElement Zipcodefield = propElement(getPropfile(gpropname4, "Zipcode"));
		Zipcodefield.sendKeys(getPropfile(gpropname4, "Zipcode5"));

		String Teachstatevalue = getPropfile(gpropname4, "Teachstatevalue");

		WebElement teachingstate = propElement(getPropfile(gpropname4, "Teachingstate"));
		selectDropDownUsingText(teachingstate, Teachstatevalue);
		waitTime(3000);

		click(propElement(getPropfile(gpropname3, "Nextbutton")));
		waitTime(3000);

		return this;
	}

	@Then("Verify Breadcrumb indicator shows page 3")
	public Pg3TeacherRegistration verifypagecount3() throws IOException {
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname5, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname5, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(gpropname5, "step3ele"), cssvalue, Greencolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greencolor) && Step3.equals(Greencolor)) {
			reportStep("you are currently viewing page 3 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}

		return this;
	}

	@Given("Verify all the Fields for page 3")
	public Pg3TeacherRegistration verifypage3fields() {
		WebElement Checkbox1 = propElement(getPropfile(gpropname5, "Checkbox1"));
		if (Checkbox1.isSelected()) {
			reportStep(Checkbox1.getText() + "is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement Checkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		if (Checkbox2.isSelected()) {
			reportStep(Checkbox1.getText() + "is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		scrollToTheGivenWebElement("Checkbox3");
		WebElement Checkbox3 = propElement(getPropfile(gpropname5, "Checkbox3"));
		if (Checkbox3.isSelected()) {
			reportStep(Checkbox1.getText() + "is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		return this;
	}

	@Given("Click back button and verify the result")
	public Pg3TeacherRegistration verifyclickbackbutton() {
		waitTime(3000);
		WebElement backbutton = propElement(getPropfile(gpropname5, "Backbutton"));
		if (backbutton.isDisplayed()) {
			backbutton.click();
			reportStep("On clicking back button page 2 display", "Pass");
		} else {
			reportStep(" page 2 is not display", "Fail");
		}
		waitTime(3000);

		String Teachstatevalue = getPropfile(gpropname4, "Teachstatevalue");
		String teachingstate = getPropfile(gpropname4, "Teachingstate");
		if (teachingstate.equals(teachingstate)) {
			reportStep(Teachstatevalue + "Teaching state is remembered", "Pass");
		} else {
			reportStep("Teaching state is not remembered", "Fail");
		}
		waitTime(3000);
		String SchoolName = getPropfile(gpropname4, "Schoolname");
		String Schoolfield = propElement(getPropfile(gpropname4, "School")).getAttribute("value");
		if (Schoolfield.equals(SchoolName)) {
			reportStep(SchoolName + "Schoolname is remembered", "Pass");
		} else {
			reportStep("Schoolname is not remembered", "Fail");
		}
		waitTime(3000);
		String zipcodevalue = getPropfile(gpropname4, "Zipcode5");
		String Zipcodefield = propElement(getPropfile(gpropname4, "Zipcode")).getAttribute("value");

		if (Zipcodefield.equals(zipcodevalue)) {
			reportStep(zipcodevalue + "zipcode is remembered", "Pass");
		} else {
			reportStep("zipcode is not remembered", "Fail");
		}
		return this;
	}

	@Given("Leave terms of use checkbox unchecked and verify the result")
	public Pg3TeacherRegistration verifytermsofusecheckbox() {
		return this;
	}

	@Given("Make valid selections - check terms of use, check emails, leave sync classes unchecked and verify the result")
	public Pg3TeacherRegistration verifygettingstartedpagewithemailcheck() {
		WebElement Checkbox1 = propElement(getPropfile(gpropname5, "Checkbox1"));
		if (Checkbox1.isSelected()) {
			reportStep(Checkbox1.getText()+"is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement Checkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		if (Checkbox2.isDisplayed()) {
			click(Checkbox2);
			reportStep(Checkbox2.getText()+"is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
	
		WebElement Checkbox3 = propElement(getPropfile(gpropname5, "Checkbox3"));
		scrollToTheGivenWebElement(getPropfile(gpropname5, "Checkbox3"));
		if (Checkbox3.isSelected()) {
			reportStep(Checkbox3.getText() + "is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement savebutton = propElement(getPropfile(gpropname5, "Savebutton"));
		if (savebutton.isDisplayed()) {
			savebutton.click();
			waitTime(3000);
			reportStep("Getting Started page is display", "Pass");
		} else {
			reportStep("Getting Started page is not display", "Fail");
		}

		return this;
	}
	@Then("Make valid selections - check terms of use, uncheck emails, leave sync classes unchecked and verify the result")
	public Pg3TeacherRegistration verifygettingstartedpagewithemailuncheck() {
		WebElement Checkbox1 = propElement(getPropfile(gpropname5, "Checkbox1"));
		if (Checkbox1.isSelected()) {
			click(Checkbox1);
			reportStep(Checkbox1.getText()+"is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement Checkbox2 = propElement(getPropfile(gpropname5, "Checkbox2"));
		if (Checkbox2.isDisplayed()) {
			click(Checkbox2);
			reportStep(Checkbox2.getText()+"is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
	
		WebElement Checkbox3 = propElement(getPropfile(gpropname5, "Checkbox3"));
		scrollToTheGivenWebElement(getPropfile(gpropname5, "Checkbox3"));
		if (Checkbox3.isSelected()) {
			reportStep(Checkbox3.getText() + "is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		waitTime(3000);
		WebElement savebutton = propElement(getPropfile(gpropname5, "Savebutton"));
		if (savebutton.isDisplayed()) {
			savebutton.click();
			waitTime(3000);
			reportStep("Getting Started page is display", "Pass");
		} else {
			reportStep("Getting Started page is not display", "Fail");
		}

		return this;
	}
}
