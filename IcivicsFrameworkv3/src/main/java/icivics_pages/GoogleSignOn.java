package icivics_pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class GoogleSignOn extends ProjectSpecificMethods {
	public String gpropname1 = "GoogleIntegration/GoogleSignOn";

	public GoogleSignOn(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivics URL")
	public GoogleSignOn launchURL(String URL) {
		navigateto(URL);
		return this;

	}

	@And("Verify Dialog opens in same window with Google accounts that are available")
	public GoogleSignOn verifygoogleaccount() {

		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		String parentWindow = driver.getWindowHandle();

		if (signinwithgooglebutton.isDisplayed()) {
			click(signinwithgooglebutton);
			waitTime(3000);
			String currentWindow = driver.getWindowHandle();

			if (parentWindow.equals(currentWindow)) {

				reportStep("Dialog opens in same window", "Pass");
			}

			else {
				reportStep("New window has been opened.", "Fail");
			}
		}
		return this;
	}

	@Given("Enter the credentials verify My iCivics page opens for this account")

	public GoogleSignOn verifyentercredentails() {
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));

		click(signinwithgooglebutton);
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
			waitTime(5000);
			reportStep("My Icivics page open for this account", "Pass");
		} else {
			reportStep("My Icivics page not open for this account", "Fail");
		}

		return this;
	}

	@Given("Enter the credentials verify register page open")
	public GoogleSignOn verifyentercredentails2() {
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));

		click(signinwithgooglebutton);
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
			reportStep("Classroom/register page display", "Pass");
		} else {
			reportStep("Classroom/register page not display", "Fail");
		}
		return this;
	}

	@Then("Verify on clicking register as educator redirect to educator registration page")
	public GoogleSignOn verifyeducatorregistrationpagedisplay() {
		WebElement registeraseducatorbutton = propElement(getPropfile(gpropname1, "RegisterasEducator"));
		if (registeraseducatorbutton.isDisplayed()) {
			registeraseducatorbutton.click();
			reportStep("Educator registration page display", "Pass");
		} else {
			reportStep("Educator registration page not display", "Pass");

		}
		return this;
	}

	@Then("Enter the fields with valid data for first page and verify the result")
	public GoogleSignOn verifyenterfieldwithvaliddataforpage1() {
		String value = getPropfile(gpropname1, "Checkboxvalue");
		List<WebElement> checkbox = propElement1(getPropfile(gpropname1, "Checkboxlist"));
		int Size = checkbox.size();

		for (int i = 0; i < Size; i++) {
			String val = checkbox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				waitTime(3000);
				if (!checkbox.get(i).isSelected()) {
					waitTime(3000);
					checkbox.get(i).click();
					reportStep(val + " is selected", "Pass");
					break;
				}
			}
			
				else {
					reportStep(val + " is not selected", "Pass");
				}
			}

		
		WebElement dropdownoption = propElement(getPropfile(gpropname1, "Roledropdown"));

		System.out.println(dropdownoption.getText());
		waitTime(3000);
		Select sel = new Select(dropdownoption);
		if (dropdownoption.isEnabled()) {
			sel.selectByVisibleText("Teacher");
			waitTime(3000);
			reportStep("Teacher Option is selected from dropdown", "Pass");
		} else {

			reportStep("Option is not selected from dropdown", "Fail");
		}
		List<WebElement> alloptions = sel.getOptions();
		System.out.println(alloptions.size());
		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton1"));
		waitTime(3000);
		if (nextbutton.isDisplayed()) {
			nextbutton.click();
			waitTime(5000);
			reportStep("Page2 is display", "Pass");
		} else {
			reportStep("Page2 is not display", "Pass");
		}

		return this;
	}

	@Then("Enter the fields with valid data for second page and verify the result")
	public GoogleSignOn verifyenterfieldwithvaliddataforpage2() {
		WebElement dropdownoption = propElement(getPropfile(gpropname1, "Roledropdown"));
		waitTime(3000);
		Select sel = new Select(dropdownoption);
		if (dropdownoption.isEnabled()) {
			sel.selectByVisibleText("Alabama");
			waitTime(3000);
			reportStep("Alabama Option is selected from dropdown", "Pass");
		} else {

			reportStep("Option is not selected from dropdown", "Fail");
		}
		List<WebElement> alloptions = sel.getOptions();
		System.out.println(alloptions.size());
		String Schoolvalue="St.Thomas's";
		WebElement schoolfield = propElement(getPropfile(gpropname1, "School"));
		clearAndType(schoolfield, Schoolvalue);
		waitTime(3000);
		String  zipcodevalue="111111111";
		WebElement zipcodefield = propElement(getPropfile(gpropname1, "Zipcode"));
		clearAndType(zipcodefield, zipcodevalue);
		waitTime(3000);
		WebElement nextbutton = propElement(getPropfile(gpropname1, "Nextbutton1"));
		if (nextbutton.isDisplayed()) {
			nextbutton.click();
			waitTime(5000);
			reportStep("Page3 is display", "Pass");
		} else {
			reportStep("Page3 is not display", "Pass");
		}
		return this;
	}

	@Then("Enter the fields with valid data for third page and verify the result")
	public GoogleSignOn verifyenterfieldwithvaliddataforpage3() {
		WebElement chkbox = propElement(getPropfile(gpropname1, "Agreetotermschkbox"));
		chkbox.click();
		WebElement savebutton = propElement(getPropfile(gpropname1, "Savebutton"));
		if (savebutton.isDisplayed()) {
			savebutton.click();
			waitTime(3000);
			reportStep("Registration is complete for this account and getting started page is display", "Pass");
		} else {
			reportStep("Registration is not complete for this account", "Fail");
		}
		return this;
	}

	@Given("Enter the credentials as a student verify My iCivics page opens for this account")
	public GoogleSignOn verifyentercredentailsasStudent() {
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));

		click(signinwithgooglebutton);
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.student1@gedu.demo.icivics.org");

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
			reportStep("My Icivics page open for this account", "Pass");
		} else {
			reportStep("My Icivics page not open for this account", "Fail");
		}
		return this;
	}

	@Given("Enter the credentials not registered and verify My iCivics page opens for this account")
	public GoogleSignOn verifycredentialsnotregistered() {
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		click(signinwithgooglebutton);
		waitTime(3000);
		WebElement emailfield = propElement(getPropfile(gpropname1, "Email"));
		waitTime(3000);
		emailfield.sendKeys("amatt.student1@gedu.demo.icivics.org");

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
			reportStep("My Icivics page open for this account", "Pass");
		} else {
			reportStep("My Icivics page not open for this account", "Fail");
		}
		return this;
	}

	@Given("Enter the credentials not registered before and verify My iCivics page opens for this account")
	public GoogleSignOn verifynotregisteredaccountforstudent() {
		WebElement signinwithgooglebutton = propElement(getPropfile(gpropname1, "Signinwithgooglebutton"));
		click(signinwithgooglebutton);
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
			reportStep("Classroom/register page display", "Pass");
		} else {
			reportStep("Classroom/register page not display", "Fail");
		}
		WebElement registerasstudentbutton = propElement(getPropfile(gpropname1, "RegisterasStudent"));
		click(registerasstudentbutton);
		waitTime(3000);
		WebElement agreetoterrms = propElement(getPropfile(gpropname1, "Studentagreetoterms"));
		if (agreetoterrms.isDisplayed()) {
			agreetoterrms.click();
			reportStep("Checkbox is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		WebElement finishbutton = propElement(getPropfile(gpropname1, "Finishbutton"));
		if (finishbutton.isDisplayed()) {
			finishbutton.click();
			waitTime(3000);
			reportStep("Gettingstarted page opens", "Pass");
		} else {
			reportStep("Gettingstarted page do not opens", "Fail");
		}

		return this;

	}
}
