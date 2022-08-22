package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AmendPage;
import pages.BasePage;
import pages.BookingInformationPage;
import pages.ManageBooking;
import utilities.BrowserUtils;
import java.text.ParseException;
import java.util.ArrayList;

public class AmendStepDefinitions {
    ManageBooking manageBookingPage = new ManageBooking();
    BookingInformationPage bookingInformationPage = new BookingInformationPage();
    AmendPage amendPage = new AmendPage();
    public static ArrayList<String> storingAlldata= new ArrayList<>();
    @Given("customer is in the main page")
    public void customerIsInTheMainPage() {
        manageBookingPage.acceptCookies.click();
    }
    @And("customer clicks Manage Booking page from dashboard")
    public void customerClicksManageBookingPageFromDashboard() {
        manageBookingPage.manageBookingButton.click();
    }
    @When("customer fills the {string} {string} {string}")
    public void customerFillsThe(String bookingReference, String surname, String arrivalDate) throws ParseException {
        manageBookingPage.enterBookingReference(bookingReference);
        manageBookingPage.enterSurname(surname);
        manageBookingPage.checkDateFromCalender(arrivalDate);
    }
    @And("customer clicks submit button")
    public void customerClicksSubmitButton() {
        BrowserUtils.waitForClickablility(manageBookingPage.searchButton,10);
        manageBookingPage.searchButton.click();
        BrowserUtils.waitFor(2);
    }
    @Then("system should direct user into Booking information page")
    public void systemShouldDirectUserIntoBookingInformationPage() {
        String expectedContainsURl="dashboard";
        BrowserUtils.verifyURLContains(expectedContainsURl);
    }
    @And("user can see {string}")
    public void userCanSee(String bookingReference) {
        Assert.assertTrue(bookingInformationPage.bookingReferenceName.getText().contains(bookingReference));
    }
    @When("customer clicks on the amend booking button")
    public void customer_clicks_on_the_amend_booking_button() {
        bookingInformationPage.amendBookingButton.click();
    }
    @And("customer  selects arrival date from amend page")
    public void customerSelectsArrivalDateFromAmendPage() {
        amendPage.amendBookingArrivalDate.click();
    }
    @Then("customer should be able amend reservation date as {string}")
    public void customerShouldBeAbleAmendReservationDateAs(String updatedArrivalDate) throws ParseException {
        amendPage.updateArrivalDate(updatedArrivalDate);
    }
    @And("customer should be able to review updated reservation details and store in {string} file")
    public void customerShouldBeAbleToReviewUpdatedReservationDetailsAndStoreInFile(String fileName) {
        String fromDateInfo = amendPage.fromDateInformation.getText();
        String nightInfo = amendPage.nightInformation.getText();
        String toDateInfo = amendPage.toDateInformation.getText();
        String newTotalInfo = amendPage.newTotalInformation.getText();
        String totalFeeInfo = amendPage.totalFee.getText();
        storingAlldata.add(fromDateInfo);
        storingAlldata.add(nightInfo);
        storingAlldata.add(toDateInfo);
        storingAlldata.add(newTotalInfo);
        storingAlldata.add(totalFeeInfo);
        BrowserUtils.writeToCSVFile(fileName,storingAlldata);

       String expectedRoomsAvailableHeader="Rooms available";
       Assert.assertEquals(expectedRoomsAvailableHeader,amendPage.roomsAvailable.getText());
    }
    @Then("system should not be able direct user into Booking information page")
    public void systemShouldNotBeAbleDirectUserIntoBookingInformationPage() {
        String expectedInformation= "Some of these details are missing or invalid. Please provide correct details";
        Assert.assertEquals(expectedInformation,manageBookingPage.incorrectDetailsInformation.getText());
    }

}