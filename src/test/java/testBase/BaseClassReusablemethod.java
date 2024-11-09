package testBase;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class BaseClassReusablemethod {
	public Logger logger; //log4j 
	
	public Properties p;
	
	public static WebDriver driver;
	@Parameters({"os","browser"})

	@BeforeClass(groups= {"Sanity","Regression","master"})
	
	public void setup(String os,String br) throws IOException
	{
		
		//loading config.properties file 
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		//before driver we write code for log4j logs 
		logger = LogManager.getLogger(this.getClass());//manually getloger method we pass class name but for automation 
		//we pass the class by using this.getclass because at runtime every class is execute dynamiclly pass to logger method 
		//here we add the code for selenium grid enviorment
		if(p.getProperty("execution_eve").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			//we getting os from xml file so we didnt pass manually browser and OS
			//for OS
			
			if(os.equalsIgnoreCase("windows"))
			{
			cap.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("Linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("NO OS Match");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome":cap.setBrowserName("chrome");break;
			case "firefox":cap.setBrowserName("firefox");break;
			default:System.out.println("no matched browser");return;
			
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444"),cap);
			
			}
		
		if(p.getProperty("execution_eve").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome": driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "C:\\Chrome_web\\chromedriver-win64\\chromedriver.exe");
			break;
			case "firefox":driver= new FirefoxDriver(); break;
			default :System.out.println("Invalid browsert"); return; //using return because if brwoser is invalid we dont go for further execution
			}
			
		}
		
		
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//	driver.get("https://tutorialsninja.com/demo/"); //also we can access this url from config.property file 
		driver.get(p.getProperty("appurl")); //reading url from config.properties file
		driver.manage().window().maximize();

		
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","master"})
	public void teardown()
	{
		driver.quit();
		
	}
	
	public String capturescreen(String tname) throws IOException
	{
		String timestamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
	//	File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);
		File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);
		String targetfilepath = System.getProperty("user.dir")+"\\Screenshots\\"+tname+"_"+timestamp+".png";
		File targetfile  = new File(targetfilepath);
		sourcefile.renameTo(targetfile);
		return targetfilepath;
		
	}
	
	public String randomemail()
	{
		String randommail = RandomStringUtils.randomAlphabetic(5);
		return randommail;
	}
	
	public String rondomphoneno()
	{
		String genratephoneno = RandomStringUtils.randomNumeric(8);
		return genratephoneno;
		
	}
	public String randomfirstname()
	{
		String genratefirstname =RandomStringUtils.randomAlphabetic(5);
		return genratefirstname;
	}
	public String randomlastname()
	{
		String genratelastname =RandomStringUtils.randomAlphabetic(6);
		return genratelastname;
	}
	
	public String randompassword()
	{
		String genratepassword =RandomStringUtils.randomAlphanumeric(8);
		return genratepassword;
	}
	

}
