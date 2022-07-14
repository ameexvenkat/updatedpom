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

	// C546 - "Do you see fields for teaching state, school or institution, and zip code?"

		@Test(dataProvider = "fetchData", priority = 0)
		public void C546_Verifypage2fields(String URL) throws IOException, InterruptedException {
			node = test.createNode("C545 - Can you tell which page you are currently viewing in the breadcrumbs?");
			extent.attachReporter(spark);
			new Pg2TeacherRegistration(driver, node, prop).launchURL(URL).Registrationpage().verifyteachingstatefield();
		}

}
