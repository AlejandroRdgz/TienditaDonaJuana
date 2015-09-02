/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.doñajuana.doñajuana.datos;

import java.util.Arrays;
import java.util.List;

/**
 * Clase que se encarda de manejar los productos del sistema de Doña juana
 * 
 * 
 * @author Alejandro Rodriguez Gonzalez
 * @version 1.0
 * 
 */
public class Producto {

    public static final String TABLA = "productos_doña";
    public static final String[] FIELDS
            = {"id", "descripcion", "precio", "clasificacion","cantidad"
                ,"cant_max","cant_min"};

    private Integer id;
    private String descripcion;
    private Double precio;
    private String clasificacion;
    private Integer cantidad;
    private Integer cant_max;
    private Integer cant_min;

    public Producto(Integer id, String descripcion, Double precio, 
     String clasificacion, Integer cantidad, Integer cant_max, 
     Integer cant_min) {
     this.id = id;
     this.descripcion = descripcion;
     this.precio = precio;
     this.clasificacion = clasificacion;
     this.cantidad = cantidad;
     this.cant_max = cant_max;
     this.cant_min = cant_min;
     }

    public Integer getId() throws NullPointerException{
        if( this.id == null){
            /*throw  new NullPointerException( todo esto se ejecuta mas lento.
                    "El usuario"+ this.name +
                            " no a sido guardado en la base de datos.");*/
            throw new NullPointerException(String.format( 
                    "El usuario %s No existe", this.descripcion));
        }
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCant_max() {
        return cant_max;
    }

    public void setCant_max(Integer cant_max) {
        this.cant_max = cant_max;
    }

    public Integer getCant_min() {
        return cant_min;
    }

    public void setCant_min(Integer cant_min) {
        this.cant_min = cant_min;
    }
    
    
    
    
    public static String fieldsToString(){
        String fieldsStr = "";
        List<String> fieldsToConvert = Arrays.asList(FIELDS);//el metodo aslist convierte de arreglos a listas
        for (String field : fieldsToConvert) {
            fieldsStr=String.format("%s, %s", fieldsStr, field);
        }
        return fieldsStr.replaceFirst(",", fieldsStr);
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.getId(), this.getDescripcion(), this.getPrecio(), this.getCantidad());
    }
}
