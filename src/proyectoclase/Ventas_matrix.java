/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author RAFAEL
 */
public class Ventas_matrix {
    
    NodeVenta head;
//    int size;
//    int size_x;
//    int size_y;
    
    public Ventas_matrix () {
        
        //public NodeVenta (String tipo, Date horas_x, int idcliente_y, Date fecha_z, String cliente, String usuario, double total, double monto, double vuelto)
        NodeVenta temp = new NodeVenta("R",null, 0, null, "raiz", "raiz", 0,  0,0);
        head = temp; 
        
//        this.size = 0;
//        this.size_x = 0;
//        this.size_y = 0;
    }
    
    public void add (String tipo, Date horas_x, int idcliente_y, Date fecha_z, String cliente, String usuario, double total, double monto, double vuelto) {
//    	//1 crear header
//    	//1.1 creade x header
//    	//cout<<"x: " <<x<<endl; 
//    	add_z_header(z, file_capa);
//    	add_x_header(x, z);
//    	add_y_header(y, z);  	
//    	//1.2 create y header
//    	
//    	
//    	//2 insert nodo
//    	//node *new_node = new node(value);
//    	node *new_node = new node(value, x, y, z, "N", valor);
//    	//add_x(new_node, x);
//    	//add_y(new_node, y, x);
//    	
//    	//primero insertamos profundidad
//    	//add_z(new_node, x, y);
//    	
//    	//add_x(new_node, x, y);
//    	//add_y(new_node, x, y);
//    	
//    	/* inicio para insertar nodo de profunidad inserta 0 en z	*/
//    	node *new_z0 = new node(0, x, y, 0, "C", "C");
//    	//node *new_z0 = new node(value, x, y, 0);
//
//    	/* fin para insertar nodo de profunidad inserta 0 en z	*/
//    	
//    	///**********insertando nodos**************/////
//    	add_x_header_z0(x, z);
//    	add_y_header_z0(y, z);  
//    	
//    	//add_x(new_node, x, y, z);
//    	//add_y(new_node, x, y, z);
//    	
//    	
//    	//////**********//esto para insertar en z. pero ya no
//    	//////////////add_x_z0(new_z0, x, y, z);
//    	//////////////add_y_z0(new_z0, x, y, z);
//    	
//    	add_x(new_node, x, y, z);
//    	add_y(new_node, x, y, z);
//    	
//    	///////******/esto para insertar en z. pero ya no
//    	//////////////add_z(new_node, x, y, z);
    	
  
          
    }
    
    ///////////insertando cabeceras
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
    
    public void add_y_header(int y_cliente, Date z_fecha, String cliente) {

        /*inicializando cordenadas en 0*/
        Date fec_0 = null;
        Date hour_0 = null;
        try {
           fec_0 = fecha.parse("01/01/1970");
           hour_0 = hora.parse("00:00");
            
        } catch (Exception e) {
        }
        
    	NodeVenta head_y = head;
    	
    	/*primero recorre prufundidad*/
		/*recorre por z, para insertar a la derecha*/	
//		while(head_y.cor_z != z){
                while(!head_y.fecha_z.equals(z_fecha)){
                    head_y = head_y.capa_up;
		}
    		
    	if (head_y.down == null) { 
                                //( tipo, horas_x, idcliente_y, fecha_z, cliente, usuario, total, monto, vuelto)
	    	NodeVenta temp = new NodeVenta("C",hour_0, 0, fec_0, cliente, ProyectoClase.session.usuario_ac, 0, 0,0);
	    	head_y.down = temp;
	    	temp.up = head_y; 
    	} else  {     	
		NodeVenta temp =head;
		/*nuevo inicio*/
		//while(temp.cor_z != z){
                while(!temp.fecha_z.equals(z_fecha)){
    		temp = temp.capa_up;
		}
		/*nuevo fin*/
		//while (temp.down != null && temp.down->data < y ) { 
                while (temp.down != null && temp.down.idcliente_y < y_cliente ) { 
			temp = temp.down;
                } 
			 if (temp.down == null ) { 
		    	NodeVenta new_temp = new NodeVenta("C",hour_0, 0, fec_0, cliente, ProyectoClase.session.usuario_ac, 0, 0,0);
		    	temp.down = new_temp;
		    	new_temp.up = temp; 
		    	
	    		}else if (temp.down != null && temp.down.idcliente_y != y_cliente )
				{
	    			NodeVenta new_temp = new NodeVenta("C",hour_0, 0, fec_0, cliente, ProyectoClase.session.usuario_ac, 0, 0,0);
	    			NodeVenta der = temp.down;
	    			
	    			temp.down =new_temp;
	    			new_temp.up = temp;
	    			new_temp.down = der;
	    			der.up = new_temp;				
				}
    	}
    }
    
}
