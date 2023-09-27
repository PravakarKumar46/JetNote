package com.example.jetnote.data

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetnote.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from notes_table") //not case sensitive
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * from notes_table where id =:id") //not case sensitive
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE) //any issue is coming like duplicate or anything then we will re[lace
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE from notes_table") //not case sensitive
    suspend fun deleteAll()

    @Delete
    suspend fun delete(note: Note)

}
