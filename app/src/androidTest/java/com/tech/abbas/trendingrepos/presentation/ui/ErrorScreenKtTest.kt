package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreenKtTest.RepoListScreen.ERROR_ANIM
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreenKtTest.RepoListScreen.ERROR_DESC
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreenKtTest.RepoListScreen.ERROR_TEXT
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreenKtTest.RepoListScreen.NETWORK_ERROR
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreenKtTest.RepoListScreen.RETRY_BUTTON
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ErrorScreenKtTest{

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup(){
        composeTestRule.setContent {
            ErrorScreen(Modifier.testTag(NETWORK_ERROR))
        }
    }

    @Test
    fun whenScreenStartsAllViewsExists(){
        composeTestRule.onNodeWithTag(ERROR_ANIM).assertExists()
        composeTestRule.onNodeWithTag(ERROR_TEXT).assertExists().assertTextEquals("Something went wrong")
        composeTestRule.onNodeWithTag(ERROR_DESC).assertExists().assertTextEquals("An alien is probably blocking your signal.")
        composeTestRule.onNodeWithTag(RETRY_BUTTON).assertExists().assertTextEquals("Retry")

    }



}