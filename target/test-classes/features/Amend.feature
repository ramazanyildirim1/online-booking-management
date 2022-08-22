@Test
Feature: Amending task


  Background:
    Given customer is in the main page
    And customer clicks Manage Booking page from dashboard

@Test1
Scenario Outline: The customer should be able to display reservation details
  When customer fills the "<booking reference>" "<booking surname>" "<arrival date>"
  And customer clicks submit button
  Then system should direct user into Booking information page
  And user can see "<booking reference>"
  Examples:
    | booking reference | booking surname | arrival date |
    | BCVR237241        | Tester          | 22-Sep-22    |
    | AUUR261388        | Tester          | 25-Sep-22    |
    | AMOR227074        | Tester          | 28-Aug-2022  |

  @Test2
  Scenario Outline: The customer should  be able to  update  reservation
    When customer fills the "<booking reference>" "<booking surname>" "<arrival date>"
    And customer clicks submit button
    And customer clicks on the amend booking button
    And customer  selects arrival date from amend page
    Then customer should be able amend reservation date as "<updatedArrival>"
    And customer should be able to review updated reservation details and store in "bookingLogs.csv" file
    Examples:
      | booking reference | booking surname | arrival date | updatedArrival |
      | BCVR237241        | Tester          | 22-Sep-22    | 28-Sep-22      |
      | AUUR261388        | Tester          | 25-Sep-22    | 26-Sep-22      |
      | AMOR227074        | Tester          | 28-Aug-22    | 29-Aug-22      |
@negative
Scenario Outline: The customer should not be able to  update  reservation as a recent date
  When customer fills the "<booking reference>" "<booking surname>" "<arrival date>"
  And customer clicks submit button
  Then system should not be able direct user into Booking information page
  Examples:
    | booking reference | booking surname | arrival date |
    | BCVR237241        | Test            | 22-Sep-22    |
    | AUUR261388        | Test            | 25-Sep-22    |
    | AMOR227074        | Test            | 28-Aug-22    |
































