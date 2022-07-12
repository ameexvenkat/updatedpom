package icivics_pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

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

		if (signinwithgooglebutton.isDisplayed()) {
			signinwithgooglebutton.click();
			waitTime(3000);
			switchToWindow("Sign in – Google accounts");
			System.out.println(driver.getTitle());
			String window = driver.getTitle();
			reportStep("Google sign in page is displayed -" + driver.getTitle(), "Pass");
			switchToWindow("User Profile | iCivics");
			if (window.contains("Sign in – Google accounts")) {

				reportStep("Google signin Page open in the same tab", "Pass");
				driver.navigate().back();
				reportStep("Page is displaying the default content after clicking back button in same tab", "Pass");
				System.out.println(driver.getTitle());

			} else {
				reportStep("Page is displaying  in new tab", "Fail");
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

		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='form-checkboxes']/div"));
		int size = checkbox.size();
		for (int i = 0; i < size; i++) {
			String value = checkbox.get(i).getAttribute("value");

			if (value.equalsIgnoreCase("Middle School")) {
				checkbox.get(i).click();
				waitTime(3000);
				reportStep("Checkbox is selected", "Pass");
			} else {
				reportStep("Checkbox is not selected ", "Fail");
			}
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
}
