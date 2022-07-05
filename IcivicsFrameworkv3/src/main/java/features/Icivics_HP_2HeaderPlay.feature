Feature: Homepage HeaderPlay Validation

Scenario: C8 - When you select Play, does a submenu open below the Play button?
Given Launch the icivics URL
Then Verify Click on play button at top play submenu open

Scenario: C9 - Do you see links to All Games, as well as each individual game in the submenu?
Given Verify iCivics game submenu list display 
 
Scenario: C10 - When you select a link in the submenu, are you navigated to the appropriate page?
Given Verify click on each link navigate to correponding page 

Scenario: C12 - If you are viewing one of the pages in the Play submenu, is that page underlined in the submenu?
Given Verify selected page is underlined

Scenario: C13 - When you select Play again while the submenu is open, does the submenu close?
Given Verify Click on the play menu again and submenu is close

