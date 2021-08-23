package com.example.nicatribute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun Calcular(view: View ) {

        var fechaInicio = findViewById<EditText>(R.id.etFecha1).text.toString();
        var fechaFin = findViewById<EditText>(R.id.etFecha2).text.toString();

        //Obtencion del salario mensual
        var etsalaryMonth = findViewById<EditText>(R.id.idSalaryMoth).text.toString();
        var salaryMonth = etsalaryMonth!!.toDouble();

        var antiguedad = Antiguedad(fechaInicio, fechaFin);
        antiguedad.calcular();

        var indemnizacion =
            Indemnizacion(antiguedad); //verificar la manera correcta de hacer una instancia la clase Indemnizacion
        indemnizacion.calcular();
        var totaldias = indemnizacion.diasIndemnizacion;

        var Result1 = findViewById<TextView>(R.id.Result1)
        Result1.setText("Años " + antiguedad.years.toString() + ",Meses " + antiguedad.months.toString() + ",Dias " + antiguedad.days.toString());

        var Resultado4 = findViewById<TextView>(R.id.result4)
        Resultado4.setText(totaldias.toString());


        //calcular salario con forme a dias de idemnizacion
        var salaryForDays = salaryMonth / 30;
        var salaryForIndemnizacion = salaryForDays * totaldias;

        var Resultado5 = findViewById<TextView>(R.id.Result5)
        Resultado5.setText(salaryForIndemnizacion.toString())



    }
}

