Feature: Google Registration Validation

Scenario: C544 - After Google sign-in with account not registered at iCivics Select teacher registration
Given Launch the icivis URL
Then Enter credentials not registered before and select register as an Educator or parent 

Scenario: C545 -Attempt to start registration process without being signed in with Google
Given Start Registration without being signed in with google and verify the error message 

Scenario: C546 -Attempt to start registration process when already registered at iCivics
Given Start registration with already registered Id and verify the error message

Scenario: C544 - After Google sign-in with account not registered at iCivics Select student registration
Given Enter credentials not registered before and select register as Student  