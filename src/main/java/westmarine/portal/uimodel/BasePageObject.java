package westmarine.portal.uimodel;

import com.browserstack.local.Local;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class BasePageObject {

    private static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    private static final String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private static final String BROWSERSTACK_HUB = String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", USERNAME, ACCESS_KEY);

    private final Local bsLocal = new Local();
    protected static WebDriver driver;

    protected void createDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");

        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("os", "Windows");
        //caps.setCapability("os_version", "10");
        //caps.setCapability("browser", "Chrome");
        //caps.setCapability("browser_version", "87");
        //caps.setCapability("name", "gabezoldi2 Tests");
        //caps.setCapability("browserstack.local", "true");
        //caps.setCapability("acceptSslCerts", "true");

        if (driver == null) {
            driver = new ChromeDriver(options);

            //try {
            //    driver = new RemoteWebDriver(new URL(BROWSERSTACK_HUB), caps);
            //}
            //catch (MalformedURLException e) {
            //    throw new RuntimeException(e);
            //}
        }

        driver.manage().window().maximize();
    }

    //protected void startBrowserStackLocal() {
    //    Map<String, String> bsLocalArgs = new HashMap<>();
    //    bsLocalArgs.put("key", ACCESS_KEY);
    //    bsLocalArgs.put("forcelocal", "true");
    //    bsLocalArgs.put("force", "true");
    //    bsLocalArgs.put("onlyAutomate", "true");
    //    try {
    //        bsLocal.start(bsLocalArgs);
    //        assertThat(bsLocal.isRunning()).as("BrowserStack is not running" ).isTrue();
    //    }
    //    catch(Exception e) {
    //        throw new RuntimeException(e);
    //    }
    //}

    //protected void stopBrowserStackLocal() {
    //    try {
    //        bsLocal.stop();
    //        assertThat(bsLocal.isRunning()).as("BrowserStack is still running" ).isFalse();
    //    }
    //    catch(Exception e) {
    //        throw new RuntimeException(e);
    //    }
    //}

    // TODO: refactor to introduce waitFor(WebElement element) using Wait.until(ExpectedCondition)
    protected void snooze(long secs) {
        long inSeconds = secs * 1000;
        try {
            Thread.sleep(inSeconds);
        }
        catch(InterruptedException ie) {
            throw new RuntimeException(ie.getMessage());
        }
    }

    protected String parseHostUrl(String url) {
        URL parsed = null;
        try {
            parsed = new URL(url);
            return String.format("%s://%s/", parsed.getProtocol(), parsed.getAuthority());
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
