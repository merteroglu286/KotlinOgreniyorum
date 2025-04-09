package com.merteroglu286.kotlinogreniyorum.presentation.screen.question

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merteroglu286.kotlinogreniyorum.domain.Resource
import com.merteroglu286.kotlinogreniyorum.domain.model.Question
import com.merteroglu286.kotlinogreniyorum.domain.uce_cases.UseCases
import com.merteroglu286.kotlinogreniyorum.utility.Constants.QUESTION_ARGUMENT_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class QuestionViewModel(
    private val useCases: UseCases,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _questionListState = MutableStateFlow<QuestionListState>(QuestionListState(isLoading = true))
    val questionListState: StateFlow<QuestionListState> = _questionListState


    private var moduleId: Int = 0

    init {
        viewModelScope.launch(Dispatchers.IO) {
            moduleId = savedStateHandle.get<Int>(QUESTION_ARGUMENT_KEY) ?: 0
            loadQuestions(moduleId)
        }
    }


    fun loadQuestions(moduleId: Int) {
        viewModelScope.launch {
            useCases.getQuestionsUseCase(moduleId)
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _questionListState.value = QuestionListState(isLoading = true)
                        }
                        is Resource.Success -> {
                            _questionListState.value = QuestionListState(questions = result.data ?: emptyList())
                        }
                        is Resource.Error -> {
                            _questionListState.value = QuestionListState(
                                error = result.message ?: "Unknown error"
                            )
                        }
                    }
                }.launchIn(viewModelScope)
        }
    }

    private suspend fun getModuleCount(): Int {
        return useCases.readModuleCountUseCase().first()
    }

    private suspend fun progressStepPoint(): Float {
        val moduleCount = getModuleCount()
        val point = if (moduleCount == 0) 0f else ((100f / (moduleCount * 2)))
        return point
    }


    fun saveQuestions() {
        viewModelScope.launch {
            val completedQuestions = useCases.readCompletedQuestionsUseCase().firstOrNull() ?: emptyList()

            if (!completedQuestions.contains(moduleId)) {
                val oldProgress = useCases.readProgressUseCase().firstOrNull() ?: 0f
                val newProgress = oldProgress + progressStepPoint()
                useCases.saveProgressUseCase(newProgress)
                useCases.saveCompletedQuestionsUseCase(moduleId)
            }
        }
    }

    data class QuestionListState(
        val isLoading: Boolean = false,
        val questions: List<Question> = emptyList(),
        val error: String = ""
    )

}