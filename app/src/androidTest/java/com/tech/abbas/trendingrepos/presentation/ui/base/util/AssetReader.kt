/*
 * Copyright (c) 2023 Bazaar technologies. All rights reserved.
 */

package com.tech.abbas.trendingrepos.presentation.ui.base.util

import androidx.test.platform.app.InstrumentationRegistry
import dagger.hilt.android.testing.HiltTestApplication
import java.io.IOException
import java.io.InputStreamReader

fun readStringFromFile(fileName: String): String {
    try {
        val inputStream = (
            InstrumentationRegistry.getInstrumentation().targetContext
                .applicationContext as HiltTestApplication
            ).assets.open(fileName)
        val builder = StringBuilder()
        val reader = InputStreamReader(inputStream, "UTF-8")
        reader.readLines().forEach {
            builder.append(it)
        }
        return builder.toString()
    } catch (e: IOException) {
        throw e
    }
}
