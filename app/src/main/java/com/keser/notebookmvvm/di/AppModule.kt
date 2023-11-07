package com.keser.notebookmvvm.di

import android.app.Application
import androidx.room.Room
import com.keser.notebookmvvm.feature_note.data.data_source.NoteDatabase
import com.keser.notebookmvvm.feature_note.data.repository.NoteRepositoryImp
import com.keser.notebookmvvm.feature_note.domain.repository.NoteRepository
import com.keser.notebookmvvm.feature_note.domain.use_case.AddNote
import com.keser.notebookmvvm.feature_note.domain.use_case.DeleteNote
import com.keser.notebookmvvm.feature_note.domain.use_case.GetNote
import com.keser.notebookmvvm.feature_note.domain.use_case.GetNotes
import com.keser.notebookmvvm.feature_note.domain.use_case.NoteUseCases
import com.keser.notebookmvvm.feature_note.domain.use_case.SearchNotes
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
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImp(db.dao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository),
            searchNotes = SearchNotes(repository)
        )
    }
}