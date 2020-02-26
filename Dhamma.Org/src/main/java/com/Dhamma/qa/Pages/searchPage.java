package com.Dhamma.qa.Pages;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dhamma.qa.Base.TestBase;

public class searchPage extends TestBase{


	@FindBy(id="course-search-date-range")
	WebElement seachbox;


	@FindBy(xpath="//div[@class='calendar-container left']//select[@class='monthselect']")
	WebElement Fselmonth;


	@FindBy(xpath="//div[@class='calendar-container left']//select[@class='yearselect']")
	WebElement Fselyear;



	@FindBy(xpath="//div[@class='calendar-container right']//select[@class='monthselect']")
	WebElement Tselmonth;


	@FindBy(xpath="//div[@class='calendar-container right']//select[@class='yearselect']")
	WebElement Tselyear;


	@FindBy(xpath="//div[@class='calendar-container right']//tbody//tr//td[contains(text(),'3')]")
	WebElement Tselday;

	@FindBy(xpath="//button[contains(text(),'Confirm')]")
	WebElement confirmbtn;


	@FindBy(id="s2id_autogen1")
	WebElement searchCountry;

	@FindBy(id="s2id_autogen2")
	WebElement language;

	@FindBy(id="s2id_autogen3")
	WebElement courseType;

	@FindBy(id="s2id_autogen4")
	WebElement gender;

	@FindBy(how=How.ID,using = "s2id_autogen5")    // another way to find element from webpage.
	//@FindBy(id="s2id_autogen5")
	public WebElement attend;      // we can provides access specifiers to the WebElement.




	@FindBy(xpath="//a[@class='btn btn-apply center']")
	WebElement searchbtn;


	@FindBy(xpath="//*[@id='course-search-results']/div[16]/div[1]/div/a[1]")
	WebElement apply;


	public searchPage()
	{
		PageFactory.initElements(driver, this);   	//initialization of page object.  this is page class object
	}


	public applyCoursePage applyCourse(String fmonth , String fyear, String fday, String tmonth, String tyear, String tday, String country, String lang, String course, String genders, String work) throws InterruptedException
	{
		seachbox.click();    // Click on Calendar text box


		//////// Select month from left calendar /////////
		Select month=new Select(Fselmonth);   
		month.selectByVisibleText(fmonth);
		System.out.println("fmonth select");

		////////Select month from left calendar /////////
		Select year=new Select(Fselyear);
		year.selectByValue(fyear);
		System.out.println("fyear select");


		//////Select Day from left calendar//////////
		driver.findElement(By.xpath("//div[@class='calendar-container left']//table//tbody/tr/td[contains(text(),"+fday+")]")).click();                        
		System.out.println("fday select");


		///////Select month from right calendar//////////
		Select month1=new Select(Tselmonth);
		month1.selectByVisibleText(tmonth);
		System.out.println("tmonth select");


		//////Select year from right calendar/////////
		Select year1=new Select(Tselyear);
		year1.selectByVisibleText(tyear);
		System.out.println("tyear select");

		//////Select day from right calendar//////////
		driver.findElement(By.xpath("//div[@class='calendar-container right']//div[2]//tr//td[contains(text(),"+tday+")]")).click();
		System.out.println("tday select");

		/////Click on confirmation button//////
		js.executeScript("arguments[0].scrollIntoView();", confirmbtn);
		Thread.sleep(2000);
		confirmbtn.click();
		System.out.println("confirmation btn clicked");

		//////Click on country text box/////////
		searchCountry.click();
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='select2-results']//ul//li"));
		System.out.println("Total no of country in list is: " +list.size());
		for(int i=1;i<list.size();i++)
		{
			if(list.get(i).getText().equals(country))
			{

				list.get(i).click();
				break;					// use break statement to terminate loop here only if we does not break if then test case gets failed

			}
		}
		System.out.println("country has been select");

		/////////Click on language text box ///////////
		language.click();
		List<WebElement> list1=driver.findElements(By.xpath("//div[@id='select2-drop']//ul//li"));
		System.out.println("Total no of language in list is: "+list1.size());

		for(int i=1;i<list1.size();i++)
		{
			if(list1.get(i).getText().equals(lang))
			{

				list1.get(i).click();
				break;						// use break statement to terminate loop here only if we does not break if then test case gets failed
			}

		}
		System.out.println("Language has beens select");

		/////////////Select Course Type //////
		courseType.click();
		List<WebElement> list2= driver.findElements(By.xpath("//div[@id='select2-drop']/ul/li"));
		System.out.println("Total no of course in list is: "+list2.size());

		for(int i=0;i<list2.size();i++)
		{
			if(list2.get(i).getText().equals(course))
			{
				list2.get(i).click();
				break;						// use break statement to terminate loop here only if we does not break if then test case gets failed
			}
		}
		System.out.println("course type has been selected");

		/////////////Select Gender//////////////////
		gender.click();	
		List<WebElement> list3= driver.findElements(By.xpath("//div[@id='select2-drop']//ul[@class='select2-results']/li"));
		System.out.println("Total no of Gender in list is: "+list3.size());
		for(int i=0;i<list3.size();i++)
		{
			if(list3.get(i).getText().equals(genders))
			{
				list3.get(i).click();
				break;   				// use break statement to terminate loop here only if we does not break if then test case gets failed
			}
		}
		System.out.println("Gender has beeen selected");

		/////////Select attend OR serve type //////////////
		attend.click();
		List<WebElement> list4= driver.findElements(By.xpath("//div[@id='select2-drop']//ul[@class='select2-results']/li"));
		System.out.println("Total no of work in list is: "+list4.size());

		for(int i=0;i<list4.size();i++)
		{
			if(list4.get(i).getText().equals(work))
			{
				list4.get(i).click();
				break;					// use break statement to terminate loop here only if we does not break if then test case gets failed
			}
		}

		//////////Search list of courses to apply//////////
		searchbtn.click();

		/////////////Navigate to the other window/////////////////
		js.executeScript("arguments[0].scrollIntoView();", apply);
		Thread.sleep(2000);
		apply.click();
		return new applyCoursePage();
	}



}
