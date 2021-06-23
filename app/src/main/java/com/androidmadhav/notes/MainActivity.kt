package com.androidmadhav.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), INotesRVAdapter {

    private val viewModel: NoteViewModel by viewModels{
        NoteViewModelFactory((application as NotesApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager  = LinearLayoutManager(this)
        val adapter = NotesRVAdapter(this, this)

        recyclerView.adapter = adapter


//        ViewModelProvider ViewModel laake deti hai
//        Aur owner(activity) ke lifecycle-> onCreate/onDelete ke saath aatch ho jayega

//        this is owner
//        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

//        ye yaha it ke aage list note ke saath ! aa rha hai means ki coming list can be nullable
        viewModel.allNotes.observe(this, Observer {
//            Observer(interface) ke andr sirf ek hi func toh directly implement
            adapter.updateList(it)
        })

        val submitButton: Button = findViewById(R.id.submitButton)

//        INSERT NOTE
        submitButton.setOnClickListener({
            val text: String = findViewById<EditText>(R.id.inputNote).text.toString()
            if(text.length != 0) {
                val newNote = Note(text)
                viewModel.insert(newNote)
            }
        })

    }

    override fun onItemClicked(note: Note) {
        viewModel.delete(note)
    }


}