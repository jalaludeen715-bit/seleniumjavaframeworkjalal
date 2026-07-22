package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Extent Reports
//1.add extent reports maven dependency in pom.xml
//2.Create blank html page (ExtentSparkReporter)
//3.create report (ExtentReports)
//4.attach report in the blank html page
//5.Create entry for each test case 
//6.save the report 

public class Report {

	public static void main(String[] args) {
		
		// 1.to create blank HTML report in the name of Test Report.html

		ExtentSparkReporter reporter = new ExtentSparkReporter("./Test Report.html");

		// 2.create reports

		ExtentReports extent = new ExtentReports();

		// 3.attach extent report in the blank html page
		extent.attachReporter(reporter);

		// 4.create Test

		ExtentTest test = extent.createTest("TC001-Login");

		test.pass("enter credentials");
		test.pass("Login Successful");
		test.assignAuthor("JALAL");
		test.assignCategory("Smoke");
		
		//5.save the report

		extent.flush();

	}

}
