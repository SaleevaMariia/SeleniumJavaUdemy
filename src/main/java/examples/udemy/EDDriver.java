package examples.udemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EDDriver {

    public static void main(String[] args) {
        String baseUrl = "http://www.google.com/";
        WebDriver driver;
        System.setProperty("webdriver.edge.driver", "libs\\MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
        driver.get(baseUrl);

    }
}
