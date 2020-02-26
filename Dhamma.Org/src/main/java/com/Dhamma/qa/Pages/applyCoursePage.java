package com.Dhamma.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dhamma.qa.Base.TestBase;

public class applyCoursePage extends TestBase{ 


	@FindBy(xpath="//select[@id='item_60']")
	WebElement selectcountry;
	@FindBy(xpath="//input[@id='item_114']")
	WebElement term_and_condition;
	@FindBy(xpath="//button[@id='next_button']")
	WebElement nextbtn;
	@FindBy(xpath="//input[@id='item_1-1'and @value='M']")
	WebElement gender;
	@FindBy(xpath="//button[@id='next_button']")
	WebElement nextbtn1;



	public applyCoursePage ()  // Constructor to create object
	{
		PageFactory.initElements(driver, this);
	}



	
	@SuppressWarnings("deprecation")
	public ApplicantForm courseapllication(String value1, String gender1,String choose1,String country1) throws InterruptedException 
	{
		
		/////////////Course Selected////////////////////
		//Thread.sleep(5000);
		List<WebElement> list=driver.findElements(By.xpath("//input[@type='radio']"));
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getAttribute("value").equals(value1))
			{
				list.get(i).click();
				break;
			}
		}

		System.out.println("click on 10 day course");


		///////////////////Choose option selected///////////////////
		List<WebElement> list1=driver.findElements(By.xpath("//input[@type='radio']"));
		for(int i=0;i<list1.size();i++)
		{
			if(list1.get(i).getAttribute("value").equals(choose1))
			{
				list1.get(i).click();
				break;
			}
		}
		System.out.println("clicked on choose"); 

		/////////////Gender Selected/////////////////////


		js.executeScript("arguments[0].scrollIntoView();",gender);
		Thread.sleep(2000);
		List<WebElement>list2=driver.findElements(By.xpath("//input[@type='radio']")); 
		for(int i=0;i<list2.size();i++) 
		{
			if(list2.get(i).getAttribute("value").equals(gender1)) 
			{
				list2.get(i).click(); 
				break;
			} 
		}
		System.out.println("Gender is selected"); 

		////////////Select Country ////////////////
		Select select=new Select(selectcountry); //Select and Actions is class
		select.selectByVisibleText(country1);
		System.out.println("Country has been selected");

		/////////Term and condition selected /////////////
		js.executeScript("arguments[0].scrollIntoView();",term_and_condition);
		term_and_condition.click();
		System.out.println("terms and condition are selected");

		js.executeScript("arguments[0].scrollIntoView();",nextbtn);
		Thread.sleep(2000);
		nextbtn.click();
		System.out.println("Next button is selected");
		
		js.executeScript("arguments[0].scrollIntoView();", nextbtn1);
		Thread.sleep(3000);
		nextbtn1.click();
		System.out.println("Next Button on Technique page is seleceted");
		

		return new ApplicantForm();

	}

	

}
