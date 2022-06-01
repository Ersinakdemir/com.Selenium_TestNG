package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {
    public BrcPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement loginElement;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailbox;

    @FindBy(xpath = "//input[@id='formBasicPassword']")
    public WebElement sifreBox;

    @FindBy(xpath = " //button[text()=' Login']")
    public WebElement loginiki;

    @FindBy(id= "dropdown-basic-button")
    public WebElement nameSurname;


}
