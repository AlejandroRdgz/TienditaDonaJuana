/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.doñajuana.doñajuana.controlador;

import java.util.ArrayList;
import java.util.List;
import mx.doñajuana.doñajuana.dao.ProductoDao;
import mx.doñajuana.doñajuana.datos.Producto;

/**
 *
 * @author Alejandro Rodriguez Gonzalez
 * @version 1.0
 */
public class Productos {
    public List<Producto> getProducto(){
        List<Producto> productos = new ArrayList<>();
        return productos;
        
    }
    
    
    public static void main(String[] args) {
        
       
        List<Producto> productos = new ProductoDao().list();
        
        System.out.println("Respuesta 1");
       // Número de productos con existencia mayor a 20
        for (Producto producto : productos) {
            if(producto.getCantidad() > 25){
                System.out.println(producto);
            }
        }
        
       productos.stream().filter(a -> {return 
               a.getCantidad() > 25 ;}).forEach(a -> {System.out.println(a);});
       
       // Número de productos con existencia menos a 15
        
       for (Producto producto : productos) {
            if(producto.getCantidad() < 25){
                System.out.println(producto);
            }
        }
        
       productos.stream().filter(a -> {return 
               a.getCantidad() < 25 ;}).forEach(a -> {System.out.println(a);});
       
       // Lista de productos con la misma clasificación y precio mayor 15.50
       
        for (Producto producto : productos) {
            for (Producto producto1 : productos) {
                if(producto.equals(producto1) && producto.getPrecio() > 15.50){
                    System.out.println(producto1+" "+producto);
                }
            }
        }
        
        //Lista de productos con precio mayor a 20.30 y menor a 45.00
        
        for (Producto producto : productos) {
            if(producto.getPrecio() > 20.30 && producto.getPrecio()<45){
                System.out.println(producto);
            }
        }
        
        productos.stream().filter(a -> {return a.getPrecio() > 20.30 && 
                a.getPrecio() < 45;}).forEach(a -> {System.out.println(a);});
        
        
        
       
        }
        
        
        }
    

