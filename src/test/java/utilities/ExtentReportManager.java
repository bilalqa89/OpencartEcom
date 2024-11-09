package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

//import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Date;

//import org.testng.IDynamicGraph.Status;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClassReusablemethod;


public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkreporter ; // ui of report
	public ExtentReports extent ;//populate common info of report 
	public ExtentTest test;//creating test case entries in the report and update 
	String repname;
	 public void onStart(ITestContext testcontext) {
		 
			/*
			 * SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss"); Date dt =
			 * new Date(); String currentdattimestamp = df.format(dt);
			 */
		 
		  //  String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		     String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		    repname = "Test-Report-"+timestamp+".html"; //genrating report name with data and time
		    sparkreporter = new ExtentSparkReporter(".\\Reports\\"+repname);
		    sparkreporter.config().setDocumentTitle("Open Cart Automation Report");//title of report 
			sparkreporter.config().setReportName("Functional testing");//report name 
			sparkreporter.config().setTheme(Theme.DARK);//set color for report theme
			extent = new ExtentReports();
			extent.attachReporter(sparkreporter);//connecting to ui along with populated infromation
			extent.setSystemInfo("Application","open cart");
			extent.setSystemInfo("Enviorment", "QA");
			extent.setSystemInfo("User Name",System.getProperty("user.name"));
			String os = testcontext.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating system", os);
			String browser= testcontext.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser", browser);
			List<String> includegroups = testcontext.getCurrentXmlTest().getIncludedGroups();
			if(!includegroups.isEmpty())
			{
				extent.setSystemInfo("Groups",includegroups.toString());
			}   
		  }
	  public void onTestSuccess(ITestResult result) {
		  
		  test = extent.createTest(result.getTestClass().getName());
		  test.assignCategory(result.getMethod().getGroups());
		  test.log(Status.PASS, result.getName()+"Executed successfully");
		  //test.log(Status.PASS,"Test Case Passed is:"+result.getName());
		    
		  }
	  
	  public void onTestFailure(ITestResult result) {
		  test = extent.createTest(result.getTestClass().getName());
		  test.assignCategory(result.getMethod().getGroups());
		  test.log(Status.FAIL,result.getName()+"got failed");
		 // test.log(Status.FAIL,result.getName()+"got failed");
			 test.log(Status.INFO,result.getThrowable().getMessage());
			 try 
			 {
				 String imgpath = new BaseClassReusablemethod().capturescreen(result.getName()); //this statment invoke capture scereen method from baseclss
				 //and passing the name result.getnamr() it will return the image path 
				 test.addScreenCaptureFromPath(imgpath);
				 
			 }
			 catch(IOException e1)
			 {
				 e1.printStackTrace();
			 }
		  }
	  public void onTestSkipped(ITestResult result) {
		  test = extent.createTest(result.getTestClass().getName());
		  test.assignCategory(result.getMethod().getGroups());
		  test.log(Status.FAIL,result.getName()+"got skipped");
		 // test.log(Status.FAIL,result.getName()+"got failed");
			 test.log(Status.INFO,result.getThrowable().getMessage()); 
		  }
	  public void onFinish(ITestContext context) {
		    extent.flush();
		    String Pathofextentreport = System.getProperty("user.dir")+"\\Reports\\"+repname;
		    File extentreport = new File(Pathofextentreport);
		    try
		    {
		    	Desktop.getDesktop().browse(extentreport.toURI()); //open the report automatically we dont need to open manually
		    } catch(IOException e)
		    {
		    	e.printStackTrace();
		    }
		  
		  }
	  
	

}
