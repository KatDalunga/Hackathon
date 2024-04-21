Feature: Travel Insurance Plan for Students
	@Smoke @Regression
  Scenario: Go to the Travel Insurance plan for Students page.
    Given the user is on the travel insurance page
    When selects any European country
    And selects dates
    And selects No of peoples and ages
    And click on meadical issues
    And enter contact details
    #Then user is on Travel Insurance plan for students page
    
  @Regression  
  Scenario: Displaying three lowest travel insurance plan for students.
    Given the user is on the travel insurance for students page
    When select student plan and sort option
    Then user should get list of three lowest insurance plans