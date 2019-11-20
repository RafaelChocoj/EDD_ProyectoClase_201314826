/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclase;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author RAFAEL
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    public Reportes() {
        initComponents();
        com_cliente.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_productos = new javax.swing.JButton();
        b_clientes = new javax.swing.JButton();
        com_cliente = new javax.swing.JComboBox<>();
        b_ventas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        b_productos.setText("Inventario");
        b_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_productosActionPerformed(evt);
            }
        });

        b_clientes.setText("Clientes");
        b_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_clientesActionPerformed(evt);
            }
        });

        b_ventas.setText("Ventas");
        b_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ventasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_ventas, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(b_clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_productos, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(com_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(b_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(com_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(b_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_productosActionPerformed
        writeDocsPDF("productos.pdf");
    }//GEN-LAST:event_b_productosActionPerformed

    private void b_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clientesActionPerformed
        writeDocsPDF_cliente("clientes.pdf");
    }//GEN-LAST:event_b_clientesActionPerformed

    private void b_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ventasActionPerformed
        writeDocsPDF_ventas("ventas.pdf");
    }//GEN-LAST:event_b_ventasActionPerformed

    public static void writeDocsPDF(String fileName) {
    PdfWriter writer = null;
 
    Document document = new Document();
 
    try {
        writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.open();

        /*  reportes de Productos  */
        document.newPage();
        document.add(new Paragraph("Reporte de Inventario (Productos)",
				FontFactory.getFont("arial",   // fuente
				20,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.BLUE)));
        document.bottom();
        document.add(new Paragraph("--"));
        document.add(new Paragraph(""));
        
        
//        int cont = 0;
//        for(ColaImpresion ca : cola){
//            cont++;
            //PdfPTable tabla = new PdfPTable(2);
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("No.");
            tabla.addCell("id Producto");
            tabla.addCell("Nombre");
            
            tabla.addCell("id Categoria");
            tabla.addCell("Categoria");
            
            tabla.addCell("Precio");
            tabla.addCell("Existencia");
//            ca.getDim1(); dimension1
//            ca.getDimension(); dimension2 graficar
//            ca.getMetrica(); metricas



////            for (int i = 0; i < dim2_im.length; i++) {
//            for (int i = 0; i < ca.getDimension().length ; i++) {
////                JOptionPane.showMessageDialog(null, "dim2_im["+i+"]: " + dim2_im[i]);
//                tabla.addCell(String.valueOf(i +1));
//                tabla.addCell(ca.getDimension()[i]);
//                tabla.addCell(String.valueOf(ca.getMetrica()[i] ));
////                tabla.addCell(ca.getGrafica().toString());
//                
//            }

    NodeProducto temp = ProyectoClase.mat_productos.head;
    int conta = 0;
    while (temp != null) { 
  
            if (temp.down != null){
                NodeProducto temp_abj = temp.down;
                while (temp_abj != null) { 
                    
                    if (temp_abj.tipo.equals("N")) {
                        conta++;
                        tabla.addCell(String.valueOf(conta));
                        tabla.addCell(String.valueOf(temp_abj.idproducto_x));
                        tabla.addCell(String.valueOf(temp_abj.nombrear));
                        
                        tabla.addCell(String.valueOf(temp_abj.idcate_y));
                        tabla.addCell(String.valueOf(temp_abj.nombrecate));
                        
                        tabla.addCell(String.valueOf(temp_abj.precio));
                        tabla.addCell(String.valueOf(temp_abj.unidades));
                        //productos.addRow(new Object[]{temp_abj.idproducto_x, temp_abj.nombrear,temp_abj.idcate_y, temp_abj.nombrecate , temp_abj.precio, temp_abj.unidades });
                    }
                       

                    temp_abj = temp_abj.down;
                }
            }
        temp = temp.right;
    } 
    
            
            
            tabla.spacingAfter();
            document.add(tabla);
            
//        PdfContentByte contentByte = writer.getDirectContent();
//        PdfTemplate template = contentByte.createTemplate(width, height);
//
//            Graphics2D graphics2d = template.createGraphics(width, height, new DefaultFontMapper());
//            Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width, height);
//            
//            ca.getGrafica().draw(graphics2d, rectangle2d );
//            graphics2d.dispose();
//            contentByte.addTemplate(template, 20, 10);
//
////////            contentByte.addTemplate(template, 0,0);

            document.newPage();
            
//        }
//        
   
        
//        JOptionPane.showMessageDialog(null, "asdfsadfasdfasdfvcfadsfasdfasdfasdfasdfasfasdf");
//        for (int i = 0; i < dim2_im.length; i++) {
//            JOptionPane.showMessageDialog(null, "dim2_im["+i+"]: " + dim2_im[i]);
//            tabla.addCell(dim2_im[i]);
//            tabla.addCell(String.valueOf(met_im[i] ));
//        }
        

        document.close();
        Desktop.getDesktop().open(new File("productos.pdf"));
        
    } catch (Exception e) {
        e.printStackTrace();
        document.close();
    }
    

    
////    JOptionPane.showMessageDialog(null,"El proceso se realizó con éxito");
}
    
  public void writeDocsPDF_ventas(String fileName) {
    PdfWriter writer = null;
 
    Document document = new Document();
 
    try {
        writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.open();

        /*  reportes de Productos  */
        document.newPage();
        document.add(new Paragraph("Reporte de Ventas",
				FontFactory.getFont("arial",   // fuente
				20,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.BLUE)));
        document.bottom();
        document.add(new Paragraph("--"));
        document.add(new Paragraph(""));
        
        
//        int cont = 0;
//        for(ColaImpresion ca : cola){
//            cont++;
            //PdfPTable tabla = new PdfPTable(2);
            
            PdfPTable tabla = new PdfPTable(9);
            tabla.addCell("No.");
            tabla.addCell("Fecha Venta");
            tabla.addCell("Hora");
            
            tabla.addCell("id Cliente");
            tabla.addCell("Cliente");
            
            tabla.addCell("Usuario");
            
            tabla.addCell("Total");
            tabla.addCell("Monto");
            tabla.addCell("Cambio");
            
            tabla.spacingAfter();
            document.add(tabla);
            conta = 0;
            print_node_cor_z(document);

//    NodeProducto temp = ProyectoClase.mat_productos.head;
//    int conta = 0;
//    while (temp != null) { 
//  
//            if (temp.down != null){
//                NodeProducto temp_abj = temp.down;
//                while (temp_abj != null) { 
//                    
//                    if (temp_abj.tipo.equals("N")) {
//                        conta++;
//                        tabla.addCell(String.valueOf(conta));
//                        tabla.addCell(String.valueOf(temp_abj.idproducto_x));
//                        tabla.addCell(String.valueOf(temp_abj.nombrear));
//                        
//                        tabla.addCell(String.valueOf(temp_abj.idcate_y));
//                        tabla.addCell(String.valueOf(temp_abj.nombrecate));
//                        
//                        tabla.addCell(String.valueOf(temp_abj.precio));
//                        tabla.addCell(String.valueOf(temp_abj.unidades));
//                        //productos.addRow(new Object[]{temp_abj.idproducto_x, temp_abj.nombrear,temp_abj.idcate_y, temp_abj.nombrecate , temp_abj.precio, temp_abj.unidades });
//                    }
//                       
//
//                    temp_abj = temp_abj.down;
//                }
//            }
//        temp = temp.right;
//    } 
    
            
            
            

            document.newPage();

        document.close();
        Desktop.getDesktop().open(new File(fileName));
        
    } catch (Exception e) {
        e.printStackTrace();
        document.close();
    }
    

    
////    JOptionPane.showMessageDialog(null,"El proceso se realizó con éxito");
}
    
    int conta = 0;
    public void writeDocsPDF_cliente(String fileName) {
    PdfWriter writer = null;
 
    Document document = new Document();
 
    try {
        writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.open();

        /*  reportes de Productos  */
        document.newPage();
        document.add(new Paragraph("Reporte de Clientes",
				FontFactory.getFont("arial",   // fuente
				20,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.BLUE)));
        document.bottom();
        document.add(new Paragraph("--"));
        document.add(new Paragraph(""));
        

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("No.");
            tabla.addCell("id Cliente");
            tabla.addCell("Nombre");
            

//    NodeProducto temp = ProyectoClase.mat_productos.head;
//    int conta = 0;
//    while (temp != null) { 
//  
//            if (temp.down != null){
//                NodeProducto temp_abj = temp.down;
//                while (temp_abj != null) { 
//                    
//                    if (temp_abj.tipo.equals("N")) {
//                        conta++;
//                        tabla.addCell(String.valueOf(conta));
//                        tabla.addCell(String.valueOf(temp_abj.idproducto_x));
//                        tabla.addCell(String.valueOf(temp_abj.nombrear));
//                        
//                        tabla.addCell(String.valueOf(temp_abj.idcate_y));
//                        tabla.addCell(String.valueOf(temp_abj.nombrecate));
//                        
//                        tabla.addCell(String.valueOf(temp_abj.precio));
//                        tabla.addCell(String.valueOf(temp_abj.unidades));
//                        //productos.addRow(new Object[]{temp_abj.idproducto_x, temp_abj.nombrear,temp_abj.idcate_y, temp_abj.nombrecate , temp_abj.precio, temp_abj.unidades });
//                    }
//                       
//
//                    temp_abj = temp_abj.down;
//                }
//            }
//        temp = temp.right;
//    } 
    
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fech_o = null;
        try {           
           fech_o = fecha.parse("01/01/1970");            
        } catch (Exception e) {
        }
        
        conta = 0;
        com_cliente.removeAllItems();
        NodeVenta temp = ProyectoClase.mat_ventas.head;
        while (temp != null) { 
            
            if (!temp.fecha_z.equals(fech_o)) {
                llenado_cliente_y(temp, tabla);
            }
            temp = temp.capa_up;
        }
        ///////////****
            
            
            tabla.spacingAfter();
            document.add(tabla);
            

            document.newPage();
            

        document.close();
        Desktop.getDesktop().open(new File("clientes.pdf"));
        
    } catch (Exception e) {
        e.printStackTrace();
        document.close();
    }
    

    
////    JOptionPane.showMessageDialog(null,"El proceso se realizó con éxito");
}
    
    public void llenado_cliente_y(NodeVenta clie_z, PdfPTable tabla){
        NodeVenta temp = clie_z;
        while (temp != null) { 
            
            if (temp.idcliente_y != 0) {
                if (ya_enlista(String.valueOf(temp.idcliente_y)) == false) {
                        com_cliente.addItem(String.valueOf(temp.idcliente_y));
                        conta++;
                        tabla.addCell(String.valueOf(conta));
                        tabla.addCell(String.valueOf(temp.idcliente_y));
                        tabla.addCell(String.valueOf(temp.cliente));

                }
                
            }
            temp = temp.down;
        }
    }
    
    public boolean ya_enlista(String clien){
        for (int i = 0; i < com_cliente.getItemCount(); i++) {
            String cl = com_cliente.getItemAt(i);
            if (cl.equals(clien)) {
                return true;
            }
    }
        return false;
    }
        
    /////////////////////////ventas
    public void print_node_cor_z(Document document) throws DocumentException {
    	NodeVenta temp = ProyectoClase.mat_ventas.head;;
    	while (temp != null) { 
	    	//cout<<"c_o_z: "<<temp->data<<endl;
	    	print_node_cor_mat(temp, document);
	    	temp = temp.capa_up;
        }  	
		
    }
    
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
    public void print_node_cor_mat(NodeVenta nodo_x_nivel, Document document) throws DocumentException {
    	NodeVenta temp = nodo_x_nivel;
    	NodeVenta temp_inicio;
    	
    	NodeVenta temp_sup_ini;
    	/*para recorrer para la derecha*/

    	while (temp != null) { 

	    	temp_inicio = temp;
	    	/*para recorrer para abajo*/

	    	while (temp != null) { 
		    	
                        //////////////
                    if (temp.tipo.equals("N")) {
                        
                        PdfPTable tablaven = new PdfPTable(9);
//                        tablaven.addCell("No.");
//                        tablaven.addCell("Fecha Venta");
//                        tablaven.addCell("Hora");
//
//                        tablaven.addCell("id Cliente");
//                        tablaven.addCell("Cliente");
//
//                        tablaven.addCell("Usuario");
//
//                        tablaven.addCell("Total");
//                        tablaven.addCell("Monto");
//                        tablaven.addCell("Cambio");
            
                        conta++;
//                        tabla.addCell(String.valueOf(conta));
//                        tabla.addCell(String.valueOf(fecha.format(temp.fecha_z) ));
//                        tabla.addCell(String.valueOf(hora.format(temp.horas_x)));
//                        
//                        tabla.addCell(String.valueOf(temp.idcliente_y));
//                        tabla.addCell(String.valueOf(temp.cliente));
//                        
//                        tabla.addCell(String.valueOf(temp.usuario));
//                        
//                        tabla.addCell(String.valueOf(temp.total));
//                        tabla.addCell(String.valueOf(temp.monto));
//                        tabla.addCell(String.valueOf(temp.vuelto));
                    tablaven.addCell(String.valueOf(conta));
                    tablaven.addCell(String.valueOf(fecha.format(temp.fecha_z) ));
                    tablaven.addCell(String.valueOf(hora.format(temp.horas_x)));

                    tablaven.addCell(String.valueOf(temp.idcliente_y));
                    tablaven.addCell(String.valueOf(temp.cliente));

                    tablaven.addCell(String.valueOf(temp.usuario));

                    tablaven.addCell(String.valueOf(temp.total));
                    tablaven.addCell(String.valueOf(temp.monto));
                    tablaven.addCell(String.valueOf(temp.vuelto));
                        
                    tablaven.spacingAfter();
                    document.add(tablaven);    
                    
                    if (temp.detalles != null) {
                        PdfPTable detalle = new PdfPTable(5);
                        //detalle.addCell("No.");
                        detalle.addCell("id producto");
                        detalle.addCell("Nombre");
                        detalle.addCell("Unidades");
                        detalle.addCell("Precio");
                        detalle.addCell("Subtotal");
                        
                        /*agregando detalles*/
                        for (int i = 0; i < temp.detalles.getRowCount() ; i++) {
                            detalle.addCell(String.valueOf(temp.detalles.getValueAt(i, 0) ));
                            detalle.addCell(String.valueOf(temp.detalles.getValueAt(i, 1) ));
                            detalle.addCell(String.valueOf(temp.detalles.getValueAt(i, 2) ));
                            detalle.addCell(String.valueOf(temp.detalles.getValueAt(i, 3) ));
                            detalle.addCell(String.valueOf(temp.detalles.getValueAt(i, 4) ));
        
                        }
                        

                    detalle.spacingAfter();
                    document.add(detalle);  
                    }
                         
                        
            
                    }
                       

		    	temp = temp.right;
			}
		
			temp = temp_inicio;
	    	temp = temp.down;
		}  	

 	
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_clientes;
    private javax.swing.JButton b_productos;
    private javax.swing.JButton b_ventas;
    private javax.swing.JComboBox<String> com_cliente;
    // End of variables declaration//GEN-END:variables
}