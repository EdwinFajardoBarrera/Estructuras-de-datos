/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author erofa
 */
public class MainView extends javax.swing.JFrame {
    
    

    /**
     * Creates new form RegistroEmpleadosView
     */
    public MainView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        JPRegistro = new javax.swing.JPanel();
        JBEmpleadoNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTEmpleados = new javax.swing.JTable();
        JCBMOrdenamiento = new javax.swing.JComboBox<>();
        JBGenerarRep = new javax.swing.JButton();
        JTFResultados = new javax.swing.JTextField();
        JBSalir = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBEmpleadoNuevo.setText("+ Agregar empleado");
        JBEmpleadoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEmpleadoNuevoActionPerformed(evt);
            }
        });

        JTEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JTEmpleados);

        JCBMOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insercion", "Burbuja", "Mergesort", "Quicksort", "Shellsort", "Mezcla directa", "Mezcla equilibrada multiple" }));

        JBGenerarRep.setText("Generar reporte");

        javax.swing.GroupLayout JPRegistroLayout = new javax.swing.GroupLayout(JPRegistro);
        JPRegistro.setLayout(JPRegistroLayout);
        JPRegistroLayout.setHorizontalGroup(
            JPRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addGroup(JPRegistroLayout.createSequentialGroup()
                        .addComponent(JBEmpleadoNuevo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPRegistroLayout.createSequentialGroup()
                        .addComponent(JCBMOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JPRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTFResultados)
                            .addComponent(JBGenerarRep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        JPRegistroLayout.setVerticalGroup(
            JPRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBEmpleadoNuevo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBGenerarRep)
                    .addComponent(JCBMOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(JBSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBEmpleadoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEmpleadoNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBEmpleadoNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
        
                
    }
    
    //Getters and setters
    public JButton getJBEmpleadoNuevo() {
        return JBEmpleadoNuevo;
    }

    public void setJBEmpleadoNuevo(JButton JBEmpleadoNuevo) {
        this.JBEmpleadoNuevo = JBEmpleadoNuevo;
    }

    public JButton getJBGenerarRep() {
        return JBGenerarRep;
    }

    public void setJBGenerarRep(JButton JBGenerarRep) {
        this.JBGenerarRep = JBGenerarRep;
    }

    public JButton getJBSalir() {
        return JBSalir;
    }

    public void setJBSalir(JButton JBSalir) {
        this.JBSalir = JBSalir;
    }

    public JComboBox<String> getJCBMOrdenamiento() {
        return JCBMOrdenamiento;
    }

    public void setJCBMOrdenamiento(JComboBox<String> JCBMOrdenamiento) {
        this.JCBMOrdenamiento = JCBMOrdenamiento;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton JBEmpleadoNuevo;
    public javax.swing.JButton JBGenerarRep;
    public javax.swing.JButton JBSalir;
    public javax.swing.JComboBox<String> JCBMOrdenamiento;
    private javax.swing.JPanel JPRegistro;
    public javax.swing.JTable JTEmpleados;
    private javax.swing.JTextField JTFResultados;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
