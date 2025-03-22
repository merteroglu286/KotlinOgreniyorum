package com.merteroglu286.kotlinogreniyorum.data.remote

import android.util.Log
import com.merteroglu286.kotlinogreniyorum.utility.Constants.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import kotlinx.serialization.json.Json

abstract class KtorApi {
    val client = HttpClient{
        install(ContentNegotiation){
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.d("KtorApiLog", message)
                }
            }
            level = LogLevel.BODY
        }
    }

    fun HttpRequestBuilder.pathUrl(path: String){
        url {
            takeFrom(BASE_URL)
            path(path)
        }
    }
}
