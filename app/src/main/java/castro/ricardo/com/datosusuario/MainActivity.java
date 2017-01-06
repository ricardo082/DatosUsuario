package castro.ricardo.com.datosusuario;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnSiguiente;

    TextView tvNombre;
    TextView tvFechaNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        tvNombre = (TextView) findViewById(R.id.tvNombreCompleto);
        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);


        try {
            Bundle parametros = getIntent().getExtras();

            String nombre = parametros.getString(getResources().getString(R.string.nombre_usuario));
            String fechaNacimiento = parametros.getString(getResources().getString(R.string.fecha_nacimiento));
            String telefono = parametros.getString(getResources().getString(R.string.telefono));
            String email = parametros.getString(getResources().getString(R.string.email));
            String descripcion = parametros.getString(getResources().getString(R.string.descripcion_contacto));

            tvNombre.setText(nombre);
            tvFechaNacimiento.setText(fechaNacimiento);
            tvTelefono.setText(telefono);
            tvEmail.setText(email);
            tvDescripcion.setText(descripcion);
        } catch (java.lang.NullPointerException e) {

        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ConfirmaDatos.class);
                intent.putExtra(getResources().getString(R.string.nombre_usuario), tvNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.fecha_nacimiento), tvFechaNacimiento.getText().toString());
                intent.putExtra(getResources().getString(R.string.telefono), tvTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.email), tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.descripcion_contacto), tvDescripcion.getText().toString());
                startActivity(intent);
                finish();


            }
        });


        tvFechaNacimiento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    new EstablecerFecha(MainActivity.this, tvFechaNacimiento);
                }
            }
        });

        tvFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EstablecerFecha(MainActivity.this, tvFechaNacimiento);
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {


        if (keyCode == KeyEvent.KEYCODE_BACK) {

            finishAffinity();
        }

        return super.onKeyDown(keyCode, event);
    }

}
