Feature: Healthcare Register Feature



  Scenario Outline: Healthcare Register Test Scenario


    Given New user is already on Login Page
    When title for login page is Sign in
    Then user clicks on create account button
    Then user is on register page
    Then user enters "<email>" and "<username>" and "<password>"
    Then user clicks on register button
    Then New user is on login page

    Examples:
      | email | username | password |
      | eron@gmail.com | eroninjo | E12345678 |
      | adis | adis | 123 |