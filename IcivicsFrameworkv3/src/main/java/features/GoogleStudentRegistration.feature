Feature: Google Student Registration Validation

Scenario: C557 - Do you see field for Agree to Terms of Use/Privacy Policy?
Given Launch the icivis URL
Then Verify field for agree to terms of use privacy policy

Scenario: C558 - If you do not check agree to terms of use, does it display an error message
Given Leave agree to terms of use checkbox unchecked and click finish and verify the result

Scenario: C559 - If you enter valid information, do not check sync classes, does it move you to the next page
Given Verify Check box for agree to terms of use and click finish
