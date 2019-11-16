/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclase;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author RAFAEL
 */
public class ListaDoUser {
    
    NodeUsuario primero_head;
    NodeUsuario ultimo;
    int size;
    
    public ListaDoUser (){
        this.primero_head = null;
        this.size = 0;
        this.ultimo = null;
    }
    public boolean esVacio(){
        return this.primero_head == null;
    }
    
    public boolean User_Login(String user, String pass){
        String pass_encrip = this.sha256(pass);
        
        NodeUsuario tempo;
        tempo = this.primero_head;
        while (tempo != null){
            
            if (tempo.usuario.equals(user) && tempo.password.equals(pass_encrip) ) {
                return true;
            }
            else if (tempo.usuario.equals(user) && !tempo.password.equals(pass_encrip) ){
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta","Err",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            tempo = tempo.siguiente;
        }
        return false;
    }
    public void Insert_fin(String usuario, String password, Date fechahora){
        String pass_encrip = this.sha256(password);
        
        NodeUsuario new_nod = new  NodeUsuario(usuario, pass_encrip, fechahora);
        
        if (this.esVacio() == true)  {  
            this.primero_head = new_nod;
            //this.ultimo = new_nod;
        }
        else{
            
            NodeUsuario tempo;
            tempo = this.primero_head;
            while (tempo.siguiente != null){
                tempo = tempo.siguiente;
            }
            
            tempo.siguiente = new_nod;
            new_nod.anterior = tempo;
                    
            //this.ultimo.siguiente  = nuevo;
            //this.ultimo = nuevo;
        }
        this.size = this.size + 1;
    }
    
    ////para encriptar sha-256
    public static String sha256(String pass){

	String pass_sha256 = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(pass.getBytes("utf8"));
	    pass_sha256 = String.format("%064x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return pass_sha256;
    }
    
    ///Imprimir lista adelante
    public void Lista_imprimir_ade(){
        if (this.esVacio()== true){
            System.out.println("La  lista esta vacia");
        }
        else{
            NodeUsuario temp_prin = this.primero_head;

            while (temp_prin != null){     
                System.out.println(temp_prin.usuario + "-" + temp_prin.password +"-" +temp_prin.fechahora );    
                temp_prin = temp_prin.siguiente;
            }
                        
                        
        }
    }
    
}
