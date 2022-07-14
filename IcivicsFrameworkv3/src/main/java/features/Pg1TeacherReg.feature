Feature: Page1TeacherRegistration Validation

Scenario: C545 - Can you tell which page you are currently viewing in the breadcrumbs?
Given Launch the icivis URL
Then Verify Breadcrumb indicator shows page 1

Scenario: C546 - Do you see fields for Role and Grade Level?
Given User on Page 1, Verify grade level field and option is displayed as checkbox and nothing is selected as default
When User on Page 1, Verify nothing is selected as default for grade level
And Verify role options in the dropdown

 Scenario: C547 - Can you make a selection for all fields?
Given Verify Grade level can have >1 value selected
When Verify Role can have only 1 value selected

Scenario: C548 - If you leave a no checks for grade level and select Next, do you receive an appropriate error message?
Given Verify Leave all grade level boxes unchecked and select next

Scenario: C549 - If you leave role none selected and select Next, do you receive an appropriate error message?
Given Verify Leave role none selected and select next

Scenario: C550 - If you fill out all required fields with valid information and select Next, are you taken to Page 2?
Given Verify on entering fields with valid data redirect to page2 
