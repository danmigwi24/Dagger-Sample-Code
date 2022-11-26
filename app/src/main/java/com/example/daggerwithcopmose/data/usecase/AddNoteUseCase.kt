package com.example.daggerwithcopmose.data.usecase

import com.example.daggerwithcopmose.data.model.Note
import com.example.daggerwithcopmose.data.repository.NoteRepository

class AddNoteUseCase(private val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Title of the note can't be empty")
        } else if (note.content.isBlank()) {
            throw InvalidNoteException("Content of the note can't be empty")
        }
        repository.insertNote(note)
    }
}

class InvalidNoteException(message: String) : Exception(message)