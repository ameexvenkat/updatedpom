package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.GoogleRegistration;

import projectSpecific.base.ProjectSpecificMethods;

public class GoogleRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Google Registration";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_GoogleRegistration";
	}

	// C544 - "After Google sign-in with account not registered at iCivics
	// Select teacher registration"

	@Test(dataProvider = "fetchData", priority = 0)
	public void C544_Verifyeducatorregistrationpage1(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C544 - After Google sign-in with account not registered at iCivics Select teacher registration");
		extent.attachReporter(spark);
		new GoogleRegistration(driver, node, prop).launchURL(URL).verifyclickregisteraseducator();
	}
	// C545 - "Attempt to start registration process without being signed in with
	// Google"

	@Test(dataProvider = "fetchData", priority = 1)
	public void C545_Verifyregistrationwithoutsignin(String URL) throws IOException, InterruptedException {
		node = test.createNode("C545 - Attempt to start registration process without being signed in with Google");
		extent.attachReporter(spark);
		new GoogleRegistration(driver, node, prop).launchURL(URL).verifyregistrationwithoutsignin();
	}
	// C546 - "Attempt to start registration process when already registered at
	// iCivics"

	@Test(dataProvider = "fetchData", priority = 2)
	public void C546_Verifyregistrationwithalreadyregisteredid(String URL) throws IOException, InterruptedException {
		node = test.createNode("C546 - Attempt to start registration process when already registered at iCivics");
		extent.attachReporter(spark);
		new GoogleRegistration(driver, node, prop).launchURL(URL).verifyregistrationwithalreadyregisteredID();
	}
	// C544 - ""After Google sign-in with account not registered at iCivics
	//Select student registration"

	@Test(dataProvider = "fetchData", priority = 3)
	public void C544_Verifystudentregistrationpage1(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C544 - After Google sign-in with account not registered at iCivics Select student registration");
		extent.attachReporter(spark);
		new GoogleRegistration(driver, node, prop).launchURL(URL).verifyregisterasstudentclick();
	}
}
