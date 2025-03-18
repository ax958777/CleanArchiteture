package com.example.cleanarchiteture.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchiteture.data.local.NoteDao
import com.example.cleanarchiteture.data.local.NoteDatabase
import com.example.cleanarchiteture.data.repository.NoterepositoryImpl
import com.example.cleanarchiteture.domain.repository.NoteRepository
import com.example.cleanarchiteture.domain.use_case.GetNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application):NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            "notes_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(db:NoteDatabase): NoteDao {
        return db.noteDao
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dao:NoteDao): NoteRepository {
        return NoterepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideGetNotesUseCase(repository:NoteRepository):GetNotesUseCase {
        return GetNotesUseCase(repository)
    }
}