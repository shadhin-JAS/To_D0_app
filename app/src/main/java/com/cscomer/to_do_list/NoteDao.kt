package com.cscomer.to_do_list

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface NoteDao {
    @Insert
    fun insertData (note:Note)

    @Update
    fun update(note:Note)

    @Delete
    fun delete(note: Note)
}