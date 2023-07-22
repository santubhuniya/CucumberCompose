package com.example.composetestproject.test

import androidx.compose.ui.test.junit4.createEmptyComposeRule
import io.cucumber.junit.WithJunitRule
import org.junit.Rule


/**
 * Created by Santu Kumar Bhuniya on 19/07/23.
 */
@WithJunitRule
class ComposeRuleHolder {

    @get:Rule(order = 1)
    val composeRule = createEmptyComposeRule()
}