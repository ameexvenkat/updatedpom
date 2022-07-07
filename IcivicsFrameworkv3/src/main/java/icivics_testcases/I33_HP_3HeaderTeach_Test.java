package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.HP_3HeaderTeach;

import projectSpecific.base.ProjectSpecificMethods;

public class I33_HP_3HeaderTeach_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Homepage Header teach1";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheaderteach";
	}

	// C15 - When you select Teach, does a submenu open below the Teach button?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C15_Verifyteachsubmenu(String URL) throws IOException, InterruptedException {
		node = test.createNode("C15 - When you select Teach, does a submenu open below the Teach button?");
		extent.attachReporter(reporter);
		new HP_3HeaderTeach(driver, node, prop).launchURL(URL).verifyteachmenu();
	}
	// C16 - Do you see links to Search Our Library, Scope and Sequence,
	// Professional Development, Get Started, Educatory Community, and FAQ in the
	// submenu?

	@Test(dataProvider = "fetchData", priority = 1)
	public void C16_Verifysubmenucount(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C16 - Do you see links to Search Our Library, Scope and Sequence, Professional Development, Get Started, Educatory Community, and FAQ in the submenu?");
		extent.attachReporter(reporter);
		new HP_3HeaderTeach(driver, node, prop).launchURL(URL).verifyteachmenu().verifyteachmenulist();
	}
	// C17 - When you select a link in the submenu, are you navigated to the
	// appropriate page?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C17_Verifyteachbuttonelements(String URL) throws IOException, InterruptedException {
		node = test
				.createNode("C17 - When you select a link in the submenu, are you navigated to the appropriate page?");
		extent.attachReporter(reporter);
		new HP_3HeaderTeach(driver, node, prop).launchURL(URL).Teachbuttonelementsverification(URL);
	}

	// C20 - When you select Teach again while the submenu is open, does the submenu
	// close?

	@Test(dataProvider = "fetchData", priority = 3)
	public void C20_verifyclickteachbuttonagain(String URL) throws IOException, InterruptedException {
		node = test.createNode("C20 - When you select Teach again while the submenu is open, does the submenu close?");
		extent.attachReporter(reporter);
		new HP_3HeaderTeach(driver, node, prop).launchURL(URL).verifyteachmenu().clickteachbuttonagain();
	}

}
