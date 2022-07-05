Feature: Homepage Teach submenu link underlinedtext Validation

Scenario: C19 - If you are viewing one of the pages in the Teach submenu, is that page underlined in the submenu?
Given Launch the icivics URL
Then Verify on Clicking teach button at top teach submenu open
Then Verify main teach page appears with underlined 
Then Verify scope and sequence page display with underlined
Then Verify professional Development page display with underlined
Then Verify get started page display with underlined
Then Verify faq page display with underlined
And Verify teach menu close on clicking again

