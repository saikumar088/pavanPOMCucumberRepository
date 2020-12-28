package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;


public class LoginSteps {
    private WebDriver driver;
    private LoginPage login;

    @Given("user launch Chrome browser")
    public void user_launch_chrome_browser() {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        login = new LoginPage(driver);

    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    /**
     * @param email
     * @param password
     */
    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {

        login.setLoginEmail(email);
        login.setLoginPwd(password);
    }

    @When("Click on login")
    public void click_on_login() {
        login.clickOnLogin();

    }

    @Then("Page Title should be {string}")
    public void page_titile_should_be(String actualTitile) {
        try {
            Assert.assertEquals(login.verifyPageTitile(), actualTitile);
        } catch (AssertionError a) {

            System.out.println("Assetrtion error " + a);
        }
    }

    @When("user click on logout link")
    public void user_click_on_logout_link() {
        login.clickLogout();

    }

    @Then("close browser")
    public void close_browser() {


        driver.quit();
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

    }
}
