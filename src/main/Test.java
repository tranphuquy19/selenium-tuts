package main;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Test {
    private static WebDriver driver;
    private static final String txtEmail_css = "#email";
    private static final String txtPassword_css = "#pass";
    private static final String btnLogin_css = "#u_0_b";

    private static final String messageIcon_xpath = "/html/body/div[1]/div/div[1]/div[1]/div[2]/div[4]/div[1]/div[2]/span";
    private static final String messageDropdown_css = "div[class='l9j0dhe7'][data-testid='mwthreadlist-item']";

    private static final String firstUserEmail = "rcdbxxu_alisonescu_1581853707@tfbnw.net";
    private static final String firstUserPassword = "8tijl6ccvdn";
    private static final String firstUserId = "100047561494587";

    private static final String secondUserEmail = "qtedpvs_liangman_1610682319@tfbnw.net";
    private static final String secondUserPassword = "g3ih8j3npqd";
    private static final String secondUserId = "100062164388855";

    private static final String thirdUserEmail = "bzsbcok_putnamwitz_1610691294@tfbnw.net";
    private static final String thirdUserPassword = "gcnrid5gi5r";
    private static final String thirdUserId = "100061973147710";


    public static void login() {
        WebElement txtEmail = driver.findElement(By.cssSelector(txtEmail_css));
        WebElement txtPassword = driver.findElement(By.cssSelector(txtPassword_css));
        WebElement btnLogin = driver.findElement(By.cssSelector(btnLogin_css));

        txtEmail.sendKeys(firstUserEmail);
        txtPassword.sendKeys(firstUserPassword);
        btnLogin.submit();
    }

    public static void openChatConsole() {
        WebElement btnMessageIcon = driver.findElement(By.xpath(messageIcon_xpath));
        btnMessageIcon.click();
    }

    public static void getListMessages() {
        List<WebElement> listMessages = driver.findElements(By.cssSelector(messageDropdown_css));

        for (WebElement e : listMessages) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // declaration and instantiation of objects/variables
//        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", "/home/christian/Documents/java_libs/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1300, 900));

        String baseUrl = "http://facebook.com";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        login();
        Thread.sleep(2000);
        openChatConsole();
        Thread.sleep(10_000);
        getListMessages();
//        driver.close();
    }
}
