Feature: Google Sign On Validation

Scenario: C539 -When you select Sign In With Google, are you asked to choose an account?
Given Launch the icivics URL
And Verify Dialog opens in same window with Google accounts that are available

Scenario: C540 -Select an account that is registered as a teacher #1
Given Enter the credentials verify My iCivics page opens for this account

Scenario: C541 -Select an account that is not registered as a teacher #2
Given Enter the credentials verify register page open 
Then Verify on clicking register as educator redirect to educator registration page 
Then Enter the fields with valid data for first page and verify the result  
Then Enter the fields with valid data for second page and verify the result 
Then Enter the fields with valid data for third page and verify the result

Scenario: C542 -Select an account that is registered as a student
Given  Enter the credentials as a student verify My iCivics page opens for this account

Scenario: C543 -Select an account that is not registered on iCivics
Given Enter the credentials not registered before and verify My iCivics page opens for this account