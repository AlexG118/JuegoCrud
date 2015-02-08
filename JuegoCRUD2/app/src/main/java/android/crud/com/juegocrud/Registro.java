package android.crud.com.juegocrud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.crud.com.juegocrud.MainActivity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Registro extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_juego);

        Button btn_registro = (Button) findViewById(R.id.btn_registrar);

        btn_registro.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText nombre = (EditText) findViewById(R.id.edit_nombre);
                EditText descripcion = (EditText) findViewById(R.id.edit_desc);
                EditText precio = (EditText) findViewById(R.id.edit_precio);

                Juego juego = new Juego(nombre.getText().toString(), descripcion.getText().toString(),
                        Integer.parseInt(precio.getText().toString()));


                Intent it = new Intent(Registro.this, MainActivity.class);
                it.putExtra("juego", juego);
                setResult(1, it);
                finish();
            }
        });

    }

}
