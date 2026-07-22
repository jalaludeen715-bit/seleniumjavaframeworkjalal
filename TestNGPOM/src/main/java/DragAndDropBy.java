

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropBy {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		//driver.get("https://letcode.in/draggable");

		driver.get("https://jqueryui.com/draggable/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//switch to frame

		driver.switchTo().frame(0);
		
		// selecting source and store in src variable
		
		WebElement src =driver.findElementById("draggable");
		
		// Actions interface for drag and drop by for drop the item when there is no specific target is available
		
		Actions builder = new Actions(driver);
		 
		builder.dragAndDropBy(src, 30, 45).perform(); // random x,y positions mentioned here 
		
		System.out.println("drag and drop completed");
		
		driver.quit();
		
		
		

	}

}
