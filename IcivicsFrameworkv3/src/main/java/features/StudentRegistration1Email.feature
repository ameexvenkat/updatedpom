Feature: Student Registration Email Validation

Scenario: C383 - Do you see a set of 3 numbered page breadcrumbs?
Given Launch the icivis Studentregistration email URL
When Studentregistration email page is verified successfully
And Verify breadcrumbs is displayed

Scenario: C384 - Can you tell which page you are currently viewing in the breadcrumbs?
Given Launch the icivis Studentregistration email URL
Then verify Current page count is 1 and print

Scenario: C385 - If you select the Watch our student registration help video link
Given Launch the icivis Studentregistration email URL
When If you click on Watch our student registration help video link, Youtube Video should open in a separate tab

Scenario: C387 - Do you see fields for Username, First Name, Last Name, E-mail address, and Verify email address?
Given Verify the Username text fields
Then Verify the First Name text fields
And Verify the Last Name text fields
And Verify the E-mail text fields
And Verify the Verify E-mail text fields

Scenario: C388 - Is a username pre-generated when you arrive on the page?
Given Verify username is pregenerated

Scenario: C389 - Can you select a button to randomly generate a new username in the field?
Given Verify New username is randomly generated and appears in the box

Scenario: C390 - Can you enter text in every field?
Given Verify username is enabled and user able to enter text in username field
Then Verify typing text allowed in firstname field
And Verify typing text allowed in lastname field
And Verify typing text allowed in email field
And Verify typing text allowed in Verify email field and click next

Scenario: C391 - Are required fields marked with an asterisk?
Given Verify username is not marked with an asterisk
Then Verify firstname is marked with an asterisk
And Verify lastname is marked with an asterisk
And Verify email is marked with an asterisk
And Verify verify email is marked with an asterisk

Scenario: C392 - If you hover over the email/verify email address fields, do you see a hover tooltip with appropriate text?
Given verify the Tooltip Text by Hovering on email field
Then verify the Tooltip Text by Hovering on verify email field

Scenario: C393 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
Given Enter invalid first name
And Enter invalid last name
And Enter invalid email
And Enter Invalid verify Email
Then click on next button
But error message should be displayed for email and verify email

Scenario: C394 - If you leave a required field blank and select Next, do you receive an appropriate error message?
Given Verify error message for all required field by leaving the fields blank and click on next button
When Verify error message by leaving the Firstname field blank and enter values in the remaining required fields and click on next button
And Verify error message by leaving the Lastname field blank and enter values in the remaining required fields and click on next button
And Verify error message by leaving the email field blank and enter values in the remaining required fields and click on next button
And Verify error message by leaving the verify email field blank and enter values in the remaining required fields and click on next button

Scenario: C396 - If you fill out all required fields with valid information and select Next, are you taken to Page 2?
Given Enter valid firstname, lastname, email, verifyemail and click on next and verify page 2 is loaded

Scenario: C397 - Does classcode link lead to class code page
Given Launch the icivis Studentregistration email URL
When You click on Wait, I have a class code! link, class code page should open in the same tab
