package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.HP_3Headerteach2;
import projectSpecific.base.ProjectSpecificMethods;

public class I34_HP_3Headerteach2_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Homepage Headerteach2";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Homepageheaderteach2";
	}

	// C19 -If you are viewing one of the pages in the Teach submenu, is that page
	// underlined in the submenu?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C19_Verifyteachsubmenu(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C19 - If you are viewing one of the pages in the Teach submenu, is that page underlined in the submenu?");
		extent.attachReporter(reporter);
		new HP_3Headerteach2(driver, node, prop).launchURL(URL).verifyteachmenu().verifytextisunderlined()
				.verifytextisunderlined1().verifytextisunderlined2().verifytextisunderlined3().verifytextisunderlined4()
				.verifytextisunderlined5().clickteachbuttonagain();
	}

}
