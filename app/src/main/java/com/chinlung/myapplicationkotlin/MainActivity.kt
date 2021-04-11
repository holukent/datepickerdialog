package com.chinlung.myapplicationkotlin

import android.app.DatePickerDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = Calendar.getInstance()
        findViewById<DatePicker>(R.id.date_picker).init(
            calendar[Calendar.YEAR], calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH],
        ) { view, year, month, day ->
            val msg = "$year, ${month + 1}, $day"
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }

        val editdate = findViewById<EditText>(R.id.EditPicker)
        editdate.setOnClickListener {
            val year = calendar[Calendar.YEAR]
            val month = calendar[Calendar.MONTH]
            val day = calendar[Calendar.DAY_OF_MONTH]

            val onSetListener = DatePickerDialog.OnDateSetListener{view: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
                editdate.setText("$year $month $dayOfMonth")
            }
            val datepickerdialog = DatePickerDialog(this,onSetListener,year,month,day)
            datepickerdialog.show()
        }
    }
}