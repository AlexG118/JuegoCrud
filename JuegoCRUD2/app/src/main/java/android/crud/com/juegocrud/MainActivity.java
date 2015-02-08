package android.crud.com.juegocrud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class MainActivity extends Activity {
    private Button btn_registrar, btn_listar;
    private final int REGISTRO = 1;
    ArrayList<Juego> juegos = new ArrayList<>();
    String filename = "ListaJuegos.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadItems();
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
                params.putSerializable("listaJuegos", juegos);
                it.putExtras(params);
                startActivityForResult(it, 2);
            }
        });

    }

    @Override
    protected void onActivityResult(int codigo, int resultado, Intent it) {
        if(codigo == REGISTRO){
            Bundle params = it != null ? it.getExtras(): null;
            if (params != null) {
                Juego juego = (Juego) params.get("juego");
                juegos.add(juego);

                saveItems(juegos);
            }
        }
        if(codigo == 2){
            Bundle params = it != null ? it.getExtras(): null;
            if (params != null) {
                juegos = (ArrayList<Juego>) it.getSerializableExtra("listaJuegos");

                saveItems(juegos);
            }
        }
        if(codigo == 3){
            Bundle params = it != null ? it.getExtras(): null;
            if (params != null) {
                Juego juego = (Juego) it.getSerializableExtra("juego");
                int position = it.getIntExtra("pos", 0);
                juegos.set(position, juego);
                saveItems(juegos);
            }
        }
    }
    public void loadItems() {
        ObjectInputStream input = null;

        try {
            input = new ObjectInputStream(new FileInputStream(new File(getFilesDir(),"") + File.separator+filename));
            juegos = (ArrayList<Juego>) input.readObject();
            input.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveItems(ArrayList<Juego> juegos) {
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(new File(getFilesDir(),"") + File.separator+filename));
            out.writeObject(juegos);
            out.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}
