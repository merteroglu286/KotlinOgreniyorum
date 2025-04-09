package com.merteroglu286.kotlinogreniyorum.data.remote

import com.merteroglu286.kotlinogreniyorum.data.remote.dto.ApiResponse
import com.merteroglu286.kotlinogreniyorum.data.remote.dto.ModuleDto
import com.merteroglu286.kotlinogreniyorum.data.remote.dto.QuestionDto
import com.merteroglu286.kotlinogreniyorum.data.remote.dto.TopicDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse


class ApiService : KtorApi() {

    suspend fun getModules(): ApiResponse<List<ModuleDto>> {
        return try {
            val httpResponse: HttpResponse = client.get {
                pathUrl("modules")
            }
            val response = httpResponse.body<ApiResponse<List<ModuleDto>>>()
            response
        } catch (e: Exception) {
            ApiResponse(errorMessage = "API Error: ${e.message}")
        }
    }

    suspend fun getTopics(moduleId: Int): ApiResponse<List<TopicDto>> {
        return try {
            val httpResponse: HttpResponse = client.get {
                pathUrl("modules/${moduleId}/topics")
            }
            val response = httpResponse.body<ApiResponse<List<TopicDto>>>()
            response
        } catch (e: Exception) {
            ApiResponse(errorMessage = "API Error: ${e.message}")
        }
    }

    suspend fun getQuestions(moduleId: Int): ApiResponse<List<QuestionDto>> {
        return try {
            val httpResponse: HttpResponse = client.get {
                pathUrl("modules/${moduleId}/questions")
            }
            val response = httpResponse.body<ApiResponse<List<QuestionDto>>>()
            response
        } catch (e: Exception) {
            ApiResponse(errorMessage = "API Error: ${e.message}")
        }
    }
}