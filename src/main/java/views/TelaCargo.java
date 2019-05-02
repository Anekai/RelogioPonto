
package views;

import configuration.SpringConfig;
import entities.Estado;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import framework.ArquivoLog;
import services.EstadoService;
import types.SimNaoType;

public class TelaCargo extends javax.swing.JDialog {

    private Estado entitySearch;
    private Estado entity;
    
    public TelaCargo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try{
            initComponents();

            this.setLocationRelativeTo(null);

            entitySearch = new Estado();

        } catch(Exception e) {
            new ArquivoLog(e.toString());
        }
    }
    
    private void load() {
        try {
            EstadoService service = SpringConfig.context.getBean(EstadoService.class);

            if (!fieldSearchId.getText().equals("")) {
                entitySearch.setId(Integer.valueOf(fieldSearchId.getText()));
            }

            if (!fieldSearchNome.getText().equals("")) {
                entitySearch.setNome(fieldSearchNome.getText());
            }

            populateTable(service.find(entitySearch));
        }catch(Exception e){
            new ArquivoLog(e.toString());
        }
    }
    
    private void populateTable(List<Estado> list) {
        DefaultTableModel model = (DefaultTableModel) tableCargo.getModel();
        Object rowData[] = new Object[3];
        model.setRowCount(0);
        
        for ( Estado estado : list ) {
            rowData[0] = estado.getId();
            rowData[1] = estado.getNome();

            model.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogInsert = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        fieldInsertNome = new javax.swing.JTextField();
        buttonInsertSalvar = new javax.swing.JButton();
        dialogUpdate = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldUpdateNome = new javax.swing.JTextField();
        fieldUpdateId = new javax.swing.JTextField();
        buttonUpdateSalvar = new javax.swing.JButton();
        buttonPesquisar = new javax.swing.JButton();
        buttonNovo = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCargo = new javax.swing.JTable();
        fieldSearchId = new javax.swing.JTextField();
        fieldSearchNome = new javax.swing.JTextField();

        dialogInsert.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogInsert.setTitle("Cadastrar Cargo");
        dialogInsert.setModal(true);
        dialogInsert.setResizable(false);
        dialogInsert.setSize(new java.awt.Dimension(360, 200));

        jLabel6.setText("*Nome:");

        buttonInsertSalvar.setText("Salvar");
        buttonInsertSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogInsertLayout = new javax.swing.GroupLayout(dialogInsert.getContentPane());
        dialogInsert.getContentPane().setLayout(dialogInsertLayout);
        dialogInsertLayout.setHorizontalGroup(
            dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonInsertSalvar)
                    .addGroup(dialogInsertLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(53, 53, 53)
                        .addComponent(fieldInsertNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 63, Short.MAX_VALUE))
        );
        dialogInsertLayout.setVerticalGroup(
            dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldInsertNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(buttonInsertSalvar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        dialogUpdate.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogUpdate.setTitle("Atualizar Cargo");
        dialogUpdate.setModal(true);
        dialogUpdate.setResizable(false);
        dialogUpdate.setSize(new java.awt.Dimension(300, 300));

        jLabel4.setText("*Nome:");

        jLabel5.setText("ID:");

        fieldUpdateId.setEditable(false);

        buttonUpdateSalvar.setText("Salvar");
        buttonUpdateSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogUpdateLayout = new javax.swing.GroupLayout(dialogUpdate.getContentPane());
        dialogUpdate.getContentPane().setLayout(dialogUpdateLayout);
        dialogUpdateLayout.setHorizontalGroup(
            dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogUpdateLayout.createSequentialGroup()
                        .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(53, 53, 53)
                        .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldUpdateId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldUpdateNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(310, Short.MAX_VALUE))
                    .addGroup(dialogUpdateLayout.createSequentialGroup()
                        .addComponent(buttonUpdateSalvar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        dialogUpdateLayout.setVerticalGroup(
            dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUpdateLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldUpdateId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldUpdateNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(buttonUpdateSalvar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cargos");

        buttonPesquisar.setText("Pesquisar");
        buttonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarActionPerformed(evt);
            }
        });

        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        tableCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCargo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableCargo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldSearchNome, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldSearchNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPesquisar)
                    .addComponent(buttonNovo)
                    .addComponent(buttonEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        load();
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity = new Estado();

                fieldInsertNome.setText("");

                dialogInsert.setLocationRelativeTo(null);
                dialogInsert.setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonNovoActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity = new Estado();
                entity.setId((Integer) tableCargo.getValueAt(tableCargo.getSelectedRow(), 0));

                entity = SpringConfig.context.getBean(EstadoService.class).find(entity).get(0);

                fieldUpdateId.setText(String.valueOf(entity.getId()));
                fieldUpdateNome.setText(entity.getNome());

                dialogUpdate.setLocationRelativeTo(null);
                dialogUpdate.setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonInsertSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertSalvarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity.setNome(fieldInsertNome.getText());

                EstadoService service = SpringConfig.context.getBean(EstadoService.class);

                service.insert(entity);

                fieldInsertNome.setText("");

                dialogInsert.dispose();
                load();
            }
        });
    }//GEN-LAST:event_buttonInsertSalvarActionPerformed

    private void buttonUpdateSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateSalvarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity.setNome(fieldUpdateNome.getText());

                EstadoService service = SpringConfig.context.getBean(EstadoService.class);

                service.update(entity);

                fieldUpdateNome.setText("");

                dialogUpdate.dispose();
                load();
            }
        });
    }//GEN-LAST:event_buttonUpdateSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCargo dialog = new TelaCargo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonInsertSalvar;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JButton buttonUpdateSalvar;
    private javax.swing.JDialog dialogInsert;
    private javax.swing.JDialog dialogUpdate;
    private javax.swing.JTextField fieldInsertNome;
    private javax.swing.JTextField fieldSearchId;
    private javax.swing.JTextField fieldSearchNome;
    private javax.swing.JTextField fieldUpdateId;
    private javax.swing.JTextField fieldUpdateNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCargo;
    // End of variables declaration//GEN-END:variables
}
