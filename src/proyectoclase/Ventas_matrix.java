/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclase;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

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
        Date fec_0 = null;
        Date hour_0 = null;
        try {
           fec_0 = fecha.parse("01/01/1970");
           hour_0 = hora.parse("00:00");
            
        } catch (Exception e) {
        }
        //public NodeVenta (String tipo, Date horas_x, int idcliente_y, Date fecha_z, String cliente, String usuario, double total, double monto, double vuelto)
        NodeVenta temp = new NodeVenta("R",hour_0, 0, fec_0, "raiz", "raiz", 0,  0,0);
        head = temp; 
        
//        this.size = 0;
//        this.size_x = 0;
//        this.size_y = 0;
    }
    
    public void add(Date horas_x, int idcliente_y, Date fecha_z, String cliente, String usuario, double total, double monto, double vuelto) {
    	//1 crear header
    	//1.1 creade x header
    	//cout<<"x: " <<x<<endl; 
    	add_z_header(fecha_z, "fecha_z");
//    	add_x_header(x, z);
    	add_y_header(idcliente_y, fecha_z, cliente);  	
    	//1.2 create y header
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
    ////para z
    public void add_z_header(Date fecha_z, String file_capa) {
    	  	
//    	string nombre_cab = "";
//    	nombre_cab = file_capa;

        /*inicializando cordenadas en 0*/
        Date fec_0 = null;
        Date hour_0 = null;
        try {
           fec_0 = fecha.parse("01/01/1970");
           hour_0 = hora.parse("00:00");
            
        } catch (Exception e) {
        }
    	
    	if (head.capa_up == null) { 
	    	//node *temp = new node(x);    	
	    	NodeVenta temp = new NodeVenta("C",hour_0, 0, fecha_z, "", ProyectoClase.session.usuario_ac, 0, 0,0);
	    	head.capa_up = temp;
	    	temp.capa_down = head; 
    	} else  {     	
		NodeVenta temp =head;
		//while (temp.capa_up != null && temp.capa_up.data < z ) { 
                while (temp.capa_up != null && temp.capa_up.fecha_z.before(fecha_z)) { 
			temp = temp.capa_up;
    	}

			 if (temp.capa_up == null ) { 
		    	//node *new_temp = new node(z);
		    	NodeVenta new_temp = new NodeVenta("C",hour_0, 0, fecha_z, "", ProyectoClase.session.usuario_ac, 0, 0,0);
		    	temp.capa_up = new_temp;
		    	new_temp.capa_down = temp; 
		    	
                        //}else if (temp.capa_up != null && temp.capa_up.data != z )
	    		}else if (temp.capa_up != null && !temp.capa_up.fecha_z.equals(fecha_z) )
				{
	    			NodeVenta new_temp = new NodeVenta("C",hour_0, 0, fecha_z, "", ProyectoClase.session.usuario_ac, 0, 0,0);
	    			NodeVenta c_up = temp.capa_up;
	    			
	    			temp.capa_up =new_temp;
	    			new_temp.capa_down = temp;
	    			
	    			new_temp.capa_up = c_up;
	    			c_up.capa_down = new_temp;
	    			
				
				}
    	
    	}
    }
    //////////////////
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
                    //JOptionPane.showMessageDialog(null, head_y.fecha_z);
                    head_y = head_y.capa_up;
		}
    		
    	if (head_y.down == null) { 
                                //( tipo, horas_x, idcliente_y, fecha_z, cliente, usuario, total, monto, vuelto)
	    	NodeVenta temp = new NodeVenta("C",hour_0, y_cliente, fec_0, cliente, ProyectoClase.session.usuario_ac, 0, 0,0);
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
		    	NodeVenta new_temp = new NodeVenta("C",hour_0,y_cliente , fec_0, cliente, ProyectoClase.session.usuario_ac, 0, 0,0);
		    	temp.down = new_temp;
		    	new_temp.up = temp; 
		    	
	    		}else if (temp.down != null && temp.down.idcliente_y != y_cliente )
				{
	    			NodeVenta new_temp = new NodeVenta("C",hour_0,y_cliente , fec_0, cliente, ProyectoClase.session.usuario_ac, 0, 0,0);
	    			NodeVenta der = temp.down;
	    			
	    			temp.down =new_temp;
	    			new_temp.up = temp;
	    			new_temp.down = der;
	    			der.up = new_temp;				
				}
    	}
    }
    
    public void add_x_header(Date x_hora,  Date z_fecha) {
    	/*inicializando cordenadas en 0*/
        Date fec_0 = null;
        Date hour_0 = null;
        try {
           fec_0 = fecha.parse("01/01/1970");
           hour_0 = hora.parse("00:00");
            
        } catch (Exception e) {
        }
    	
    	NodeVenta head_x = head;
    	
    	/*primero recorre prufundidad*/
		/*recorre por z, para insertar a la derecha*/	
                //while(head_x.fecha_z != z){
		while(!head_x.fecha_z.equals(z_fecha)){
    		head_x = head_x.capa_up;
		}
		//cout<<"222 z,x head_x: "<<head_x->data<<" "<<endl;
    	if (head_x.right == null) { 	
	    	NodeVenta temp = new NodeVenta("C",x_hora,0 , fec_0, "x_hora", ProyectoClase.session.usuario_ac, 0, 0,0);
	    	head_x.right = temp;
	    	temp.left = head_x; 
    	} else  {     
			
		/*recorre por z, para insertar a la derecha*/		
		NodeVenta temp = head;
				
		//while(temp.fecha_z != z){
                while(!temp.fecha_z.equals(z_fecha)){
    		temp = temp.capa_up;
		}
		
                //while (temp.right != null && temp.right.horas_x < x ) { 
		while (temp.right != null && temp.right.horas_x.before(x_hora) ) { 
			temp = temp.right;
    	} 
			 if (temp.right == null ) { 
		    	NodeVenta new_temp = new  NodeVenta("C",x_hora,0 , fec_0, "x_hora", ProyectoClase.session.usuario_ac, 0, 0,0);
		    	temp.right = new_temp;
		    	new_temp.left = temp; 
		    	
	    		}else if (temp.right != null && !temp.right.horas_x.equals(x_hora) )
                        //}else if (temp.right != null && temp.right.horas_x != x )
				{
	    			NodeVenta new_temp = new NodeVenta("C",x_hora,0 , fec_0, "x_hora", ProyectoClase.session.usuario_ac, 0, 0,0);
	    			NodeVenta der = temp.right;
	    			
	    			temp.right =new_temp;
	    			new_temp.left = temp;
	    			new_temp.right = der;
	    			der.left = new_temp;
				
				}
    	
    	}
    }
    
   public void print_z_header() {
    NodeVenta temp = head;
    while (temp != null) { 
        //System.out.println("("+temp.idproducto_x+ ","+temp.idcate_y +") -> ");
        System.out.println(temp.fecha_z );
        temp = temp.capa_up;
    }  	
    //System.out.print("("+temp.idproducto_x+ ","+temp.idcate_y +") -> ");
}
    
    
}
