Feature: Page3TeacherRegistration Validation

Scenario: C551 - Can you tell which page you are currently viewing in the breadcrumbs?
Given Launch the icivis URL
Then Verify Breadcrumb indicator shows page 3

Scenario: C552 - Do you see fields for Sign Up for Emails, Agree to Terms of Use/Privacy Policy, and Sync Google Classroom courses?
Given Verify all the Fields for page 3

Scenario: C553 - Can you select Back to proceed to the previous page?
Given Click back button and verify the result 


Scenario: C554 - If you do not check agree to terms of use, does it display an error message
Given Leave terms of use checkbox unchecked and verify the result 

Scenario: C554 -If you enter valid information, do not check sync classes, does it move you to the next page
Given Make valid selections - check terms of use, check emails, leave sync classes unchecked and verify the result
Then Make valid selections - check terms of use, uncheck emails, leave sync classes unchecked and verify the result

Scenario: C556 - If you enter valid information, do check sync classes, does it move you to the next page
Given  Make valid selections - check terms of use, check emails, check sync classes unchecked and verify the result
 
