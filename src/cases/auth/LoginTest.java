package cases.auth;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import shared.User;

public class LoginTest extends BaseTest {
    public LoginTest () {
        super("https://facebook.com");
    }

    public void login(String email, String password) {
        String txtEmail_css = "#email";
        WebElement txtEmail = driver.findElement(By.cssSelector(txtEmail_css));
        String txtPassword_css = "#pass";
        WebElement txtPassword = driver.findElement(By.cssSelector(txtPassword_css));
        String btnLogin_css = "#u_0_b";
        WebElement btnLogin = driver.findElement(By.cssSelector(btnLogin_css));

        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnLogin.submit();
    }

    @Test()
    public void loginWithValidUser() throws InterruptedException {
        login(User.firstUserEmail, User.firstUserPassword);
        Thread.sleep(10_000);
    }

//    @Test()
//    public void loginWithInvalidUser() {
//        login("", "");
//        this.waitPageLoading();
//    }
}
