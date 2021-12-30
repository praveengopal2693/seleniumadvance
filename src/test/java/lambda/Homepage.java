package lambda;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.awt.AWTException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Homepage {
	
	public static WebDriver driver;
	
	public void Homevalidations() throws InterruptedException, IOException, AWTException
	   {
		   this.automation();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	   
	 }

	
    public Homepage(WebDriver driver )
    {
       Homepage.driver= driver;  	
    }

	public void automation() throws InterruptedException
	{
		
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Sign in']")));
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
		
		//Get the Web Element corresponding to the field Business Email (Textfield)
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));

		
		//Get the Web Element corresponding to the Password Field 
		WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));

		
		//Find the Sign me in button
		WebElement signin = driver.findElement(By.xpath("//span[normalize-space()='Sign in']"));

	
	    email.sendKeys("lt.testautomation21@gmail.com");
	    password.sendKeys("Test@2021");

		signin.click();
		
		
	}
}
