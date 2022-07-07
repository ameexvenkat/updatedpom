package icivics_testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import icivics_pages.EducatorRegistration1;
import projectSpecific.base.ProjectSpecificMethods;

public class I11_EducatorRegistration1_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page1";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C327 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C327_verifybreadcrumbspage1(String URL) throws IOException, InterruptedException {
		node = test.createNode("C327 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop).launchURL(URL).verifypagecount1();
	}

	// C328 - Do you see fields for Username, First Name, Last Name, E-mail address, and Verify email address?
	@Test(dataProvider = "fetchData", priority = 1)
	public void C328_verifytextfields(String URL) throws IOException, InterruptedException {
		node = test.createNode("C328 - Do you see fields for Username, First Name, Last Name, E-mail address, and Verify email address?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop).launchURL(URL).Verifyusernametextfields()
				.Verifyfirstnamenametextfields().Verifylastnametextfields().Verifyemailtextfields()
				.Verifyemail2textfields();
	}

	// C329 - Is a username pre-generated when you arrive on the page?
	@Test(dataProvider = "fetchData", priority = 2)
	public void C329_verifyusernamepregenerated(String URL) throws IOException, InterruptedException {
		node = test.createNode("C329 - Is a username pre-generated when you arrive on the page?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop).launchURL(URL).usernamepregenerated();
	}

	// C330 - Can you select a button to randomly generate a new username in the field?
	@Test(dataProvider = "fetchData", priority = 3)
	public void C330_verifyusernamepregeneratedrandomly(String URL) throws IOException, InterruptedException {
		node = test.createNode("C330 - Can you select a button to randomly generate a new username in the field?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop).launchURL(URL).usernamegeneratedrandomly();
	}

	// C331 - Can you enter text in every field?
	@Test(dataProvider = "fetchData", priority = 4)
	public void C331_verifyentertextinallfields(String URL) throws IOException, InterruptedException {
		node = test.createNode("C331 - Can you enter text in every field?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop).launchURL(URL).entertextinusernamefield()
				.entertextinfirstnamefield().entertextinlastnamefield().entertextinemailfield()
				.entertextinverifyemailfield();
	}

	// C332 - Are required fields marked with an asterisk?
	@Test(dataProvider = "fetchData", priority = 5)
	public void C332_verifyfieldsmarkedwithanasterisk(String URL) throws IOException, InterruptedException {
		node = test.createNode("C332 - Are required fields marked with an asterisk?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop).launchURL(URL).usernameAsteriks().firstnameAsteriks()
				.lastnameAsteriks().emailAsteriks().verifyemailAsteriks();
	}

	// C333 - If you hover over the email/verify email address fields, do you see a hover tooltip with appropriate text?
	@Test(dataProvider = "fetchData", priority = 6)
	public void C333_verifyemailtooltips(String URL) throws IOException, InterruptedException {
		node = test.createNode("C333 - If you hover over the email/verify email address fields, do you see a hover tooltip with appropriate text?");
		extent.attachReporter(spark);
		new EducatorRegistration1(driver, node, prop)
		.launchURL(URL)
		.hoveronemailfield()
		.hoveronverifyemailfield();
	}
	
	// C334 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
		@Test(dataProvider = "fetchData", priority = 7)
		public void C334_verifyemailerrormsg(String URL) throws IOException, InterruptedException {
			node = test.createNode("C334 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
			extent.attachReporter(spark);
			new EducatorRegistration1(driver, node, prop)
			.launchURL(URL)
			.Enterinvalidfirstname()
			.Enterinvalidlastname()
			.Enterinvalidemailfield()
			.Enterinvalidverifyemailfield()
			.clicknextbutton()
			.verifyerrormsgforinvaliddatasubmit();
		}
		
	// C335 - If you leave a required field blank and select Next, do you receive an appropriate error message?
		@Test(dataProvider = "fetchData", priority = 8)
		public void C335_verifyblankerrormsg(String URL) throws IOException, InterruptedException {
			node = test.createNode("C335 - If you leave a required field blank and select Next, do you receive an appropriate error message?");
			extent.attachReporter(spark);
			new EducatorRegistration1(driver, node, prop)
			.launchURL(URL)
			.verifyerrormsgblankfieldall()
			.verifyerrormsgfirstnameblankfield()
			.verifyerrormsglastnameblankfield()
			.verifyerrormsgemailblankfield()
			.verifyerrormsgverifyemailblankfield();
		}	
		
	//C336 - Do all error messages display correctly?	
		@Test(dataProvider = "fetchData", priority = 9)
		public void C336_verifyinvaliderrormsg(String URL) throws IOException, InterruptedException {
			node = test.createNode("C336 - Do all error messages display correctly?");
			extent.attachReporter(spark);
			new EducatorRegistration1(driver, node, prop)
			.launchURL(URL)
			.verifyinvaliderrormsg();
		}	
		
	//C337 - If you fill out all required fields with valid information and select Next, are you taken to Page 2?
		@Test(dataProvider = "fetchData", priority = 10)
		public void C337_verifyvalidregistration(String URL) throws IOException, InterruptedException {
			node = test.createNode("C337 - If you fill out all required fields with valid information and select Next, are you taken to Page 2?");
			extent.attachReporter(spark);
			new EducatorRegistration1(driver, node, prop)
			.launchURL(URL)
			.verifyregistrationwithvaliddata();
		}	
		
}