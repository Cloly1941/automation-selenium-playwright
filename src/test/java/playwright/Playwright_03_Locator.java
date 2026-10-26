 package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 public class Playwright_03_Locator {
     Playwright playwright;
     Browser browser;
     Page page;

     @BeforeClass
     public void beforeClass() {
         playwright = Playwright.create();
         browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                 .setHeadless(false).setSlowMo(50));
         page = browser.newPage();
     }

     @Test
     public void TC_01_Role() {
         page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

         page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Yes"));
         page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Account"));
         page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));
     }

     @Test
     public void TC_02_Label() {
         page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

         page.getByLabel("FirstName");
         page.getByLabel("E-mail");
         page.getByLabel("Yes");
         page.getByLabel("Subscribe");
     }

     @Test
     public void TC_03_Placeholder() throws InterruptedException {
         page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

         page.getByPlaceholder("Telephone").fill("0987654321");
         page.getByPlaceholder("Password Confirm").fill("Testing");
         page.getByPlaceholder("Search").fill("iMac");

         Thread.sleep(4000);
     }

     @Test
     public void TC_04_Text() {
         page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

         page.getByText("Your Personal Details");
         page.getByText("First Name");
         page.getByText("Forgotten Password");
     }

     @Test
     public void TC_05_AltText() {
         page.navigate("https://opencart.abstracta.us/index.php?route=common/home");

         page.getByAltText("Macbook");
         page.getByAltText("iPhone");
         page.getByAltText("Canon EOS 5D");
     }

     @Test
     public void TC_06_Title() {
         page.navigate("https://opencart.abstracta.us/index.php?route=common/home");

         page.getByTitle("Shopping Cart");
         page.getByTitle("My Account");
         page.getByTitle("Checkout");
     }

     @Test
     public void TC_07_TestID() {
         page.navigate("https://demo-bank.vercel.app/");

         page.getByTestId("login-input");
         page.getByTestId("password-input");
         page.getByTestId("login-button");
     }

     @Test
     public void TC_08_Css () {
         page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

         page.locator("form input#input-firstname");
         page.locator("input[name='agree']");
         page.locator("div#content>h1");
         page.locator("input[value='Continue']");
     }

     @Test
     public void TC_09_Xpath () {
         page.navigate("https://opencart.abstracta.us/index.php?route=account/register");

         page.locator("//label[contains(string(), 'Yes')]/input");
         page.locator("//label[contains(string(), 'No')]/input");
         page.locator("//a[text()='Address Book']");
         page.locator("//div[@id='content']/h1");
     }

     @AfterClass
     public void afterClass() {
         browser.close();
         playwright.close();
     }
 }