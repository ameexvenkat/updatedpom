Feature: Page2TeacherRegistration Validation

Scenario: C545 - Can you tell which page you are currently viewing in the breadcrumbs?
Given Launch the icivis URL
Then Verify Breadcrumb indicator shows page 2

Scenario: C546 - Do you see fields for teaching state, school or institution, and zip code?
Given Verify the fields for teaching state, school or institution, and zip code display for page 2