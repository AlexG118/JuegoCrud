package android.crud.com.juegocrud;

import java.io.Serializable;

public class Juego implements Serializable{

    private String nombre, descripcion,imagen;
    private int precio,puntuacion;

    public Juego(String nombre, String descripcion, int precio, int puntuacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDesc() {
        return descripcion;
    }

    public void setDesc(String descripcion) {
        this.descripcion = descripcion;
    }



    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }



    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }



    /*public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
*/
    @Override
    public String toString() {
        return "Juego [nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
                + precio + ", puntuacion=" + puntuacion +  "]";
    }




}
