package com.androidmadhav.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ViewModelProvider ViewModel laake deti hai
//        Aur owner(activity) ke lifecycle-> onCreate/onDelete ke saath aatch ho jayega

//        this is owner
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, Observer {
//            Observer ke andr sirf ek hi func toh directly implement

        })

    }


}