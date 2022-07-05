package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_HP_2HeaderPlay;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics15_HP_2Headerplay_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "HomepageHeaderplay";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheaderplay";
	}

	// C8 - When you select Play, does a submenu open below the Play button?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C8_Verifyplaysubmenu(String URL) throws IOException, InterruptedException {
		node = test.createNode("C8 -  When you select Play, does a submenu open below the Play button?");
		extent.attachReporter(reporter);
		new Icivics_HP_2HeaderPlay(driver, node, prop).launchURL(URL).verifyplaysubmenu();
	}
	// C9 - Do you see links to All Games, as well as each individual game in the
	// submenu?

	@Test(dataProvider = "fetchData", priority = 1)
	public void C9_Verifyplaybuttonlist(String URL) throws IOException, InterruptedException {
		node = test.createNode("C9- Do you see links to All Games, as well as each individual game in the submenu?");
		extent.attachReporter(reporter);
		new Icivics_HP_2HeaderPlay(driver, node, prop).launchURL(URL).verifyplaysubmenu().verifyplaysubmenulist();
	}
	// C10 - When you select a link in the submenu, are you navigated to the
	// appropriate page?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C10_Verifyplaybuttonelements(String URL) throws IOException, InterruptedException {
		node = test
				.createNode("C10- When you select a link in the submenu, are you navigated to the appropriate page?");
		extent.attachReporter(reporter);
		new Icivics_HP_2HeaderPlay(driver, node, prop).launchURL(URL).Playbuttonelementsverification(URL);
	}

	// C12 -If you are viewing one of the pages in the Play submenu, is that page
	// underlined in the submenu?

	@Test(dataProvider = "fetchData", priority = 3)
	public void C12_Verifypageisunderlined(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C12- If you are viewing one of the pages in the Play submenu, is that page underlined in the submenu?");
		extent.attachReporter(reporter);
		new Icivics_HP_2HeaderPlay(driver, node, prop).launchURL(URL)
				.verifyselectedoptionunderlined();
	}

	// C13 - When you select Play again while the submenu is open, does the submenu
	// close?

	@Test(dataProvider = "fetchData", priority = 4)
	public void C13_Verifyclickonplaybuttonagain(String URL) throws IOException, InterruptedException {
		node = test.createNode("C13- When you select Play again while the submenu is open, does the submenu close?");
		extent.attachReporter(reporter);
		new Icivics_HP_2HeaderPlay(driver, node, prop).launchURL(URL).verifyplaysubmenu().clickplaybuttonagain();
	}
}
