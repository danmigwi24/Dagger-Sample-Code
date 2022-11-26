package com.example.daggerwithcopmose.data.usecase

import com.example.daggerwithcopmose.data.model.Note
import com.example.daggerwithcopmose.data.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }

}