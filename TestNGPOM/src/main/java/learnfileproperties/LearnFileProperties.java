package learnfileproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

//Properties file and it's usage
//we can give 
//1.locators value
//2.Read static data
//3.Project configuration
//
//How to Create new Property File?
//Right click on the project--New-- File-- select project--Enter file name with properties extention(Ex- "TestNGPOMFile.properties") ,Finish

public class LearnFileProperties {
	public static void main(String[] args) throws FileNotFoundException, IOException {


		Properties properties = new Properties();

		// 1.Eng property file
		//declare the property file location
		properties.load(new FileInputStream("./TestNGPOMFileEng.properties"));

		//getProperty(key) used to get the value of that specific key
		String propertyValue = properties.getProperty("welcome");

		System.out.println(propertyValue);

		// 2.French property file
		//declare the property file location
		properties.load(new FileInputStream("./TestNGPOMFileFrench.properties"));

		//getProperty(key) used to get the value of that specific key
		String propertyValue1 = properties.getProperty("welcome");

		System.out.println(propertyValue1);
		
		// 3.Sending login data through property file
		
		properties.load(new FileInputStream("./TestNGPOMLoginData.properties"));
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/" );
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByLinkText("Signup / Login").click();		
		
		driver.findElementByXPath("//input[@data-qa = 'login-email']").sendKeys(properties.getProperty("email"));
		driver.findElementByXPath("//input[@data-qa = 'login-password']").sendKeys(properties.getProperty("pass"));
				
		driver.findElementByXPath("//button[@data-qa = 'login-button']").click();
		
		
		
		
	}

}
