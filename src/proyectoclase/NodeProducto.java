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
    int idproducto_x;
    String nombrear;
    double precio;
    int unidades;
    
    int idcate_y;
    String nombrecate;
    
    NodeProducto right;
    NodeProducto left;
    NodeProducto down;
    NodeProducto up;
    
    NodeProducto capa_up;
    NodeProducto capa_down;
            
    public NodeProducto (String tipo,int idproducto_x, int idcate_y, String nombrear, double precio,int unidades, String nombrecate){
        this.tipo = tipo;
        this.idproducto_x = idproducto_x;
        this.nombrear = nombrear;
        this.precio = precio;
        this.unidades = unidades;
        
        this.idcate_y = idcate_y;
        this.nombrecate = nombrecate;
        
        this.right  = null;
        this.left = null;
        this.down  = null;
        this.up = null;
        
        this.capa_up = null;
        this.capa_down = null;

    }
}
