import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriver2 {



    public static void main(String[] args) {
        WebDriver driver;
        driver = new InternetExplorerDriver();
        driver.navigate().to("http://www.baidu.com");
        System.out.println("dfa");
    }
}
