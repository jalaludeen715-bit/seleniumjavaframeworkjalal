package org.jalal.baseclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ReadExcelIntegrationwithDataProvider;

public class BaseClass {
	
	public RemoteWebDriver driver = null;
	
	public String fileName = null;
	
	String url = "https://automationexercise.com/login" ;
	
	@DataProvider(name ="data")
	public String[][] dataProvider() throws IOException
	{
		String [][] excelData= ReadExcelIntegrationwithDataProvider.getExcelData("TC001");
		return excelData;
	}
	
	@BeforeMethod
	public void startApp()
	
	{		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	@AfterMethod
	
	public void stopApp()
	
	{
		driver.quit();
	}

}
