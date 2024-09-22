package com.cscomer.to_do_list

import android.icu.text.CaseMap.Title
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(

    @PrimaryKey(autoGenerate = true)

    val id :Int=0,

    val title:String,
    val time:String,
    val date:String

)
