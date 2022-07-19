package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Pg2TeacherRegistration;
import projectSpecific.base.ProjectSpecificMethods;

public class Pg2TeacherRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Page2TeacherRegistration";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C545 - "Can you tell which page you are currently viewing in the
	// breadcrumbs?"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C545_VerifyTeacherregistrationpage1(String URL) throws IOException, InterruptedException {
		node = test.createNode("C545 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifypagecount2();
	}

	// C546 - "Do you see fields for teaching state, school or institution, and zip
	// code?"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C546_Verifypage2fields(String URL) throws IOException, InterruptedException {
		node = test.createNode("C5456- Do you see fields for teaching state, school or institution, and zip code?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifypage2field();
	}
	// C546 - "Can you select Back to proceed to the previous page?"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C546_Verifybackbutton(String URL) throws IOException, InterruptedException {
		node = test.createNode("C5456- Can you select Back to proceed to the previous page?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifyclickonbackbutton();
	}

// C547 - "Can you make a selection for all fields?"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C547_Verifyfieldselection(String URL) throws IOException, InterruptedException {
		node = test.createNode("C5457- Can you make a selection for all fields?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifyselectschoolfield()
				.verifyzipcodeselection().verifyteachingstateselection();
	}
	// C548 - "If you enter invalid information in a required field and select Next,
	// do you receive an appropriate error message?"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C548_Verifyfieldswithinvaliddata(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C5458- If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifyenterinvaliddata();
	}
	// C549 - "If you leave a required field blank and select Next, do you receive
	// an appropriate error message?"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C549_Verifyfieldswithinvaliddata(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C5459- If you leave a required field blank and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifyenterinvaliddata();
	}

	// C550 - "If you fill out all required fields with valid information and select
	// Next, are you taken to Page 3?"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C550_Verifyfieldswithinvaliddata(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C550- If you fill out all required fields with valid information and select Next, are you taken to Page 3?");
		extent.attachReporter(spark);
		new Pg2TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage()
				.verifyregistrationwithvaliddata().verifypage3loaded();
	}
}
