package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
@Test
public class AppDriver {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver Driver){
        driver.set(Driver);
        System.out.println(driver.get());
        System.out.println("Driver is set");
    }
    
   
}
