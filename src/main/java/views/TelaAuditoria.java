
package views;

import configuration.SpringConfig;
import entities.ParametroGenerico;
import org.apache.commons.lang3.StringUtils;
import services.ParametroGenericoService;

public class TelaAuditoria extends javax.swing.JDialog {

    private ParametroGenerico gerarAuditoria;
    
    public TelaAuditoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        ParametroGenericoService service = SpringConfig.context.getBean(ParametroGenericoService.class);
        
        gerarAuditoria = service.findGerarAuditoria();
        
        if (gerarAuditoria != null && StringUtils.equals(gerarAuditoria.getValor(), "SIM")) {
            buttonAtivarAuditoria.setText("Desativar Auditoria");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonAtivarAuditoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle Auditoria");

        buttonAtivarAuditoria.setText("Ativar Auditoria");
        buttonAtivarAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtivarAuditoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAtivarAuditoria, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAtivarAuditoria)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAtivarAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtivarAuditoriaActionPerformed
        ParametroGenericoService service = SpringConfig.context.getBean(ParametroGenericoService.class);
        
        if (gerarAuditoria == null) {
            gerarAuditoria = new ParametroGenerico();
            
            gerarAuditoria.setNome("GERAR_AUDITORIA");
            gerarAuditoria.setValor("SIM");
            
            service.insert(gerarAuditoria);
            
            buttonAtivarAuditoria.setText("Desativar Auditoria");
        } else if (StringUtils.equals(gerarAuditoria.getValor(), "NAO")) {
            gerarAuditoria.setValor("SIM");
            
            service.update(gerarAuditoria);
                    
            buttonAtivarAuditoria.setText("Desativar Auditoria");
        } else {
            gerarAuditoria.setValor("NAO");
            
            service.update(gerarAuditoria);
                    
            buttonAtivarAuditoria.setText("Ativar Auditoria");
        }
    }//GEN-LAST:event_buttonAtivarAuditoriaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAuditoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAuditoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAuditoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAuditoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAuditoria dialog = new TelaAuditoria(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonAtivarAuditoria;
    // End of variables declaration//GEN-END:variables
}
