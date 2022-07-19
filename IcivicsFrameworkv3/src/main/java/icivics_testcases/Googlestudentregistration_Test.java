package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Googlestudentregistration;
import projectSpecific.base.ProjectSpecificMethods;

public class Googlestudentregistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Google Student Registration ";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleIntegration";
	}

	// C557 - Do you see field for Agree to Terms of Use/Privacy Policy?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C557_Verifyagreetotermsandconditionfield(String URL) throws IOException, InterruptedException {
		node = test.createNode("C557- Do you see field for Agree to Terms of Use/Privacy Policy?");
		extent.attachReporter(spark);
		new Googlestudentregistration(driver, node, prop).launchURL(URL).verifyregisterasstudent()
				.verifyagreetotermsfield();
	}

	// C558 - If you do not check agree to terms of use, does it display an error
	// message

	@Test(dataProvider = "fetchData", priority = 0)
	public void C558_Verifyerrormsg(String URL) throws IOException, InterruptedException {
		node = test.createNode("C558-If you do not check agree to terms of use, does it display an error message");
		extent.attachReporter(spark);
		new Googlestudentregistration(driver, node, prop).launchURL(URL).verifyregisterasstudent().verifyerrormsg();

	}
	// C559 -If you enter valid information, do not check sync classes, does it move
	// you to the next page

	@Test(dataProvider = "fetchData", priority = 0)
	public void C559_Verifyerrormsg(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C559-If you enter valid information, do not check sync classes, does it move you to the next page");
		extent.attachReporter(spark);
		new Googlestudentregistration(driver, node, prop).launchURL(URL).verifyregisterasstudent().verifysubmit();

	}
}
