package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_HP_5HeaderSigninMisc;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics20_HP_5HeaderSigninMisc_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "HomepageHeadermysigninmisc";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheadersigninmisc";
	}

	// C29 - Can you see an appropriate icon for Donate?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C29_Verifydonatebutton(String URL) throws IOException, InterruptedException {
		node = test.createNode("C29 -  Can you see an appropriate icon for Donate?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderSigninMisc(driver, node, prop).launchURL(URL).VerifyDonatebutton();
	}
	// C30 - When you select Donate, are you directed to https://give.icivics.org/?

	@Test(dataProvider = "fetchData", priority = 1)
	public void C30_Verifydonatebuttonclick(String URL) throws IOException, InterruptedException {
		node = test.createNode("C30 -  When you select Donate, are you directed to https://give.icivics.org/?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderSigninMisc(driver, node, prop).launchURL(URL).VerifyDonateclick();
	}
	// C31 - Can you see an appropriate icon for Shop?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C31_Verifyshopbutton(String URL) throws IOException, InterruptedException {
		node = test.createNode("C31 -  Can you see an appropriate icon for Shop?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderSigninMisc(driver, node, prop).launchURL(URL).VerifyShopbutton();
	}
	// C32 - When you select Shop, are you directed to
	// https://icivics.myshopify.com/?

	@Test(dataProvider = "fetchData", priority = 3)
	public void C32_Verifyshopbuttonclick(String URL) throws IOException, InterruptedException {
		node = test.createNode("C32 -  When you select Shop, are you directed to https://icivics.myshopify.com/?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderSigninMisc(driver, node, prop).launchURL(URL).VerifyShopbuttonclick();
	}
	// C33 - If you are not signed in, do you see a Sign In button instead of My
	// iCivics?

	@Test(dataProvider = "fetchData", priority = 4)
	public void C33_Verifysigninbuttonforanonymoususer(String URL) throws IOException, InterruptedException {
		node = test.createNode("C33 - If you are not signed in, do you see a Sign In button instead of My iCivics?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderSigninMisc(driver, node, prop).launchURL(URL).verifysigninbutton();
	}

	// C37 - When you select Sign In, do you see links to Sign In, Register As a
	// Student, Register As A Teacher in the submenu?

	@Test(dataProvider = "fetchData", priority = 5)
	public void C37_Verifysigninbuttonsubmenu(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C37 - When you select Sign In, do you see links to Sign In, Register As a Student, Register As A Teacher in the submenu?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderSigninMisc(driver, node, prop).launchURL(URL).verifysigninbuttonsubmenulist();
	}
	// C38 - If not signed in and you select a link in the submenu, are you
	// navigated to the appropriate page?

	@Test(dataProvider = "fetchData", priority = 6)
	public void C38_Verifysigninbuttonsubmenu(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C38 - If not signed in and you select a link in the submenu, are you navigated to the appropriate page?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderSigninMisc(driver, node, prop).launchURL(URL).Signinbuttonelementsverification(URL);
	}
	// C41 - If you are viewing one of the pages in the Sign In submenu, is that
	// page underlined in the submenu?

	@Test(dataProvider = "fetchData", priority = 7)
	public void C41_Verifysubmenuoptionisunderlined(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C41 - If you are viewing one of the pages in the Sign In/My iCivics submenu, is that page underlined in the submenu?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderSigninMisc(driver, node, prop).launchURL(URL).verifysigninbutton()
				.verifyselectedsigninunderlined().verifyselectedregasmystuunderlined()
				.verifyselectedregzasmyteacherunderlined().Clickonsigninbuttonagain();
	}

	// C42 - When you select Sign In / My iCivics again while the submenu is open,
	// does the submenu close?

	@Test(dataProvider = "fetchData", priority = 8)
	public void C42_Verifysubmenuoptionisunderlined(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C42 - When you select Sign In / My iCivics again while the submenu is open, does the submenu close?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderSigninMisc(driver, node, prop).launchURL(URL).verifysigninbutton().Clickonsigninbuttonagain();
	}

}
