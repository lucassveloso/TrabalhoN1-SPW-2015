/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.VendaController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Venda;

/**
 *
 * @author Lucas
 */
public class HistoricoCompras extends javax.swing.JFrame {

    VendaController vendaControler = new VendaController();
    DefaultTableModel dtm;
    
    public HistoricoCompras() {
        initComponents();
        this.setLocationRelativeTo(null);
        dtm = (DefaultTableModel) jtTabela.getModel();
        carregaUltimas5Vendas();
    }

    public void carregaUltimas5Vendas() {
        try {
            List<Venda> listaVenda = vendaControler.trazerVendas().getVendas();
            for (int j = dtm.getRowCount() - 1; j > -1; j--) {
                dtm.removeRow(j);
            }
            
            
            for (int i = listaVenda.size() -1; i >= listaVenda.size()-5 ; i--) {
                dtm.addRow(new String[]{
                    listaVenda.get(i).getId()+"",
                    listaVenda.get(i).getDiscos().size()+"",
                    listaVenda.get(i).getValorTotal()+"",
                    });
            }
            
        } catch (Exception e) {
           
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbDetalhes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Compras");

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nº de Discos", "Valor Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTabela);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Histórico das Ultimas 5 Compras:");

        jbDetalhes.setText("Ver Detalhes");
        jbDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDetalhesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jbDetalhes)))
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbDetalhes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDetalhesActionPerformed
             if (jtTabela.getSelectedRow() != -1) {
                DetalhesCompra dc = new DetalhesCompra(Integer.parseInt(dtm.getValueAt(jtTabela.getSelectedRow(), 0).toString()));
                dc.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Escolha uma venda para ver seus detalhes!");
            }
             
    }//GEN-LAST:event_jbDetalhesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbDetalhes;
    private javax.swing.JTable jtTabela;
    // End of variables declaration//GEN-END:variables
}
