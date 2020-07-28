Feature: Healthcare System Login Feature



  Scenario Outline: Healthcare Login Test Scenario

    Given user is already on Login Page
    When title of login page is Sign in
    Then user enters "<username>" and "<password>"
    Then user clicks on login button
    Then user is on dashboard
#    Then Close the browser
    Examples:
      | username | password |
      | drin  | 123 |
      |  adis     | durguti123  |