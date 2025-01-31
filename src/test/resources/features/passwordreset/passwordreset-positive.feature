@password-reset
Feature: Password Reset
  Scenario Outline: Successful Password Reset
    # Ask for a password reset link
    Given the user is on the "Password Reset" page
    When the user enters "<email>" as the email
    When the user clicks on the send password reset link button
    Then the user should see a message saying "<message>"
    # Reset the password
    When the user goes to the reset link
    When the user enters "<password>" as their new password
    When the user clicks on the password reset button
    Then the user should be redirected to the "Login" page
    # Verify the new password works
    When the user enters "<email>" as email
    And the user enters "<password>" as password
    And the user clicks on the login button
    Then the user should be redirected to the "Home" page

    Examples:
      | email | password | message |
      | jane@gmail.com | P@ssword123 | A link to reset your password has been sent to 'jane@gmail.com', please check your email! |
      | jane@gmail.com | password | A link to reset your password has been sent to 'jane@gmail.com', please check your email! |

    # second case is just to reset the password to the expected value for other tests