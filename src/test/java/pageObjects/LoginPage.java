package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;


    @FindBy(id="Email")
    @CacheLookup
    WebElement loginEmail;

    @FindBy(id="Password")
    @CacheLookup
    WebElement loginPwd;

    @FindBy(xpath = "//input[@value='Log in']")
    @CacheLookup
    WebElement login_button;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement logOut_link;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void setLoginEmail(String email){
        loginEmail.clear();
        loginEmail.sendKeys(email);
    };

    public void setLoginPwd(String loginPwd) {
        this.loginPwd.clear();;
        this.loginPwd.sendKeys(loginPwd);
    }

    public void clickOnLogin() {
        login_button.click();
    }

    public void clickLogout() {

        logOut_link.click();
    }

    public String verifyPageTitile(){

        return driver.getTitle();

    }



}
