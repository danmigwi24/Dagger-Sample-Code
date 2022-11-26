package com.example.daggerwithcopmose.ui.notes

import com.example.daggerwithcopmose.data.model.Note
import com.example.daggerwithcopmose.data.model.NoteOrder
import com.example.daggerwithcopmose.data.model.OrdetType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrdetType.Descending),
    val isOrderSelectionVisible: Boolean = false
)