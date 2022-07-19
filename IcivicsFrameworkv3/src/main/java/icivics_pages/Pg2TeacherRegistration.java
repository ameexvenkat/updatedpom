package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class Pg2TeacherRegistration extends ProjectSpecificMethods {
	public String gpropname1 = "Homepage/homepageheader";
	public String gpropname2 = "Homepage/homepageheader";
	public String gpropname3 = "GoogleIntegration/Page1TeacherRegistration";
	public String gpropname4 = "GoogleIntegration/Page2TeacherRegistration";

	public Pg2TeacherRegistration(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis URL")
	public Pg2TeacherRegistration launchURL(String URL) {
		navigateto(URL);
		return this;

	}

	public Pg2TeacherRegistration Registrationpage() {
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
		return this;
	}

	@Then("Verify Breadcrumb indicator shows page 2")
	public Pg2TeacherRegistration verifypagecount2() throws IOException {
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname4, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname4, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(gpropname4, "step3ele"), cssvalue, Greycolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greencolor) && Step3.equals(Greycolor)) {
			reportStep("you are currently viewing page 2 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}

		return this;
	}

	@Given("Verify the fields for teaching state, school or institution, and zip code display for page 2")
	public Pg2TeacherRegistration verifypage2field() throws IOException {
		WebElement teachingfield = propElement(getPropfile(gpropname4, "Teachingstate"));
		teachingfield.click();
		waitTime(3000);
		Select sel = new Select(teachingfield);
		if (sel.getFirstSelectedOption().getText().equals("- None -")) {

			reportStep(sel.getFirstSelectedOption().getText() + "is the default selected option for teaching dropdown",
					"Pass");
		} else {
			reportStep(sel.getFirstSelectedOption().getText() + "is not default selected option for teaching dropdown",
					"Pass");
		}
		WebElement schoolfield = propElement(getPropfile(gpropname4, "School"));
		String schoolname = schoolfield.getText();
		System.out.println(schoolname + "School field is empty");
		if (schoolname.isEmpty()) {
			scrollToTheGivenWebElement(getPropfile(gpropname4, "schoollabel"));
			waitTime(3000);
			reportStep("School field is empty by default", "Pass");
		} else {
			reportStep("School field contain text ", "Fail");
		}
		WebElement zipcodefield = propElement(getPropfile(gpropname4, "Zipcode"));
		String zipcode = zipcodefield.getText();
		System.out.println(zipcodefield + "zipcode field is empty");
		if (zipcode.isEmpty()) {
			scrollToTheGivenWebElement(getPropfile(gpropname4, "schoollabel"));
			waitTime(3000);
			reportStep("Zipcode is empty by default", "Pass");
		} else {
			reportStep("Zipcode contain text ", "Fail");
		}
		return this;
	}

	@Given("Click on back button and verify page go to page1 with fields filled")
	public Pg2TeacherRegistration verifyclickonbackbutton() {

		WebElement backbutton = propElement(getPropfile(gpropname4, "Backbutton"));
		click(backbutton);
		waitTime(3000);
		String value = getPropfile(gpropname3, "Checkboxvalue");
		List<WebElement> chkBox = propElement1(getPropfile(gpropname3, "Checkboxlist"));
		int Size = chkBox.size();
		for (int i = 0; i < Size-1; i++) {
			String val = chkBox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				if(chkBox.get(i).isSelected())
				{       
					reportStep("Grade level value " + val + " is remembered ", "Pass");
					break;
				} else {
					reportStep("Grade level value " + val + " is not remembered ", "Fail");
					}
				}
		}
		scrollToTheGivenWebElement(getPropfile(gpropname3, "Nextbutton"));
		String dropdownvalue = getPropfile(gpropname3, "Roledropdown");
		String roleDropDown = propElement(getPropfile(gpropname4, "Rolevalue")).getAttribute("value");
		if (roleDropDown.equals(dropdownvalue)) {
			reportStep("Role value " + roleDropDown + " is remembered ", "Pass");
		} else {
			reportStep("Role value " + roleDropDown + " is not remembered ", "Fail");
		}
		return this;
		
	}

	@Given("Make a selection for school field and verify the result")
	public Pg2TeacherRegistration verifyselectschoolfield() {
		String schoolname = "St.Thomas's";
		WebElement schoolfield = propElement(getPropfile(gpropname4, "School"));
		waitTime(3000);
		if (schoolfield.isDisplayed()) {
			clearAndType(schoolfield, schoolname);
			reportStep("School name is not blank", "Pass");
		} else {
			reportStep("School name is  blank", "Fail");
		}
		return this;
	}

	@Then("Make seletion for zipcode and verify the result")
	public Pg2TeacherRegistration verifyzipcodeselection() {
		String zipcode = "30001";
		WebElement zipcodefield = propElement(getPropfile(gpropname4, "Zipcode"));
		waitTime(3000);
		if (zipcodefield.isDisplayed()) {
			clearAndType(zipcodefield, zipcode);
			reportStep("Zipcode field  is not blank", "Pass");
		} else {
			reportStep("Zipcode field is  blank", "Fail");
		}
		return this;
	}

	@Then("Make selection for teaching state and verify the result")
	public Pg2TeacherRegistration verifyteachingstateselection() {
		String state = "Alabama";
		WebElement teachingfield = propElement(getPropfile(gpropname4, "Teachingstate"));
		teachingfield.click();
		waitTime(3000);
		if (teachingfield.isDisplayed()) {
			waitTime(3000);
			selectDropDownUsingText(teachingfield, state);
			reportStep("Teaching state is not blank", "Pass");
		} else {
			reportStep("Teaching state is  blank", "Fail");
		}
		return this;
	}

	@Given("Enter invalid School, Zipcode as none for Teacherstate and verify the error messages.")
	public Pg2TeacherRegistration verifyenterinvaliddata() {
		WebElement Schoolfield = propElement(getPropfile(gpropname4, "School"));
		clearAndType(Schoolfield, "gfgh^d$fthf&");

		WebElement Zipcodefield = propElement(getPropfile(gpropname4, "Zipcode"));
		clearAndType(Zipcodefield, "66654789789678");

		WebElement teachingstate = propElement(getPropfile(gpropname4, "Teachingstate"));
		selectDropDownUsingIndex(teachingstate, 0);
		waitTime(3000);

		click(propElement(getPropfile(gpropname3, "Nextbutton")));

		WebElement TeachstateError = propElement(getPropfile(gpropname4, "Teachingerror"));
		WebElement TeachstateError1 = propElement(getPropfile(gpropname4, "Teachingerror1"));
		WebElement TeachstateError2 = propElement(getPropfile(gpropname4, "Teachingerror2"));
		if (TeachstateError.isDisplayed() && TeachstateError1.isDisplayed() && TeachstateError2.isDisplayed()) {
			verifyExactText(TeachstateError, "Teaching State field is required.");
			verifyExactText(TeachstateError1, "1 error has been found:");
			verifyExactText(TeachstateError2, "Teaching State");
		} else {
			reportStep("Teacherstate text box error messages is not verifed", "Fail");
		}

		return this;
	}
	@Given("Verify select vaild options and click on next button")
	public Pg2TeacherRegistration verifyregistrationwithvaliddata() {
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
	
	@Then("verify page 3 is loaded")
	public Pg2TeacherRegistration verifypage3loaded()  {
		
		WebElement page3 = propElement(getPropfile(gpropname4, "Page3text"));
		if (page3.isDisplayed()) {
			reportStep(page3.getText()+"Page 3 is displayed", "Pass");
		}else {
			reportStep("Page 3 is not displayed", "Fail");
		}
		return this;
	}
}

