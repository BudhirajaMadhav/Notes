package com.androidmadhav.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")

//ye constructor ke arguments column hain
//we can also change the column name explicitly
class Note(@ColumnInfo(name = "note_text") val text: String) {
//    it will autogenerate a new id no everytime we add a row
    @PrimaryKey(autoGenerate = true) var id: Int = 0

}

//Doubt: agar table ke andr ye 2 cols hain text and id toh ye Note class se delete kaise kr rha hai