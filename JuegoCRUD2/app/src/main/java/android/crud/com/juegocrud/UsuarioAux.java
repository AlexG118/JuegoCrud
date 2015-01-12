package android.crud.com.juegocrud;

import java.util.ArrayList;

public class UsuarioAux {

    private ArrayList<Juego> juegos;
    private static UsuarioAux instance;

    private UsuarioAux() {}

    public static UsuarioAux getInstance () {
        if ( UsuarioAux.instance == null )
            UsuarioAux.instance = new UsuarioAux();
        return UsuarioAux.instance;
    }

    public ArrayList<Juego> getJuegos() {
        if (this.juegos == null)
            this.juegos = new ArrayList<Juego>();
        return this.juegos;
    }

}
