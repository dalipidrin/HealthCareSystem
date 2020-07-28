Feature: Healthcare Book Appointment Feature



  Scenario Outline: Healthcare Book Appointment Test Scenario

    Given patient is already on Login Page
    When login page title is Sign in
    Then patient enters "<username>" and "<password>"
    Then patient clicks on login button
    Then patient is on dashboard
    Then patient clicks on book appointment
    Then patient is on Repart list page
    Then patient clicks on cardiology repart
    Then patient is on cardiologist list page
    Then patient clicks book appointment
    Then patient is on book appointment page
    Then patient enters "<date>" and "<time>" and "<description>"
    Then patient clicks save appointment
    Then patient should see his appointments

#    Then Close the browser
    Examples:
      | username | password  | date | time | description |
      | Arber |Arber12345678 |07/30/2020 | 08:00 - 09:00 | testbllabllabllablla|
