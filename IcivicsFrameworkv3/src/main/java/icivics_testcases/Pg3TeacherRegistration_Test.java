package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import icivics_pages.Pg3TeacherRegistration;
import projectSpecific.base.ProjectSpecificMethods;

public class Pg3TeacherRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Page3TeacherRegistration";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C551- "Can you tell which page you are currently viewing in the breadcrumbs?"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C551_Verifypagecount3(String URL) throws IOException, InterruptedException {
		node = test.createNode("C551 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(spark);
		new Pg3TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifypagecount3();
	}

	// C552- "Do you see fields for Sign Up for Emails, Agree to Terms of
	// Use/Privacy Policy, and Sync Google Classroom courses?"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C552_Verifypage3fields(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C552 - Do you see fields for Sign Up for Emails, Agree to Terms of Use/Privacy Policy, and Sync Google Classroom courses?");
		extent.attachReporter(spark);
		new Pg3TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifypage3fields();
	}
	// C553- "Can you select Back to proceed to the previous page?"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C553_Verifybackbutton(String URL) throws IOException, InterruptedException {
		node = test.createNode("C553 - Can you select Back to proceed to the previous page?");
		extent.attachReporter(spark);
		new Pg3TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifyclickbackbutton();
	}
	// C554- "If you do not check agree to terms of use, does it display an error
	// message"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C554_Verifygettingstartedpagewithemailcheck1(String URL) throws IOException, InterruptedException {
		node = test.createNode("C554 - If you do not check agree to terms of use, does it display an error message");
		extent.attachReporter(spark);
		new Pg3TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage()
				.verifygettingstartedpagewithemailcheck();
	}
	// C555- "If you enter valid information, do not check sync classes, does it
	// move you to the next page"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C555_Verifygettingstartedpagewithemailcheck(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C555 - If you enter valid information, do not check sync classes, does it move you to the next page");
		extent.attachReporter(spark);
		new Pg3TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage()
				.verifygettingstartedpagewithemailcheck();
	}
	// C555- "If you enter valid information, do not check sync classes, does it
	// move you to the next page"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C555_Verifygettingstartedpagewithemailuncheck(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C555 - If you enter valid information, do not check sync classes, does it move you to the next page");
		extent.attachReporter(spark);
		new Pg3TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().
		verifygettingstartedpagewithemailuncheck();
	}
}
