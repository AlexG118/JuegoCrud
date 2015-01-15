package android.crud.com.juegocrud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class MainActivity extends Activity {

    private Button btn_registrar, btn_listar;
    private final int REGISTRO = 1;
    UsuarioAux sing = UsuarioAux.getInstance();
    Juego juego;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{

            FileInputStream fin = new FileInputStream("MisJuegos.txt");
            ObjectInputStream ois = new ObjectInputStream(fin);
            juego = (Juego) ois.readObject();
            ois.close();


        }catch(Exception ex){
            ex.printStackTrace();

        }


        setContentView(R.layout.activity_main);
        btnListener();
    }


    public void btnListener(){

        btn_registrar = (Button) findViewById(R.id.btn_registrar);
        btn_listar = (Button) findViewById(R.id.btn_listar);

        btn_registrar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Registro.class);
                startActivityForResult(it, REGISTRO);
            }
        });

        btn_listar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Listar.class);
                Bundle params = new Bundle();
                params.putSerializable("listaJuegos", sing.getJuegos());
                it.putExtras(params);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onActivityResult(int codigo, int resultado, Intent it) {
        if(codigo == REGISTRO){
            Bundle params = it != null ? it.getExtras(): null;
            if (params != null) {
                Juego juego = (Juego) params.get("juego");
                sing.getJuegos().add(juego);
            }
        }

    }

}
