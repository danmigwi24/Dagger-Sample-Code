package com.example.daggerwithcopmose.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.daggerwithcopmose.ui.theme.Purple500
import java.sql.Timestamp

@Entity
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int
) {
    companion object {
        val noteColors = listOf(Purple500, Purple500, Purple500, Purple500)
    }
}
