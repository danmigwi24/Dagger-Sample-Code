package com.example.daggerwithcopmose.ui.notes

import com.example.daggerwithcopmose.data.model.Note
import com.example.daggerwithcopmose.data.model.NoteOrder

sealed class NoteEvent(){
    data class Order(val noteOrder: NoteOrder):NoteEvent()
    data class DeleteNote(val note: Note):NoteEvent()
    object RestoreNote:NoteEvent()
    object ToggleOrderSelection:NoteEvent()
}
