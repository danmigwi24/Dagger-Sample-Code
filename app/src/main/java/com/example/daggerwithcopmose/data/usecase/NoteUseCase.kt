package com.example.daggerwithcopmose.data.usecase

data class NoteUseCase(
    val getNote: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase,
    val addNoteUseCase: AddNoteUseCase
)
