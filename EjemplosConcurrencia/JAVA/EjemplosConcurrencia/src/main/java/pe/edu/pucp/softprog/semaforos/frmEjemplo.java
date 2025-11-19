package pe.edu.pucp.softprog.semaforos;

import java.util.concurrent.Semaphore;
import javax.swing.DefaultListModel;

public class frmEjemplo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmEjemplo.class.getName());
    
    private DefaultListModel modeloProductor;
    private DefaultListModel modeloConsumidor1;
    private DefaultListModel modeloConsumidor2;
    
    public static Semaphore semaforo1;
    public static Semaphore semaforo2;
    public static Semaphore semaforo3;
    
    public frmEjemplo() {
        initComponents();
        
        semaforo1 = new Semaphore(0);
        semaforo2 = new Semaphore(3);
        semaforo3 = new Semaphore(1);
        
        modeloProductor = new DefaultListModel();
        modeloConsumidor1 = new DefaultListModel();
        modeloConsumidor2 = new DefaultListModel();
    
        jlProductor.setModel(modeloProductor);
        jlConsumidor.setModel(modeloConsumidor1);
        jlConsumidor2.setModel(modeloConsumidor2);
        
        Productor productor = new Productor(modeloProductor);
        Consumidor consumidor1 = new Consumidor(modeloProductor, modeloConsumidor1);
        Consumidor consumidor2 = new Consumidor(modeloProductor, modeloConsumidor2);
        productor.start();
        consumidor1.start();
        consumidor2.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProductor = new javax.swing.JLabel();
        lblConsumidor = new javax.swing.JLabel();
        jspConsumidor = new javax.swing.JScrollPane();
        jlConsumidor = new javax.swing.JList<>();
        jspProductor = new javax.swing.JScrollPane();
        jlProductor = new javax.swing.JList<>();
        jspConsumidor2 = new javax.swing.JScrollPane();
        jlConsumidor2 = new javax.swing.JList<>();
        lblConsumidor2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProductor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblProductor.setText("Productor:");

        lblConsumidor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblConsumidor.setText("Consumidor 1:");

        jlConsumidor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jspConsumidor.setViewportView(jlConsumidor);

        jlProductor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jspProductor.setViewportView(jlProductor);

        jlConsumidor2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jspConsumidor2.setViewportView(jlConsumidor2);

        lblConsumidor2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblConsumidor2.setText("Consumidor 2:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductor)
                    .addComponent(jspProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConsumidor)
                    .addComponent(jspConsumidor, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConsumidor2)
                    .addComponent(jspConsumidor2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblConsumidor2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jspConsumidor2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProductor)
                            .addComponent(lblConsumidor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jspProductor, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(jspConsumidor))))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new frmEjemplo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jlConsumidor;
    private javax.swing.JList<String> jlConsumidor2;
    private javax.swing.JList<String> jlProductor;
    private javax.swing.JScrollPane jspConsumidor;
    private javax.swing.JScrollPane jspConsumidor2;
    private javax.swing.JScrollPane jspProductor;
    private javax.swing.JLabel lblConsumidor;
    private javax.swing.JLabel lblConsumidor2;
    private javax.swing.JLabel lblProductor;
    // End of variables declaration//GEN-END:variables
}
