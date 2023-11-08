package com.keser.notebookmvvm.feature_note.presentation.notes

import com.keser.notebookmvvm.feature_note.domain.model.Note
import com.keser.notebookmvvm.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(var noteOrder: NoteOrder, val title: String = "") : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
    //data class OrderByTitle(val noteOrder: NoteOrder, ) : NotesEvent()
}
