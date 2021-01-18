package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import shared.Config;

public class BaseTest {
    protected WebDriver driver;

    protected String URL = "";

    private final String CHROME_DRIVE_PATH = "/home/christian/Documents/java_libs/chromedriver_linux64/chromedriver";
    private final String[] chromeOptions = {"--disable-notifications", "--window-size=1300,900"};

    protected void waitPageLoading() {
        new WebDriverWait(driver, 10_000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public BaseTest() {

    }

    public BaseTest (String pathUrl) {
        this.URL = Config.BASE_URL + pathUrl;
    }

    public BaseTest(String baseUrl, String pathUrl) {
        this.URL = baseUrl + pathUrl;
    }

    @BeforeMethod()
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();

        for(String option : this.chromeOptions) {
            options.addArguments(option);
        }

        System.setProperty("webdriver.chrome.driver", CHROME_DRIVE_PATH);
        driver = new ChromeDriver(options);

        driver.get(URL);
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
