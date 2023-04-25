package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.presentation.mock.GithubReposProvider
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreenKtTest.RepoListScreen.REPO_LIST
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepoSuccessScreenKtTest{

    @get:Rule
    val composeTestRule = createComposeRule()

    fun setup(data : List<GithubRepo> = listOf()){
        composeTestRule.setContent {
            RepoSuccessScreen(Modifier.testTag(REPO_LIST),data)
        }
    }

    @Test
    fun whenListItemsAreEmpty(){
        setup()
        composeTestRule.onNodeWithTag(REPO_LIST)
            .onChildren()
            .assertCountEquals(0)
    }

    @Test
    fun whenListItemsAreNotEmpty(){
        setup(GithubReposProvider.getGithubRepoList())
        composeTestRule.onNodeWithTag(REPO_LIST)
            .onChildren()
            .assertCountEquals(5)
    }

    @Test
    fun verifyFirstAndLastItemName(){
        setup(GithubReposProvider.getGithubRepoList())
        composeTestRule.apply {
            onNodeWithTag(REPO_LIST)
                .onChildren()
                .onFirst()
                .assert(hasText("some-username"))

            onNodeWithTag(REPO_LIST)
                .onChildren()
                .onLast()
                .assert(hasText("some-username"))
        }
    }
}