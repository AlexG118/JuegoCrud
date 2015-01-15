package android.crud.com.juegocrud;

import java.io.Serializable;

public class Juego implements Serializable{

    private String nombre, descripcion;
    private int precio;

    public Juego(String nombre, String descripcion, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Juego() {

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



    @Override
    public String toString() {
        return "Juego [nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
                + precio +  "]";
    }




}
