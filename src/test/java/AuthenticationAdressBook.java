import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AuthenticationAdressBook {

    WebDriver driver;

    @BeforeMethod
    public void signUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");

        WebElement username = driver.findElement(By.id("session_email"));
        username.sendKeys("kexesobepu@zsero.com ");

        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("password");

        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
    }

    @Test
    public void signIn(){

        WebElement actualUsername = driver.findElement(By.xpath("//span[@class='navbar-text']"));

        String expectedUsername = "kexesobepu@zsero.com";

        Assert.assertEquals(actualUsername.getText(), expectedUsername);

        Assert.assertFalse(driver.getTitle().equals("Sign In"));

    }

}