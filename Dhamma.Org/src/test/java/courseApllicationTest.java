import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dhamma.qa.Base.TestBase;
import com.Dhamma.qa.Pages.ApplicantForm;
import com.Dhamma.qa.Pages.applyCoursePage;
import com.Dhamma.qa.Pages.searchPage;
import com.Dhamma.qa.Utils.commonUtils;

public class courseApllicationTest extends TestBase{
	applyCoursePage applycourse;
	commonUtils common;
	searchPage search;
	ApplicantForm applicant;
	

	public courseApllicationTest()
	{
		super();

	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		intialization();
		applycourse=new applyCoursePage();
		common=new commonUtils();
		common.searcholdstudent();
		common.mediumwait();
		search=new searchPage();
		applycourse=search.applyCourse(pro.getProperty("fmonth"),pro.getProperty("fyear"),pro.getProperty("fday"),pro.getProperty("tmonth"),pro.getProperty("tyear"),pro.getProperty("tday"),pro.getProperty("country"),pro.getProperty("language"),pro.getProperty("course"),pro.getProperty("gender"),pro.getProperty("work"));
		common.windowSwitch();
	}

	@Test(priority = 1)
	public void verifycourseApplication() throws InterruptedException

	{

		applicant=applycourse.courseapllication(pro.getProperty("value"),pro.getProperty("gender1"),pro.getProperty("choose1"),pro.getProperty("country1"));
	}
	
	


	@AfterMethod
	public void tearoff() throws InterruptedException {

		common.mediumwait();
		driver.quit();
	}

}
