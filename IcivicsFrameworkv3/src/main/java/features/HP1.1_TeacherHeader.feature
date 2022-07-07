Feature: Homepage HeaderTeacher page Validation

Scenario: C3 -While on all other pages, do you see buttons for Play, Teach, About, Donate, Shop, and My iCivics in the navigation bar?
Given Launch the icivics URL
When homepage is loaded successfully
Then Verify Play buttons should appear in the top right
Then Verify Teach buttons should appear in the top right
Then Verify About buttons should appear in the top right
Then Verify Donate buttons should appear in the top right
Then Verify Shop buttons should appear in the top right
And Verify after login MyIcivics buttons should appear in the top right
Then Verify header button after login

Scenario: C4-Are all header elements consistent with those in the mockups?(Need to take one content from each content type)
Given Verify Header elements are consistent with mockup
Then Verify curriculum unit content type 
Then Verify DBquest content type 
Then Verify Game content type
Then Verify Lessonplay content type 
Then Verify Professional development content type 
Then Verify Video content type 
Then Verify Webquest content type 

Scenario: C6-Do all buttons have hover/click states?
Given Verify playbutton should have Hand cursor should appear over buttons Tooltip appears after hover.
Then Verify teachbutton should have Hand cursor should appear over buttons Tooltip appears after hover.
Then Verify aboutbutton should have Hand cursor should appear over buttons Tooltip appears after hover.
Then Verify donatebutton should have Hand cursor should appear over buttons Tooltip appears after hover.
Then Verify shopbutton should have Hand cursor should appear over buttons Tooltip appears after hover.
Then Verify myicivicsbutton should not present for anonymous user it should present only when we login
Then Verify afterlogin myicivicsbutton should have Hand cursor should appear over buttons Tooltip appears after hover.

Scenario: C7-Does the header resize responsively at different resolutions?
Given  Verify header resize turn into hamburger menu when its small enough
Then Verify card is displaying in list pattern on resizing the window

