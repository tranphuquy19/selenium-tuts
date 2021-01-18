package cases.post;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AddNewPostPage;
import shared.Config;
import shared.User;

public class AddNewPost extends BaseTest {
    private AddNewPostPage postPage;

    public AddNewPost() {
        super("wp-login.php");
    }

    @Test()
    public void addNewPost() throws InterruptedException {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.login(User.firstUserEmail, User.firstUserPassword);
        driver.get(Config.BASE_URL + "wp-admin/post-new.php");

        AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
        addNewPostPage.addNewPost("Title nè", "Content nè");
        Thread.sleep(10_000);
        addNewPostPage.gotoDetailPage();
        Thread.sleep(10_000);
    }

}
