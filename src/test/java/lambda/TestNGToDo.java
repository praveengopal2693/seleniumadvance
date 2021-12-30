package lambda;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class TestNGToDo {
//	public WebDriver driver;
		
	public String username = "vijipraveen18";
	  public String accesskey = "E6n7LpFEjCLpfwVJrUN9abeGU4dAY41nyzgrR8Ye22n3iR6NIk";
	  public RemoteWebDriver driver = null;
	  public String gridURL = "@hub.lambdatest.com/wd/hub";
	  boolean status = false;
	  @BeforeMethod
	@BeforeTest
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	     DesiredCapabilities capabilities = new DesiredCapabilities();
	      capabilities.setCapability("browserName", browser);
	      capabilities.setCapability("version", version);
	      capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get the any available one
	      capabilities.setCapability("build", "LambdaTestSampleApp");
	      capabilities.setCapability("name", "LambdaTestJavaSample");
	     
	      try {
	          driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	      } catch (MalformedURLException e) {
	          System.out.println("Invalid grid URL");
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	      }
	  }
/*
	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				
				System.setProperty("webdriver.chrome.driver","/Users/siriusit/Documents/LambdaTestNG-main/chromedriver");
						        driver = new  FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","/Users/siriusit/Documents/LambdaTestNG-main/chromedriver");
				driver=new ChromeDriver();
		//		driver.manage().window().maximize();
     	//		driver.get("http://automationpractice.com/index.php");
			} 
			
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}
*/	

	@Test(priority = 0)
	public void lamassignment() throws InterruptedException, IOException, AWTException
	{
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

		Homepage Home = new Homepage(driver);
	    Home.Homevalidations();
	    
	  
	    
	    String Logoutlink = driver.findElement(By.xpath("//a[@title='Log me out']")).getText();
		String expected_Logoutlink = "Sign out";

		Assert.assertTrue(Logoutlink.equals(expected_Logoutlink), "Success Logout link matched");
	    System.out.println("Success Logout link -Sign out- is displayed as expected");
	    
	    String Myaccountlink = driver.findElement(By.xpath("//span[normalize-space()='LT Automation']")).getText();
		String expected_Myaccountlink = "LT Automation";

		Assert.assertTrue(Myaccountlink.equals(expected_Myaccountlink), "Success Myaccount link matched");
	    System.out.println("Success Myaccount link -Sign out- is displayed as expected");
	    
	    driver.findElement(By.xpath("//a[@title='Log me out']")).click();
	}
	
	    @Test(priority = 1)
        public void lamassignment2() throws InterruptedException, IOException, AWTException
    	{
    		driver.manage().window().maximize();
    		driver.get("http://automationpractice.com/index.php");

    		driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
    		
    		//Get the Web Element corresponding to the field Business Email (Textfield)
    		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));

    		
    		//Get the Web Element corresponding to the Password Field 
    		WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));

    		
    		//Find the Sign me in button
    		WebElement signin = driver.findElement(By.xpath("//span[normalize-space()='Sign in']"));

    	
    	    email.sendKeys("test@yopmail.com");
    	    password.sendKeys("Test@2021");

    		signin.click();
    		
    		String error = driver.findElement(By.xpath("//li[normalize-space()='Authentication failed.']")).getText();
    		String expected_error = "Authentication failed.";

    	    Assert.assertTrue(expected_error.equals(error), "Error message matched");
    	   
    	    System.out.println("Unable to login and Error message is displayed as expected");
    		
    	}
	    
	  
		@Test(priority = 2)
		public void lamassignment3() throws InterruptedException, IOException, AWTException
		{
			driver.manage().window().maximize();
			driver.get("http://automationpractice.com/index.php");

			Homepage Home = new Homepage(driver);
		    Home.Homevalidations();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		  
		    driver.findElement(By.xpath("//a[@title='Women']")).click();
		
		    
		    WebDriverWait wait = new WebDriverWait(driver, 10);
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Faded Short Sleeve T-shirts']")));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		    
		    Actions builder = new Actions(driver);
		    WebElement product1 = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		    builder.moveToElement(product1);
		    builder.perform();
		   
		    	 
		 
		    
		    String Price1 = driver.findElement(By.xpath("//div[@class='product-image-container']//span[@class='price product-price'][normalize-space()='$16.51']")).getText();
		    System.out.println("The Price of the product in the product page is --- "+Price1);
		    

		    
		    
		    driver.findElement(By.cssSelector("a[href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=1&token=e394cf60bf8d54976f8d3232b5433234']")).click();
	
		    
		
   
		    String successmessage1 = driver.findElement(By.xpath("//span[normalize-space()='There is 1 item in your cart.']")).getText();
			String expected_message = "There is 1 item in your cart.";

		    Assert.assertTrue(successmessage1.equals(expected_message), "Success message matched");
	
		    System.out.println("Success message -There is 1 item in your cart.- is displayed as expected");
		    
		    driver.findElement(By.xpath("//span[@title='Continue shopping']//span[1]")).click();
		    
	
		    
		    driver.findElement(By.xpath("//i[@class='icon-th-large']")).click();
		  

		    WebElement secpro = driver.findElement(By.xpath("(//div[@class='product-container'])[2]"));

		    Actions action1 = new Actions(driver);
		    action1.moveToElement(secpro).perform();	
		    
		    String Price2 = driver.findElement(By.xpath("//div[@class='product-image-container']//span[@class='price product-price'][normalize-space()='$27.00']")).getText();
		    System.out.println("The Price of the product in the product page is --- "+Price2);
		    
     
		    
		    driver.findElement(By.cssSelector("a[href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=2&token=e394cf60bf8d54976f8d3232b5433234']")).click();


	    
		    String successmessage2 = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/h2/span[1]")).getText();
			String expected_message1 = "There are 2 items in your cart.";

		    Assert.assertTrue(successmessage2.equals(expected_message1), "Success message matched");
		    System.out.println("Success message -There are 2 items in your cart.- is displayed as expected");
		    
		    driver.findElement(By.xpath("//span[normalize-space()='Proceed to checkout']")).click();
		    

		    
		    System.out.println("Final price is displayed as expected with $50");
		   
		  
		    driver.findElement(By.cssSelector("a[href='http://automationpractice.com/index.php?controller=order&step=1']")).click();
		    driver.findElement(By.xpath("//*[@id='center_column']/form/p/button")).click();	 
		 
		    driver.findElement(By.xpath("//*[@id='form']/p/button")).click();
  
		 
		    

		  //Get handles of the windows
	        String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();

	        // Here we will check if child window has other child windows and will fetch the heading of the child window
	        while (iterator.hasNext()) {
	        String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                System.out.println("Child window is switched successfully ");
	                WebElement text = driver.findElement(By.xpath("//p[@class='fancybox-error']"));
	                System.out.println("Heading of child window is " + text.getText());
	            }
		    

            
            String popuperrormessage = driver.findElement(By.xpath("//p[@class='fancybox-error']")).getText();
			String expected_popuperror_message1 = "You must agree to the terms of service before continuing.";

		    Assert.assertTrue(popuperrormessage.equals(expected_popuperror_message1), "Success popup error message matched");
		    System.out.println("Success popup error message -You must agree to the terms of service before continuing.- is displayed as expected");
	        
    	    driver.findElement(By.xpath("//a[@title='Close']")).click();
    	    
    	    
            driver.findElement(By.xpath("//input[@id='cgv']")).click();
		    
		    driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();


		    String paymentmessage = driver.findElement(By.xpath("//h1[normalize-space()='Please choose your payment method']")).getText();
			String expected_payment_message1 = "PLEASE CHOOSE YOUR PAYMENT METHOD";

		    Assert.assertTrue(paymentmessage.equals(expected_payment_message1), "Success payment message matched");
		    System.out.println("Success payment message -PLEASE CHOOSE YOUR PAYMENT METHOD- is displayed as expected");
		    
		    driver.findElement(By.xpath("//a[@title='Log me out']")).click();
	        }    
		    
		}
		    
	
	@AfterTest
        public void terminateBrowser(){
            driver.close();
        }
	   
	}