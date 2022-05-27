 @login
  Feature:Login
    @TC1
    Scenario: The user should be able to login with valid credentials
      Given The	user should be in the login page
      When The user enters a valid credentials
      Then Verify that the user is successfully logged in
    @TC2
    Scenario: The user should not be able to login with invalid	credentials
      When The user enters a following invalid "invalid@gmail.com" and "invalidPassword"
      Then Error message should be displayed

    @TC3
    Scenario: End to end testing
      Given The	user should be in the login page
      When The user enters a valid credentials
      Then Verify that the user is successfully logged in
      When Navigate to Products page and search for "Green Side Placket Detail T-Shirt"
      Then Verify that the prices is RS 1000
      When Add the "Green Side Placket Detail T-shirt" to the basket
      When Search and Add the "Fancy Green Top" to the basket
      When Process to basket and to checkout
      Then Verify that the Green Side Placket Detail T-shirt is in checkout (Assert)
      Then Verify that the Fancy Green Top is in checkout (Assert)
      When Select Place Order and enter in the following banking information: Name on card: "Sadik" , Card Number: 6210, Cvc: 123, Expiration: 11, Year: 2077
      When Pay and confirm order
      Then Verify that the order has been placed (Assert)