Feature: Homepage HeaderTeach Validation

Scenario: C15 - When you select Teach, does a submenu open below the Teach button?
Given Launch the icivics URL
Then Verify on Clicking teach button at top teach submenu open 

Scenario: C16 - Do you see links to Search Our Library, Scope and Sequence, Professional Development, Get Started, Educatory Community, and FAQ in the submenu?
Given Verify click on Teach button and menu Options display

Scenario: C17 - When you select a link in the submenu, are you navigated to the appropriate page?
Given Verify click on links in the submenu 

Scenario: C20 - When you select Teach again while the submenu is open, does the submenu close?
Given Verify click on teach menu again it close 


