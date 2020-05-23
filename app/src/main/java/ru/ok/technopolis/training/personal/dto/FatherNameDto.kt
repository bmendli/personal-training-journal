package ru.ok.technopolis.training.personal.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FatherNameDto(
    @SerializedName("father_name")
    @Expose
    val fatherName: String
)