package com.tech.abbas.trendingrepos.base

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.tech.abbas.trendingrepos.HiltTestActivity
import com.tech.abbas.trendingrepos.base.network.MockServerDispatcher
import dagger.hilt.android.testing.HiltAndroidRule
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Rule

internal open class BaseTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<HiltTestActivity>()

    val mockWebServer by lazy { MockWebServer() }

    fun startMockServer() {
        mockWebServer.start(8090)
    }

    fun initSuccessMockServerDispatcher() {
        mockWebServer.dispatcher = MockServerDispatcher().SuccessDispatcher()
    }

    fun initFailureMockServerDispatcher(errorCode: Int = 404) {
        mockWebServer.dispatcher = MockServerDispatcher().FailureDispatcher(errorCode)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }
}
