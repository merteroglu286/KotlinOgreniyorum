package com.merteroglu286.kotlinogreniyorum.utility

import com.merteroglu286.kotlinogreniyorum.data.remote.dto.ModuleDto
import com.merteroglu286.kotlinogreniyorum.data.remote.dto.QuestionDto
import com.merteroglu286.kotlinogreniyorum.data.remote.dto.TopicDto
import com.merteroglu286.kotlinogreniyorum.domain.model.Module
import com.merteroglu286.kotlinogreniyorum.domain.model.Question
import com.merteroglu286.kotlinogreniyorum.domain.model.Topic

fun ModuleDto.toModule(): Module {
    return Module(
        id = id,
        title = title,
        description = description
    )
}

fun List<ModuleDto>.toModuleList(): List<Module> {
    return map { it.toModule() }
}

fun TopicDto.toTopic(): Topic {
    return Topic(
        id = id,
        title = title,
        moduleId = moduleId,
        content = content,
        examples = examples
    )
}

fun List<TopicDto>.toTopicList(): List<Topic> {
    return map { it.toTopic() }
}

fun QuestionDto.toQuestion(): Question {
    return Question(
        id = id,
        moduleId = moduleId,
        questionText = questionText,
        options = options,
        correctAnswerIndex = correctAnswerIndex
    )
}

fun List<QuestionDto>.toQuestionList(): List<Question> {
    return map { it.toQuestion() }
}