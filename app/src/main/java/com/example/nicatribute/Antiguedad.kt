package com.example.nicatribute

import java.time.LocalDate
import java.time.Period

class Antiguedad(var fechaInicio: String, var fechaFin: String) {

    var years = 0;
    var months = 0;
    var days = 0;
    fun calcular() {
        var listFieldsStartDate = fechaInicio.split('/')
        var listFielsEndDate = fechaFin.split('/')

        var startYear = listFieldsStartDate[0].toInt()
        var startMoth = listFieldsStartDate[1].toInt()
        var startday = listFieldsStartDate[2].toInt()

        var endYear = listFielsEndDate[0].toInt()
        var endMoth = listFielsEndDate[1].toInt()
        var endDay = listFielsEndDate[2].toInt()

        var date1 = LocalDate.of(startYear, startMoth, startday)
        var date2 = LocalDate.of(endYear, endMoth, endDay)

        var antiguedad = Period.between(date1, date2)
        years = antiguedad.years;
        months = antiguedad.months;
        days = antiguedad.days;

    }
}