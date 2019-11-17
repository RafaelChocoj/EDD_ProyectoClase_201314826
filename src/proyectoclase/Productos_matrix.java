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
        
        //NodeProducto (String tipo,int idproducto_x, int idcate_y, String nombrear, double precio,int unidades, String nombrecate)
        NodeProducto temp = new NodeProducto("R", 0, 0, "raiz", 0.00, 0,  "raiz");
        head = temp; 
        
        this.size = 0;
        this.size_x = 0;
        this.size_y = 0;
    }
    
    public void add (int x_prod, int y_cat, String nombreprod, double precio,int unidades, String cat_nomnbre) {
    	//1 crear header
    	//1.1 creade x header
    	////add_z_header(z, file_capa);
        
//    	add_x_header(x, z);
//    	add_y_header(y, z);  	
        
        add_x_header(x_prod);
    	add_y_header(y_cat);  
        
    	//1.2 create y header
    	
    	
    	//2 insert nodo
        //NodeProducto (String tipo,int idproducto_x, int idcate_y, String nombrear, double precio,int unidades, String nombrecate)
    	NodeProducto new_node = new NodeProducto("N", x_prod, y_cat, nombreprod, precio, unidades, cat_nomnbre);

//    	/* inicio para insertar nodo de profunidad inserta 0 en z	*/
//    	node *new_z0 = new node(0, x, y, 0, "C", "C");

    	/* fin para insertar nodo de profunidad inserta 0 en z	*/
    	
//    	///**********insertando nodos**************/////
//    	add_x_header_z0(x, z);
//    	add_y_header_z0(y, z);  
    	
    	
    	//add_x(new_node, x_prod, y_cat, z);
        add_x(new_node, x_prod, y_cat);
    	//add_y(new_node, x_prod, y_cat, z);
        add_y(new_node, x_prod, y_cat);

          
    }
    
    /////////////////inicio insertando encabezados
    //public void add_x_header(int x,  int z) {
    public void add_x_header(int x_prod) {

    	NodeProducto head_x = head;
    	
//    	/*primero recorre prufundidad*/
//		/*recorre por z, para insertar a la derecha*/	
//		while(head_x.cor_z != z){
//    		head_x = head_x.capa_up;
//		}

        //NodeProducto (String tipo,int idproducto_x, int idcate_y, String nombrear, double precio,int unidades, String nombrecate)
    	if (head_x.right == null) {   	
	    	NodeProducto temp = new NodeProducto("C", x_prod,0, "prod" , 0.00, 0, "cat");
	    	head_x.right = temp;
	    	temp.left = head_x; 
    	} else  {     
			
		/*recorre por z, para insertar a la derecha*/		
		NodeProducto temp = head;
				
//		while(temp.cor_z != z){
//    		temp = temp.capa_up;
//		}
		
		while (temp.right != null && temp.right.idproducto_x < x_prod ) { 
			temp = temp.right;
                } 
                    if (temp.right == null ) { 
		    	NodeProducto new_temp = new NodeProducto("C", x_prod,0, "prod" , 0.00, 0, "cat");
		    	temp.right = new_temp;
		    	new_temp.left = temp; 
		    	
	    		}else if (temp.right != null && temp.right.idproducto_x != x_prod )
                        {
                            NodeProducto new_temp = new NodeProducto("C", x_prod,0, "prod" , 0.00, 0, "cat");
                            NodeProducto der = temp.right;

                            temp.right = new_temp;
                            new_temp.left = temp;
                            new_temp.right = der;
                            der.left = new_temp;

                        }
    	}
    }
    
    //public void add_y_header(int y_cat, int z) {
    public void add_y_header(int y_cat) {

    	NodeProducto head_y = head;
        
//    	/*primero recorre prufundidad*/
//        /*recorre por z, para insertar a la derecha*/	
//        while(head_y.cor_z != z){
//        head_y = head_y.capa_up;
//        }	
    		
    	if (head_y.down == null) { 
                //NodeProducto (String tipo,int idproducto_x, int idcate_y, String nombrear, double precio,int unidades, String nombrecate)
                NodeProducto temp =       new NodeProducto("C", 0, y_cat, "prod" , 0.00, 0, "cat");
	    	head_y.down = temp;
	    	temp.up = head_y; 
    	} else  {     	
		NodeProducto temp =head;
                
//		/*nuevo inicio*/
//		while(temp.cor_z != z){
//    		temp = temp.capa_up;
//		}
//		/*nuevo fin*/

		while (temp.down != null && temp.down.idcate_y < y_cat ) { 
			temp = temp.down;
                } 
                    if (temp.down == null ) { 
		    	NodeProducto new_temp = new NodeProducto("C", 0, y_cat, "prod" , 0.00, 0, "cat");
		    	temp.down = new_temp;
		    	new_temp.up = temp; 
		    	
	    		}else if (temp.down != null && temp.down.idcate_y != y_cat )
                        {
                            NodeProducto new_temp = new NodeProducto("C", 0, y_cat, "prod" , 0.00, 0, "cat");
                            NodeProducto der = temp.down;

                            temp.down =new_temp;
                            new_temp.up = temp;
                            new_temp.down = der;
                            der.up = new_temp;				
                        }
    	}
    }
    
