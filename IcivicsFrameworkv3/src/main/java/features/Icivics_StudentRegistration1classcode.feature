Feature: Student Registration Class Code Validation

Scenario: C425 - Do Email address and Verify email address fields appear if you select the Optional: Click here to enter your email address button?
Given Launch the icivis Studentregistration email URL
When Click on Wait, I have a class code! link, class code page should open in the same tab
Then Click link Optional, Click here to enter your email address

Scenario: C426 - If you hover over the email/verify email address fields, do you see a hover tooltip with appropriate text?
Given verify the Tooltip Text by Hovering on email field
Then verify the Tooltip Text by Hovering on verify email field

Scenario: C427 - Do the Email address and Verify email address fields disappear if you select the Click here to remove the email address button?
Given Click on Click here to remove the email address

Scenario: C428 - Is a username pre-generated when you arrive on the page?
Given Verify username is pregenerated

Scenario: C429 - Can you select a button to randomly generate a new username in the field?
Given Verify New username is randomly generated and appears in the box

Scenario: C430 - Can you enter text in every field?
Given Verify username is enabled and user able to enter text in username field
Then Verify typing text allowed in classcode field
And Verify typing text allowed in firstname field
And Verify typing text allowed in lastname field
And Verify typing text allowed in email field
And Verify typing text allowed in Verify email field and click next
And Click on Next Button

Scenario: C431 - Are required fields marked with an asterisk?
Given Verify username is not marked with an asterisk
Then Verify classcode is marked with an asterisk
And Verify firstname is marked with an asterisk
And Verify lastname is marked with an asterisk
And Verify email is marked with an asterisk
And Verify verify email is marked with an asterisk

Scenario: C432 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
Given Verify on entering invalid class code and improper email address error msg should display 

Scenario: C433 - If you leave a required field blank and select Next, do you receive an appropriate error message?
Given Verify error message for all required field by leaving the fields blank and click on next button
When Verify error message by leaving the Classcode field blank and enter values in the remaining required fields and click on next button
And Verify error message by leaving the Firstname field blank and enter values in the remaining required fields and click on next button
And Verify error message by leaving the Lastname field blank and enter values in the remaining required fields and click on next button
And Verify error message by leaving the email field blank and enter values in the remaining required fields and click on next button
And Verify error message by leaving the verify email field blank and enter values in the remaining required fields and click on next button


Scenario: C434 - Do all error messages display correctly?
Given Verify on entering invalid or blank info and hit next

Scenario: If you fill out all required fields with valid information and select Next, are you taken to Page 2?
Given Enter valid firstname, lastname, email, verifyemail and click on next and verify page 2 is loaded
