import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement username = driver.findElement(By.id("user_login"));
        username.sendKeys("username");

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");

        driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();


    }
}
