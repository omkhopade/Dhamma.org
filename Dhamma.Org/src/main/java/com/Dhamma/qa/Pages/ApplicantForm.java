package com.Dhamma.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Dhamma.qa.Base.TestBase;

public class ApplicantForm extends TestBase{


	@FindBy(xpath="//input[@name='items[item_2]']")
	WebElement firstName;

	@FindBy(xpath="//input[@name='items[item_3]']")
	WebElement LastName;

	@FindBy(xpath="//input[@name='items[item_10]")
	WebElement Address;

	@FindBy(xpath="//input[@name='items[item_11]']")
	WebElement city;

	@FindBy(xpath="//input[@name='items[item_13]']")
	WebElement zip;

	@FindBy(xpath="//input[@name='items[item_106]']")
	WebElement age;

	@FindBy(xpath="//input[@name='items[item_65]']")
	WebElement occupation;

	@FindBy(xpath="//input[@name='items[item_247]']")
	WebElement email;

	@FindBy(xpath="//input[@id='phone_item_61']")
	WebElement homePhone;

	@FindBy(xpath="//input[@id='phone_item_63']")
	WebElement mobilePhone;

	@FindBy(xpath="//input[@id='phone_item_62']")
	WebElement workPhone;

	@FindBy(xpath="//input[@name='items[item_75]']")
	WebElement coursedate1;

	@FindBy(xpath="//input[@name='items[item_76]']")
	WebElement location1;

	@FindBy(xpath="//input[@name='items[item_77]']")
	WebElement teacher1;

	@FindBy(xpath="//input[@name='items[item_79]']")
	WebElement coursedate2;

	@FindBy(xpath="//input[@name='items[item_80]']")
	WebElement location2;

	@FindBy(xpath="//input[@name='items[item_81]']")
	WebElement teacher2;

	@FindBy(xpath="//input[@name='items[item_104]']")
	WebElement name;

	@FindBy(xpath="//button[@id='accept_button']")
	WebElement agree;



	public ApplicantForm()
	{
		PageFactory.initElements(driver, this);
	}


	public void ApplicantFormPage(String fname, String lname, String add, String ct, String zp, String ag, String occ, String em, String hp, String mp, String wp, String c1, String l1, String t1, String c2, String l2, String t2, String nm, String state, String country, String plang, String prolang, String day1, String month1, String year1, String radio1)
	{
		firstName.sendKeys(fname);
		LastName.sendKeys(lname);
		Address.sendKeys(add);
		city.sendKeys(ct);
		Select sel=new Select(driver.findElement(By.xpath("//select[@id='item_12']")));
		sel.selectByVisibleText(state);
		zip.sendKeys(zp);
		Select sel1 =new Select(driver.findElement(By.xpath("//select[@id='item_60']")));
		sel1.selectByVisibleText(country);
		Select sel2= new Select(driver.findElement(By.xpath("//select[@id='item_15']")));
		sel2.selectByVisibleText(plang);
		Select sel3= new Select(driver.findElement(By.xpath("//select[@id='item_526_language_en']")));
		sel3.selectByVisibleText(prolang);
		age.sendKeys(ag);
		Select day= new Select(driver.findElement(By.xpath("//select[@id='item_107_day']"))); 
		day.selectByVisibleText(day1);
		Select month=new Select(driver.findElement(By.xpath("//select[@id='item_107_month']")));
		month.selectByVisibleText(month1);
		Select year= new Select(driver.findElement(By.xpath("//select[@id='item_107_year']")));
		year.selectByVisibleText(year1);
		occupation.sendKeys(occ);
		email.sendKeys(em);
		homePhone.sendKeys(hp);
		mobilePhone.sendKeys(mp);
		workPhone.sendKeys(wp);
		coursedate1.sendKeys(c1);
		location1.sendKeys(l1);
		teacher1.sendKeys(t1);
		coursedate2.sendKeys(c2);
		location2.sendKeys(l2);
		teacher2.sendKeys(t2);

		List<WebElement> list= driver.findElements(By.xpath("//input[@type='radio' and @name='items[item_638]']"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getAttribute("value").equals(radio1))
			{
				list.get(i).click();
				break;

			}
		}

		List<WebElement> list1= driver.findElements(By.xpath("//input[@type='radio' and @name='items[item_639]']"));
		System.out.println(list1.size());
		for(int i=0;i<list1.size();i++)
		{
			if(list1.get(i).getAttribute("value").equals(radio1))
			{
				list1.get(i).click();
				break;

			}
		}

		List<WebElement> list2= driver.findElements(By.xpath("//input[@type='radio' and @name='items[item_653]']"));
		System.out.println(list2.size());
		for(int i=0;i<list2.size();i++)
		{
			if(list2.get(i).getAttribute("value").equals(radio1))
			{
				list2.get(i).click();
				break;

			}
		}

		List<WebElement> list3= driver.findElements(By.xpath("//input[@type='radio' and @name='items[item_659]']"));
		System.out.println(list3.size());
		for(int i=0;i<list3.size();i++)
		{
			if(list3.get(i).getAttribute("value").equals(radio1))
			{
				list3.get(i).click();
				break;

			}
		}

		List<WebElement> list4= driver.findElements(By.xpath("//input[@type='radio' and @name='items[item_92]']"));
		System.out.println(list4.size());
		for(int i=0;i<list4.size();i++)
		{
			if(list4.get(i).getAttribute("value").equals(radio1))
			{
				list4.get(i).click();
				break;

			}
		}

		List<WebElement> list5= driver.findElements(By.xpath("//input[@type='radio' and @name='items[item_91]']"));
		System.out.println(list5.size());
		for(int i=0;i<list5.size();i++)
		{
			if(list5.get(i).getAttribute("value").equals(radio1))
			{
				list5.get(i).click();
				break;

			}
		}

		driver.findElement(By.xpath("//input[@id='item_240']")).click();

		name.sendKeys(nm);

		agree.click();
	}


}
