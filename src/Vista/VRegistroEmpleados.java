//JFrame de interfaz grafica del usuario para el registro de los datos de los empleados
package Vista;

import javax.swing.JButton;
/**
 * @author Edwin Fajardo
 */
public class VRegistroEmpleados extends javax.swing.JFrame {

    public VRegistroEmpleados() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLTitulo = new javax.swing.JLabel();
        JBGuardar = new javax.swing.JButton();
        JBSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        JLNombre = new javax.swing.JLabel();
        JTFNombre = new javax.swing.JTextField();
        JLMonto = new javax.swing.JLabel();
        JTFMonto = new javax.swing.JTextField();
        JBCuentaD = new javax.swing.JLabel();
        JTFCuentaD = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLTitulo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JLTitulo.setText("Generar registro de empleado");

        JBGuardar.setText("Guardar");

        JBSalir.setText("Salir");
        JBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalirActionPerformed(evt);
            }
        });

        JLNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JLNombre.setText("Nombre");

        JTFNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JTFNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLMonto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JLMonto.setText("Monto");

        JTFMonto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JTFMonto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JBCuentaD.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JBCuentaD.setText("Cuenta destino");

        JTFCuentaD.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JTFCuentaD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTFNombre)
                    .addComponent(JTFMonto)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLNombre)
                            .addComponent(JLMonto)
                            .addComponent(JBCuentaD))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JTFCuentaD))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLMonto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBCuentaD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFCuentaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(JLTitulo)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JBSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGuardar)
                    .addComponent(JBSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VRegistroEmpleados().setVisible(true);
            }
        });
    }

    //Getters and setters de los items del JFrame
    public JButton getJBGuardar() {
        return JBGuardar;
    }

    public void setJBGuardar(JButton JBGuardar) {
        this.JBGuardar = JBGuardar;
    }

    public JButton getJBSalir() {
        return JBSalir;
    }

    public void setJBSalir(JButton JBSalir) {
        this.JBSalir = JBSalir;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JBCuentaD;
    public javax.swing.JButton JBGuardar;
    public javax.swing.JButton JBSalir;
    private javax.swing.JLabel JLMonto;
    private javax.swing.JLabel JLNombre;
    private javax.swing.JLabel JLTitulo;
    public javax.swing.JTextField JTFCuentaD;
    public javax.swing.JTextField JTFMonto;
    public javax.swing.JTextField JTFNombre;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
