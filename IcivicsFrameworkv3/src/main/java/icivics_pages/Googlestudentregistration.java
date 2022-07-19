package icivics_pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class Googlestudentregistration extends ProjectSpecificMethods {
	public String gpropname1 = "Homepage/homepageheader";

	public Googlestudentregistration(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis URL")
	public Googlestudentregistration launchURL(String URL) {
		navigateto(URL);
		return this;

	}

	public Googlestudentregistration verifyregisterasstudent() {

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
		WebElement studentasregisterbutton = driver.findElement(By.xpath("//div/h4[text()='Register as a Student!']"));
		studentasregisterbutton.click();
		waitTime(3000);
		return this;
	}

	@Then("Verify field for agree to terms of use privacy policy")
	public Googlestudentregistration verifyagreetotermsfield() {
		WebElement agreetoterrms = driver.findElement(By.xpath("//label[@class='control-label option']/input"));
		if (agreetoterrms.isDisplayed()) {
			reportStep(agreetoterrms.getText() + "field is present", "Pass");
		} else {
			reportStep(agreetoterrms.getText() + " field is not present", "Fail");
		}
		if (agreetoterrms.isSelected()) {
			reportStep(agreetoterrms.getText() + "field is checked", "Pass");
		} else {
			reportStep(agreetoterrms.getText() + "field is not checked by default", "Fail");
		}
		WebElement finishbutton = driver.findElement(By.xpath("//button[@id='edit-submit']"));
		if (finishbutton.isDisplayed()) {
			reportStep("Finish button is present", "Pass");
		} else {
			reportStep("Finish button is not present", "Fail");
		}
		return this;
	}

	@Given("Leave agree to terms of use checkbox unchecked and click finish and verify the result")
	public Googlestudentregistration verifyerrormsg() {
		WebElement agreetoterrms = driver.findElement(By.xpath("//label[@class='control-label option']/input"));
		WebElement finishbutton = driver.findElement(By.xpath("//button[@id='edit-submit']"));
		finishbutton.click();
		waitTime(3000);
		WebElement errormsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']/p"));
		WebElement errormsg1 = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']/descendant::li"));
		WebElement errormsg2 = driver
				.findElement(By.xpath("//div[@class='form-item--error-message alert alert-danger alert-sm']"));
		if (errormsg.isDisplayed() && errormsg1.isDisplayed() && errormsg2.isDisplayed()) {
			waitTime(3000);
			verifyPartialText(errormsg, "1 error has been found:");
			reportStep(errormsg.getText() + "is verified", "Pass");
			verifyPartialText(errormsg1, "I agree to the");
			reportStep(errormsg1.getText() + "is verified", "Pass");
			verifyPartialText(errormsg2, "You must agree with Terms of Use and Privacy Policy to register!");
			reportStep(errormsg2.getText() + "is verified", "Pass");
		} else {
			reportStep("Errormsg is not present", "Fail");
		}

		return this;
	}

	@Given("Verify Check box for agree to terms of use and click finish")
	public Googlestudentregistration verifysubmit() {
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
			reportStep("Student registration is done ", "Pass");
		} else {
			reportStep("Student registration is not done ", "Fail");
		}

		return this;
	}

}
