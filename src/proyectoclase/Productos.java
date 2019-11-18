package proyectoclase;

import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RAFAEL
 */
public class Productos extends javax.swing.JDialog {


    /**
     * Creates new form Productos
     */
    public Productos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenadoComboBox();
    }
    
    public void llenadoComboBox(){
        bom_cat.removeAllItems();
        //bom_cat.removeAll();
        NodeProducto temp = ProyectoClase.mat_productos.head;
        while (temp != null) { 
            
            //Categiria cat = new Categiria(temp.idcate_y, temp.nombrecate);
            //cb_cat.addItem(cat);
            if (temp.idcate_y != 0) {
                bom_cat.addItem(String.valueOf(temp.idcate_y));
            }
            temp = temp.down;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        t_precio = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t_nomcat = new javax.swing.JTextField();
        b_guardar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        t_unidades = new javax.swing.JFormattedTextField();
        t_id = new javax.swing.JFormattedTextField();
        bom_cat = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Producto");

        jLabel1.setText("Id Producto:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");

        t_precio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.##"))));
        t_precio.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel4.setText("id Categoria:");

        jLabel5.setText("Nombre Categoría:");

        b_guardar.setText("Guardar");
        b_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_guardarActionPerformed(evt);
            }
        });

        b_cancelar.setText("Salir");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Unidades:");

        t_unidades.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        t_id.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        bom_cat.setEditable(true);
        bom_cat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bom_catItemStateChanged(evt);
            }
        });
        bom_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bom_catActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(t_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t_unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(t_nomcat, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_id, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bom_cat, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(b_guardar)
                        .addGap(39, 39, 39)
                        .addComponent(b_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(t_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(t_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(t_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(t_unidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bom_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(t_nomcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_guardar)
                    .addComponent(b_cancelar))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
//        Menu men = new Menu();
//        men.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_b_cancelarActionPerformed

    public void Insert_Producto(){
        String nombre = t_nombre.getText();
        /*nombre prod*/
        if (t_nombre.getText().trim().length() == 0 || t_nombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de ingresar Nombre del Producto","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }  
        
        /*id*/
        int idprod;
        if (t_id.getText().trim().length() == 0 || t_id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de ingresar id producto","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }   else    {
            idprod = Integer.parseInt(t_id.getText());
        }
        
        /*unidades*/
        int unidades;
        if (t_unidades.getText().trim().length() == 0 || t_unidades.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de ingresar unidades","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }   else    {
            unidades = Integer.parseInt(t_unidades.getText());
        }
        /*unidades*/
        double precio;
        if (t_precio.getText().trim().length() == 0 || t_precio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de ingresar Precio","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }   else    {
            precio = Double.parseDouble(t_precio.getText());
        }
        

        String categori = t_nomcat.getText();
        /*nombre categoria*/
        if (t_nomcat.getText().trim().length() == 0 || t_nomcat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de ingresar Nombre de la Categoria","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }  
        
        /*idcategoria*/
//        if (t_idcat.getText().trim().length() == 0 || t_idcat.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe de ingresar id Categoria","Error",JOptionPane.ERROR_MESSAGE);
//            return;
//        }   else    {
//            idcat = Integer.parseInt(t_idcat.getText());
//        }
        
            String idcat_str = bom_cat.getSelectedItem().toString();
            int int_cat;
            try {
                int_cat = Integer.parseInt(idcat_str);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe de ingresar un numero","info",JOptionPane.ERROR_MESSAGE);
                bom_cat.setToolTipText("");
                return;
            }
            
        /*verificando si existe producto*/
        NodeProducto nod_prod;
        nod_prod = ProyectoClase.mat_productos.existeProducto(idprod);
        if (nod_prod != null) {
            JOptionPane.showMessageDialog(null, "Ya existe el Producto id " + nod_prod.idproducto_x +" " + nod_prod.nombrear,"Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //add (int x_prod, int y_cat, String nombreprod, double precio,int unidades, String cat_nomnbre)
        ProyectoClase.mat_productos.add(idprod, int_cat, nombre, precio, unidades, categori);
        
        llenadoComboBox();
        bom_cat.setSelectedItem(int_cat);
        JOptionPane.showMessageDialog(null, "Se Guardó Producto" ,"Save",JOptionPane.INFORMATION_MESSAGE);
        
        
    }
    private void b_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_guardarActionPerformed
        
        Insert_Producto();
        //add (int x_prod, int y_cat, String nombreprod, double precio,int unidades, String cat_nomnbre)

//        ProyectoClase.mat_productos.print_x_header();
//        ProyectoClase.mat_productos.print_y_header();
        
        //ProyectoClase.mat_productos.print_node_mat();
        
        ProyectoClase.mat_productos.print_Grafica_matrix();
    }//GEN-LAST:event_b_guardarActionPerformed

    private void bom_catItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bom_catItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String idcat = bom_cat.getSelectedItem().toString();
            int int_cat;
            try {
                int_cat = Integer.parseInt(idcat);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe de ingresar un numero","info",JOptionPane.ERROR_MESSAGE);
                bom_cat.setToolTipText("");
                return;
            }
            //JOptionPane.showMessageDialog(null, idcat,"info",JOptionPane.INFORMATION_MESSAGE);
            
            NodeProducto nod_cat;
            nod_cat = ProyectoClase.mat_productos.existeCategoria(int_cat);
            if (nod_cat != null) {
                t_nomcat.setText(nod_cat.nombrear);
            } else {
                t_nomcat.setText("");
            }
                
        
        }
    }//GEN-LAST:event_bom_catItemStateChanged

    private void bom_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bom_catActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bom_catActionPerformed

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos dialog = new Productos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancelar;
    private javax.swing.JButton b_guardar;
    private javax.swing.JComboBox<String> bom_cat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JFormattedTextField t_id;
    private javax.swing.JTextField t_nombre;
    private javax.swing.JTextField t_nomcat;
    private javax.swing.JFormattedTextField t_precio;
    private javax.swing.JFormattedTextField t_unidades;
    // End of variables declaration//GEN-END:variables
}
