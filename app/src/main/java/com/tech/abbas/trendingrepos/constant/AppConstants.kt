package com.tech.abbas.trendingrepos.constant

internal object AppConstants {
    private const val GATEWAY_DOMAIN = "api.github.com/search/repositories?q=language=+sort:stars"
    const val GATEWAY_URL = "https://$GATEWAY_DOMAIN/"
}