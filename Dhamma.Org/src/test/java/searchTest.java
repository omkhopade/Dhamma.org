import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dhamma.qa.Base.TestBase;
import com.Dhamma.qa.Pages.applyCoursePage;
import com.Dhamma.qa.Pages.searchPage;
import com.Dhamma.qa.Utils.commonUtils;



public class searchTest extends TestBase{


	searchPage Se;
	commonUtils cm;
	applyCoursePage ac;


	public searchTest()
	{
		super();

	}


	@BeforeMethod
	public void setUp()
	{
		intialization();
		Se=new searchPage();
		cm=new commonUtils();

	}

	@Test(priority = 1 ,description = "This is methpd of course period",enabled = true)   
	public void selectDateTest() throws InterruptedException
	{
		cm.searcholdstudent();
		cm.mediumwait();
		ac=Se.applyCourse(pro.getProperty("fmonth"),pro.getProperty("fyear"),pro.getProperty("fday"),pro.getProperty("tmonth"),pro.getProperty("tyear"),pro.getProperty("tday"),pro.getProperty("country"),pro.getProperty("language"),pro.getProperty("course"),pro.getProperty("gender"),pro.getProperty("work"));  // lick on apply and navigate to the next page

	}
	@AfterMethod
	public void tearOff() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}


}
