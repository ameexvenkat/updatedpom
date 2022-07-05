package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_HP_1Header;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics13_HP_1Header_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "HomepageHeader";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheader";
	}

	// C1 - Do you see the iCivics Logo in the upper left?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C1_VerifyLogo(String URL) throws IOException, InterruptedException {
		node = test.createNode("C1 - Do you see the iCivics Logo in the upper left?");
		extent.attachReporter(reporter);
		new Icivics_HP_1Header(driver, node, prop).launchURL(URL).VerifyLogo();
	}
	// C2 - While on the iCivics Home Page, do you see buttons for Donate, Shop, and
	// My iCivics in the navigation bar?

	@Test(dataProvider = "fetchData", priority = 1)
	public void C2_VerifyHeaderbuttonforanonymoususer(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C2 - While on the iCivics Home Page, do you see buttons for Donate, Shop,  and My iCivics in the navigation bar?for anonymous user");
		extent.attachReporter(reporter);
		new Icivics_HP_1Header(driver, node, prop).launchURL(URL).VerifyDonatebutton()
				.Verifyshopbutton().Verifymyicivicsbuttondisplayafterlogin();
	}
	// C2 - While on the iCivics Home Page, do you see buttons for Donate, Shop, and
	// My iCivics in the navigation bar?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C2_VerifyHeaderbuttonforauthenticateduser(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C2 - While on the iCivics Home Page, do you see buttons for Donate, Shop,  and My iCivics in the navigation bar?for authenticated user");
		extent.attachReporter(reporter);
		new Icivics_HP_1Header(driver, node, prop).launchURL(URL).signin().Verifyheaderbuttonsafterlogin();
	}

	// C1538 - Does the donation popup NOT show?

	@Test(dataProvider = "fetchData", priority = 3)
	public void C1538_Verifydonationpopup(String URL) throws IOException, InterruptedException {
		node = test.createNode("C1538 - Does the donation popup NOT show?");
		extent.attachReporter(reporter);
		new Icivics_HP_1Header(driver, node, prop).launchURL(URL).Verifydonationpopup();
	}

}
