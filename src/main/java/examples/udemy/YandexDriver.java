package examples.udemy;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class YandexDriver {
    public WebDriver driver;
    public String baseUrl;

    @Before
    public void runDriver() {
        baseUrl = "http://selenium1py.pythonanywhere.com/en-gb/catalogue/the-robot-novels_25/";
        System.setProperty("webdriver.chrome.driver", "libs\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\79819\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void openSite() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.id("id_q")).sendKeys("robot");
        driver.findElement(By.xpath("//input[@value='Search']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Add')][1]")).click();

        Thread.sleep(5000l);
    }

    @Test
    public void takeScreenshot() throws IOException {
        driver.get(baseUrl);
        String fileName = generateName(5) + ".png";
        String directory = System.getProperty("user.dir") + "//screenshots//";
        File fileSource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fileSource, new File(directory+fileName));
    }

    public String generateName(int length){
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int)(Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @Test
    public void executeJSScript() throws InterruptedException {
        driver.get(baseUrl);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // Size of window
        long height = (Long) js.executeScript("return window.innerHeight;");
        long width = (Long) js.executeScript("return window.innerWidth;");

        System.out.println("Height is: " + height);
        System.out.println("Width is: " + width);

        js.executeScript("window.scrollBy(0, arguments[0]);", height);
        Thread.sleep(3000);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }


}
