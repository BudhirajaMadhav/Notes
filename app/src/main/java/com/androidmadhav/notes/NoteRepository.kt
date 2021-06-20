package com.androidmadhav.notes

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

//    Ho sakta hai daqo ki bajay kahi or se leke aa rha ho toh ab
//    viewModel ko uski tnsn nahi leni wo sab ab data kaha se lana hai ye repo dekh legi
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}