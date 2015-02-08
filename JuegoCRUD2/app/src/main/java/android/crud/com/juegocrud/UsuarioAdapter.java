package android.crud.com.juegocrud;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


public class UsuarioAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    ArrayList<Juego> juegos = new ArrayList<>();
    private Button btn_edit, btn_remove;
    int position;

    public UsuarioAdapter(Context context, ArrayList<Juego> juegoslista){
        this.juegos = juegoslista;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return juegos.size();
    }

    @Override
    public Object getItem(int position) {
        return juegos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent){

        final Juego juego = juegos.get(position);

        View v = inflater.inflate(R.layout.lista_juego, null);

        ((TextView) v.findViewById(R.id.text_nombre)).setText(juego.getNombre());
        ((TextView) v.findViewById(R.id.text_desc)).setText(juego.getDesc());
        ((TextView) v.findViewById(R.id.text_precio)).setText((String.valueOf(juego.getPrecio())));

        btn_edit = (Button) v.findViewById(R.id.btn_editar);
        btn_remove = (Button) v.findViewById(R.id.btn_remover);

        btn_edit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(v.getContext(), Editar.class);
                it.putExtra("lista", juegos);
                it.putExtra("juego", juego);
                it.putExtra("pos", position);
                v.getContext().startActivity(it);
            }
        });

        btn_remove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                juegos.remove(juego);
                notifyDataSetChanged();
            }
        });

        return v;
    }




}
