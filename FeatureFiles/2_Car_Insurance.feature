Feature: Car Insurance.
 
  @Smoke @Regression
  Scenario: Go to Car Insurance option and fill details
    Given User is on the policybazar website
    When User Click On Car Insurance
    And User select on new car
		And User select city and RTO
		Then User select car brand and variant
	
	@Regression
	Scenario: Capturing error message
		Given User is on contact details page
    When User Enters invalid email address
    Then Display the Error Message