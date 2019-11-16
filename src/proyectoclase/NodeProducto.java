/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclase;

/**
 *
 * @author RAFAEL
 */
public class NodeProducto {
    
    String tipo;
    int idproducto;
    String nombrear;
    double precio;
    int unidades;
    
    int idcate;
    String nombrecate;
    
    NodeProducto right;
    NodeProducto left;
    NodeProducto down;
    NodeProducto up;
            
    public NodeProducto (String tipo,int idproducto_x, String nombrear, double precio,int unidades, int idcate_y, String nombrecate){
        this.tipo = tipo;
        this.idproducto = idproducto;
        this.nombrear = nombrear;
        this.precio = precio;
        this.unidades = unidades;
        
        this.idcate = idcate;
        this.nombrecate = nombrecate;
        
        this.right  = null;
        this.left = null;
        this.down  = null;
        this.up = null;

    }
}
