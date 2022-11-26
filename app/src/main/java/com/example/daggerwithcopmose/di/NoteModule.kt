package com.example.daggerwithcopmose.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.daggerwithcopmose.data.db.NoteDataBase
import com.example.daggerwithcopmose.data.repository.NoteRepository
import com.example.daggerwithcopmose.data.repository.NoteRepositoryImpl
import com.example.daggerwithcopmose.data.usecase.AddNoteUseCase
import com.example.daggerwithcopmose.data.usecase.DeleteNoteUseCase
import com.example.daggerwithcopmose.data.usecase.GetNotesUseCase
import com.example.daggerwithcopmose.data.usecase.NoteUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDataBase {
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            "NOTE_DB"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDataBase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }


    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository): NoteUseCase {
        return NoteUseCase(
            getNote = GetNotesUseCase(repository = repository),
            deleteNote = DeleteNoteUseCase(repository = repository),
            addNoteUseCase = AddNoteUseCase(repository = repository)
        )
    }
}