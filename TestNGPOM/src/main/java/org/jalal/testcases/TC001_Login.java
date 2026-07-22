package org.jalal.testcases;

import org.jalal.baseclass.BaseClass;
import org.jalal.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_Login extends BaseClass {
	
	@BeforeTest
	public void setData()
	{
		fileName = "TC001";
	}
	
	@Test(dataProvider = "data")
	public void loginTest(String[] data) {
	
	LoginPage lp = new LoginPage(driver);
	lp.enterUserName(data[0]);
	lp.enterPassWord(data[1]);
	lp.clickLogin();
	

}
	
}
