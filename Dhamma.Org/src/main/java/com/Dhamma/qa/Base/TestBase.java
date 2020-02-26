package com.Dhamma.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dhamma.qa.Utils.commonUtils;

public class TestBase {
	
	public static Properties pro;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public JavascriptExecutor js= (JavascriptExecutor) driver;
	public static Workbook book;
	public static Sheet sheet;
	public static FileInputStream file;
	
	
	
	
	public TestBase()    	// Initialization of constructor and accept properties
	{
		pro=new Properties();
		 try {
			FileInputStream file= new FileInputStream("D:\\Selenium\\Automation Testing\\Dhamma.Org\\src\\main\\java\\com\\Dhamma\\qa\\Configure\\Config.properties");
			pro.load(file);  			// load() is used load inputStreame file into properties.
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	}
	
	
	
	public void intialization()
	{
		
		if(pro.getProperty("Browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(pro.getProperty("Browser").equals("fireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Drivers\\geckodriver.exe");
			driver= new FirefoxDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(commonUtils.implicit, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(commonUtils.pageload, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(916,1023));    // by using this method we can customize size window
		driver.get("https://www.dhamma.org/en-US/courses/search");
		driver.findElement(By.xpath("//a[contains(text(),'Ok')]")).click();
		
	}
	
	
	

}
