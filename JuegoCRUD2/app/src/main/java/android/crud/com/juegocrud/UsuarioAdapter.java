package android.crud.com.juegocrud;

import java.util.List;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;


public class UsuarioAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private List<Juego> juegos;
    UsuarioAux sing = UsuarioAux.getInstance();
    private Button btn_edit, btn_remove;

    public UsuarioAdapter(Context context, List<Juego> usuarios){
        this.juegos = usuarios;
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
    public View getView(int position, View view, ViewGroup parent){

        final Juego u = juegos.get(position);

        final int  p = position;

        Juego juego = juegos.get(position);
        View v = inflater.inflate(R.layout.lista_juego, null);

        ((TextView) v.findViewById(R.id.text_nombre)).setText(juego.getNombre());
        ((TextView) v.findViewById(R.id.text_desc)).setText(juego.getDesc());
        ((TextView) v.findViewById(R.id.text_precio)).setText(juego.getPrecio());
        ((RatingBar) v.findViewById(R.id.text_rating)).setNumStars(juego.getPuntuacion());

        btn_edit = (Button) v.findViewById(R.id.btn_editar);
        btn_remove = (Button) v.findViewById(R.id.btn_remover);

        btn_edit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(v.getContext(), Editar.class);
                it.putExtra("position", p);
                v.getContext().startActivity(it);

            }
        });

        btn_remove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                juegos.remove(u);
                sing.getJuegos().remove(p);
                notifyDataSetChanged();
            }
        });

        return v;
    }

}
