Feature: Homepage HeaderMyIcivicsMisc Validation

Scenario: C29 - Can you see an appropriate icon for Donate?
Given Launch the icivics URL
Then login as a teacher
And Verify Donate button is display

Scenario: C30 - When you select Donate, are you directed to https://give.icivics.org/?
Given Click on donate button and verify url 


Scenario: C31 - Can you see an appropriate icon for Shop?
Given Verify Shop button is display

Scenario: C32 - When you select Shop, are you directed to https://icivics.myshopify.com/?
Given login as a teacher
Then click on shop button and verify the URL 

Scenario: C34 - If you are signed in, do you see a My iCivics button instead of Sign In?
Given Launch the icivics URL
Then login as a teacher  
And Verify My iCivics button appears in top right for an authenticated user 

Scenario: C35 - Can you see your avatar icon represented in the button?
Given Verify signin as a teacher with avatar
Then Verify signin as a teacher with no avatar

Scenario: C36 - When you select Sign In/My iCivics, does a submenu open below the button?
Given login as a teacher  
And Click on Myicivics button and verify submenu display

Scenario: C39 -When you select a link in the submenu, are you navigated to the appropriate page?
Given login as a teacher  
Then Click on the submenu links of MyIcivicsbutton and verify it redirects to corresponding page

Scenario: C41 -If you are viewing one of the pages in the Sign In/My iCivics submenu, is that page underlined in the submenu?
Given Verify myicivics link is underlined.
Then Verify myclasses link is underlined.
And Verify myfavorite link is underlined.


Scenario: C42 -When you select Sign In / My iCivics again while the submenu is open, does the submenu close?
Given Verify Click on My Icivics button submenu is display and click again submenu is close
