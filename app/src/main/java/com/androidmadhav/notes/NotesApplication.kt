package com.androidmadhav.notes

import android.app.Application

class NotesApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { NoteDatabase.getDatabase(this) }
    val repository by lazy { NoteRepository(database.getNoteDao()) }
}
