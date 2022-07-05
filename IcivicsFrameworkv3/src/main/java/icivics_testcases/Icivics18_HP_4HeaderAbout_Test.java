package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_HP_4HeaderAbout;

import projectSpecific.base.ProjectSpecificMethods;

public class Icivics18_HP_4HeaderAbout_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "HomepageHeaderAbout";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheaderabout";
	}

	// C22 - When you select About, does a submenu open below the About button?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C22_Verifyaboutsubmenu(String URL) throws IOException, InterruptedException {
		node = test.createNode("C22 -  When you select About, does a submenu open below the About button?");
		extent.attachReporter(reporter);
		new Icivics_HP_4HeaderAbout(driver, node, prop).launchURL(URL).clickonaboutmenu().verifyaboutbuttonathomepage();
	}
	// C23 - Do you see links to About iCivics, Who We Are, Our Strategy, CIVXNOW,
	// Our Team, Blog, and Contact Us in the submenu?

	@Test(dataProvider = "fetchData", priority = 1)
	public void C23_Verifysubmenucount(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C23 - Do you see links to About iCivics, Who We Are, Our Strategy, CIVXNOW, Our Team, Blog, and Contact Us in the submenu?");
		extent.attachReporter(reporter);
		new Icivics_HP_4HeaderAbout(driver, node, prop).launchURL(URL).clickonaboutmenu().verifyaboutoptionscount();
	}
	// C24 - When you select a link in the submenu, are you navigated to the
	// appropriate page?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C24_VerifysubmenuElement(String URL) throws IOException, InterruptedException {
		node = test
				.createNode("C24 - When you select a link in the submenu, are you navigated to the appropriate page?");
		extent.attachReporter(reporter);
		new Icivics_HP_4HeaderAbout(driver, node, prop).launchURL(URL).aboutbuttonelementsverification(URL);
	}
	/*// C26 - If you are viewing one of the pages in the About submenu, is that page underlined in the submenu?


	@Test(dataProvider = "fetchData", priority = 3)
	public void C26_Verifysubmenucount1(String URL) throws IOException, InterruptedException {
		node = test
				.createNode("C26 - If you are viewing one of the pages in the About submenu, is that page underlined in the submenu?");
		extent.attachReporter(reporter);
		new Icivics_HP_4HeaderAbout(driver, node, prop).launchURL(URL).aboutbuttonelementsverification(URL);
	}*/
	// C27 - When you select About again while the submenu is open, does the submenu close?


	@Test(dataProvider = "fetchData", priority = 3)
	public void C27_Verifyclickaboutbuttonagain(String URL) throws IOException, InterruptedException {
		node = test
				.createNode("C27 - When you select About again while the submenu is open, does the submenu close?");
		extent.attachReporter(reporter);
		new Icivics_HP_4HeaderAbout(driver, node, prop).launchURL(URL).clickonaboutmenu().clickaboutbuttonagain();
	}
}
