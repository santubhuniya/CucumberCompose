package com.example.composetestproject.test

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.composetestproject.MainActivity
import com.example.composetestproject.test.ComposeRuleHolder
import io.cucumber.java.Before
import io.cucumber.java.en.Then
import io.cucumber.java.en.When


/**
 * Created by Santu Kumar Bhuniya on 18/07/23.
 */

class LaunchScreenTest (val composeRuleHolder: ComposeRuleHolder,
                        val scenarioHolder: ActivityScenarioHolder
):
    SemanticsNodeInteractionsProvider by composeRuleHolder.composeRule{

    @Before
    fun setUp(){
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        scenarioHolder.launch(MainActivity.create(instrumentation.targetContext,null))
    }

    @When("^I open compose activity")
    fun checkButtonClick(){
        val button = onNode(hasText("Say My name"),true)
        button.assertIsDisplayed()
        button.performClick()
    }

//    @Test
//    fun checkSecondPage(){
//        val buttonSecond =  composeTestRule.onNode(hasText("Second Page"),true)
//
//        buttonSecond.assertIsDisplayed()
//        buttonSecond.performClick()
//        val secondPageText = composeTestRule.onNodeWithText("Second Page View")
//        secondPageText.assertIsDisplayed()
//    }
//
//    @Test
//    fun goBackToGreeting(){
//        val buttonSecond =  composeTestRule.onNode(hasText("Second Page"),true)
//        buttonSecond.assertIsDisplayed()
//        buttonSecond.performClick()
//        val buttonGreeting =  composeTestRule.onNode(hasText("Greeting back"),true)
//        buttonGreeting.assertIsDisplayed()
//        buttonGreeting.performClick()
//    }

}

