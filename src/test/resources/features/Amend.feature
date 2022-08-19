@Test
Feature: Amending task


  Background:
    Given customer is in the main page

@Test1
Scenario Outline: The customer should be able to display reservation details
  And customer clicks Manage Booking page from dashboard
  When customer fills the "<booking reference>" "<booking surname>" "<arrival date>"
  And customer clicks submit button
  Then system should direct user into Booking information page
  And user can see "<booking reference>"
  Examples:
    | booking reference | booking surname | arrival date |
    | BCVR237241        | Tester          | 22-9-2022    |
    | AUUR261388        | Tester          | 25-9-2022    |
    | AMOR227074        | Tester          | 28-8-2022    |

  @Test2
  Scenario Outline: The customer should be able to update reservation
    And customer clicks Manage Booking page from dashboard
    When customer fills the "<booking reference>" "<booking surname>" "<arrival date>"
    And customer clicks submit button
    And customer clicks on the amend booking button
    And customer  selects arrival date from amend page
    Then customer should be able amend reservation date as "<updated date>"
    And customer should be able to review updated reservation details
    Examples:
      | booking reference | booking surname | arrival date | updated date |
      | BCVR237241        | Tester          | 22-Sep -22   | 23-Sep -22   |
      | AUUR261388        | Tester          | 25- Sep-22   | 26- Sep -22  |
      | AMOR227074        | Tester          | 28- Aug -22  | 29- Aug -22  |




























