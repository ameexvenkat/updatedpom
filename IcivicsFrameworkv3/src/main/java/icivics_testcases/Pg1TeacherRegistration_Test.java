package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Pg1TeacherRegistration;
import projectSpecific.base.ProjectSpecificMethods;

public class Pg1TeacherRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Page1TeacherRegistration";
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
		new Pg1TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifypagecount1();
	}
	// C546 - "Do you see fields for Role and Grade Level?"

	@Test(dataProvider = "fetchData", priority = 1)
	public void C546_Verifyroleandgradefield(String URL) throws IOException, InterruptedException {
		node = test.createNode("C546 - Do you see fields for Role and Grade Level?");
		extent.attachReporter(spark);
		new Pg1TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifygradelevelfield()
				.verifygradelevelfieldisselected().verifyrolefieldoptions();
	}
	// C547 - "Can you make a selection for all fields?"

	@Test(dataProvider = "fetchData", priority = 2)
	public void C547_Verifyroleandgradefield(String URL) throws IOException, InterruptedException {
		node = test.createNode("C547 - Can you make a selection for all fields?");
		extent.attachReporter(spark);
		new Pg1TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifygradelevelselection()
				.verifyroledropdownselection();
	}
	// C548 - "If you leave a no checks for grade level and select Next, do you
	// receive an appropriate error message?"

	@Test(dataProvider = "fetchData", priority = 3)
	public void C548_Verifyleavegradeboxesunchecked(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C548 - If you leave a no checks for grade level and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new Pg1TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage()
				.verifyleavegradelevelboxesunchecked();
	}
	// C549 - "If you leave role none selected and select Next, do you receive an
	// appropriate error message?"

	@Test(dataProvider = "fetchData", priority = 4)
	public void C549_Verifyleaverolenoneselected(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C548 -If you leave role none selected and select Next, do you receive an appropriate error message?");
		extent.attachReporter(spark);
		new Pg1TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifyleaverolenoneselected();
	}
	// C550 - "If you fill out all required fields with valid information and select Next, are you taken to Page 2?"

		@Test(dataProvider = "fetchData", priority = 5)
		public void C550_Verifyenterwithvaliddata(String URL) throws IOException, InterruptedException {
			node = test.createNode(
					"C550 -If you fill out all required fields with valid information and select Next, are you taken to Page 2?");
			extent.attachReporter(spark);
			new Pg1TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifyentervaliddata();
		}
}
