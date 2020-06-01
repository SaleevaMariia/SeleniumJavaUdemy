package examples.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class IEDriver {

    public static void main(String[] args) {
        String baseUrl = "http://selenium1py.pythonanywhere.com/en-gb/catalogue/the-robot-novels_25/";
        WebDriver driver;
        System.setProperty("webdriver.ie.driver", "libs\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("id_q")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Search']")).click();

    }
}
