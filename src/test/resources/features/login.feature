Feature: Login

  Scenario: Given Successful login with Credentials
    Given user launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then Page Title should be "Your store. Login"
    And close browser


  Scenario Outline: Given Successful login with Credentials
    Given user launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters email as "<userName>" and password as "<password>"
    And Click on login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then Page Title should be "Your store. Login"
    And close browser

    Examples:
      | userName            | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin123 |
