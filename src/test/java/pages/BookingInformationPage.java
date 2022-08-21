package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

public class BookingInformationPage extends BasePage {
    @FindBy(xpath ="//h3[@data-test-id='booking-reference']" )
    public WebElement bookingReferenceName ;
    @FindBy(xpath =" //button[@data-test-id='amend-button']" )
    public WebElement amendBookingButton;
    public void feedBackPopUp(){
        WebElement element=Driver.getDriver().findElement(By.xpath(" //a[@aria-label='No thanks']"));
        element.click();
    }





}
