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

public class Editar  extends Activity{


    UsuarioAux sing = UsuarioAux.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_juego);
        Intent it = getIntent();

        if(it.getExtras() != null){

            final int position = it.getExtras().getInt("position");
            final Juego juego = (Juego) sing.getJuegos().get(position);

            if(juego != null){

                final TextView nombre = (TextView) findViewById(R.id.new_edit_nombre);
                nombre.setText(juego.getNombre());
                final TextView desc = (TextView) findViewById(R.id.new_edit_nombre);
                desc.setText(juego.getDesc());
                final TextView precio = (TextView) findViewById(R.id.new_edit_precio);
                precio.setText(juego.getPrecio());

                final RatingBar rating = (RatingBar)findViewById(R.id.new_edit_RatingBar);
                rating.setNumStars(juego.getPuntuacion());



                Button btn_editar = (Button) findViewById(R.id.btn_editar);
                btn_editar.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        juego.setNombre(nombre.getText().toString());
                        juego.setDesc(desc.getText().toString());
                        juego.setPrecio(precio.getInputType());
                        juego.setPuntuacion(rating.getNumStars());
                        Intent it = new Intent(Editar.this, MainActivity.class);
                        startActivity(it);
                    }
                });
            }
        }
    }

}
