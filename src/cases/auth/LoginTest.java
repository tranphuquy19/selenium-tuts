package cases.auth;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import shared.Config;
import shared.User;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    public LoginTest () {
        super("wp-login.php");
    }

    @Test()
    public void loginWithInvalidUser() throws InterruptedException {
        loginPage = new LoginPage(this.driver);
        loginPage.login("abc", "abc");
        Thread.sleep(1_000);
        Assert.assertNotEquals(driver.getCurrentUrl(), Config.BASE_URL + "wp-admin/");
    }

    @Test()
    public void loginWithValidUser() throws InterruptedException {
        loginPage = new LoginPage(this.driver);
        loginPage.login(User.firstUserEmail, User.firstUserPassword);
        Thread.sleep(1_000);
        Assert.assertEquals(driver.getCurrentUrl(), Config.BASE_URL + "wp-admin/");
    }

}
