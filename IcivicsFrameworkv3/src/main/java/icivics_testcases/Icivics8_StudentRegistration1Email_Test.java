package icivics_testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;

import icivics_pages.Icivics_StudentReg1Email;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics8_StudentRegistration1Email_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Student Registration Email";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Studentregistration1Email";
	}

	// C383 - Do you see a set of 3 numbered page breadcrumbs?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C383_Verifybreadcrumbs(String URL) throws IOException, InterruptedException {
		node = test.createNode("C383 - Do you see a set of 3 numbered page breadcrumbs?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).verifystudentpage(URL).verifybreadcrumbs();
	}

	// C384 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(dataProvider = "fetchData", priority = 1)
	public void C384_Verifybreadcrumbspage(String URL) throws IOException, InterruptedException {
		node = test.createNode("C384 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).verifypagecount1();
	}

	// C385 - If you select the Watch our student registration help video link
	@Test(dataProvider = "fetchData", priority = 2)
	public void C385_Verifyvideolink(String URL) throws IOException, InterruptedException {
		node = test.createNode("C385 - If you select the Watch our student registration help video link");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).verifyregistrationvideolink();
	}

	// C387 - Do you see fields for Username, First Name, Last Name, E-mail address,
	// and Verify email address?
	@Test(dataProvider = "fetchData", priority = 3)
	public void C387_verifytextfields(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C387 - Do you see fields for Username, First Name, Last Name, E-mail address, and Verify email address?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).Verifyusernametextfields()
				.Verifyfirstnamenametextfields().Verifylastnametextfields().Verifyemailtextfields()
				.Verifyemail2textfields();
	}

	// C388 - Is a username pre-generated when you arrive on the page?
	@Test(dataProvider = "fetchData", priority = 4)
	public void C388_verifyusernamepregenerated(String URL) throws IOException, InterruptedException {
		node = test.createNode("C388 - Is a username pre-generated when you arrive on the page?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).usernamepregenerated();
	}

	// C389 - Can you select a button to randomly generate a new username in the
	// field?
	@Test(dataProvider = "fetchData", priority = 5)
	public void C389_verifyusernamepregeneratedrandomly(String URL) throws IOException, InterruptedException {
		node = test.createNode("C389 - Can you select a button to randomly generate a new username in the field?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).usernamegeneratedrandomly();
	}

	// C390 - Can you enter text in every field?
	@Test(dataProvider = "fetchData", priority = 6)
	public void C390_verifyentertextinallfields(String URL) throws IOException, InterruptedException {
		node = test.createNode("C390 - Can you enter text in every field?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).entertextinusernamefield()
				.entertextinfirstnamefield().entertextinlastnamefield().entertextinemailfield()
				.entertextinverifyemailfield();
	}

	// C391 - Are required fields marked with an asterisk?
	@Test(dataProvider = "fetchData", priority = 7)
	public void C391_verifyfieldsmarkedwithanasterisk(String URL) throws IOException, InterruptedException {
		node = test.createNode("C391 - Are required fields marked with an asterisk?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).usernameAsteriks().firstnameAsteriks()
				.lastnameAsteriks().emailAsteriks().verifyemailAsteriks();
	}

	// C392 - If you hover over the email/verify email address fields, do you see a
	// hover tooltip with appropriate text?
	@Test(dataProvider = "fetchData", priority = 8)
	public void C392_verifyemailtooltips(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C392 - If you hover over the email/verify email address fields, do you see a hover tooltip with appropriate text?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).hoveronemailfield().hoveronverifyemailfield();
	}

	// C393 - If you enter invalid information in a required field and select Next,
	// do you receive an appropriate error message?
	@Test(dataProvider = "fetchData", priority = 9)
	public void C393_verifyemailerrormsg(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C393 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).Enterinvalidfirstname().Enterinvalidlastname()
				.Enterinvalidemailfield().Enterinvalidverifyemailfield().clicknextbutton()
				.verifyerrormsgforinvaliddatasubmit();
	}

	// C394 - If you leave a required field blank and select Next, do you receive an
	// appropriate error message?
	@Test(dataProvider = "fetchData", priority = 10)
	public void C394_verifyblankerrormsg(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C394 - If you leave a required field blank and select Next, do you receive an appropriate error message?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).verifyerrormsgblankfieldall()
				.verifyerrormsgfirstnameblankfield().verifyerrormsglastnameblankfield().verifyerrormsgemailblankfield()
				.verifyerrormsgverifyemailblankfield();
	}

	// C396 - If you fill out all required fields with valid information and select
	// Next, are you taken to Page 2?
	@Test(dataProvider = "fetchData", priority = 11)
	public void C396_verifyvalidregistration(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C396 - If you fill out all required fields with valid information and select Next, are you taken to Page 2?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata();
	}
	
	// C397 - Does classcode link lead to class code page
		@Test(dataProvider = "fetchData", priority = 12)
		public void C397_Verifyclasscodelink(String URL) throws IOException, InterruptedException {
			node = test.createNode("C397 - Does classcode link lead to class code page");
			extent.attachReporter(reporter);
			new Icivics_StudentReg1Email(driver, node, prop).launchstudentURL(URL).verifyclasscodelink();
		}
}
