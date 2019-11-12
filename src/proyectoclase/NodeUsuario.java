/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclase;

import java.util.Date;

/**
 *
 * @author RAFAEL
 */
public class NodeUsuario {
    String password;
    String usuario;
    Date fechahora;
    
    NodeUsuario siguiente;
    NodeUsuario anterior;
    
    public NodeUsuario (String usuario, String password, Date fechahora){
        this.password = password;
        this.usuario = usuario;
        this.fechahora = fechahora;
        
        this.siguiente = null;
        this.anterior = null;
        
    }
    
}