////////////////////////////////agregando nodos
    //public void add_x(NodeProducto new_node, int x_prod, int y_cat, int z){
    public void add_x(NodeProducto new_node, int x_prod, int y_cat){
        NodeProducto tem = head;

//    /*primero recorre prufundidad*/
//    /*recorre por z, para insertar a la derecha*/	
//    while(tem.cor_z != z){
//    tem = tem.capa_up;
//    }		
//    //////////////*************************

    /*recorre por x, para insertar a abajo (y)*/	
    //while(tem.idproducto_x != x_prod){
        while(tem.idproducto_x != x_prod){
            tem = tem.right;
        }
            if(tem.down == null){
                    tem.down = new_node;
                    new_node.up = tem;
            } 
            /*si y es mejor al ultimo*/
            else if(tem.down.idcate_y >= y_cat ){

                    if(tem.down.idcate_y == y_cat && tem.down.idproducto_x == x_prod ){ ///nre para repetidos
                    }else{

                            NodeProducto ul_down = tem.down;

                            tem.down = new_node;
                            new_node.up = tem;

                            //para que enlace el que estaba antes
                            new_node.down = ul_down;
                            ul_down.up = new_node;
                    } //fin nre para repetidos
            }
            else
            {
                    NodeProducto temp_abaj = tem.down;
                    //while (temp_abaj.down != null && temp_abaj.down.idcate_y < y_cat ) { 
                    while (temp_abaj.down != null && temp_abaj.down.idcate_y <= y_cat ) { 
                            temp_abaj = temp_abaj.down;
            }

            if(temp_abaj.idcate_y == y_cat && temp_abaj.idproducto_x == x_prod ){ //in new para repetidos
            }else{

                    NodeProducto ul_down = null;  /// in  new para no insertar repetido
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
 
    //public void add_y(NodeProducto new_node, int x_prod, int y_cat, int z){
    public void add_y(NodeProducto new_node, int x_prod, int y_cat){
            NodeProducto tem= head;
            
//            /*primero recorre prufundidad*/
//            /*recorre por z, para insertar a la derecha*/	
//            while(tem.cor_z != z){
//            tem = tem.capa_up;
//            }

            /*recorre por y, para insertar a la derecha (x)*/	
            while(tem.idcate_y != y_cat){
            tem = tem.down;
            }
            if(tem.right == null){
                    tem.right = new_node;
                    new_node.left = tem;
            }
            else if(tem.right.idproducto_x >= x_prod ){

            if(tem.right.idcate_y == y_cat && tem.right.idproducto_x == x_prod ){ ///nre para que no se repita
            }else{

                        NodeProducto ul_der = tem.right;

                        tem.right = new_node;
                        new_node.left = tem;

                        //para que enlace el que estaba antes
                        new_node.right = ul_der;
                        ul_der.left = new_node;
                    }
            }
            else
            {
                NodeProducto temp_der = tem.right;
                while (temp_der.right != null && temp_der.right.idproducto_x <= x_prod ) {  
                        temp_der = temp_der.right;
                }
            if(temp_der.idcate_y == y_cat && temp_der.idproducto_x == x_prod ){  /// inic nre parte para que nos repita
            }else{

                    NodeProducto ul_der = null;
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
    
    
    /*imprimiendo encabezados*/
    
    /*imprimiendo encabezados*/
 public void print_x_header() {
    NodeProducto temp = head;
    while (temp.right != null) { 
        System.out.print("("+temp.idproducto_x+ ","+temp.idcate_y +") -> ");
        temp = temp.right;
    }  	
    System.out.print("("+temp.idproducto_x+ ","+temp.idcate_y +") -> ");
}
   
public void print_y_header() {
    System.out.println();
    NodeProducto temp = head;

    while (temp.down != null) { 
        System.out.println("("+temp.idproducto_x+ ","+temp.idcate_y +") -> ");
        temp = temp.down;
    }  	 
    System.out.println("("+temp.idproducto_x+ ","+temp.idcate_y +") -> ");
}

public void print_node_mat() {
    System.out.println();
    
    NodeProducto temp = head;
    NodeProducto temp_inicio;

    while (temp != null) { 
            temp_inicio = temp;
            while (temp != null) { 
                    if (temp != null)
                    {
                        System.out.print("("+temp.idproducto_x+ ","+temp.idcate_y +") -> ");

                    }	    	
                    temp = temp.right;
                    }

                    temp = temp_inicio;
            temp = temp.down;
            System.out.println();
            }  	

            System.out.println("**********termina**********");   
    }
    
}
