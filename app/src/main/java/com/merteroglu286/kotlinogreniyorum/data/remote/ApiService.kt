package com.merteroglu286.kotlinogreniyorum.data.remote

import android.util.Log
import com.merteroglu286.kotlinogreniyorum.data.remote.dto.ApiResponse
import com.merteroglu286.kotlinogreniyorum.data.remote.dto.ModuleDto
import com.merteroglu286.kotlinogreniyorum.data.remote.dto.TopicDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

private const val TAG = "mertLog"

class ApiService : KtorApi() {

    suspend fun getModules(): ApiResponse<List<ModuleDto>> {
        return try {
            Log.d(TAG, "Fetching modules from API")
            val httpResponse: HttpResponse = client.get {
                pathUrl("modules")
            }

            Log.d(TAG, "API Response Status: ${httpResponse.status}")

            val response = httpResponse.body<ApiResponse<List<ModuleDto>>>()
            Log.d(TAG, "Response parsed successfully: ${response.data?.size ?: 0} modules")
            response
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching modules: ${e.message}", e)
            ApiResponse(errorMessage = "API Error: ${e.message}")
        }
    }

    suspend fun getTopics(moduleId: Int): ApiResponse<List<TopicDto>> {
        return try {
            Log.d(TAG, "Fetching modules from API")
            val httpResponse: HttpResponse = client.get {
                pathUrl("modules/${moduleId}/topics")
            }

            Log.d(TAG, "API Response Status: ${httpResponse.status}")

            val response = httpResponse.body<ApiResponse<List<TopicDto>>>()
            Log.d(TAG, "Response parsed successfully: ${response.data?.size ?: 0} modules")
            response
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching modules: ${e.message}", e)
            ApiResponse(errorMessage = "API Error: ${e.message}")
        }
    }
}