package Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utiity.helper;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}

	@BeforeSuite
	@Parameters({"browser"})
	public void StartDriver( @Optional("chrome")String browserName) 
	{
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver(chromeOption());
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver=new FirefoxDriver(firefoxOption());


		}
		//headless browser options
		else if (browserName.equalsIgnoreCase("headless")) {
			
			DesiredCapabilities caps =new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY ,
				 System.getProperty("user.dir")+"/Drivers/phantomjs.exe");
			String [] phantomsjsArg= {"--web-security=no","--ignore--ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomsjsArg);
			driver =new PhantomJSDriver(caps);
		}
		
		else if (browserName.equalsIgnoreCase("chromeheadles"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--windows-size=1920,1080");
			driver =new ChromeDriver(options);
					
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
  		driver.navigate().to("https://demo.nopcommerce.com/register");

	}
	
	
	 
	
	@AfterSuite
	public void closeDriver()
	{
		driver.quit();

	}

	//TakeScreenShot on Failure

	@AfterMethod
	public void ScreenShotOnFailure (ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{ 
			System.out.println("Faied TestCase");
			System.out.println("Taking ScreenSgot .....");
			helper.captureScreenShot(driver, result.getName());


		}
	}
	
	
}
