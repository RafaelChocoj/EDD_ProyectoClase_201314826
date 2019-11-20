/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclase;

import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAFAEL
 */
public class NodeVenta {
    
    String tipo;
    
    Date horas_x;
    int idcliente_y;
    Date fecha_z;
    String cliente;
    String usuario;
    
    double total;
    double monto;
    double vuelto;

    NodeVenta right;
    NodeVenta left;
    NodeVenta down;
    NodeVenta up;
    
    NodeVenta capa_up;
    NodeVenta capa_down;
    
    DefaultTableModel detalles;
    
    public NodeVenta (String tipo, Date horas_x, int idcliente_y, Date fecha_z, String cliente, String usuario, double total, double monto, double vuelto, DefaultTableModel detalles){
        this.tipo = tipo;
        this.horas_x = horas_x;
        this.idcliente_y = idcliente_y;
        this.fecha_z = fecha_z;
        
        this.cliente = cliente;
        this.usuario = usuario;
        
        this.total = total;
        this.monto = monto;
        this.vuelto = vuelto;
        
        this.detalles = detalles;
    }
    
}
