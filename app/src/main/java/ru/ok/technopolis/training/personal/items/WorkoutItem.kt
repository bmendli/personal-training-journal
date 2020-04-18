package ru.ok.technopolis.training.personal.items

import ru.ok.technopolis.training.personal.items.interfaces.WithId

data class WorkoutItem(
    override val id: String,
    val iconId: Int,
    val title: String,
    val description: String
) : WithId
