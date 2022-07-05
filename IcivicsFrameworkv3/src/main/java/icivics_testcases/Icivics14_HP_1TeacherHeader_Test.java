package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_HP_1TeacherHeader;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics14_HP_1TeacherHeader_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "HomepageTeacherHeader";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageteacherheader";
	}

	// C3 - While on all other pages, do you see buttons for Play, Teach, About,
	// Donate, Shop, and My iCivics in the navigation bar?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C3_Verifyheaderbuttonsforanonymoususer(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C3 - While on all other pages, do you see buttons for Play, Teach, About, Donate, Shop, and My iCivics in the navigation bar?(for anonymous user)");
		extent.attachReporter(reporter);
		new Icivics_HP_1TeacherHeader(driver, node, prop).launchteacherpageURL(URL).playbutton().Teachbutton()
				.aboutbutton().donatebutton().shopbutton().Verifymyicivicsbuttondisplayafterlogin();
	}
	// C3 - While on all other pages, do you see buttons for Play, Teach, About,
	// Donate, Shop, and My iCivics in the navigation bar?

	@Test(dataProvider = "fetchData", priority = 1)
	public void C3_Verifyheaderbuttonsforauthenticateduser(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C3 - While on all other pages, do you see buttons for Play, Teach, About, Donate, Shop, and My iCivics in the navigation bar?for authenticated user");
		extent.attachReporter(reporter);
		new Icivics_HP_1TeacherHeader(driver, node, prop).launchteacherpageURL(URL).signin2()
				.Verifyheaderbuttonsafterlogin();
	}
	// C4 - Are all header elements consistent with those in the mockups?(Need to
	// take one content from each content type)

	@Test(dataProvider = "fetchData", priority = 2)
	public void C4_Verifyheaderelemets(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C4 - Are all header elements consistent with those in the mockups?(Need to take one content from each content type");
		extent.attachReporter(reporter);
		new Icivics_HP_1TeacherHeader(driver, node, prop).launchteacherpageURL(URL).verifyblogcontenttype()
				.VerifyLogo().playbutton().Teachbutton().aboutbutton().donatebutton().shopbutton().verifysigninbutton()
				.launchteacherpageURL(URL).verifycurriculumcontenttype().VerifyLogo().playbutton().Teachbutton()
				.aboutbutton().donatebutton().shopbutton().verifysigninbutton().launchteacherpageURL(URL)
				.verifydbquestcontenttype().VerifyLogo().playbutton().Teachbutton().aboutbutton().donatebutton()
				.shopbutton().verifysigninbutton().launchteacherpageURL(URL).verifygamecontenttype().VerifyLogo()
				.playbutton().Teachbutton().aboutbutton().donatebutton().shopbutton().verifysigninbutton()
				.launchteacherpageURL(URL).verifylessonplaycontenttype().VerifyLogo().playbutton().Teachbutton()
				.aboutbutton().donatebutton().shopbutton().verifysigninbutton().launchteacherpageURL(URL)
				.verifyprofessionaldeveopmentcontenttype().VerifyLogo().playbutton().Teachbutton().aboutbutton()
				.donatebutton().shopbutton().verifysigninbutton().launchteacherpageURL(URL).verifyvideocontenttype()
				.VerifyLogo().playbutton().Teachbutton().aboutbutton().donatebutton().shopbutton().verifysigninbutton()
				.launchteacherpageURL(URL).verifyWebquestcontenttype().VerifyLogo().playbutton().Teachbutton()
				.aboutbutton().donatebutton().shopbutton().verifysigninbutton();
	}
	// C6 - Do all buttons have hover/click states?

	@Test(dataProvider = "fetchData", priority = 3)
	public void C6_Verifyheaderbuttonhoverforanonymoususer(String URL) throws IOException, InterruptedException {
		node = test.createNode("C6 - Do all buttons have hover/click states?for anonymous user");
		extent.attachReporter(reporter);
		new Icivics_HP_1TeacherHeader(driver, node, prop).launchteacherpageURL(URL).verifyplaybuttonhover()
				.verifyteachbuttonhover().verifyaboutbuttonhover().verifydonatebuttonhover().launchteacherpageURL(URL)
				.verifyshopbuttonhover().launchteacherpageURL(URL).verifysigninbuttonhover().signin2()
				.verifymyicvicsbuttonhover();
	}

	// C6 - Do all buttons have hover/click states?

	@Test(dataProvider = "fetchData", priority = 4)
	public void C6_verifyaheaderbuttonhoverforauthenticateduser(String URL) {
		node = test.createNode("C6 - Do all buttons have hover/click states?for authenticated user");
		extent.attachReporter(reporter);
		new Icivics_HP_1TeacherHeader(driver, node, prop).launchteacherpageURL(URL).signin2()
				.verifyplaybuttonhover().verifyteachbuttonhover().verifyaboutbuttonhover().verifydonatebuttonhover()
				.launchteacherpageURL(URL).verifyshopbuttonhover2().launchteacherpageURL(URL)
				.verifymyicvicsbuttonhover();
	}
	// C7 - Does the header resize responsively at different resolutions?

	@Test(dataProvider = "fetchData", priority = 5)
	public void C7_verifyresizeheaderintohamburger(String URL) throws IOException, InterruptedException {
		node = test.createNode("C7 - Does the header resize responsively at different resolutions?");
		extent.attachReporter(reporter);

		new Icivics_HP_1TeacherHeader(driver, node, prop).launchteacherpageURL(URL).resizeheader()
				.carddisplayinlistpattern();
	}
}
