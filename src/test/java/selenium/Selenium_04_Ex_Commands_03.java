package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;

public class Selenium_04_Ex_Commands_03 {
    WebDriver driver;

    By registerButton = By.xpath("//form[@id=\"frmLogin\"]//button[text()=\"ĐĂNG KÝ\"]");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_MailChimp() {
        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@gmail.io.vn");
        driver.findElement(By.cssSelector("input#new_username")).sendKeys(Keys.TAB);

        // Number
        driver.findElement(By.cssSelector("new_password")).sendKeys("123456");
        driver.findElement(By.cssSelector("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li['8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Assert.assertFalse(driver.findElement(By.cssSelector("button#create-account-enabled")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id='marketing_newsletter']")).isSelected());

        // LowerCase
        driver.findElement(By.cssSelector("new_password")).clear();
        driver.findElement(By.cssSelector("new_password")).sendKeys("manual");
        driver.findElement(By.cssSelector("new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li['8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        Assert.assertFalse(driver.findElement(By.cssSelector("button#create-account-enabled")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id='marketing_newsletter']")).isSelected());

        // UpperCase
        driver.findElement(By.cssSelector("new_password")).clear();
        driver.findElement(By.cssSelector("new_password")).sendKeys("manual");
        driver.findElement(By.cssSelector("new_password")).sendKeys(Keys.TAB);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
