import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import java.io.File;
import java.net.URL;
public class LookingBus {
    private static AppiumDriver driver;

    public static void main(String args[]) throws MalformedURLException, InterruptedException {

        try {
            File app = new File("C:\\Users\\srkri\\OneDrive\\Documents\\express\\LookingBus_v0.6.23.8.apk");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Pixel5");
            capabilities.setCapability("platformVersion", "10");
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("isRealMobile", false);
            capabilities.setCapability("app", app.getAbsolutePath()); // Enter your app url
            capabilities.setCapability("app-package", "com.seeing_bus_user_app");

            capabilities.setCapability("app-activity", "com.seeing_bus_user_app.activities.MainActivity");
            capabilities.setCapability("appium.server", "127.0.0.1"); // specify the Appium host
            capabilities.setCapability("appium.port", "4723");
            capabilities.setCapability("uiautomator2ServerLaunchTimeout", 60000);

            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            WebElement email = ( WebElement ) driver
                    .findElement(By.id("com.seeing_bus_user_app:id/username"));

            WebElement  pass = ( WebElement ) driver.findElement(By.id("com.seeing_bus_user_app:id/password"));

            WebElement  login = ( WebElement ) driver.findElement(By.id("com.seeing_bus_user_app:id/login"));

            email.sendKeys("4allfriends.krish@gmail.com");
            pass.sendKeys("KRIShn@345");
            login.click();
        } catch (AssertionError a) {

            a.printStackTrace();
        }

        driver.quit();
    }
}
