package icivics_testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import icivics_pages.Icivics_EducatorReg;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics1_EducatorRegistration_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration General";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C321 - Are all page elements consistent with those on Live?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C321_VerifyallpageElements(String URL) throws IOException, InterruptedException {
		node = test.createNode("C321 - Are all page elements consistent with those on Live?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg(driver, node, prop).launchURL(URL).verifyeducatorpage(URL).pagecounter().username()
				.reloadbutton().firstname().lastname().Email().verifyEmail().nextbutton();
	}

	// C322 - Do all buttons have hover/click states consistent with Live?
	@Test(dataProvider = "fetchData", priority = 1)
	public void C322_ButtonHover(String URL) throws IOException, InterruptedException {
		node = test.createNode("C322 - Do all buttons have hover/click states consistent with Live?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg(driver, node, prop).launchURL(URL).verifyeducatorpage(URL).hoverplaybutton()
				.hoverteachbutton().hoveraboutbutton().Donatebutton().shopbutton().signinbutton().hoverfirstname()
				.hoverlastname().hoveremail().hoververifyemail().hovernextbutton();
	}

	// C323 - Do all buttons/links navigate you to the appropriate page?
	@Test(dataProvider = "fetchData", priority = 2)
	public void C323_Verifyallbuttonlinks(String URL) throws IOException, InterruptedException {
		node = test.createNode("C323 - Do all buttons/links navigate you to the appropriate page?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg(driver, node, prop).launchURL(URL).verifyeducatorpage(URL)
				.Playbuttonelementsverification(URL).Teachbuttonelementsverification(URL).aboutbuttonelementsverification(URL);
	}

	// C324 - Does the page resize responsively at different resolutions?
	@Test(dataProvider = "fetchData", priority = 3)
	public void C324_WindowResize(String URL) throws IOException, InterruptedException {
		node = test.createNode("C324 - Does the page resize responsively at different resolutions?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg(driver, node, prop).launchURL(URL).verifyeducatorpage(URL).resizewindow();
	}

	// C325 - Is all copy correct?
	@Test(dataProvider = "fetchData", priority = 4)
	public void C325_Verifyerrormsg(String URL) throws IOException, InterruptedException {
		node = test.createNode("C325 - Is all copy correct??");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg(driver, node, prop).launchURL(URL).verifyeducatorpage(URL).typos();
	}

	// C326 - Do you see a set of 5 numbered page breadcrumbs?
	@Test(dataProvider = "fetchData", priority = 5)
	public void C326_Verifybreadcrumbs(String URL) throws IOException, InterruptedException {
		node = test.createNode("C326 - Do you see a set of 5 numbered page breadcrumbs?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg(driver, node, prop).launchURL(URL).verifyeducatorpage(URL).pagebreadcrumbs();
	}

}
