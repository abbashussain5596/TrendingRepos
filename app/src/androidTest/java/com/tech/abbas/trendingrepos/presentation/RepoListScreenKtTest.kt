package com.tech.abbas.trendingrepos.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.tech.abbas.trendingrepos.RepoListScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class RepoListScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun repoListScreenTest() {
        composeTestRule.setContent {
            RepoListScreen()
        }
    }

    @Test
    fun whenScreenStartsToolbarCorrectlyVisible() {

        composeTestRule.onNodeWithTag(TOOLBAR_TAG).assertIsDisplayed()

    }

    companion object RepoListScreen {
        const val TOOLBAR_TAG = "toolbar"

    }
}
