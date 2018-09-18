package cn.gov.learn.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest {
    public static WebDriver driver;

    public static void main(String[] args) {
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator.gaoshou-PC\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://www.baidu.com");
        System.out.println("4566");
    }
}
