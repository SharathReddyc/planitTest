package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPage {

	
	public WebDriver driver;
	
	
	By AccountId=By.xpath("//a[@class='account']");
	By Books=By.linkText("Books");
	By SelectBook=By.linkText("Computing and Internet");
	By Price=By.xpath("//span[@itemprop='price']");
	By Quantity=By.xpath("//input[@id='addtocart_13_EnteredQuantity']");
	By AddtoCart=By.xpath("//input[@id='add-to-cart-button-13']");
	By NavBarMessage=By.xpath("//body/div[@id='bar-notification']/p[1]");
	By Shoppingcart=By.xpath("//span[contains(text(),'Shopping cart')]");
	By SubTotal=By.xpath("//tbody/tr[1]/td[2]/span[1]/span[1]");
	By CheckBox_TM=By.xpath("//input[@id='termsofservice']");
	By Checkout=By.xpath("//button[@id='checkout']");
	By FirstName=By.id("BillingNewAddress_FirstName");
	By LastName=By.id("BillingNewAddress_LastName");
	By City=By.xpath("//input[@id='BillingNewAddress_City']");
	By Address=By.xpath("//input[@id='BillingNewAddress_Address1']");
	By Zip=By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	By PhoneNumber=By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	By Billing_Continue=By.xpath("//input[@title='Continue']");
	By Shipping_Continue=By.xpath("//div[@id='shipping-buttons-container']/input"); 
	By NextDayAir=By.xpath("//input[@id='shippingoption_1']");
	By Shippingday_Continue=By.xpath("//div[@id='shipping-method-buttons-container']/input");
	By COD=By.xpath("//input[@id='paymentmethod_0']");  
	By Payment_Continue=By.xpath("//div[@id='payment-method-buttons-container']/input");
	By COD_confirm=By.xpath("//tbody//tr//td//p");
	By COD_Continue=By.xpath("//div[@id='payment-info-buttons-container']/input");
	By ConfirmOrder=By.xpath("//div[@id='confirm-order-buttons-container']/input"); 
	By Success_confirm=By.xpath("//div[@class='section order-completed']/div");
	By Logout=By.linkText("Log out");
	
	
	
	
	
	
	
	public NavigationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}



	 public WebElement getAccountId()    		{ return driver.findElement(AccountId);  }		
	 public WebElement getBooks()				{ return driver.findElement(Books);  }	
	 public WebElement getSelectBook()			{ return driver.findElement(SelectBook);  }
	 public WebElement getPrice()			    { return driver.findElement(Price);  }
	 public WebElement getQuantity()			{ return driver.findElement(Quantity);  }	
	 public WebElement getAddtoCart()			{ return driver.findElement(AddtoCart);  }	
	 public WebElement getNavBarMessage()		{ return driver.findElement(NavBarMessage);  }	
	 public WebElement getShoppingcart()		{ return driver.findElement(Shoppingcart);  }
	 public WebElement getSubTotal()		    { return driver.findElement(SubTotal);  }
	 public WebElement getCheckBox_TM()			{ return driver.findElement(CheckBox_TM);  }
	 public WebElement getCheckout()			{ return driver.findElement(Checkout);  }
	 public WebElement getFirstName()			{ return driver.findElement(FirstName);  }	
	 public WebElement getLastName()			{ return driver.findElement(LastName);  }
	 public WebElement getCity()			    { return driver.findElement(City);  }
	 public WebElement getAddress()				{ return driver.findElement(Address);  }
	 public WebElement getZip()			        { return driver.findElement(Zip);  }
	 public WebElement getPhoneNumber()			{ return driver.findElement(PhoneNumber);  }
	 public WebElement getBilling_Continue()    { return driver.findElement(Billing_Continue);  }
	 public WebElement getShipping_Continue()   { return driver.findElement(Shipping_Continue);  }
	 public WebElement getNextDayAir()          { return driver.findElement(NextDayAir);  }
	 public WebElement getShippingday_Continue(){ return driver.findElement(Shippingday_Continue);  }	
	 public WebElement getCOD()                 { return driver.findElement(COD);  }
	 public WebElement getPayment_Continue()	{ return driver.findElement(Payment_Continue);  }	
	 public WebElement getCOD_confirm()         { return driver.findElement(COD_confirm);  }
	 public WebElement getCOD_Continue()		{ return driver.findElement(COD_Continue);  }	
	 public WebElement getConfirmOrder()		{ return driver.findElement(ConfirmOrder);  }
	 public WebElement getSuccess_confirm()		{ return driver.findElement(Success_confirm);  }
	 public WebElement getLogout()	            { return driver.findElement(Logout);  }
	
	
}
