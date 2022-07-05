package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_StudentReg3classcode;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics11_StudentRegistration3classcode_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Student Registration3 classcode";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Studentregistration3classcode";
	}

	// C454- Can you tell which page you are currently viewing in the breadcrumbs?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C454_verifypagecount3(String URL) throws IOException, InterruptedException {
		node = test.createNode("C454 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg3classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.verifypagecount3();
	}
	// C455 - Do you see a notification that displays your generated username?

	@Test(dataProvider = "fetchData", priority = 1)
	public void C455_verifyusernamegenerateddisplay(String URL) throws IOException, InterruptedException {
		node = test.createNode("C455 -Do you see a notification that displays your generated username?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg3classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.verifyusernamegenerateddisplay();
	}
	// C456 - Do you see text that you will use your username and chosen password to
	// log in?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C456_verifyusernametextddisplay(String URL) throws IOException, InterruptedException {
		node = test.createNode("C456 -Do you see text that you will use your username and chosen password to log in?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg3classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.verifyusernametextddisplay();
	}
	// C457 - If you entered an email address, do you see a notification that
	// displays your entered email address?

	@Test(dataProvider = "fetchData", priority = 3)
	public void C457_verifyemailddisplay(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C457 -If you entered an email address, do you see a notification that displays your entered email address?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg3classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.verifyemailddisplay();
	}
	// C458 - If you entered an email address, do you see text that the email address can be used to log in?


	@Test(dataProvider = "fetchData", priority = 4)
	public void C458_verifyemailtextddisplay(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C458 -If you entered an email address, do you see text that the email address can be used to log in?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg3classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.verifyemailtextddisplay();
	}
	// C459 - When you select 'Continue to my Assignments,' are you brought to your My iCivics page?



		@Test(dataProvider = "fetchData", priority = 5)
		public void C459_clickcontinuetomyassignmentbutton(String URL) throws IOException, InterruptedException {
			node = test.createNode(
					"C459 -When you select 'Continue to my Assignments,' are you brought to your My iCivics page?");
			extent.attachReporter(reporter);
			new Icivics_StudentReg3classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
					.clickcontinuetomyassignmentbutton();
		}

}
