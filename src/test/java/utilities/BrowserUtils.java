package utilities;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

public class BrowserUtils {


    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }
    public static void setBookingReference(WebElement element){
        element.sendKeys();
    }
    public static void setBookingSurname(WebElement element){
        element.sendKeys();
    }
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void writeToCSVFile(String fileName, ArrayList<String> data) {
        try(PrintWriter printWriter=new PrintWriter(fileName)) {

            printWriter.write(String.valueOf(data));

        } catch (FileNotFoundException e) {
            System.out.println("Not found it!!");
            e.printStackTrace();
        }
    }
    public static Map<String, Object> dateConverter(String date) throws ParseException {

        //this code will convert String input into date format
        Calendar calendarDate = new GregorianCalendar();
        Date parsedDate = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH).parse(date);
        calendarDate.setTime(parsedDate);

        //this code will convert MMM month into full month format
        int calenderMonth= calendarDate.get(Calendar.MONTH)+1;
        Month month =Month.of(calenderMonth);

        //adding
        Map<String,Object> dates = new HashMap<>();
        dates.put("day",calendarDate.get(Calendar.DATE));
        dates.put("monthFull",month.getDisplayName(TextStyle.FULL,Locale.ENGLISH));
        dates.put("monthShort",calendarDate.get(Calendar.MONTH)+1);
        dates.put("year",calendarDate.get(Calendar.YEAR));
        return dates;
    }








}
