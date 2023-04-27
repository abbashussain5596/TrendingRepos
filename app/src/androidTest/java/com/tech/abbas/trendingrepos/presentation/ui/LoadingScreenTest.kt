package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tech.abbas.trendingrepos.presentation.mock.GithubReposProvider
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoadingScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            LoadingScreen()
        }
    }

    @Test
    fun whenViewStartsShimmerExists() {
        composeTestRule.onNodeWithTag(LOADING_SHIMMER).assertExists()
    }

    @Test
    fun whenLoadingStartsAllComponentsShouldExists() {

        val shimmerCount =
            composeTestRule.onAllNodes(hasTestTag(LOADING_SHIMMER)).fetchSemanticsNodes().size
        val imageCount =
            composeTestRule.onAllNodes(hasTestTag(IMAGE_BOX)).fetchSemanticsNodes().size
        val nameCount =
            composeTestRule.onAllNodes(hasTestTag(NAME_BOX)).fetchSemanticsNodes().size
        val descCount =
            composeTestRule.onAllNodes(hasTestTag(DESC_BOX)).fetchSemanticsNodes().size
        val dividerCount =
            composeTestRule.onAllNodes(hasTestTag(DIVIDER_LINE)).fetchSemanticsNodes().size

        assert(shimmerCount == 9)
        assert(imageCount == 9)
        assert(nameCount == 9)
        assert(descCount == 9)
        assert(dividerCount == 9)
    }

    companion object RepoLoadingConst {
        const val LOADING_SHIMMER = "shimmer"
        const val IMAGE_BOX = "imageBox"
        const val NAME_BOX = "nameBox"
        const val DESC_BOX = "descBox"
        const val DIVIDER_LINE = "dividerLine"

    }

}