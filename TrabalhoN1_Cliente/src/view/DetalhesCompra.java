/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DiscoController;
import controller.VendaController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Disco;
import model.Venda;

/**
 *
 * @author Lucas
 */
public class DetalhesCompra extends javax.swing.JFrame {

    DefaultTableModel dtm;
    double ValorTotal = 0;
    List<Disco> listaDiscos;
    DiscoController discoController = new DiscoController();
    VendaController vendaController = new VendaController();
    
    public DetalhesCompra(List<Integer> idsDisco) {
        initComponents();
        this.setLocationRelativeTo(null);
        dtm = (DefaultTableModel) jtTabela.getModel();
        jlID.setVisible(false);
        jtTotal.setEditable(false);
        carregaDiscosCompradosPorID(idsDisco);
    }

    public DetalhesCompra(int idVenda) {
        initComponents();
        this.setLocationRelativeTo(null);
        dtm = (DefaultTableModel) jtTabela.getModel();
        jtTotal.setEditable(false);
        jbConfirmar.setVisible(false);
        Venda v = new Venda();
        v.setId(idVenda);
        v = vendaController.trazerVenda(v);
        jlID.setText("Venda de ID "+v.getId());
        jtTotal.setText(v.getValorTotal()+"");
        carregaDiscosComprados(v.getDiscos());
    }
    
    public void carregaDiscosCompradosPorID(List<Integer> idsDisco) {
        try {
            Disco disco = new Disco();
            List<Disco> listaDisco  = new ArrayList<Disco>();
            for (int i = 0; i< idsDisco.size(); i++) {
                disco.setId(idsDisco.get(i));
                listaDisco.add(discoController.trazerDisco(disco));
            }
            
            this.listaDiscos = listaDisco;
            
            for (int j = dtm.getRowCount() - 1; j > -1; j--) {
                dtm.removeRow(j);
            }
            for (Disco d : listaDisco) {
                dtm.addRow(new String[]{
                    d.getId()+"",
                    d.getTitulo(),
                    d.getArtista().getNome(),
                    d.getGenero(),
                    d.getAno()+"",
                    d.getPreco()+""});
                    
                ValorTotal += d.getPreco();
            }
            
            jtTotal.setText(ValorTotal+"");
        } catch (Exception e) {
           
        }
    }
    
    public void carregaDiscosComprados(List<Disco> discos) {
        try {
            
            this.listaDiscos = discos;
            
            for (int j = dtm.getRowCount() - 1; j > -1; j--) {
                dtm.removeRow(j);
            }
            for (Disco d : discos) {
                dtm.addRow(new String[]{
                    d.getId()+"",
                    d.getTitulo(),
                    d.getArtista().getNome(),
                    d.getGenero(),
                    d.getAno()+"",
                    d.getPreco()+""});
                    
                ValorTotal += d.getPreco();
            }
            
            jtTotal.setText(ValorTotal+"");
        } catch (Exception e) {
           
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jlID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        jbConfirmar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes Venda");

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Título", "Artista", "Gênero", "Ano", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTabela);

        jlID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlID.setText("Venda de ID 10");

        jLabel1.setText("Total:");

        jtTotal.setEditable(false);

        jbConfirmar.setText("Confirmar Compra");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jbConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jlID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlID)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        // TODO add your handling code here:
        Venda v = new Venda();
        v.setDiscos(listaDiscos);
        v.setValorTotal(Double.parseDouble(jtTotal.getText()));
        try {
            vendaController.criarVenda(v);
        } catch (Exception ex) {
            Logger.getLogger(DetalhesCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
         JOptionPane.showMessageDialog(null,"Cadastro feito com sucesso!");
         this.dispose();
    }//GEN-LAST:event_jbConfirmarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JLabel jlID;
    private javax.swing.JTable jtTabela;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables
}
