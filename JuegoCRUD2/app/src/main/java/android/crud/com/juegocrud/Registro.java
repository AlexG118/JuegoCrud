package android.crud.com.juegocrud;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class Registro extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_juego);

        Button btn_registro = (Button) findViewById(R.id.btn_registrar);
       // Button btn_imagen = (Button) findViewById(R.id.btn_imagen);
        btn_registro.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText nombre = (EditText) findViewById(R.id.edit_nombre);
                EditText descripcion = (EditText) findViewById(R.id.edit_desc);
                EditText precio = (EditText) findViewById(R.id.edit_precio);

                RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

                //ImageView imagen = (ImageView) findViewById(R.id.imgView);
                // imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

                Juego juego = new Juego(nombre.getText().toString(), descripcion.getText().toString(),
                        precio.getInputType(), ratingBar.getNumStars());

                Intent it = new Intent(Registro.this, MainActivity.class);
                it.putExtra("juego", juego);
                setResult(1, it);
                finish();
            }
        });
        /*btn_imagen.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

               // startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });*/

    }

}
