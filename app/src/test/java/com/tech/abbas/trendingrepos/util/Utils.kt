package com.tech.abbas.trendingrepos.util

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody

fun errorBodyTest(): ResponseBody {
    return ResponseBody.create("application/json".toMediaTypeOrNull(), "")
}
