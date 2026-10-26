package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.Set;

public class Selenium_04_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_WebBrowser() {
        // Browser
        driver.get("https://demo.nopcommerce.com");
        driver.get("https://demo.nopcommerce.com/login");

        // Đóng tab (dùng để handed windown)
        driver.close();

        // Đóng trình duyệt
        driver.quit();

        // Đi tìm 1 element của page hiện tại
        driver.findElement(By.id(""));

        // Tìm nhiều element giống nhau ở page hiện tại
        driver.findElements(By.cssSelector(""));

        // Lấy title của page hiện tại
        String homePageTitle = driver.getTitle();

        // 1 - Thao tác/ verify trực tiếp (dùng 1 lần)
        Assert.assertEquals(driver.getTitle(), "Home page");

        // 2 - Khai báo biến để thao tác/ verify (dùng 2 lần trở lên)
        Assert.assertEquals(homePageTitle, "Home page");

        // Lấy ra source code của page hiện tại (HTML/CSS/JS/Jquery)
        driver.getPageSource();

        Assert.assertTrue(driver.getPageSource().contains("$500.00"));

        // Lấy ra url hiện tại
        driver.getCurrentUrl();

        // Thao tác với windows
        // Lấy ra ID của tab hiện tại
        driver.getWindowHandle();

        // Lấy ra tất cả ID của tab windows đang có
        Set<String> allIDs = driver.getWindowHandles();

        driver.manage().deleteAllCookies();

        // Thao tác trực tiếp
        driver.manage().deleteAllCookies();

        WebDriver.Options manage = driver.manage();
        manage.deleteAllCookies();

        // Hạ browser xuống thanh taskbar
        driver.manage().window().minimize();

        // Browser phóng to lên
        driver.manage().window().maximize();

        // Chế độ fullscreen
        driver.manage().window().fullscreen();

        // Lấy ra kích thước của browser (Rộng - Cao)
        driver.manage().window().getSize();

        // Browser mở với kích thước nào (responsive)
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().window().getPosition();

        driver.manage().window().setPosition(new Point(0,0));

        // Lấy ra cookie của phiên hiện tại
        driver.manage().getCookies();

        // Gán cookie vào tab hiện tại
//        driver.manage().addCookie();

        // Xóa cookie bất kì
//        driver.manage().deleteCookie();
//        driver.manage().deleteCookieNamed();
//        driver.manage().deleteAllCookies();

        // Wait ngầm định để tìm element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().getImplicitWaitTimeout();

        // Wait ngầm định để thực thi JS
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().getScriptTimeout();

        // Wait ngầm định để page load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().getPageLoadTimeout();

        driver.manage().logs().get("");
        driver.manage().logs().getAvailableLogTypes();
    }

    @Test
    public void TC_02_WebElement() {
        // Element
        WebElement webElement = driver.findElement(By.cssSelector(""));

        // Click vào button/ link/ radio/ checkbox/ dropdown ...
        webElement.click();

        // Dùng với loại element dạng editable (Textbox/ Texarea/ Dropdown)
        // Xóa dữ liệu đang có trước khi nhập mới
        webElement.clear();

        // Nhập dữ liệu (Textbox/ Texarea/ Dropdown)
        webElement.sendKeys("cloly@gmail.com");
        webElement.sendKeys(Keys.ENTER);

        // Dùng để kiểm tra 1 element đang hiển thị
        // Có kích thước cụ thể/ nhìn thấy được
        // Áp dụng cho tất cả element
        // Hiển thị trả về true/ ko thì trả về false
        Assert.assertTrue(webElement.isDisplayed());
        Assert.assertFalse(webElement.isDisplayed());
        webElement.isDisplayed();

        // Áp dụng cho tất cả các loại element
        // Kiểm tra element có thể thao tác được không (k bị disable)
        // disable = readonly (only view)
        Assert.assertFalse(webElement.isEnabled());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
