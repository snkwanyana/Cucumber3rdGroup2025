Scenario Outline: Fill in the Web Automation form
  Given I am on the Web Automation form page
  When I Select the <device> from the Device dropdown
  Then I Select the <storage> from the Storage radio buttons

Examples:
| device   |storage
| Phone |64GB
| Tablet |128GB
| Laptop |256GB
