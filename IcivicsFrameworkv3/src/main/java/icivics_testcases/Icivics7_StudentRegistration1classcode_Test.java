package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_StudentReg1classcode;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics7_StudentRegistration1classcode_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Student Registration classcode";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Studentregistration1classcode";
	}

	// C425 - Do 'Email address' and 'Verify email address' fields appear if you
	// select the 'Optional: Click here to enter your email address' button?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C425_verifyemailfieldsappear(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C425 - Do 'Email address' and 'Verify email address' fields appear if you select the 'Optional: Click here to enter your email address' button?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).verifyOptionallink();
	}

	// C426 -If you hover over the email/verify email address fields, do you see a
	// hover tooltip with appropriate text?
	@Test(dataProvider = "fetchData", priority = 1)
	public void C426_verifyemailtooltips(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C426 - If you hover over the email/verify email address fields, do you see a hover tooltip with appropriate text?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).hoveronemailfield()
				.hoveronverifyemailfield();
	}

	// C427 -Do the 'Email address' and 'Verify email address' fields disappear if
	// you select the 'Click here to remove the email address' button?
	@Test(dataProvider = "fetchData", priority = 2)
	public void C427_verifyemailfieldsdisappear(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C427 - Do the 'Email address' and 'Verify email address' fields disappear if you select the 'Click here to remove the email address' button?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).clickonremovelink();
	}
	// C428 -Is a username pre-generated when you arrive on the page?

	@Test(dataProvider = "fetchData", priority = 3)
	public void C428_verifyusernamepregenerated(String URL) throws IOException, InterruptedException {
		node = test.createNode("C428 - Is a username pre-generated when you arrive on the page");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).usernamepregenerated();
	}

	// C429 -Can you select a button to randomly generate a new username in the
	// field?

	@Test(dataProvider = "fetchData", priority = 4)
	public void C429_usernamegeneratedrandomly(String URL) throws IOException, InterruptedException {
		node = test.createNode("C429 - Can you select a button to randomly generate a new username in the field?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).usernamegeneratedrandomly();
	}

	// C430 -Can you enter text in every field?

	@Test(dataProvider = "fetchData", priority = 5)
	public void C430_verifyregistrationwithvaliddata(String URL) throws IOException, InterruptedException {
		node = test.createNode("C430 - Can you enter text in every field?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).clickOptionallink()
				.entertextinusernamefield().entertextinclasscodefield().entertextinfirstnamefield()
				.entertextinlastnamefield().entertextinemailfield().entertextinverifyemailfield().clicknext();
	}

	// C431 -Are required fields marked with an asterisk?

	@Test(dataProvider = "fetchData", priority = 6)
	public void C431_verifyAsteriks(String URL) throws IOException, InterruptedException {
		node = test.createNode("C431 -Are required fields marked with an asterisk?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).clickOptionallink()
				.usernameAsteriks().classcodeAsteriks().firstnameAsteriks().lastnameAsteriks().emailAsteriks()
				.verifyemailAsteriks();
	}
	// C432 -If you enter invalid information in a required field and select Next,
	// do you receive an appropriate error message?

	@Test(dataProvider = "fetchData", priority = 7)
	public void C432_verifyinvaliderrormsg(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C432 -If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).verifyinvaliderrormsg();
	}

	// C433 -If you leave a required field blank and select Next, do you receive an
	// appropriate error message?

	@Test(dataProvider = "fetchData", priority = 8)
	public void C433_verifyerrormsgverifyemailblankfield(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C433 -If you leave a required field blank and select Next, do you receive an appropriate error message?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).verifyerrormsgblankfieldall()
				.verifyerrormsgclasscodeblankfield().verifyerrormsgfirstnameblankfield()
				.verifyerrormsglastnameblankfield().verifyerrormsgemailblankfield()
				.verifyerrormsgverifyemailblankfield();
	}
	// C434 -Do all error messages display correctly?

	@Test(dataProvider = "fetchData", priority = 9)
	public void C434_verifyinvaliderrormsg2(String URL) throws IOException, InterruptedException {
		node = test.createNode("C434 -Do all error messages display correctly?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).verifyinvaliderrormsg2();
	}

	// C435 -If you fill out all required fields with valid information and select
	// Next, are you taken to Page 2?

	@Test(dataProvider = "fetchData", priority = 10)
	public void C435_verifyregistrationwithvalidvalue(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C435 -If you fill out all required fields with valid information and select Next, are you taken to Page 2?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg1classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvalidvalue();
	}
}
