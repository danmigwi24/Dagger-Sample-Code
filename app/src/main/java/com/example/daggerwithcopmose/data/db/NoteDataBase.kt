package com.example.daggerwithcopmose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggerwithcopmose.data.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDataBase :RoomDatabase(){
    abstract val noteDao: NoteDao
}
