package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public abstract class Reporter extends AbstractTestNGCucumberTests {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public ExtentTest test, node;
	public Properties prop;
	protected static File file;
	
	public String testCaseName, testDescription, nodes, authors,category, propname;
	public String excelFileName;
	
	@BeforeSuite
	public void startReport() {
		String date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
		file = new File("./reports/"+date);
		if(!file.exists()) {
			System.out.println("Exists? "+file.exists());
			file.mkdir();
		}
		spark = new ExtentSparkReporter(file.toString()+"./result.html");
		spark.config().setDocumentTitle("ICIVICS TEST REPORT");
		spark.config().setReportName("ICIVICS AUTOMATION DASHBOARD"); 
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
    @BeforeClass
	public void report() throws IOException {
		test = extent.createTest(testCaseName);
		test.assignAuthor(authors);
		test.assignCategory(category);  
	}
    
    public abstract long takeSnap();
    public void reportStep(String dec, String status,boolean bSnap ) {
    	Media img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){
			long snapNumber = 100000L;
			snapNumber = takeSnap();
			img = MediaEntityBuilder.createScreenCaptureFromPath("./../images/"+snapNumber+".jpg").build();
		}
    	if(status.equalsIgnoreCase("pass")) {
    		node.pass(dec, img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		node.fail(dec, img);
    	}
    }
    
    public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

    @AfterSuite
    public void stopReport() {
    	extent.flush();
    }
}














