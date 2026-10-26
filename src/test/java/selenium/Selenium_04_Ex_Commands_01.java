package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selenium_04_Ex_Commands_01 {
    WebDriver driver;

    By registerButton = By.xpath("//form[@id=\"frmLogin\"]//button[text()=\"ĐĂNG KÝ\"]");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void Register_01_Empty() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(registerButton).click();

        driver.findElement(By.cssSelector("label#txtFirstname-error")).getText();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

    }

    @Test
    public void Register_02_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("John Terry");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("joker@testing@345");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("joker@testing@345");

        driver.findElement(registerButton).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("John Terry");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("joker@testing.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("joker@testing.net");

        driver.findElement(registerButton).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void Register_04_Invalid_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("John Terry");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("joker@testing.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("joker@testing.net");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("12345");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("12345");

        driver.findElement(registerButton).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void Register_05_Invalid_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("John Terry");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("joker@testing.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("joker@testing.net");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("654321");

        driver.findElement(registerButton).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
    }

    public void Register_06_Invalid_Phone() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("John Terry");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("joker@testing.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("joker@testing.net");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("098712345");

        // < 10
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("098712345");
        driver.findElement(registerButton).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số");

        // Lớn hơn 11
        driver.findElement(By.cssSelector("input#txtPhone")).clear();
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0987123456548");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số");

        // Đầu số sai
        driver.findElement(By.cssSelector("input#txtPhone")).clear();
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("9999999999");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
