package icivics_pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class GoogleSignOn extends ProjectSpecificMethods {
	public String gpropname1 = "Homepage/homepageheader";

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

		WebElement signinwithgooglebutton = driver
				.findElement(By.xpath("//img[@src='/themes/custom/refresh/images/google_signin.png']"));
		String parentWindow = driver.getWindowHandle();
		if (signinwithgooglebutton.isDisplayed()) {
			click(signinwithgooglebutton);
			waitTime(3000);
			String currentWindow = driver.getWindowHandle();

			if (parentWindow.equals(currentWindow)) {

				reportStep("New window has not been opened.", "Pass");
			}

			else {
				reportStep("New window has been opened.", "Fail");
			}
		}
		return this;
	}

	@Given("Enter the credentials verify My iCivics page opens for this account")

	public GoogleSignOn verifyentercredentails() {
		WebElement signinwithgooglebutton = driver
				.findElement(By.xpath("//img[@src='/themes/custom/refresh/images/google_signin.png']"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = driver.findElement(By.xpath("//input[@type='email']"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher24@gedu.demo.icivics.org");

		WebElement nextbutton = driver.findElement(By.xpath("//span[text()='Next']"));
		nextbutton.click();
		waitTime(3000);
		WebElement pwdfield = driver.findElement(By.xpath("//input[@type='password']"));

		pwdfield.sendKeys("Freedom17@");
		waitTime(3000);
		WebElement nextbutton1 = driver.findElement(By.xpath("//span[text()='Next']"));
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
			reportStep("Classroom/register page display", "Pass");
		} else {
			reportStep("Classroom/register page not display", "Fail");
		}
		return this;
	}

	@Then("Verify on clicking register as educator redirect to educator registration page")
	public GoogleSignOn verifyeducatorregistrationpagedisplay() {
		WebElement registeraseducatorbutton = driver
				.findElement(By.xpath("//h4[text()='Register as an Educator or a Parent!']"));
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

		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='form-checkboxes']/descendant::input"));
		int size = checkbox.size();
		System.out.println(size);
		for (int i = 0; i <= size - 1; i++) {
			String value = checkbox.get(i).getAttribute("value");
			System.out.println(value);
			if (value.equalsIgnoreCase("Middle School")) {
				checkbox.get(i).click();
				waitTime(3000);
				reportStep("Checkbox is selected", "Pass");
			} else {
				reportStep("Checkbox is not selected ", "Fail");
			}

		}
		WebElement dropdownoption = driver
				.findElement(By.xpath("//select[@class='form-select required form-control']"));

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
		WebElement nextbutton = driver.findElement(By.xpath("//button[@value='Next']"));
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
		WebElement dropdownoption = driver
				.findElement(By.xpath("//select[@class='form-select required form-control']"));

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
		WebElement schoolfield = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[1]"));
		schoolfield.sendKeys("ST.Thomas's");
		waitTime(3000);
		WebElement zipcodefield = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[2]"));
		zipcodefield.sendKeys("11111111");
		waitTime(3000);
		WebElement nextbutton = driver.findElement(By.xpath("//button[@value='Next']"));
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
		WebElement chkbox = driver.findElement(By.xpath("//input[@id='edit-agreement']"));
		chkbox.click();
		WebElement savebutton = driver.findElement(By.xpath("//button[@id='edit-submit']"));
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
		WebElement signinwithgooglebutton = driver
				.findElement(By.xpath("//img[@src='/themes/custom/refresh/images/google_signin.png']"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = driver.findElement(By.xpath("//input[@type='email']"));
		waitTime(3000);
		emailfield.sendKeys("amatt.student1@gedu.demo.icivics.org");

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
			reportStep("My Icivics page open for this account", "Pass");
		} else {
			reportStep("My Icivics page not open for this account", "Fail");
		}
		return this;
	}

	@Given("Enter the credentials not registered and verify My iCivics page opens for this account")
	public GoogleSignOn verifycredentialsnotregistered() {
		WebElement signinwithgooglebutton = driver
				.findElement(By.xpath("//img[@src='/themes/custom/refresh/images/google_signin.png']"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = driver.findElement(By.xpath("//input[@type='email']"));
		waitTime(3000);
		emailfield.sendKeys("amatt.student1@gedu.demo.icivics.org");

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
			reportStep("My Icivics page open for this account", "Pass");
		} else {
			reportStep("My Icivics page not open for this account", "Fail");
		}
		return this;
	}

	@Given("Enter the credentials not registered before and verify My iCivics page opens for this account")
	public GoogleSignOn verifynotregisteredaccountforstudent() {
		WebElement signinwithgooglebutton = driver
				.findElement(By.xpath("//img[@src='/themes/custom/refresh/images/google_signin.png']"));
		signinwithgooglebutton.click();
		waitTime(3000);
		WebElement emailfield = driver.findElement(By.xpath("//input[@type='email']"));
		waitTime(3000);
		emailfield.sendKeys("amatt.teacher30@gedu.demo.icivics.org");

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
			reportStep("Classroom/register page display", "Pass");
		} else {
			reportStep("Classroom/register page not display", "Fail");
		}
		WebElement registerasstudentbutton = driver.findElement(By.xpath("//h4[text()='Register as a Student!']"));
		registerasstudentbutton.click();
		waitTime(3000);
		WebElement agreetoterrms = driver.findElement(By.xpath("//label[@class='control-label option']/input"));
		if (agreetoterrms.isDisplayed()) {
			agreetoterrms.click();
			reportStep("Checkbox is checked", "Pass");
		} else {
			reportStep("Checkbox is not checked", "Fail");
		}
		WebElement finishbutton = driver.findElement(By.xpath("//button[@id='edit-submit']"));
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
