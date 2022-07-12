package icivics_pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class GoogleRegistration extends ProjectSpecificMethods {
	public String gpropname1 = "Homepage/homepageheader";

	public GoogleRegistration(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis URL")
	public GoogleRegistration launchURL(String URL) {
		navigateto(URL);
		return this;

	}

	@Then("Enter credentials not registered before and select register as an Educator or parent")
	public GoogleRegistration verifyclickregisteraseducator() {

		navigateto("https://staging.d9.icivics.org/user/login");
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
		WebElement registeraseducatorbutton = driver
				.findElement(By.xpath("//h4[text()='Register as an Educator or a Parent!']"));
		registeraseducatorbutton.click();
		WebElement header = driver.findElement(By.xpath("//h2[@class='reg-header']"));
		String headertext = header.getText();
		System.out.println(headertext);
		if (headertext.contains("Educator / Parent Registration")) {
			reportStep("Teacher registration page 1 display ", "Pass");
		} else {
			reportStep("Teacher registration page 1 not display ", "Fail");
		}
		return this;
	}
	@Given("Start Registration without being signed in with google and verify the error message")
	public GoogleRegistration verifyregistrationwithoutsignin() {
		
		WebElement errormsg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']/p"));
		String msg=errormsg.getText();
		System.out.println(msg);
		verifyText(errormsg, "Google Classroom token was not set correctly.");
		return this;
		
	}
	@Given("Start registration with already registered Id and verify the error message")
	public GoogleRegistration verifyregistrationwithalreadyregisteredID() {
		navigateto("https://staging.d9.icivics.org/user/login");
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
			waitTime(3000);
			reportStep("Registration page display", "Pass");
		} else {
			reportStep("Registration page not display", "Fail");
		}
		navigateto("https://staging.d9.icivics.org/classroom/register");
		WebElement errormsg =driver.findElement(By.xpath("//h2[@class='block-title']"));
		verifyText(errormsg, "Sorry but you do not have permission to view this page");
		return this;
	}
	@Given("Enter credentials not registered before and select register as Student")
	public GoogleRegistration verifyregisterasstudentclick() {
		navigateto("https://staging.d9.icivics.org/user/login");
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
			reportStep("Registration page display", "Pass");
		} else {
			reportStep("Registration page not display", "Fail");
		}
		WebElement registeraseducatorbutton = driver
				.findElement(By.xpath("//h4[text()='Register as a Student!']"));
		registeraseducatorbutton.click();
		return this;
	}
}
