package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Demo_Guru99_Page {
    public Demo_Guru99_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Accept All']")
    public WebElement cookiesConset;

    @FindBy(id= "credit2")
    public WebElement bankElement;

    @FindBy(xpath = "//ol[@id='bank']")
    public WebElement accountAlti;

    @FindBy(id = "credit1")
    public WebElement salesElment;

    @FindBy(xpath = "//ol[@id='loan']")
    public WebElement creditSideAccount;

    @FindBy(xpath = "(//li[@id='fourth'])[1]")
    public WebElement birinciBesBin;

    @FindBy(id = "amt7")
    public WebElement amaountAlti;

    @FindBy(xpath = "(//li[@id='fourth'])[2]")
    public WebElement ikinciBesBin;

    @FindBy(id = "amt8")
    public WebElement amountAltiCreditSide;

    @FindBy(className = "table4_result")
    public WebElement perfectElement;
}
