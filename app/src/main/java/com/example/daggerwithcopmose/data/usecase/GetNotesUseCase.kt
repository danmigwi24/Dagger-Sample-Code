package com.example.daggerwithcopmose.data.usecase

import com.example.daggerwithcopmose.data.model.Note
import com.example.daggerwithcopmose.data.model.NoteOrder
import com.example.daggerwithcopmose.data.model.OrdetType
import com.example.daggerwithcopmose.data.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrdetType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrdetType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> {
                            notes.sortedBy { it.title.lowercase() }
                        }
                        is NoteOrder.Date -> {
                            notes.sortedBy { it.timestamp }
                        }
                        is NoteOrder.Color -> {
                            notes.sortedBy { it.color }
                        }
                    }
                }
                is OrdetType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> {
                            notes.sortedByDescending { it.title.lowercase() }
                        }
                        is NoteOrder.Date -> {
                            notes.sortedByDescending { it.timestamp }
                        }
                        is NoteOrder.Color -> {
                            notes.sortedByDescending { it.color }
                        }
                    }
                }
            }
        }
    }
}