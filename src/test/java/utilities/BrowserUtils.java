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
        Calendar calendar= new GregorianCalendar();
        Date parseDate= new SimpleDateFormat("dd-MMM-yy",Locale.ENGLISH).parse(date);
        calendar.setTime(parseDate);

        int calenderMonth= calendar.get(Calendar.MONTH)+1;
        Month month= Month.of(calenderMonth);
        Map<String, Object> dates= new HashMap<>();
        dates.put("day",calendar.get(Calendar.DATE));
        dates.put("monthsFull",month.getDisplayName(TextStyle.FULL,Locale.ENGLISH));
        dates.put("monthsShort",calenderMonth);
        dates.put("year",calendar.get(Calendar.YEAR));

       return dates;
    }


}
