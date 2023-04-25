package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.tech.abbas.trendingrepos.presentation.mock.GithubReposProvider
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepoExpandedViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup(){
        composeTestRule.setContent {
            ExpandedView(GithubReposProvider.githubRepo)
        }
    }

    @Test
    fun whenExpandedViewStartsAllViewsExists(){

        composeTestRule.onNodeWithTag(USER_IMAGE).assertExists()
        composeTestRule.onNodeWithTag(USER_NAME).assertExists().assertTextEquals("some-username")
        composeTestRule.onNodeWithTag(USER_REPO).assertExists().assertTextEquals("some-repoName")
        composeTestRule.onNodeWithTag(REPO_DESC).assertExists().assertTextEquals("some-desc")
        composeTestRule.onNodeWithTag(REPO_LANG).assertExists()
        composeTestRule.onNodeWithTag(REPO_STAR).assertExists()
        composeTestRule.onNodeWithTag(DIVIDER_LINE).assertExists()
        composeTestRule.onRoot(useUnmergedTree = false).printToLog("ExpandedState")

    }

    companion object RepoExpandedViewConst{
        const val USER_IMAGE = "userImage"
        const val USER_NAME = "userName"
        const val USER_REPO = "userRepo"
        const val REPO_DESC = "repoDesc"
        const val REPO_LANG = "repoLang"
        const val REPO_STAR = "repoStar"
        const val DIVIDER_LINE = "divider"
    }
}