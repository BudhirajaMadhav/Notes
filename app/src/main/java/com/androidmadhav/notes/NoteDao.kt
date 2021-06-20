package com.androidmadhav.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

//    suspend: I/O operation agr main thread pe hoga toh toh app atak jayegi
//    isliye suspend ke thru ek background thread pe ye kaam karate hai
//    or ye supend funcs sirf couroutines ya already suspended funcs ke thru hi call hote hai
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

//    We can also use Flow instead of LiveData
    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>

}