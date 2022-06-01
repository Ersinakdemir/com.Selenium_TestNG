package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import utilities.Driver;

public class HotelMyCampPage {
    public HotelMyCampPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement logInElement;

    @FindBy(id="UserName")
    public WebElement userNameElement;

    @FindBy(xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagementElemet;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsElement;

    @FindBy(xpath = ("//a[@class='btn btn-circle btn-default']"))
    public WebElement addHotelRoomsElement;

    @FindBy(xpath = "//select[@id='IDHotel']")
    public WebElement idHotelElement;

    @FindBy(xpath = "//textarea[@aria-describedby='cke_105']")
    public WebElement descrieptionEelement;

    @FindBy(id = "Code")
    public WebElement codeElement;

    @FindBy(id = "IDGroupRoomType")
    public WebElement roomTypeElement;


    @FindBy(xpath = "//*[text()='HotelRoom was inserted successfully']")
    public WebElement successfullyElement;

    @FindBy(className = "btn btn-primary")
    public WebElement okTusuElementi;

    @FindBy(xpath = "//a[text()='Hotelrooms']")
    public WebElement hoteRoomsLink;


    @FindBy(xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement listOFHotelroomsElement;

}
