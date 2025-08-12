
	Feature: Get the Products list using API.
		@smoke
		Scenario Outline: Retreive the Products using API
		Given Set the base url
		When I hit the get products list API
		Then I expect to see the statuscode as 200
			And I validate the rate of product <number> as <ProductPrice>
		Examples:
				|number|ProductPrice|
				|1     |3.9         |
				|2     |4.1         |
			