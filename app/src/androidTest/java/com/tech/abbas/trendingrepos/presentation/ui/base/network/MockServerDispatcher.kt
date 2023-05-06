package com.tech.abbas.trendingrepos.presentation.ui.base.network


import com.tech.abbas.trendingrepos.presentation.ui.base.util.readStringFromFile
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.util.concurrent.TimeUnit

internal class MockServerDispatcher {

    private val endpoint = HashMap<String, String>()

    init {
        endpoint["/search/repositories?q=language=+sort:stars"] = "RepoApiResponse.json"
    }

    internal inner class SuccessDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            endpoint[request.path]?.let {
                return MockResponse().setResponseCode(200)
                    .setBody(readStringFromFile(it))
                    .setBodyDelay(1000, TimeUnit.MILLISECONDS)
            } ?: kotlin.run {
                return MockResponse().setResponseCode(400)
            }
        }
    }

    internal inner class FailureDispatcher(private val errorCode: Int = 404) : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse().setResponseCode(errorCode)
        }
    }
}

object ErrorCode {
    const val NOT_FOUND = 404
    const val BAD_REQUEST = 400
    const val INTERNAL_SERVER_ERROR = 500
}
