package castro.ricardo.com.datosusuario;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Ricardo Castro Tapia on 6/01/2017.
 */

public class EstablecerFecha {

    final java.util.Calendar myCalendar = java.util.Calendar.getInstance();


    private TextView textView;


    public EstablecerFecha(Context miContexto, TextView miTextView) {
        mostrarPicker(miContexto);
        this.textView = miTextView;
    }


    public void mostrarPicker(Context contexto){
        new DatePickerDialog(contexto, pickerFecha, myCalendar
                .get(java.util.Calendar.YEAR), myCalendar.get(java.util.Calendar.MONTH),
                myCalendar.get(java.util.Calendar.DAY_OF_MONTH)).show();

    }

    //  Establece las configuraciones necesarias para llenar los campos requeridos
    final DatePickerDialog.OnDateSetListener pickerFecha = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(java.util.Calendar.YEAR, year);
            myCalendar.set(java.util.Calendar.MONTH, monthOfYear);
            myCalendar.set(java.util.Calendar.DAY_OF_MONTH, dayOfMonth);
            getFecha(myCalendar);
        }

    };

    private void getFecha(java.util.Calendar myCalendar) {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ROOT);
        textView.setText(sdf.format(myCalendar.getTime()));


    }


}