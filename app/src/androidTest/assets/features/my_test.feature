Feature: Cucumber Compose Test Feature
     Scenario: Greet cucumber and compose
        Given I initialize App
        When I click Greet Cucumber
        Then Show Cucumber greeting
        When I click Greet Espresso
        Then Show Espresso Page
        When I click Greet Cucumber Espresso Page
        Then I am on Greet CucumberCompose Page

