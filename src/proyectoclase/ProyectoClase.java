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
public class ProyectoClase {

    /**
     * @param args the command line arguments
     */
    static DataActualC session; //usuario actual
    static ListaDoUser lis_user;
    static Productos_matrix mat_productos;
    public static void main(String[] args) {
        // TODO code application logic here
        lis_user = new ListaDoUser();
        session = new DataActualC(null);
        mat_productos = new Productos_matrix();
        
        ProyectoClase.mat_productos.add(10, 5, "Chetos", 4.00, 0, "Snaks");
        ProyectoClase.mat_productos.add(1, 1, "Coca Cola", 7.00, 0, "Bebidas");
        ProyectoClase.mat_productos.add(3, 2, "Lapiz", 3.50, 0, "Utiles");
        
        ProyectoClase.mat_productos.add(9, 2, "Cuaderno", 9.50, 0, "Utiles");
        
        //lis_user.Insert_fin("user1", "123", null);
        lis_user.Insert_fin("admin", "0", null);
        //lis_user.Insert_fin("rafael", "987", null);
        
        lis_user.Lista_imprimir_ade();
        
        loguinC log = new loguinC();
        log.setVisible(true);
        
    }
    
}
