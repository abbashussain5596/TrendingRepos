package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tech.abbas.trendingrepos.presentation.mock.GithubReposProvider
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepoCollapsedViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup(){
        composeTestRule.setContent {
            RepoCollapsedView(GithubReposProvider.githubRepo)
        }
    }

    @Test
    fun whenViewStartsAllViewsExists(){
        composeTestRule.onNodeWithTag(USER_IMAGE).assertExists()
        composeTestRule.onNodeWithTag(USER_NAME).assertExists().assertTextEquals("some-username")
        composeTestRule.onNodeWithTag(USER_REPO).assertExists().assertTextEquals("some-repoName")
        composeTestRule.onNodeWithTag(DIVIDER_LINE).assertExists()

    }

    companion object RepoCollapsedViewConst{
        const val USER_IMAGE = "userImage"
        const val USER_NAME = "userName"
        const val USER_REPO = "userRepo"
        const val DIVIDER_LINE = "divider"
    }

}