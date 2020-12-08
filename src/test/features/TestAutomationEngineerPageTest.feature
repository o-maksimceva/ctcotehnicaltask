Feature: Test Automation Engineer page tests

  Background:
    * Open base url in browser

  Scenario: Verify professional skills quantity on Test Automation Engineer page
    And Open vacancy with title "Test Automation Engineer"
    Then "Professional skills and qualification" paragraph has 5 items in list

#  Scenario: Verify "advantages" quantity on Test Automation Engineer page
#    And Open vacancy with title "Test Automation Engineer"
#    Then "As an advantage" paragraph has 3 items in list