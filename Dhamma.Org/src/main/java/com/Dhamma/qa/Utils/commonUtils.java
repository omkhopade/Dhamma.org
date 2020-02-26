package com.Dhamma.qa.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import com.Dhamma.qa.Base.TestBase;

public class commonUtils extends TestBase{
	
	
	public static final long pageload=40;
	public static final long implicit=20;
	
	public void smallwait() throws InterruptedException
	{
		Thread.sleep(3000);
	}

	public void mediumwait() throws InterruptedException
	{
		Thread.sleep(6000);
	}
	
	public void largewait() throws InterruptedException
	{
		Thread.sleep(10000);
	}
	
	
	public void searcholdstudent()
	{
		driver.findElement(By.xpath("//div[@id='course-search']//a[contains(text(),'For Old Students')]")).click();
	}
	
	
	public void windowSwitch()
	{
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> it= handler.iterator();
		String parentwindow = it.next();
		System.out.println(parentwindow);
		
		String childwindow=it.next();
		System.out.println(childwindow);
		
		driver.switchTo().window(childwindow);
		
		
	}
	
	public static Object[][] getTestData(String sheetName)
	{
			
			try {
				file =new FileInputStream("D:\\Selenium\\Automation Testing\\Dhamma.Org\\src\\main\\java\\com\\Dhamma\\qa\\Testdata\\TestData.xlsx");
			}
			catch (FileNotFoundException e) {
				
			}
			
			try {
				book=WorkbookFactory.create(file);
			}
			catch (InvalidFormatException e) {
				e.printStackTrace();
				}
			catch (IOException e) {
				// TODO: handle exception
			}
			
			sheet=book.getSheet(sheetName);
			Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for(int k=0;k<sheet.getRow(0).getLastCellNum();i++)
				{
					data[i][k]=sheet.getRow(i+1).getCell(k).toString();
					System.out.println(data[i][k]);
				}
					
			}
			
			return data;
	}
	
	
	
}
