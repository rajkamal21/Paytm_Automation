package android.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;


public class BasePage {

AndroidDriver  driver;
String value;


    public BasePage(AndroidDriver driver){
    //Assigned the value of local driver to the global driver	
    	this.driver = driver;
        PageFactory.initElements(this.driver, this);
        
     	System.out.println("constructor done");
     	
    }
    
    @FindBy(xpath = "//android.widget.Button[@content-desc = 'Update Later']")
    public WebElement Update_Later;
    @FindBy(xpath = "//android.view.View[@content-desc = 'Hub']")
    public WebElement HubBtn;

    @FindBy(xpath = "//android.view.View[@content-desc = 'Currency\n"+ "Convertor']")
    public WebElement CC;
    
    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
    public WebElement ChooseCurrency_UpperBox;
    
    @FindBy(xpath = "//android.view.View[1]/android.view.View/android.view.View[3]")
    public WebElement Search_Currency;
    
    @FindBy(xpath = "//android.view.View[5]/android.view.View/android.view.View[1]")
    public WebElement Choose_Currency;
  
    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[2]")
    public WebElement ChooseCurrency_BottomBox;
 
    @FindBy(xpath = "//android.view.View[1]/android.view.View/android.view.View[3]")
    public WebElement Search_2ndCurrency;
    
    @FindBy(xpath = " //android.view.View[5]/android.view.View/android.view.View")
    public WebElement Choose_2ndCurrency;
    
    @FindBy(xpath = "//android.widget.EditText[1]")
    public WebElement Type_Amount;
  
    @FindBy(xpath = "//android.widget.EditText[2]")
    public WebElement Converted_Amount;

   //android.view.View[1]/android.view.View/android.view.View[3]}]

//   @FindBy(xpath= "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]")
//   public WebElement BackBtn;
   
  
    
    public BasePage Get_Passcode() throws InterruptedException {
   
    	Update_Later.click();
        Actions action = new Actions(driver);
      		driver.findElement(By.xpath("//android.view.View[@index= 0]")).click();
     		action.sendKeys("121212").perform(); 	
      		return this;
     }
    
   


    public BasePage hub_Verify() throws InterruptedException, MalformedURLException {
    	
    	HubBtn.click();	
    	CC.click();  
     
    	
    	ChooseCurrency_UpperBox.click();
    	 Actions action = new Actions(driver);
    		Search_Currency.click();
   		    action.sendKeys("us").perform(); 
    	    Choose_Currency.click();
    	    
    	    Converted_Amount.click();
    	ChooseCurrency_BottomBox.click();
    	Search_2ndCurrency.click();
	    	action.sendKeys("India").perform(); 
	    	Choose_2ndCurrency.click();
	    	Type_Amount.click();
	    	Type_Amount.sendKeys("11");
	    	Converted_Amount.click();
    	    value = Converted_Amount.getText();

   	       System.out.println(value);
    
   	       
   	 Assert.assertTrue(value.contains("Indian"));
   
   	 
//   	    878.78, Indian Rupee (INR)
   	       
   	       //split a string
//   	    String s="Android_a_b.pdf";
//   	 String[] parts = s.split("\\."); // escape .
//   	 String part1 = parts[0];
//   	 String part2 = parts[1];

//    	BackBtn.click();
   	 driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    	return this;
    }
  
    
 

}