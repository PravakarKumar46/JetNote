package com.example.jetnote.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.jetnote.data.NotesDataSources
import com.example.jetnote.model.Note

class NoteViewModel : ViewModel() {

    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSources().loadNotes())
    }

    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note> {
        return noteList
    }
}