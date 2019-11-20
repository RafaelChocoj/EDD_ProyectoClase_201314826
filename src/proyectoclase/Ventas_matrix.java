/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclase;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        NodeVenta temp = new NodeVenta("R",hour_0, 0, fec_0, "raiz", "raiz", 0,  0,0, null);
        head = temp; 
        
//        this.size = 0;
//        this.size_x = 0;
//        this.size_y = 0;
    }
    
    public void add(Date horas_x, int idcliente_y, Date fecha_z, String cliente, String usuario, double total, double monto, double vuelto, DefaultTableModel detalles) {
    	//1 crear header
    	//1.1 creade x header
    	//cout<<"x: " <<x<<endl; 
    	add_z_header(fecha_z, "fecha_z");
    	add_x_header(horas_x, fecha_z);
    	add_y_header(idcliente_y, fecha_z, cliente);  	
        
        //JOptionPane.showMessageDialog(null, "creo las cabe");
    	//1.2 create y header
    	
    	
    	//2 insert nodo
    	//node *new_node = new node(value);
    	NodeVenta new_node = new NodeVenta("N", horas_x, idcliente_y, fecha_z, cliente, usuario, total, monto, vuelto, detalles);
    	//add_x(new_node, x);
    	//add_y(new_node, y, x);
    	
    	//primero insertamos profundidad
    	//add_z(new_node, x, y);
    	
    	//add_x(new_node, x, y);
    	//add_y(new_node, x, y);
    	
    	/* inicio para insertar nodo de profunidad inserta 0 en z	*/
    	////////////////////////node *new_z0 = new node(0, x, y, 0, "C", "C");
    	//node *new_z0 = new node(value, x, y, 0);

    	/* fin para insertar nodo de profunidad inserta 0 en z	*/
    	
    	///**********insertando nodos**************/////
    	/////////////add_x_header_z0(x, z);
    	///////////////add_y_header_z0(y, z);  
    	
    	//add_x(new_node, x, y, z);
    	//add_y(new_node, x, y, z);
    	
    	
    	//////**********//esto para insertar en z. pero ya no
    	//////////////add_x_z0(new_z0, x, y, z);
    	//////////////add_y_z0(new_z0, x, y, z);
    	
    	add_x(new_node,  horas_x, idcliente_y, fecha_z);
        
        //JOptionPane.showMessageDialog(null, "creo en x");
        
        add_y(new_node,  horas_x, idcliente_y, fecha_z);
        //JOptionPane.showMessageDialog(null, "creo en y");
//    	add_y(new_node, x, y, z);
    	
    	/////******/esto para insertar en z. pero ya no
    	////////////add_z(new_node, x, y, z);
    	
  
          
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
	    	NodeVenta temp = new NodeVenta("C",hour_0, 0, fecha_z, "", ProyectoClase.session.usuario_ac, 0, 0,0, null);
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
		    	NodeVenta new_temp = new NodeVenta("C",hour_0, 0, fecha_z, "", ProyectoClase.session.usuario_ac, 0, 0,0, null);
		    	temp.capa_up = new_temp;
		    	new_temp.capa_down = temp; 
		    	
                        //}else if (temp.capa_up != null && temp.capa_up.data != z )
	    		}else if (temp.capa_up != null && !temp.capa_up.fecha_z.equals(fecha_z) )
				{
	    			NodeVenta new_temp = new NodeVenta("C",hour_0, 0, fecha_z, "", ProyectoClase.session.usuario_ac, 0, 0,0, null);
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
	    	NodeVenta temp = new NodeVenta("C",hour_0, y_cliente, fec_0, cliente, ProyectoClase.session.usuario_ac, 0, 0,0, null);
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
		    	NodeVenta new_temp = new NodeVenta("C",hour_0,y_cliente , fec_0, cliente, ProyectoClase.session.usuario_ac, 0, 0,0, null);
		    	temp.down = new_temp;
		    	new_temp.up = temp; 
		    	
	    		}else if (temp.down != null && temp.down.idcliente_y != y_cliente )
				{
	    			NodeVenta new_temp = new NodeVenta("C",hour_0,y_cliente , fec_0, cliente, ProyectoClase.session.usuario_ac, 0, 0,0, null);
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
	    	NodeVenta temp = new NodeVenta("C",x_hora,0 , fec_0, "x_hora", ProyectoClase.session.usuario_ac, 0, 0,0, null);
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
		    	NodeVenta new_temp = new  NodeVenta("C",x_hora,0 , fec_0, "x_hora", ProyectoClase.session.usuario_ac, 0, 0,0, null);
		    	temp.right = new_temp;
		    	new_temp.left = temp; 
		    	
	    		}else if (temp.right != null && !temp.right.horas_x.equals(x_hora) )
                        //}else if (temp.right != null && temp.right.horas_x != x )
				{
	    			NodeVenta new_temp = new NodeVenta("C",x_hora,0 , fec_0, "x_hora", ProyectoClase.session.usuario_ac, 0, 0,0, null);
	    			NodeVenta der = temp.right;
	    			
	    			temp.right =new_temp;
	    			new_temp.left = temp;
	    			new_temp.right = der;
	    			der.left = new_temp;
				
				}
    	
    	}
    }
    
    ////////////////////////////////////////////insertando nodos
    public void add_x(NodeVenta new_node, Date x_hora, int y_cliente, Date z_fecha){
    	NodeVenta tem = head;
    	
    	/*primero recorre prufundidad*/
		/*recorre por z, para insertar a la derecha*/	
		//while(tem.fecha_z != z){
                while(!tem.fecha_z.equals(z_fecha)){
    		tem = tem.capa_up;
		}		
		//////////////*************************
		
    	/*recorre por x, para insertar a abajo (y)*/	
        //while(tem.horas_x != x){
    	while(!tem.horas_x.equals(x_hora)){
    		tem = tem.right;
		}
		if(tem.down == null){
			tem.down = new_node;
			new_node.up = tem;
		} 
		/*si y es mejor al ultimo*/
		else if(tem.down.idcliente_y >= y_cliente ){
			
                        //if(tem.down.idcliente_y == y_cliente && tem.down.horas_x == x ){ ///nre para repetidos
			if(tem.down.idcliente_y == y_cliente && tem.down.horas_x.equals(x_hora) ){ ///nre para repetidos
			}else{

				NodeVenta ul_down = tem.down;
			   	
				tem.down = new_node;
				new_node.up = tem;
				
				//para que enlace el que estaba antes
				new_node.down = ul_down;
				ul_down.up = new_node;
			} //fin nre para repetidos
		
		}
		else
		{			
			NodeVenta temp_abaj = tem.down; 
                        //while (temp_abaj.down != null && temp_abaj.down.cor_y <= y ) { 
			while (temp_abaj.down != null && temp_abaj.down.idcliente_y <= y_cliente ) { 
				temp_abaj = temp_abaj.down;
    		}
    		//if(temp_abaj.cor_y == y && temp_abaj.cor_x == x ){ //in new para repetidos
    		if(temp_abaj.idcliente_y == y_cliente && temp_abaj.horas_x == x_hora ){ //in new para repetidos
    		}else{
    			NodeVenta ul_down = null;  /// in  new para no insertar repetido
    			if (temp_abaj.down != null ){
    				ul_down = temp_abaj.down;
				} /// fi new para no insertar repetido
    			
	    		temp_abaj.down = new_node;
				new_node.up = temp_abaj;
				
				//para que enlace el que estaba antes
				if (ul_down != null ){
										
    				new_node.down = ul_down;
					ul_down.up = new_node;
				}
				
			} //fin new para repetidos
		}
	}
    
    public void add_y(NodeVenta new_node, Date x_hora, int y_cliente, Date z_fecha){
            NodeVenta tem= head;
            /*primero recorre prufundidad*/
            /*recorre por z, para insertar a la derecha*/
            //while(tem.cor_z != z){
            while(!tem.fecha_z.equals(z_fecha)){
            tem = tem.capa_up;
            }

            /*recorre por y, para insertar a la derecha (x)*/
            //while(tem.cor_y != y){
            while(tem.idcliente_y != y_cliente){
            tem = tem.down;
            }
            if(tem.right == null){
                    tem.right = new_node;
                    new_node.left = tem;
            }
            //else if(tem.right.cor_x >= x ){
            else if(tem.right.horas_x.after(x_hora) || tem.right.horas_x.equals(x_hora) ){

               //if(tem.right.cor_y == y && tem.right.cor_x == x ){ ///nre para que no se repita
               if(tem.right.idcliente_y == y_cliente && tem.right.horas_x.equals(x_hora) ){ ///nre para que no se repita
            }else{
                        NodeVenta ul_der = tem.right;

                        tem.right = new_node;
                        new_node.left = tem;

                        //para que enlace el que estaba antes
                        new_node.right = ul_der;
                        ul_der.left = new_node;
                    }
            }
            else
            {
                    NodeVenta temp_der = tem.right;
                    //while (temp_der.right != null && temp_der.right.cor_x <= x ) {  
                    while (temp_der.right != null && (temp_der.right.horas_x.before(x_hora) || temp_der.right.horas_x.equals(x_hora) ) ) {  
                            temp_der = temp_der.right;
            }
            //if(temp_der.cor_y == y && temp_der.cor_x == x ){  /// inic nre parte para que nos repita
            if(temp_der.idcliente_y == y_cliente && temp_der.horas_x.equals(x_hora) ){  /// inic nre parte para que nos repita
            }else{

                    NodeVenta ul_der = null;
                    if (temp_der.right != null ){
                            ul_der = temp_der.right;
                    } /// fin new parte para que nos repita

            temp_der.right = new_node;
                    new_node.left = temp_der;

                    //para que enlace el que estaba antes
                            if (ul_der != null ){

                            new_node.right = ul_der;
                                    ul_der.left = new_node;
                            }
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
  
public NodeVenta existeCliente_y(NodeVenta nod_clie, int idcliente_y) {
    //NodeVenta temp = head;
    NodeVenta temp = nod_clie;
    while (temp != null) { 
        if (temp.idcliente_y == idcliente_y) {
            return temp;
         }
        temp = temp.down;
    } 	
    return temp;
}

public NodeVenta existeCliente_z(int idcliente_y) {
    NodeVenta temp = head;
    while (temp != null) { 
        existeCliente_y(temp, idcliente_y);
        temp = temp.capa_up;
    } 	
    return null;
}


/*retorna capa de fecha*/
public NodeVenta existeFecha(Date fecha_z) {
    NodeVenta temp = head;
    while (temp != null) { 
        if (temp.fecha_z.equals(fecha_z)) {
            
//            if (temp.down != null){
//                NodeProducto temp_abaj = temp.down;
//                while (temp_abaj != null) { 
//                    if (temp_abaj.idproducto_x == produ_x) {
                        return temp;
//                    }
//                    temp_abaj = temp_abaj.down;
//                }
//            }
        }
        temp = temp.capa_up;
    }  	
    return null;
}

///////////////////////////////inicio grafica venta
public int alto_mat_x_cap(NodeVenta matrix_capa){
    int alt = 0;

    //NodeVenta temp = head;
    NodeVenta temp = matrix_capa;
    while (temp.down != null) {
        alt++;
        //JOptionPane.showMessageDialog(null,"alto temp: " + temp.dir_completo);
        temp = temp.down;
    }
    alt++;
    return alt;
}

 public int cor_x_hora(Date hor_x, NodeVenta ven_cap) {
    //NodeVenta temp = head;
    NodeVenta temp = ven_cap;
    int corx = 0;
    while (temp != null) { 
        if (temp.horas_x.equals(hor_x)) { 
            return corx;
        }
        corx++;
        temp = temp.right;
    }  	
    return 0;
}
 
 public int cor_y_carpeta(int clie_y, NodeVenta ven_cap) {
    //NodeVenta temp = head;
    NodeVenta temp = ven_cap;
    int cory = 0;
    while (temp != null) { 
        if (temp.idcliente_y == clie_y) { 
            return cory;
        }
        cory++;
        temp = temp.down;
    }  	
    return 0;
}
 
public boolean print_Grafica_matrix(NodeVenta matrix_capa) {
        
        StringBuilder graf  = new StringBuilder(); //grafica total

    	int alto;
        
        SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        int y_grap;
        int x_grap;
        int xx, yy;
        xx = 0;
        yy = 0;
    	
    	graf.append("");
		graf.append("digraph{ \n");
		graf.append("rankdir=BT;\n");
		//graf_matrix = graf_matrix + "graph [nodesep=5.5]; \n";
		graf.append("node[shape=record]; \n");
		//graf_matrix = graf_matrix + "node[shape=record ,width=2.0]; \n";
		graf.append("graph[pencolor=transparent]; \n");
		graf.append("node [style=filled]; \n");
    	
                
    	//NodeVenta temp = head;
    	NodeVenta temp = matrix_capa;
    	
    	//alto = alto_mat();
    	alto = alto_mat_x_cap(matrix_capa);
    	//cout<<"alto_nod: "<<alto<<endl;
        //JOptionPane.showMessageDialog(null,"raiz: " + temp.dir_completo);
    	
    	//node *temp = nodo_x_nivel;
    	NodeVenta temp_inicio;
    	
    	NodeVenta temp_sup_ini;
		   	
        String fecha_str = "";
        if (temp.fecha_z != null) {
            fecha_str =  fecha.format(temp.fecha_z);
        }
                                                
    	/*para recorrer para la derecha*/
    	//while (temp->down != NULL) { 
    	while (temp != null) { 
	    	temp_inicio = temp;
	    	/*para recorrer para abajo*/
	    	//while (temp->right != NULL) { 
                String car_pad = "";
  
	    	while (temp != null) { 

                                       
                                        if (xx == 0 || yy == 0) {
                                        }else{
                                            ////////////xx = cor_x_carpeta(temp.dir_completo);
                                            xx = cor_x_hora(temp.horas_x, matrix_capa);
                                        }
                                        
                                        y_grap = alto - yy;;
                                        
                                        y_grap = y_grap*2;
                                        x_grap = xx*3;
                                        

                                                //graf_matrix = graf_matrix + "p"+xx+yy +"[label=\"{<data>"+xx+","+yy+"|<next>}\" pos=\""+xx+","+y_grap+"!\"]; \n";
						//graf_matrix = graf_matrix + "p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+ temp->valor+ "}\" pos=\""+xx+","+y_grap+"!\"]; \n";
						
						/////////////////////////////////////////////graf_matrix = graf_matrix + "p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+ temp->valor+ "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n";
                                                //graf.append("p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+ temp.nombre+ "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n");
                                                
                                                String hora_str = "";
                                                if (temp.horas_x != null) {
                                                    hora_str =  hora.format(temp.horas_x);
                                                }
//                                                String fecha_str = "";
//                                                if (temp.fecha_z != null) {
//                                                    fecha_str =  fecha.format(temp.fecha_z);
//                                                }
                                                 
////////////                                                int carpetas = CantidadCarpetas(temp.dir_completo);
////////////                                                int files =0;
////////////                                                if (temp.arbol_archivos != null) {
////////////                                                    files = temp.arbol_archivos.Cantfiles();
////////////                                                }
                                                
                                                //System.out.print(temp.dir_completo+" -> ");
                                                //graf.append("p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+  temp.dir_completo+ "\\n" + temp.dir_padre + "\\n" + temp.nombre + "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n");
                                                if (temp.tipo.equals("N")) {
//                                                graf.append("p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+  temp.nombre 
//                                                        + "\\n" + "carpetas: "+carpetas +  "\\n" + "archivos: "+files + "\\n" + fech + "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n");
                                                
//                                                graf.append("p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+  hora_str
//                                                        + "\\n" + "cliente: "+temp.cliente +  "\\n" + "archivos: "+files + "\\n" + fech + "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n");

                                                            graf.append("p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+  hora_str
                                                        + "\\n" +temp.cliente + "\\n" +temp.total + "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n");
                                                
                                                } else {
//                                                    graf.append("p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+  temp.nombre 
//                                                        + "\\n" + "carpetas: "+carpetas +  "\\n" +  "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n");
                                                    
                                                    if (yy == 0 && xx == 0) {
                                                        //JOptionPane.showMessageDialog(null, "raiz","info",JOptionPane.ERROR_MESSAGE);
                                                        graf.append("p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+  fecha_str 
                                                        +  "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n");
                                                    } else if (yy == 0) {
                                                        graf.append("p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+  hora_str 
                                                        +  "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n");
                                                    } else if (xx == 0) {
                                                         graf.append("p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+  
                                                        temp.cliente +  "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n");
                                                    } 
                                                    
                                                     
                                                }
                                                
                                                //graf.append("p"+xx+"_"+yy +"[label=\"{<data>"+xx+","+yy+"|<next>"+  temp.nombre + " : " + temp.tipo+ "}\" pos=\""+x_grap+","+y_grap+"!\"]; \n");
                
                                               
                                                
						
                                            /*para imprimir las flechas de la derecha*/
                                            if (temp.right != null){

//                                                    int xx2 = xx+1; 
//                                                    int yy2 = yy;
                                                    int xx2 = 0;
//                                                    if (xx == 0 || yy == 0) {
//                                                        //xx2 = xx+1;
//                                                    }else{
                                                        xx2 = cor_x_hora(temp.right.horas_x, matrix_capa);
//                                                    }

                                                    //graf_matrix = graf_matrix + "p"+xx+"_"+yy + "->p"+ xx2+"_"+yy2+"[dir=both]; \n";
                                                    graf.append("p"+xx+"_"+yy + "->p"+ xx2+"_"+yy+"; \n");
                                            }

                                            /*para imprimir las flechas de abajo*/
                                            if (temp.down != null){


                                                    //int xx2 = xx; 
                                                    int yy2 = 0;
                                                    yy2 = cor_y_carpeta(temp.down.idcliente_y, matrix_capa);

                                                    graf.append("p"+xx+"_"+yy + "->p"+ xx+"_"+yy2+"; \n");
                                                    //graf_matrix = graf_matrix + "p"+xx+"_"+yy + "->p"+ xx2+"_"+yy2+"[dir=both]; \n";
                                            }
				    	
                        xx++;
		    	temp = temp.right;
			}
	
			temp = temp_inicio;
                yy++;
                xx = 0;
	    	temp = temp.down;  	
//                System.out.println();
		}  	

		graf.append("\n}\n");

		//create_archivo(name_cap, graf_matrix);
                return this.graf_matrix(graf.toString(), "mat_ventas");
 	
    }


public boolean graf_matrix(String grafica, String name_graf){
        //File archivo =new File("hash_user.txt");
        try
            {
            //File archivo =new File("mat_carpetas.txt");
            File archivo =new File(name_graf+".txt");
            FileWriter escribir= new FileWriter(archivo);
            escribir.write(grafica);
            escribir.close();
            }

            catch(Exception e)
            {
            JOptionPane.showMessageDialog(null, "Error al escribir","NANI",JOptionPane.ERROR_MESSAGE);
            return false;
            }
        
        try {

            Runtime rt = Runtime.getRuntime();
            //rt.exec( cmd );
            //Process p = rt.exec("neato -Tpng mat_carpetas.txt -o mat_carpetas.jpg");
            Process p;
//            if (name_graf.equals("grafodir_carpetas")) {
//                p = rt.exec("dot -Tpng "+name_graf+".txt -o "+name_graf+".jpg");
//            } else{
                p = rt.exec("neato -Tpng "+name_graf+".txt -o "+name_graf+".jpg");
//            }
            
            p.waitFor();
            //rt.exec("hash_user.jpg");
            ////Desktop.getDesktop().open(new File("mat_carpetas.jpg"));
            
            Desktop.getDesktop().open(new File(name_graf+".jpg"));

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex,"NANI",JOptionPane.ERROR_MESSAGE);
                return false;
            } finally {}
        
        return true;
        
    }

//////////////////////////////////fin grafica
public NodeVenta existeCliente_des(int idcliente_y) {
    //System.out.println();
    
    NodeVenta temp = head;
    NodeVenta temp_inicio;

    while (temp != null) { 
            temp_inicio = temp;
            while (temp != null) { 
                    if (temp != null)
                    {
                        if (temp.idcliente_y == idcliente_y) {
                            return temp;
                         }
                    }	    	
                    temp = temp.down;
                    }

                    temp = temp_inicio;
            temp = temp.capa_up;
            //System.out.println();
            }  	
    
            return null;
            //System.out.println("**********termina**********");   
    }

    
    
}
