 package playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Cookie;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.Proxy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

 public class Playwright_04_Commands_01 {
     Playwright playwright;
     BrowserType browserType;
     Browser browser;
     BrowserContext browserContext;
     Page page;

     @BeforeClass
     public void beforeClass() {
         playwright = Playwright.create(); // Ko có tham số (parameter/ param)

         browserType = playwright.chromium();
         browserType = playwright.firefox();
         browserType = playwright.webkit();

         // Web Api Testing
         APIRequest apiRequest = playwright.request();
         Selectors selectors = playwright.selectors();

         // Browser Type
         browserType.launch(new BrowserType.LaunchOptions().setHeadless(true)); // non-UI
         browserType.launch(new BrowserType.LaunchOptions().setHeadless(false)); // UI (Hiển thị cửa sổ)

         // phương thức thiết lập độ trễ giữa các thao tác của Playwright.
         browserType.launch(new BrowserType.LaunchOptions().setSlowMo(250)); //

         // - mở trình duyệt nào
         browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome"));
         browserType.launch(new BrowserType.LaunchOptions().setChannel("msedge"));

         // thiết lập đường dẫn thư mục lưu file tải xuống (Chọn thư mục lưu file tải xuống)
         // Mặc định không set đường dẫn để download về nó sẽ vào thư mục Download của OS
         String projectPath = System.getProperty("user.dir");
         browserType.launch(new BrowserType.LaunchOptions().setDownloadsPath(Path.of(projectPath + "\\downloadFile")));

         // Action Chaining : Chuỗi hành động liên tiếp hamA().hamB()
         // browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome").setSlowMo(500).setHeadless(false));

         // Trỏ vào nơi chứa thư mục đã cài đặt của trình duyệt
         browserType.launch(new BrowserType.LaunchOptions().setExecutablePath(Path.of("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));

         // cấu hình Proxy cho trình duyệt khi Playwright khởi chạy
         browserType.launch(new BrowserType.LaunchOptions().setProxy(new Proxy("")));

         // Chrome/ Edge: Chạy với Profile nào
         browserType.launchPersistentContext(Path.of("C:\\Users\\ADMIN\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1"));
         browserType.launchPersistentContext(Path.of("C:\\Users\\ADMIN\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2"));

         // Lấy ra đường dẫn cài đặt của trình duyệt ex:C:\Program Files\Google\Chrome\Application\chrome.exe
         browserType.executablePath();

         //  kết nối Playwright với một trình duyệt đang chạy từ xa (Remote Browser) thông qua một địa chỉ WebSocket hoặc endpoint của dịch vụ Cloud Testing.
         // Thay vì chạy browser trên máy local của bạn, bạn có thể chạy browser trên một máy chủ hoặc nền tảng Cloud Testing như BrowserStack, Sauce Labs, LambdaTest...
         // Cloud Testing: BrowserStack/ SauceLab/ Device Farm/ LambaTest/ ...
         // EndPoint: GRID URL/ HUB URL
         browserType.connect("");

         // Chrome Dev Tool
         // kết nối với một trình duyệt Chromium đang chạy thông qua giao thức CDP (Chrome DevTools Protocol).
         // endpointURL - A CDP websocket endpoint or http url to connect to.
         // For example http://localhost:9222/ or ws://127.0.0.1:9222/devtools/browser/387adf4c-243f-4051-a181-46798f4a46f4.
         browserType.connectOverCDP("");

         // Browser Engine
         browserType.name();


         // Browser
         // Ẩn danh (Incognito) playwright mở 1 trình duyệt ẩn danh selenium mở 1 trình duyệt mới hoàn toàn
         browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                 .setHeadless(false).setSlowMo(50));

         // Kiểm tra browser có đang hoạt động/ đang chạy k
         browser.isConnected();

         // Trả về danh sách browser tab/ window đang mở
         browser.contexts();

         // Trả về type của browser
         browser.browserType();

         if(browser.browserType().name().equals("firefox")) {
             // Action
         }

         // Close browser
         browser.close();

         // Trả về version của browser
         browser.version(); // 156.0

         // Trả về Page để thao tác với các element
         browser.newPage();

         // Trả về 1 context thao tác với Window/ Tab
         // Creates a new browser context. It won't share cookies/cache with other browser contexts.
         browserContext = browser.newContext();

         // Launches browser that uses persistent storage located at userDataDir and returns the only context.
         // Closing this context will automatically close the browser.
         browserContext = playwright.firefox().launchPersistentContext(Path.of(""));

         // BROWSER CONTEXT
         browserContext = browser.newContext();

         // Get ra cookie
         List<Cookie> cookie = browserContext.cookies();

         // Gán Cookie
         browserContext.addCookies(cookie);

         // clear
         browserContext.clearCookies();

         // Thiết lập tọa độ giả lập (Latitude, Longitude) cho browser. Cần cấp quyền Geolocation thì website mới có thể truy cập vị trí.
         browserContext.setGeolocation(new Geolocation(21.136266, 105.809997));

         // Gỉả lập internet offline
         browserContext.setOffline(true);

         //  Cấp quyền cho website sử dụng các tính năng của browser. 
         browserContext.grantPermissions(new ArrayList<>());
         browserContext.clearPermissions();
     }

     @Test
     public void TC_01_() {
         page.navigate("https://www.facebook.com/");
     }

     @AfterClass
     public void afterClass() {
         browser.close();
         playwright.close();
     }
 }