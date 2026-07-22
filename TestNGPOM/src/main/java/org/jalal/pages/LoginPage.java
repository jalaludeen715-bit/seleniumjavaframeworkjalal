package org.jalal.pages;

import org.jalal.baseclass.BaseClass;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends BaseClass {
	
 // RemoteWebDriver driver = null; 
  
	public LoginPage(RemoteWebDriver driver) {
		
		this.driver = driver;		
	}
	
  //Actions -- what actions we are going to perform in this page
  
  public LoginPage enterUserName(String user)
  {
	driver.findElementByXPath("//input[@data-qa = 'login-email']").sendKeys(user);
	
	return this; // same page means give return this, it will prompt to change return to class name(LoginPage) instead of void

}
  
  public LoginPage enterPassWord(String pass) 
  {
	  driver.findElementByXPath("//input[@data-qa = 'login-password']").sendKeys(pass);
	  return this;
  }
  
  public home clickLogin() 
  {
	  driver.findElementByXPath("//button[@data-qa = 'login-button']").click();
	  return new home(); // if we navigate to new page give return new pagename
  }
  
  
  // this function is used to do login directly and move to next page,no need to perform each and every step above for all test cases 
  public void login(String user, String pass)
  {
	  enterUserName(user);
	  enterPassWord(pass);
	  clickLogin();
	 // return home;
  }
  
  
  
}
