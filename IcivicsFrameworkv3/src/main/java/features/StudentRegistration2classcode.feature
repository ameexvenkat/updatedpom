Feature: Student Registration Class Code page2 Validation

Scenario: C398 - Can you tell which page you are currently viewing in the breadcrumbs?
Given Launch the icivis Studentregistration email URL
Then Verify Breadcrumb indicator is on page 2

Scenario: C399- Can you select Back to proceed to the previous page?
Given Verify clicking on back button will take to previous page 1



Scenario: C400- When you go Back, are your entries in all fields remembered?
Given Verify classcode is remembered.
And Verify Username is regenerated.
And Verify firstname is remembered.
And Verify lastname is remembered.
And Verify email is remembered.
And Verifyemail is remembered.


Scenario: C403- If you select the Terms of Use link, does the iCivics Terms of Use page open in a new tab?
Given Verify Terms of use page opens in new tab


Scenario: C404- If you select the Privacy Policy link, does the iCivics Privacy Policy page open in a new tab?
Given Verify Privacy policy page opens in new tab

Scenario: C405- As a student, are you NOT prompted to sign up for the newsletter?
Given Verify No email subscription checkbox appears


Scenario: C408- If you hover over the password field, do you see a hover tooltip with appropriate text?
Given Verify Hover over password field

Scenario: C409- When you enter text in the Password field, do you see text indicating the current password's strength?
Given Verify Indicator for strength should change according to pwd strength


Scenario: C410- When you enter text in the Confirm Password field do you see text indicating whether the two passwords match?
Given Verify Password match indicator says yes or no depending on match with the confirm Password

Scenario: C412- If you leave a required field blank and select Next, do you receive an appropriate error message?
Given Click on next without entering any valid data and verify the error messages.
Then Verify Error message is in pink box at the top
Scenario: C412- You must check terms of use and privacy
Given Verify on Leaving terms of use and privacy checkbox unckecked Errors is displayed in red

Scenario: C413- Do all error messages display correctly?
Given Verify Leave password or confirm password blank check error messages

Scenario: C414- If you fill out all required fields with valid information and select Finish, are you taken to Page 3?
Given  Verify Fill out required fields, passwords match, terms of use is checked



