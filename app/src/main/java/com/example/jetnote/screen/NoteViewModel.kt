package com.example.jetnote.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnote.model.Note
import com.example.jetnote.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    //private var noteList = mutableStateListOf<Note>()

    private var _noteList = MutableStateFlow<List<Note>>(emptyList()) // private

    val noteList = _noteList.asStateFlow() //public

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect { listOfNotes ->
                if (listOfNotes.isNullOrEmpty())
                    Log.d("empty", ": Empty List ")
                else
                    _noteList.value = listOfNotes
            }
        }
//        noteList.addAll(NotesDataSources().loadNotes())
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }

    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }

    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }

}