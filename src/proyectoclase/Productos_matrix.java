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
public class Productos_matrix {
    NodeProducto head;
    int size;
    int size_x;
    int size_y;
    
    public Productos_matrix () {
        
        NodeProducto temp = new NodeProducto("o", 0, "R", "o", "0_0", "o", null, null);
        head = temp; 
        
        this.size = 0;
        this.size_x = 0;
        this.size_y = 0;
    }
}
