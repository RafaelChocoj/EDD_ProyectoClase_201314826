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
public class Categiria {
    
    int idcate_y;
    String nombrecate;
    
     public Categiria (int idcate_y, String nombrecate){
        this.idcate_y = idcate_y;
        this.nombrecate = nombrecate;
     }
    public int getIdcate_y() {
        return idcate_y;
    }

    public void setIdcate_y(int idcate_y) {
        this.idcate_y = idcate_y;
    }

    public String getNombrecate() {
        return nombrecate;
    }

    public void setNombrecate(String nombrecate) {
        this.nombrecate = nombrecate;
    }
    
    public String toString(){
        return idcate_y + " - " + nombrecate;
    }
}
