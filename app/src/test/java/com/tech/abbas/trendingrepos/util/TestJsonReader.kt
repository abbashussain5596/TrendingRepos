package com.tech.abbas.trendingrepos.util

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.ByteArrayOutputStream
import java.io.InputStream

object TestJsonReader {

    inline fun <reified T : Any> createResponseFromFile(fileName: String): List<T> {
        val inputStream: InputStream =
            this.javaClass.classLoader!!.getResourceAsStream(fileName)
        val json: String? = inputStream.readTextStream()

        val moshi = Moshi.Builder().build()

        val type = Types.newParameterizedType(
            MutableList::class.java, T::class.java
        )

        val adapter =
            moshi.adapter<List<T>>(type)
        val reasons: List<T>? = adapter.fromJson(json!!)

        return reasons!!
    }

    inline fun <reified T : Any> createObjectFromFile(fileName: String): T {
        val inputStream: InputStream =
            this.javaClass.classLoader!!.getResourceAsStream(fileName)
        val json: String? = inputStream.readTextStream()

        val moshi = Moshi.Builder().build()

        val adapter =
            moshi.adapter(T::class.java)
        val reasons: T? = adapter.fromJson(json!!)

        return reasons!!
    }

    inline fun InputStream.readTextStream(): String? {
        val result = ByteArrayOutputStream()
        val buffer = ByteArray(1024)
        var length: Int
        while (this.read(buffer).also { length = it } != -1) {
            result.write(buffer, 0, length)
        }
        return result.toString("UTF-8")
    }
}
