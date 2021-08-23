package com.example.nicatribute

class   Indemnizacion(var antiguedad: Antiguedad) {

    val DIAS_DEL_MES = 30.00;
    val DIAS_INDEMNIZACION_PRIMEROS_TRES_ANIOS = 30.00;
    val DIAS_INDEMNIZACION_TERCER_ANIO_ADELANTE = 20.00;
    val MESES_MAXIMOS_INDEMNIZACION = 6.00;
    val ONE_YEAR = 1;

    var diasIndemnizacion = 0.0;

    var firstDays = 0.0;
    var daysRestOfYears = 0.0;
    var daysFromMoths = 0.0;
    var daysFromDays = 0.0;


    fun calcular() {
        var yearsAntiguedad = antiguedad.years;
        var mothsAntiguedad = antiguedad.months;
        var daysAntiguedad = antiguedad.days;

        if (yearsAntiguedad >= MESES_MAXIMOS_INDEMNIZACION) {
            diasIndemnizacion =
                (DIAS_INDEMNIZACION_PRIMEROS_TRES_ANIOS * 3) + (DIAS_INDEMNIZACION_TERCER_ANIO_ADELANTE * 3);

        }
        if ((yearsAntiguedad >= 3) and (yearsAntiguedad <= 5)) {
            firstDays = DIAS_INDEMNIZACION_PRIMEROS_TRES_ANIOS * 3;
            daysRestOfYears = DIAS_INDEMNIZACION_TERCER_ANIO_ADELANTE * (yearsAntiguedad - 3);
            daysFromMoths =
                ((mothsAntiguedad * DIAS_DEL_MES) * DIAS_INDEMNIZACION_TERCER_ANIO_ADELANTE / 360);
            daysFromDays = daysAntiguedad * DIAS_INDEMNIZACION_TERCER_ANIO_ADELANTE / 360;
            diasIndemnizacion = firstDays + daysRestOfYears + daysFromMoths + daysFromDays;

        }

        if ((yearsAntiguedad < 3) and (yearsAntiguedad >= 1)) {
            firstDays = (DIAS_INDEMNIZACION_PRIMEROS_TRES_ANIOS * yearsAntiguedad);
            daysFromMoths =
                ((mothsAntiguedad * DIAS_DEL_MES) * DIAS_INDEMNIZACION_PRIMEROS_TRES_ANIOS) / 360;
            daysFromDays = daysAntiguedad * DIAS_INDEMNIZACION_PRIMEROS_TRES_ANIOS / 360;
            diasIndemnizacion = firstDays + daysFromMoths + daysFromDays;

        }
        if (yearsAntiguedad < ONE_YEAR) {
            daysFromMoths =
                ((mothsAntiguedad * DIAS_DEL_MES) * DIAS_INDEMNIZACION_PRIMEROS_TRES_ANIOS) / 360;
            daysFromDays = daysAntiguedad * DIAS_INDEMNIZACION_PRIMEROS_TRES_ANIOS / 360;
            diasIndemnizacion = daysFromMoths + daysFromDays;

        }

    }

}