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
    public static void main(String[] args) {
        // TODO code application logic here
        ListaDoUser lis_user = new ListaDoUser();
        
        lis_user.Insert_fin("user1", "123", null);
        lis_user.Insert_fin("Admin", "0", null);
        lis_user.Insert_fin("rafael", "987", null);
        
        lis_user.Lista_imprimir_ade();
    }
    
}
