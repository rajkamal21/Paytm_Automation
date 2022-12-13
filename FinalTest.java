package android.tc;

import android.po.BasePage;
import base.AppFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
public class FinalTest extends AppFactory{
	
	@BeforeTest
   public void Setup() throws MalformedURLException, InterruptedException {
		
       AppFactory.Android_LaunchApp();	
		
	
   }
	
    @Test
    public void Automation_Android() throws InterruptedException, MalformedURLException {
    
       BasePage methods_OneApp = new BasePage(driver);
     //  Thread.sleep(8000);
    methods_OneApp.Get_Passcode();
   
       methods_OneApp.hub_Verify();
     System.out.println("Done!");
    }




}