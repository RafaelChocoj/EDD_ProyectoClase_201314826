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
    	
    	
//    	//2 insert nodo
//    	node *new_node = new node(value, x, y, z, "N", valor);
//
//    	/* inicio para insertar nodo de profunidad inserta 0 en z	*/
//    	node *new_z0 = new node(0, x, y, 0, "C", "C");
//
//    	/* fin para insertar nodo de profunidad inserta 0 en z	*/
//    	
//    	///**********insertando nodos**************/////
//    	add_x_header_z0(x, z);
//    	add_y_header_z0(y, z);  
//    	
//    	
//    	add_x(new_node, x, y, z);
//    	add_y(new_node, x, y, z);

          
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
    
}
