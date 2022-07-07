package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.StudentRegistration3Email;
import projectSpecific.base.ProjectSpecificMethods;

public class I25_StudentRegistration3Email_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Student Registration3 Email id ";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Studentregistration2email";
	}

	// C372 - Can you tell which page you are currently viewing in the breadcrumbs?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C372_verifypagecount3(String URL) throws IOException, InterruptedException {
		node = test.createNode("C372 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(reporter);
		new StudentRegistration3Email(driver, node, prop).launchstudentURL(URL).verifywithvaliddata().verifypagecount3();
	}
	// C373 - Do you see a notification that a welcome message has been sent to your
	// email address?

	@Test(dataProvider = "fetchData", priority = 1)
	public void C373_verifycheckmsgdisplay(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C373 - Do you see a notification that a welcome message has been sent to your email address?");
		extent.attachReporter(reporter);
		new StudentRegistration3Email(driver, node, prop).launchstudentURL(URL).verifywithvaliddata()
				.verifycheckmsgdisplay();
	}
	// C374 - Do you see text that your confirmation email is on the way?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C374_verifycheckmsgdisplay(String URL) throws IOException, InterruptedException {
		node = test.createNode("C374 - Do you see text that your confirmation email is on the way?");
		extent.attachReporter(reporter);
		new StudentRegistration3Email(driver, node, prop).launchstudentURL(URL).verifywithvaliddata()
				.verifyemailheaderlabel();
	}
	// C375 - Is your email displayed on the page?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C375_verifyregisteredemaildisplay(String URL) throws IOException, InterruptedException {
		node = test.createNode("C375 - Is your email displayed on the page?");
		extent.attachReporter(reporter);
		new StudentRegistration3Email(driver, node, prop).launchstudentURL(URL).verifywithvaliddata()
				.verifyregisteredemaildisplay();
	}
	// C376 - Can you select a button to resend your confirmation email?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C376_verifyresendbutton(String URL) throws IOException, InterruptedException {
		node = test.createNode("C376 - Can you select a button to resend your confirmation email?");
		extent.attachReporter(reporter);
		new StudentRegistration3Email(driver, node, prop).launchstudentURL(URL).verifywithvaliddata()
				.verifyresendbutton();
	}
	// C377 - Do you see a notification when the email has been resent?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C377_verifyconfirmationemail(String URL) throws IOException, InterruptedException {
		node = test.createNode("C377 - Do you see a notification when the email has been resent?");
		extent.attachReporter(reporter);
		new StudentRegistration3Email(driver, node, prop).launchstudentURL(URL).verifywithvaliddata()
				.verifyconfirmationemail();
	}
}
