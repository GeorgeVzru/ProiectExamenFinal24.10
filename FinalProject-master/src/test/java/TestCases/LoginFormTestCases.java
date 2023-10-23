package TestCases;

import Pages.BasePage;
import Pages.DemoShopPage;
import Pages.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFormTestCases extends BasePage {
    private LoginForm loginFormPopUp;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        loginFormPopUp = new LoginForm(driver);
    }
    @Test
    public void clickOnLoginButtonWithValidCredentials()throws InterruptedException{
        driver.findElement(By.id("responsive-navbar-nav")).click();
        loginFormPopUp.ClickOnLoginButton();
        loginFormPopUp.enterUserName("dino");
        loginFormPopUp.enterPassword("choochoo");
        loginFormPopUp.credentialsLogin();
        Assert.assertEquals("User logged in!", "User logged in!");
    }
    @Test
    public void lockedOutUser()throws InterruptedException{
        driver.findElement(By.id("responsive-navbar-nav")).click();
        loginFormPopUp.ClickOnLoginButton();
        loginFormPopUp.enterUserName("locked");
        loginFormPopUp.enterPassword("choochoo");
        loginFormPopUp.credentialsLogin();
        Assert.assertEquals("The user has been locked out.", "The user has been locked out.");
    }
    @Test
    public void loginWithLettersAndNumbers()throws InterruptedException{
        driver.findElement(By.id("responsive-navbar-nav")).click();
        loginFormPopUp.ClickOnLoginButton();
        loginFormPopUp.enterUserName("dino1");
        loginFormPopUp.enterPassword("choochoo1");
        loginFormPopUp.credentialsLogin();
        Assert.assertEquals(" Incorrect username or password!", " Incorrect username or password!");
    }
    @Test
    public void clickOnLoginButtonWithInvalidCredentials()throws InterruptedException {
        driver.findElement(By.id("responsive-navbar-nav")).click();
        loginFormPopUp.ClickOnLoginButton();
        loginFormPopUp.enterUserName("George");
        loginFormPopUp.enterPassword("password");
        loginFormPopUp.credentialsLogin();
        Assert.assertEquals(" Incorrect username or password!", " Incorrect username or password!");

    }
    @Test
    public void loginWithNumbers()throws InterruptedException{
        driver.findElement(By.id("responsive-navbar-nav")).click();
        loginFormPopUp.ClickOnLoginButton();
        loginFormPopUp.enterUserName("12345");
        loginFormPopUp.enterPassword("54321");
        loginFormPopUp.credentialsLogin();
        Assert.assertEquals(" Incorrect username or password!", " Incorrect username or password!");
    }
    @Test
    public void loginWithSpecialCharacters()throws InterruptedException{
        driver.findElement(By.id("responsive-navbar-nav")).click();
        loginFormPopUp.ClickOnLoginButton();
        loginFormPopUp.enterUserName("*^$^#@");
        loginFormPopUp.enterPassword("&*@!");
        loginFormPopUp.credentialsLogin();
        Assert.assertEquals(" Incorrect username or password!", " Incorrect username or password!");
    }
    @Test
    public void clickUserAccountAfterSignIn()throws InterruptedException{
        loginFormPopUp.ClickOnLoginButton();
        loginFormPopUp.enterUserName("dino");
        loginFormPopUp.enterPassword("choochoo");
        loginFormPopUp.credentialsLogin();
        loginFormPopUp.checkUserAccountAfterSignIn();
        Assert.assertTrue(driver.getPageSource().contains("Account"));
    }
}
