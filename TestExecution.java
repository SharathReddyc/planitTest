package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.FirstPage;
import pageObjects.LoginPage;
import pageObjects.NavigationPage;
import resources.base;

public class TestExecution extends base{
	public WebDriver driver;
	
	
	NavigationPage np=new NavigationPage(driver);
	
	//Method to Initialize driver and navigate to url
	@BeforeTest
	public void initialize() throws IOException
	{
		
		 driver =initializeDriver();    
		 driver.get(prop.getProperty("url")); //getting url from properties file
		 driver.manage().window().maximize();

	}
	
	//Method to Login and validate successfull login
	@Test(priority = 0)
	public void logintoApplication() throws IOException
	{

	try {
		FirstPage fp= new FirstPage(driver);
		LoginPage lp=new LoginPage(driver);
		fp.getloginUrl().click();   //Clicking login link
		String WelcomeText=lp.getwelcomeText().getText();
		//compare the text from the browser with actual text.
		 System.out.println("Text is : " +WelcomeText);
		Assert.assertEquals(WelcomeText, "Welcome, Please Sign In!");
		
		
		lp.getEmail().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		lp.getLogin().click();
		System.out.println("Login Successfull!!!");
	}catch(Exception e) {
		System.out.println(e);
	}
		
		
		}
	
	@Test(priority = 1)
	public void AddItemstoCart() {
		
		try {
			//Validating the account ID after login
			NavigationPage np=new NavigationPage(driver);
			String AccountID=np.getAccountId().getText();
			System.out.println("Account ID: " +AccountID);
			Assert.assertEquals(AccountID, "testdemowebshop@gmail.com");
			System.out.println("Account ID is validated");
			
			//Clicking on Books and selecting a book
			np.getBooks().click();
			np.getSelectBook().click();
			String Price=np.getPrice().getText();
			System.out.println("Price of Book: "+Price);
			
			//Adding 3 books to cart 
			np.getQuantity().clear();
			np.getQuantity().sendKeys("3");
			np.getAddtoCart().click();
			System.out.println("Added Books to Cart");
			String NavBarMessage=np.getNavBarMessage().getText();
			System.out.println("Message after books added: " +NavBarMessage);
			Assert.assertEquals(NavBarMessage, "The product has been added to your shopping cart");
			System.out.println("Success message afetr books added to cart is validated");
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Performing cart transactions
	@Test(priority = 2)
	public void PerformCartTransactions() {
		
		try {
			NavigationPage np=new NavigationPage(driver);
			np.getShoppingcart().click();
			np.getCheckBox_TM().click();
			np.getCheckout().click();
			
			//Selecting New Address from dropdown
			Select s=new Select(driver.findElement(By.xpath("//select[@id='billing-address-select']")));
			s.selectByVisibleText("New Address");
			
			//Entering address details
			np.getFirstName().clear();
			np.getFirstName().sendKeys("Sharath");
			np.getLastName().clear();
			np.getLastName().sendKeys("Reddy");
			//Selecting country
			Select s2=new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
			s2.selectByVisibleText("Australia");
			np.getCity().sendKeys("Sydney");
			np.getAddress().sendKeys("Strathfield,Sydney,NSW");
			np.getZip().sendKeys("2132");
			np.getPhoneNumber().sendKeys("+61 4516*****");
			
			np.getBilling_Continue().click();
			
			//Selecting added address in Billing section
			Select s1=new Select(driver.findElement(By.xpath("//select[@id='shipping-address-select']")));
			s1.selectByValue("1879373");
			np.getShipping_Continue().click();
			
			//Selecting Shipping day to Next day
			np.getNextDayAir().click();
			np.getShippingday_Continue().click();
			
			//Click on COD
			np.getCOD().click();
			np.getPayment_Continue().click();
			
			//Validate the COD success message and confirm order
			String COD_confirm=np.getCOD_confirm().getText();
			System.out.println("COD confirmation message : "+COD_confirm);
			Assert.assertEquals(COD_confirm,"You will pay by COD");
			System.out.println("Validated COD confirmation message");
			np.getCOD_Continue().click();
			np.getConfirmOrder().click();
			
			//validate the success message 
			String Confirm_message=np.getSuccess_confirm().getText();
			Assert.assertEquals(Confirm_message, "Your order has been successfully processed!");
			System.out.println("Order Confirmation message Validated");
			
			np.getLogout().click();
			System.out.println("Log out Successfull");
			
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

	
	
		
		
		
	
	
}
