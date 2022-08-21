package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtils;
import utilities.Driver;


import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AmendPage extends BasePage {
    @FindBy(id = "arrivalDate")
    public WebElement amendBookingArrivalDate;
    @FindBy(xpath = "//strong[@data-test='departure_date']")
    public WebElement amendBookingCheckOutDate;
    @FindBy(xpath = " //select[@class='pika-select pika-select-year']")
    public WebElement yearDropDown;
    @FindBy(xpath = "//select[@class='pika-select pika-select-month']")
    public WebElement monthDropDown;
    //tr[@class="pika-row"]/td[@aria-selected="false" and not(contains(@class,'disabled'))]
    @FindBy(xpath = " (//b)[1]")
    public WebElement fromDateInformation;
    @FindBy(xpath = " (//b)[2]")
    public WebElement nightInformation;
    @FindBy(xpath = " (//b)[3]")
    public WebElement toDateInformation;
    @FindBy(xpath = " (//b)[5]")
    public WebElement newTotalInformation;
    @FindBy(xpath = " (//b)[6]")
    public WebElement totalFee;
    //h3[@data-test="rooms_available_header"]
    @FindBy(xpath = "//h3[@data-test='rooms_available_header']")
    public WebElement roomsAvailable;
    public List<WebElement> getListOfDays() {
        return Driver.getDriver().findElements(By.cssSelector("[class='pika-button pika-day']"));
    }
    public void selectYear(String year){
        yearDropDown.click();
        Select select =new Select(yearDropDown);
        select.selectByVisibleText(year);
    }
    public void selectMonth(String month){
        monthDropDown.click();
        Select select =new Select(monthDropDown);
        select.selectByVisibleText(month);
    }
    //tr[@class="pika-row"]/td[@data-day="1" and @aria-selected="false" and not(contains(@class,'disabled'))]
    public void selectDay(String day){
        WebElement element=Driver.getDriver().findElement(By.xpath("//tr[@class='pika-row']/td[@data-day='"+day+"' and @aria-selected='false' and not(contains(@class,'disabled'))]"));
        element.click();
    }
    public void updateArrivalDate(String date) throws ParseException {
        BrowserUtils.dateConverter(date);
        String day = String.valueOf(BrowserUtils.dateConverter(date).get("day"));
        String month=String.valueOf(BrowserUtils.dateConverter(date).get("monthFull"));
        String year = String.valueOf(BrowserUtils.dateConverter(date).get("year"));
        selectYear(year);
        selectMonth(month);
        selectDay(day);
    }




}



