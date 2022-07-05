package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_HP_5HeaderMyicivicsMisc;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics19_HP_5HeaderMyicivicsMisc_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "HomepageHeaderMyIcivicsMisc";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheadermyicivicsmisc";
	}

	// C29 - Can you see an appropriate icon for Donate?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C29_Verifydonatebutton(String URL) throws IOException, InterruptedException {
		node = test.createNode("C29 -  Can you see an appropriate icon for Donate?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin().VerifyDonatebutton();
	}
	// C30 - When you select Donate, are you directed to https://give.icivics.org/?

	@Test(dataProvider = "fetchData", priority = 1)
	public void C30_Verifydonatebuttonclick(String URL) throws IOException, InterruptedException {
		node = test.createNode("C30 -  When you select Donate, are you directed to https://give.icivics.org/?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin().VerifyDonateclick();
	}
	// C31 - Can you see an appropriate icon for Shop?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C31_Verifyshopbutton(String URL) throws IOException, InterruptedException {
		node = test.createNode("C31 -  Can you see an appropriate icon for Shop?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin().VerifyShopbutton();
	}
	// C32 - When you select Shop, are you directed to
	// https://icivics.myshopify.com/?

	@Test(dataProvider = "fetchData", priority = 3)
	public void C32_Verifyshopbuttonclick(String URL) throws IOException, InterruptedException {
		node = test.createNode("C32 -  When you select Shop, are you directed to https://icivics.myshopify.com/?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin().VerifyShopbuttonclick();
	}

	// C34 - If you are signed in, do you see a My iCivics button instead of Sign
	// In?

	@Test(dataProvider = "fetchData", priority = 4)
	public void C34_VerifyIcivicsbutton(String URL) throws IOException, InterruptedException {
		node = test.createNode("C34 - If you are signed in, do you see a My iCivics button instead of Sign In?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin()
				.verifymyicvicsbuttonafterlogin();
	}

	// C35 - Can you see your avatar icon represented in the button?

	@Test(dataProvider = "fetchData", priority = 5)
	public void C35_Verifytheavatar(String URL) throws IOException, InterruptedException {
		node = test.createNode("C35 - Can you see your avatar icon represented in the button?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin().verifywithavatar();
	}

	// C35 - Can you see your avatar icon represented in the button?

	@Test(dataProvider = "fetchData", priority = 6)
	public void C35_Verifythenoavatar(String URL) throws IOException, InterruptedException {
		node = test.createNode("C35 - Can you see your avatar icon represented in the button?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifywithnoavatar();
	}

	// C36 - When you select Sign In/My iCivics, does a submenu open below the
	// button?

	@Test(dataProvider = "fetchData", priority = 7)
	public void C36_VerifyIcivicssubmenu(String URL) throws IOException, InterruptedException {
		node = test.createNode("C36 - When you select Sign In/My iCivics, does a submenu open below the button?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin()
				.verifymyicvicsbuttonsubmenu();
	}
	// C37 - When you select Sign In, do you see links to Sign In, Register As a
	// Student, Register As A Teacher in the submenu?

	@Test(dataProvider = "fetchData", priority = 8)
	public void C37_VerifyIcivicssubmenu(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C37 - When you select Sign In, do you see links to Sign In, Register As a Student, Register As A Teacher in the submenu?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin()
				.verifymyicivicssubmenulist();
	}
	// C39 - When you select a link in the submenu, are you navigated to the
	// appropriate page?

	@Test(dataProvider = "fetchData", priority = 9)
	public void C39_Myicivicsbuttonelementsverification(String URL) throws IOException, InterruptedException {
		node = test
				.createNode("C39 -When you select a link in the submenu, are you navigated to the appropriate page?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin()
				.Myicivicsbuttonelementsverification(URL);
	}
	// C41 - If you are viewing one of the pages in the Sign In/My iCivics submenu,
	// is that page underlined in the submenu?

	@Test(dataProvider = "fetchData", priority = 10)
	public void C41_verifyselectpageisunderlined(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C41 -If you are viewing one of the pages in the Sign In/My iCivics submenu, is that page underlined in the submenu?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin()
				.verifymyicvicsbuttonsubmenu().verifyselectedmyicivicsunderlined().verifyselectedmyclassesunderlined()
				.verifyselectedmyfavoritesunderlined().Clickonmyicivicsbuttonagain();

	}
	// C42 - When you select Sign In / My iCivics again while the submenu is open,
	// does the submenu close?

	@Test(dataProvider = "fetchData", priority = 11)
	public void C42_Verifymyicivicsbuttonsubmenuclose(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C42 - When you select Sign In / My iCivics again while the submenu is open, does the submenu close?");
		extent.attachReporter(reporter);
		new Icivics_HP_5HeaderMyicivicsMisc(driver, node, prop).launchURL(URL).verifylogin()
				.Clickonmyicivicsbuttonagain();
	}
}
