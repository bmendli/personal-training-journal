package ru.ok.technopolis.training.personal.items

import ru.ok.technopolis.training.personal.items.interfaces.WithId

data class Workout(
    override val id: String,
    val time: String,
    val title: String
) : WithId
