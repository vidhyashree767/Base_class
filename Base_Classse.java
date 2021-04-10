package com.base_class;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Classse {
	public static WebDriver driver;
	public static WebElement close;


	// Browser Launch
	public static WebDriver getbrowser(String type) {
		if(type.equalsIgnoreCase("chrome")) {
	   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
	   driver= new ChromeDriver();
		
	}
		
	     else if (type.equalsIgnoreCase("firefox")) {
	     System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Driver//geckodriver.exe");
		  driver= new FirefoxDriver();
		
		 }
		driver.manage().window().maximize();
		return driver;
	}


	//get
	public static void get (String value) {
		driver.get(value);
			
	}

	//GetCurrentTitle
	public static void gettitle() {
		String title = driver.getTitle();
	    System.out.println(title);

	}

	//CurrentUrl
	public static  void getUrl() {
		String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
	}


	//QUIT
	public static void quit() {
		driver.quit();
		
		
	}

	//close
	public static void close() {
		driver.close();

	}
	//To

	public static  void toUrl(String valuee) {
		driver.navigate().to(valuee);

	}
	//FORWARD
	public static void forward() {
		driver.navigate().forward();

	}

	//Back
	public static void back() {
		driver.navigate().back();

	}


	//Refresh
	public static  void refresh() {
		driver.navigate().refresh();

	}
	// find element by id

	public static WebElement findelement( String locate ) {
		WebElement close = driver.findElement(By.id(locate));
	return close;

	}

	//find element by xpath

	public static WebElement findelementx(String locatee) {
		WebElement close = driver.findElement(By.xpath(locatee));
	return close;
	}

	//find element by class name

	public static WebElement findelementclass(String locateee ) {
		WebElement close = driver.findElement(By.className(locateee));
	return close;
	}

	//webelement method

	public static void inputvalue( WebElement element,String values) {
		element.sendKeys(values);
		
		

	}

	// get text
	public static void gettxt( WebElement element ) {
		element.getText();

	}





	//click
	public static void click(WebElement element) {
		element.click();
		

		
	}

	//clear
	public static void clear(WebElement element) {
		element.clear();

	}

	//is enabled

	public static void isenabled(WebElement element) {
		
	boolean enabled = element.isEnabled();
	System.out.println("Is Enabled"+ enabled);
	}

	//displayed

	public static void isdisplayed(WebElement element) {
		
		boolean displayed = element.isDisplayed();
		System.out.println("Is Displayed"+ displayed);
		

	}

	//Selected

	public static void isselected(WebElement element) {
		boolean selected = element.isSelected();
	System.out.println("Is Selected"+selected);
	}


	//Single downdown

	public static void singledropdown(WebElement element , String input, String type) {
		Select s = new Select(element) ;
	if (type.equalsIgnoreCase("value"))
	{
		s.selectByValue(input);
		
	} else if (type.equalsIgnoreCase("text")) {
		s.selectByVisibleText(input);
		
	} 

	else if (type.equalsIgnoreCase("Index")) {
		int index = Integer.parseInt(input);
		s.selectByIndex(index);
	}
		
	}

	// Robot class


	public static void robotclass(String type ) throws AWTException {
		Robot r= new Robot();
	if (type.equalsIgnoreCase("down")) {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}	
	else if (type.equalsIgnoreCase("enter")) {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	}

	//Actions


	/*public static void actions(WebElement element,String type) {
		
		Actions a=  new  Actions(driver);	
		if (type.equalsIgnoreCase("click")) { 
	    a.click(element).build().perform();
		}

	else if (type.equalsIgnoreCase("doubleclick")) {
		a.doubleClick(element).build().perform();
			
		}
		else if (type.equalsIgnoreCase("contextclick")) {
		a.contextClick(element).build().perform();
		}
			else if (type.equalsIgnoreCase("move to element")) {
			a.moveToElement(element).build().perform();
				
		}
			
		} */

//Actions
	
	
	public static void movetoelement(WebElement element) {
		Actions a= new Actions(driver);
		a.moveToElement(element).build().perform();

	}
	// alert


	public static void alert(String type) {
		
	Alert Alerts = driver.switchTo().alert();

	if (type.equalsIgnoreCase("accept")) {
		 Alerts.accept();
	}
	else if (type.equalsIgnoreCase("dismiss")) {
		Alerts.dismiss();
		
	}
	else if (type.equalsIgnoreCase("gettext")) {
		Alerts.getText();
		
	}
	}

	//screenshot

	public static  void screenshot( String destin) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
				File destination = new File(destin);
	FileUtils.copyFile(source, destination);
				
	}

	//Scroll up and scroll down



	public static void javascript(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}
	//Thread

public static void threadsleep(long min) throws Throwable {
	Thread.sleep(min);


}
	
	
	public static void frame(WebElement element, String type,String value) {
		if (type.equalsIgnoreCase("by index")) {
			int a =Integer.parseInt(value);
			driver.switchTo().frame(a);
			
		}
		
		else if (type.equalsIgnoreCase("by id")) {
			driver.switchTo().frame(value);
			
		}
		else if (type.equalsIgnoreCase("by element")) {
			driver.switchTo().frame(element);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
}
