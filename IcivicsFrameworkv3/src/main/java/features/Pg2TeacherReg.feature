Feature: Page2TeacherRegistration Validation

Scenario: C545 - Can you tell which page you are currently viewing in the breadcrumbs?
Given Launch the icivis URL
Then Verify Breadcrumb indicator shows page 2

Scenario: C546 - Do you see fields for teaching state, school or institution, and zip code?
Given Verify the fields for teaching state, school or institution, and zip code display for page 2

Scenario: C546 - Can you select Back to proceed to the previous page?
Given Click on back button and verify page go to page1 with fields filled 

Scenario: C547 - Can you make a selection for all fields?
Given Make a selection for school field and verify the result
Then Make seletion for zipcode and verify the result 
Then Make selection for teaching state and verify the result 


Scenario: C548 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
Given Enter invalid School, Zipcode as none for Teacherstate and verify the error messages.

Scenario: C549 - If you leave a required field blank and select Next, do you receive an appropriate error message?
Given Click on next without entering any valid data in School, Zipcode as none for Teacherstate and verify the error messages.


Scenario: C550- If you fill out all required fields with valid information and select Next, are you taken to Page 3?
Given Verify select vaild options and click on next button
Then verify page 3 is loaded
