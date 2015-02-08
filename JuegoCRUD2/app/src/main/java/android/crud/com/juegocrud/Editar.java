package android.crud.com.juegocrud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Editar  extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_juego);
        Intent it = getIntent();

        if(it.getExtras() != null){

            final Juego juego = (Juego) it.getSerializableExtra("juego");
            final int position = it.getIntExtra("pos", -1);

            if(juego != null){

                final TextView nombre = (TextView) findViewById(R.id.new_edit_nombre);
                nombre.setText(juego.getNombre());
                final TextView desc = (TextView) findViewById(R.id.new_edit_desc);
                desc.setText(juego.getDesc());
                final TextView precio = (TextView) findViewById(R.id.new_edit_precio);
                precio.setText(String.valueOf(juego.getPrecio()));

                Button btn_editar = (Button) findViewById(R.id.btn_editar);
                btn_editar.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        juego.setNombre(nombre.getText().toString());
                        juego.setDesc(desc.getText().toString());
                        juego.setPrecio(Integer.parseInt(precio.getText().toString()));

                        Intent it = new Intent(Editar.this, MainActivity.class);
                        Bundle params = new Bundle();
                        params.putSerializable("juego", juego);
                        params.putInt("pos", position);
                        it.putExtras(params);
                        setResult(3, it);
                    }
                });
            }
        }
    }

}
