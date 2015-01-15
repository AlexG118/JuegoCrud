package android.crud.com.juegocrud;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Listar extends ListActivity{

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.lista);

        ArrayList<Juego> juegos = new ArrayList<>();

        Intent it = getIntent();
        Bundle params = it != null ? it.getExtras(): null;

        if (params != null)
            juegos = (ArrayList<Juego>) params.get("listaJuegos");

        setListAdapter(new UsuarioAdapter(this, juegos));

        Button btn_volver = (Button) findViewById(R.id.btn_volver);
        btn_volver.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(Listar.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });


    }

}
