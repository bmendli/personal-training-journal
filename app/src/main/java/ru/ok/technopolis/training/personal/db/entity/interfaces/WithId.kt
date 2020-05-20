package ru.ok.technopolis.training.personal.db.entity.interfaces

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

abstract class WithId(@ColumnInfo var server_id: Int = -1) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}
