Feature: Healthcare Rate Doctor Feature



  Scenario Outline: Healthcare Rate Doctor Test Scenario

    Given patient is already on Login Page
    When login page title is Sign in
    Then patient enters "<username>" and "<password>"
    Then patient clicks on login button
    Then patient is on dashboard
    Then patient clicks on book appointment
    Then patient is on Repart list page
    Then patient clicks on cardiology repart
    Then patient is on cardiologist list page
    Then patient clicks rate doctor button
    Then patient is on rate doctor page
    Then patient enters "<rate>" and "<feedback>"
    Then patient clicks save rate
    Then patient should see dashboard

#    Then Close the browser
    Examples:
      | username | password  | date | time | description |
      | Arber |Arber12345678 |07/30/2020 | 08:00 - 09:00 | testbllabllabllablla|
