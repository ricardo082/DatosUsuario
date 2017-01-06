package castro.ricardo.com.datosusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;

public class ConfirmaDatos extends AppCompatActivity {

    private TextView tvNombreConfirmar;
    private TextView tvFechaNacimientoConfirmar;
    private TextView tvTelefonoConfirmar;
    private TextView tvEmailConfirmar;
    private TextView tvDescripcionConfirmar;

    private Button btnEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_datos);

        tvNombreConfirmar = (TextView) findViewById(R.id.tvNombreCompletoUsuario);
        tvFechaNacimientoConfirmar = (TextView) findViewById(R.id.tvFechaNacimientoUsuario);
        tvTelefonoConfirmar = (TextView) findViewById(R.id.tvTelefonoUsuario);
        tvEmailConfirmar = (TextView) findViewById(R.id.tvEmailUsuario);
        tvDescripcionConfirmar = (TextView) findViewById(R.id.tvDescripcionUsuario);

        btnEditar = (Button) findViewById(R.id.btnEditar);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.nombre_usuario));
        String fechaNacimiento = parametros.getString(getResources().getString(R.string.fecha_nacimiento));
        String telefono = parametros.getString(getResources().getString(R.string.telefono));
        String email = parametros.getString(getResources().getString(R.string.email));
        String descripcion = parametros.getString(getResources().getString(R.string.descripcion_contacto));

        tvNombreConfirmar.setText(nombre);
        tvFechaNacimientoConfirmar.setText(fechaNacimiento);
        tvTelefonoConfirmar.setText(telefono);
        tvEmailConfirmar.setText(email);
        tvDescripcionConfirmar.setText(descripcion);


        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConfirmaDatos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.nombre_usuario), tvNombreConfirmar.getText().toString());
                intent.putExtra(getResources().getString(R.string.fecha_nacimiento), tvFechaNacimientoConfirmar.getText().toString());
                intent.putExtra(getResources().getString(R.string.telefono), tvTelefonoConfirmar.getText().toString());
                intent.putExtra(getResources().getString(R.string.email), tvEmailConfirmar.getText().toString());
                intent.putExtra(getResources().getString(R.string.descripcion_contacto), tvDescripcionConfirmar.getText().toString());
                startActivity(intent);
                finish();


            }
        });


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ConfirmaDatos.this, MainActivity.class);
            startActivity(intent);

        }

        return super.onKeyDown(keyCode, event);
    }
}
