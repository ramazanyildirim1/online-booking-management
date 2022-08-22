package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.Driver;

import java.text.ParseException;
import java.util.ArrayList;

public class ManageBooking extends BasePage{

    @FindBy(xpath ="//button[@class='nav-button find-a-booking']" )
    public WebElement manageBookingButton ;
    @FindBy(xpath = "//button[@id='accept-all-cookies-button']")
    public WebElement acceptCookies ;
    @FindBy(xpath = "//span[@class='burger-menu']")
    public WebElement menuButton ;
    @FindBy(xpath ="//input[@id='booking-reference-input']" )
    public WebElement bookingReferenceField ;
    @FindBy(xpath ="//input[@id='booking-surname-input']" )
    public WebElement bookingSurnameField;
    @FindBy(xpath ="(//input[@readonly='readonly'])[3]" )
    public WebElement arrivalDateField;
    @FindBy(xpath = "(//button[@class='calendar-chevron date-picker-right-arrow'])[2]" )
    public WebElement calendarRightArrow;
    //button[@id="find-booking-form-button"]
    @FindBy(xpath = "//button[@id='find-booking-form-button']" )
    public WebElement searchButton;

    @FindBy(xpath = "(//div[@class='wb-notification-new-text'])[4]" )
    public WebElement incorrectDetailsInformation;

    public void checkDateFromCalender(String date ) throws ParseException {

        arrivalDateField.click();
        String day = String.valueOf(BrowserUtils.dateConverter(date).get("day"));
        String month = String.valueOf(BrowserUtils.dateConverter(date).get("monthShort"));
        String year = String.valueOf(BrowserUtils.dateConverter(date).get("year"));

        String convertedDate = day+month+year;
        WebElement calenderDate = Driver.getDriver().findElement(By.xpath("//button[@id='date-picker-day-"+convertedDate+"']"));
        try{
            BrowserUtils.waitForClickablility(calenderDate,3);
            BrowserUtils.clickWithJS(calenderDate);
        }catch (TimeoutException e){
            calendarRightArrow.click();
            BrowserUtils.waitForClickablility(calenderDate,3);
            BrowserUtils.clickWithJS(calenderDate);
        }
    }
    public void enterBookingReference(String bookingReference){
        bookingReferenceField.click();
        bookingReferenceField.sendKeys(bookingReference);
    }
    public void enterSurname(String surname ){
        bookingSurnameField.click();
        bookingSurnameField.sendKeys(surname);
    }


}
