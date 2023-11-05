package com.keser.notebookmvvm.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.keser.notebookmvvm.ui.theme.BabyBlue
import com.keser.notebookmvvm.ui.theme.LightGreen
import com.keser.notebookmvvm.ui.theme.RedOrange
import com.keser.notebookmvvm.ui.theme.RedPink
import com.keser.notebookmvvm.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String) : Exception(message)