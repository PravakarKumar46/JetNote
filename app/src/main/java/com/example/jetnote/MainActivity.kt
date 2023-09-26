package com.example.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetnote.screen.NoteScreen
import com.example.jetnote.screen.NoteViewModel
import com.example.jetnote.ui.theme.JetNoteTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp {
                JetNoteTheme {
                    Surface {
                        val noteViewModel: NoteViewModel by viewModels()
                        NoteApp(noteViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun NoteApp(noteViewModel: NoteViewModel = viewModel()) {

    val noteList = noteViewModel.getAllNotes()

    NoteScreen(notes = noteList,
        onAddNote = {
            noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        })

}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetNoteTheme {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetNoteTheme {
        val noteViewModel: NoteViewModel = viewModel()
        MyApp {
            NoteApp(noteViewModel)
        }
    }
}