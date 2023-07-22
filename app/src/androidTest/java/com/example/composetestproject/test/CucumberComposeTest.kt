package com.example.composetestproject.test

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.composetestproject.MainActivity
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When


/**
 * Created by Santu Kumar Bhuniya on 18/07/23.
 */

class CucumberComposeTest (val composeRuleHolder: ComposeRuleHolder,
                           val scenarioHolder: ActivityScenarioHolder
):
    SemanticsNodeInteractionsProvider by composeRuleHolder.composeRule{

   @Given("^I initialize App")
   fun initializeApp(){
       val instrumentation = InstrumentationRegistry.getInstrumentation()
       scenarioHolder.launch(MainActivity.create(instrumentation.targetContext,null))
   }

    @When("^I click Greet Cucumber")
    fun checkButtonClick(){
        val button = onNode(hasText("Greet Cucumber"),true)
        button.assertIsDisplayed()
        button.performClick()
    }
    @Then("^Show Cucumber greeting")
    fun checkGreetingText(){
        onNode(hasTestTag("greeting_test")).assert(hasText("Hi Cucumber!"))
    }
    @When("^I click Greet Espresso")
    fun greetEspresso(){
        onNode(hasText("Greet Espresso"),true)
            .assertIsDisplayed().performClick()
    }
    @Then("^Show Espresso Page")
    fun showEspressoPage(){
        onNode(hasTestTag("greet_espresso")).assert(hasText("Hello Espresso"))
    }

    @When("^I click Greet Cucumber Espresso Page")
    fun greetCucumberButtonPress(){
        onNode(hasText("Greet Cucumber"),true)
            .assertIsDisplayed().performClick()
    }

    @Then("^I am on Greet CucumberCompose Page")
    fun greetCucumberPage(){
        onNode(hasTestTag("greeting_test")).assert(hasText("Hi Compose Cucumber!"))
    }


}

