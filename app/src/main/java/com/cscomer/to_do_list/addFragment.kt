package com.cscomer.to_do_list

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.provider.CalendarContract.Calendars
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.cscomer.to_do_list.databinding.FragmentAddBinding
import java.sql.Time
import java.time.Month
import java.util.Calendar
import java.util.TimeZone


class addFragment : Fragment() {

    lateinit var binding: FragmentAddBinding
         var showtime:String?=null
         var showdate:String?=null

    lateinit var database: NoteDatabase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)

        database= Room.databaseBuilder(requireActivity(),NoteDatabase::class.java,"Note-DB")
            .allowMainThreadQueries().build()


        binding.dateTV.setOnClickListener {

               pickADate()
           }

           binding.timeTV.setOnClickListener{


               pickTime()
           }
        binding.subTV.setOnClickListener {
            val titlestr=binding.editTV.text.toString()
            val timestr=  showtime ?:"00:00"
            val datestr=  showdate ?:"00:00:00"

        val note=Note(title=titlestr, time = timestr, date = datestr)
            database.getNoteDao().insertData(note)


            

        }


        return binding.root
    }

    private fun pickTime() {
      val time=Calendar.getInstance()

        val minute=time.get(Calendar.MINUTE)
        val hour=time.get(Calendar.HOUR_OF_DAY)

     val showtimePicker=  TimePickerDialog(requireActivity(),TimePickerDialog.OnTimeSetListener{view,hour,minute->

           showtime="$hour:$minute"
            binding.timeTV.text=showtime

        },hour,minute,false

        )
        showtimePicker.show()



    }

    private fun pickADate() {

        val calendar = Calendar.getInstance()

        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)


      val showdatePicker=  DatePickerDialog(
            requireActivity(), DatePickerDialog.
            OnDateSetListener
            { View, year, month, dayofmonth ->

          showdate="$dayofmonth/$month/$year"
                binding.dateTV.text=showdate


            }, year, month, day,

        )

        showdatePicker.show()
    }

}