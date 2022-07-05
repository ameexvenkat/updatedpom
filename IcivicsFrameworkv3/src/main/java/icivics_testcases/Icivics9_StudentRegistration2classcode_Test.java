package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_StudentReg2classcode;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics9_StudentRegistration2classcode_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Student Registration2 Classcode ";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Studentregistration2classcode";
	}

	// C398 - Can you tell which page you are currently viewing in the breadcrumbs?

	@Test(dataProvider = "fetchData", priority = 0)
	public void C398_verifypagecount2(String URL) throws IOException, InterruptedException {
		node = test.createNode("C398 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.verifypagecount2();
	}
	// C399 - Can you select Back to proceed to the previous page?

	@Test(dataProvider = "fetchData", priority = 1)
	public void C399_Clickbackbutton(String URL) throws IOException, InterruptedException {
		node = test.createNode("C399 - Can you select Back to proceed to the previous page?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.verifyClickbackbutton();
	}
	// C400 - When you go Back, are your entries in all fields remembered?

	@Test(dataProvider = "fetchData", priority = 2)
	public void C400_verifyfieldsisremembered(String URL) throws IOException, InterruptedException {
		node = test.createNode("C400 - When you go Back, are your entries in all fields remembered?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.Clickbackbutton().verifyclasscoderemembered().verifyfirstnameremembered().verifylastnameremembered()
				.verifyemailremembered().verifyemailfieldremembered();
	}
	// C403- If you select the 'Terms of Use' link, does the iCivics Terms of Use
	// page open in a new tab?

	@Test(dataProvider = "fetchData", priority = 3)
	public void C403_clickontermsofuselink(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C403- If you select the 'Terms of Use' link, does the iCivics Terms of Use page open in a new tab");
		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.clickontermsofuselink();
	}
	// C404- If you select the 'Privacy Policy' link, does the iCivics Privacy
	// Policy page open in a new tab?

	@Test(dataProvider = "fetchData", priority = 4)
	public void C404_clickprivacypolicy(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C404- If you select the 'Privacy Policy' link, does the iCivics Privacy Policy page open in a new tab?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.clickprivacypolicy();
	}
	// C405- As a student, are you NOT prompted to sign up for the newsletter?


		@Test(dataProvider = "fetchData", priority = 5)
		public void C405_verifypage2SignUpforEmailsfield(String URL) throws IOException, InterruptedException {
			node = test.createNode(
					"C405- As a student, are you NOT prompted to sign up for the newsletter?");
			extent.attachReporter(reporter);
			new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
					.verifypage2noemailsubscriptioncheckbox() ;
		}
	// C408- If you hover over the password field, do you see a hover tooltip with
	// appropriate text?

	@Test(dataProvider = "fetchData", priority = 6)
	public void C408_hoveronpwdfield(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C408- If you hover over the password field, do you see a hover tooltip with appropriate text?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.hoveronpwdfield();
	}
	// C409- When you enter text in the Password field, do you see text indicating
	// the current password's strength?

	@Test(dataProvider = "fetchData", priority = 7)
	public void C409_VerifyPasswordstrengthmeter(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C409- When you enter text in the Password field, do you see text indicating the current password's strength?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.VerifyPasswordstrengthmeter();
	}
	// C410- When you enter text in the Confirm Password field do you see text
	// indicating whether the two passwords match?

	@Test(dataProvider = "fetchData", priority = 8)
	public void C410_VerifyPasswordindicatormatch(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C410- When you enter text in the Confirm Password field do you see text indicating whether the two passwords match?");
		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.VerifyPasswordindicatormatch();
	}
	// C412- If you leave a required field blank and select Next, do you receive an
	// appropriate error message?

	@Test(dataProvider = "fetchData", priority = 9)
	public void C412_verifyenterinvaliddata(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C412- If you leave a required field blank and select Next, do you receive an appropriate error message?");

		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata().
		verifyblankerrormsgforpwdandcpwd().verifyenterinvaliddataerror();
	}
	// C412- You must check terms of use and privacy

	@Test(dataProvider = "fetchData", priority = 10)
	public void C412_verifytermsofuseandprivacycheckbox(String URL) throws IOException, InterruptedException {
		node = test.createNode("C412- You must check terms of use and privacy");

		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.verifytermsofuseandprivacycheckbox();
	}
	// C413- Do all error messages display correctly?

	@Test(dataProvider = "fetchData", priority = 11)
	public void C413_verifyblankerrormsg(String URL) throws IOException, InterruptedException {
		node = test.createNode("C413- Do all error messages display correctly?");

		extent.attachReporter(reporter);
		new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
				.verifyblankerrormsg();
	}
	// C414- If you fill out all required fields with valid information and select
		// Finish, are you taken to Page 3?

		@Test(dataProvider = "fetchData", priority = 12)
		public void C414_verifypage3loaded(String URL) throws IOException, InterruptedException {
			node = test.createNode(
					"C414- If you fill out all required fields with valid information and select Finish, are you taken to Page 3?");

			extent.attachReporter(reporter);
			new Icivics_StudentReg2classcode(driver, node, prop).launchstudentURL(URL).verifyregistrationwithvaliddata()
					.verifypage3loaded();
		}
}
