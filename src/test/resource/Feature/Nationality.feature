Feature: Iam doing automation of Add Nationality in Orange HRM


Background: Common Steps
Given User opens chrome browser
Then User opens application URL"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

Scenario: Add Nationality
Given User enters Username as "Admin" and Password as "admin123"
When User creats Nationality record
      |NationalityText|
      |Japan101       |
      |Japan102       |
      |Japan103       |
Then User logout
And User close browser


