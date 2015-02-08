package android.crud.com.juegocrud;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Listar extends ListActivity{
    ArrayList<Juego> juegos = new ArrayList<>();
    UsuarioAdapter adaptador;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.lista);

        Intent it = getIntent();
        Bundle params = it != null ? it.getExtras(): null;

        if (params != null)

            if (params.get("juego") != null & params.getInt("pos") != -1) {
                juegos = (ArrayList<Juego>) params.get("listaJuegos");
                Juego juego = (Juego) params.get("juego");
                int position = params.getInt("pos");
                juegos.set(position, juego);
            } else {
                juegos = (ArrayList<Juego>) params.get("listaJuegos");
            }





        adaptador = new UsuarioAdapter(this, juegos);
        setListAdapter(adaptador);

        adaptador.notifyDataSetChanged();

        Button btn_volver = (Button) findViewById(R.id.btn_volver);
        btn_volver.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                adaptador.notifyDataSetChanged();
                Intent it = new Intent(Listar.this, MainActivity.class);
                it.putExtra("listaJuegos", juegos);


                setResult(2, it);
                finish();
            }
        });

    }

}
