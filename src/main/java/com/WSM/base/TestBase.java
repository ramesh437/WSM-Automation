package com.WSM.base;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver ;
	
	public static  WebDriver initialization(String browserName) {

	if(browserName.equals("chrome")){
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
	}
	else if(browserName.equals("ff")){
		WebDriverManager.firefoxdriver().setup();	
		driver = new FirefoxDriver(); 
	}
	else if(browserName.equals("ie")){
		WebDriverManager.iedriver().setup();	
		driver = new InternetExplorerDriver(); 
	}
	else if(browserName.equals("edge")){
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(); 
	}
	return driver;
	}
	
	public static void browsersettings() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
	}

	public static void destroy() {
		driver.close();
		driver.quit();
	}

	public static void waitUntilVisibilityOfElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static String takeScreenshotBase64() throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/"+ dateName+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		byte[] image=IOUtils.toByteArray(new FileInputStream(destination)); 
		return "data:image/png;base64,"+Base64.getEncoder().encodeToString(image);

	}

	
	
	
}
