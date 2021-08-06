package com.example.nicatribute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.time.LocalDate
import java.time.Period
import java.time.Year

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun Calcular(view: View) {

        var fecha1 = findViewById<EditText>(R.id.etFecha1).text.toString();
        var fecha2 = findViewById<EditText>(R.id.etFecha2).text.toString();

        val listDate1 = fecha1.split("/")
        var year1 = listDate1[0].toInt()
        var moth1 = listDate1[1].toInt()
        var day1 = listDate1[2].toInt()

        val listDate2 = fecha2.split("/")
        var year2 = listDate2[0].toInt()
        var moth2 = listDate2[1].toInt()
        var day2 = listDate2[2].toInt()

        var datestart = LocalDate.of(year1, moth1, day1);
        var dateEnd = LocalDate.of(year2, moth2, day2);

        var antiguedad = Period.between(datestart, dateEnd);

        var Result1 = findViewById<TextView>(R.id.Result1)
        Result1.setText(antiguedad.years.toString());

        var Result2 = findViewById<TextView>(R.id.Result2)
        Result2.setText(antiguedad.months.toString());

        var Result3 = findViewById<TextView>(R.id.Result3)
        Result3.setText(antiguedad.days.toString());




    }
}