/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.doñajuana.doñajuana.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.doñajuana.doñajuana.datos.Producto;

/**
 *
 * @author Rodrigo
 */
public class ProductoDao implements CRUD{

    @Override
    public List<Producto> list() {
         
        
        List<Producto> productos = new ArrayList<>();
        try {
            
            
            Statement st = Conexion.getInstance().getConexion().createStatement();
            System.out.println(Producto.fieldsToString());
            ResultSet rs = st.executeQuery(String.format("SELECT %s From %s",
                    Producto.fieldsToString(),Producto.TABLA));
            
            while(rs.next()){
                Integer id = rs.getInt(Producto.FIELDS[0]);
                String descripcion = rs.getString(Producto.FIELDS[1]);
                
                Double precio = rs.getDouble(Producto.FIELDS[2]);
                
                String clasificacion = rs.getString(Producto.FIELDS[3]);
                Integer cantidad = rs.getInt(Producto.FIELDS[4]);
                
                Integer cant_max = rs.getInt(Producto.FIELDS[5]);
                Integer cant_min = rs.getInt(Producto.FIELDS[6]);
                
                /*Producto prod = new Producto(id, nombre, primerApellido, edad);
                productos.add(prod);*/
                Producto prd = new Producto(id, descripcion, precio,
                  clasificacion, cantidad, cant_max, cant_min);
                    productos.add(prd);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return productos;
    }

    @Override
    public void create(Producto producto) {

    }

    @Override
    public void update(Producto producto) {

    }

    @Override
    public void delete(Integer id) {

    }
    
}
