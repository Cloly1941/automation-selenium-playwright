package selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selenium_02_Template {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_() {
        driver.get("https://www.facebook.com/");

        driver.manage().window().setPosition(new Point(0,0));

        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test
    public void TC_02_() {

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
