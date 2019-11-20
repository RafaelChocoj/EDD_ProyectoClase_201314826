package proyectoclase;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RAFAEL
 */
public class gra_ven extends javax.swing.JFrame {

    /**
     * Creates new form gra_ven
     */
    public gra_ven() {
        initComponents();
        print_z_header();
    }
    
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    public void print_z_header() {
        
        Date fech_o = null;
        try {           
           fech_o = fecha.parse("01/01/1970");            
        } catch (Exception e) {
        }
        
        com_fecha.removeAllItems();
        NodeVenta temp = ProyectoClase.mat_ventas.head;
        while (temp != null) { 
            if (!temp.fecha_z.equals(fech_o)) {
            //System.out.println(temp.fecha_z );
            com_fecha.addItem(String.valueOf( fecha.format(temp.fecha_z) ));
            }
            temp = temp.capa_up;
        }  	
        //System.out.print("("+temp.idproducto_x+ ","+temp.idcate_y +") -> ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        com_fecha = new javax.swing.JComboBox<>();
        b_graf = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b_graf.setText("Mostrar Grafica");
        b_graf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_grafActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha Venta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_graf, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(com_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(b_graf)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_grafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_grafActionPerformed
        
        String fecha_capa = com_fecha.getSelectedItem().toString();
        Date fec = null;
        try {
           fec = fecha.parse(fecha_capa);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ingrese fecha correcta","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //JOptionPane.showMessageDialog(null, fec,"Error",JOptionPane.ERROR_MESSAGE);
        
        //retornado nodo;
        NodeVenta nod_ven;
        nod_ven = ProyectoClase.mat_ventas.existeFecha(fec);
        if (nod_ven != null) {
            ProyectoClase.mat_ventas.print_Grafica_matrix(nod_ven);
        } else {
            JOptionPane.showMessageDialog(null, "ingrese fecha correcta","Error",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_b_grafActionPerformed

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
            java.util.logging.Logger.getLogger(gra_ven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gra_ven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gra_ven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gra_ven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gra_ven().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_graf;
    private javax.swing.JComboBox<String> com_fecha;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
