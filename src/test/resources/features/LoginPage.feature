	Feature: Login Page Testing.
		@regression @smoke
		Scenario Outline: Login with Valid Credentials
		Given I Launch the Login Page
		When I enter the username <username> and password <password>
			And I click the login button
		Then I expect to see the home page
		Examples:
				| username | password |
				| Admin	   | admin123 |