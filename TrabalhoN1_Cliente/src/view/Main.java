/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DiscoController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Artista;
import model.Disco;
import model.Discos;

/**
 *
 * @author Lucas
 */
public class Main extends javax.swing.JFrame {

  
   DefaultTableModel dtm;
   DiscoController discoController = new DiscoController();
   
    public Main() {
        initComponents();
          this.setLocationRelativeTo(null);
        dtm = (DefaultTableModel) jtTabela.getModel();
         carregaTodosDiscos();
    }

   public void carregaTodosDiscos() {
        try {
            List<Disco> listaDisco = discoController.trazerDiscos().getDiscos();
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
            }
        } catch (Exception e) {
            
        }
    }
     
   
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbCadastrar = new javax.swing.JButton();
        jbDeletar = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbBusca = new javax.swing.JComboBox();
        jtCampoBusca = new javax.swing.JTextField();
        jbBusca = new javax.swing.JButton();
        jbBuscaTodos = new javax.swing.JButton();
        jbHistorico = new javax.swing.JButton();
        jbComprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loja de Discos");

        jbCadastrar.setText("Cadastrar Novo Disco");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbDeletar.setText("Deletar");
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jbAtualizar.setText("Atualizar");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Procurar por");

        cbBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Artista", "Gênero", "Ano" }));

        jbBusca.setText("Procurar");
        jbBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaActionPerformed(evt);
            }
        });

        jbBuscaTodos.setText("Trazer Todos os Discos");
        jbBuscaTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaTodosActionPerformed(evt);
            }
        });

        jbHistorico.setText("Histórico de Compras");
        jbHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHistoricoActionPerformed(evt);
            }
        });

        jbComprar.setText("Comprar Discos Selecionado");
        jbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbComprar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jbCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbBuscaTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBusca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbBuscaTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAtualizar)
                    .addComponent(jbDeletar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        FormularioDisco fd = new FormularioDisco(this);
        fd.setVisible(true);
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        try {
            if (jtTabela.getSelectedRow() != -1) {
                discoController.deletarDisco(Integer.parseInt(dtm.getValueAt(jtTabela.getSelectedRow(), 0).toString()));
                JOptionPane.showMessageDialog(null, "Disco deletado com sucesso!");
                carregaTodosDiscos();
            } else {
                JOptionPane.showMessageDialog(null, "Escolha um disco para deletar!");
            }
        } catch (Exception e) {
           
        }
    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        try {
            if (jtTabela.getSelectedRow() != -1) {
                Disco d = new Disco();
                d.setId(Integer.parseInt(dtm.getValueAt(jtTabela.getSelectedRow(), 0).toString()));
                d = discoController.trazerDisco(d);
                FormularioDisco fd = new FormularioDisco(d,this);
                fd.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Escolha um Disco para atualizar!");
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jbAtualizarActionPerformed

    private void jbBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaActionPerformed
        try{
            Disco disco = new Disco();
            Discos discos = new Discos();
            Artista a = new Artista();
            int opcaoEscolhida = cbBusca.getSelectedIndex();
            switch (opcaoEscolhida){
                case 0:
                a.setNome(jtCampoBusca.getText());
                disco.setArtista(a);
                discos = discoController.buscarDiscoArtista(disco);
                break;
                case 1:
                disco.setGenero(jtCampoBusca.getText());
                discos= discoController.buscarDiscoGenero(disco);
                break;
                case 2:
                disco.setAno(Integer.parseInt(jtCampoBusca.getText()));
                discos= discoController.buscarDiscoAno(disco);
                break;
            }

            for (int j = dtm.getRowCount() - 1; j > -1; j--) {
                dtm.removeRow(j);
            }
            for (Disco d : discos.getDiscos()) {
                dtm.addRow(new String[]{
                    d.getId()+"",
                    d.getTitulo(),
                    d.getArtista().getNome(),
                    d.getGenero(),
                    d.getAno()+"",
                    d.getPreco()+""});
            }
        }
        catch (Exception e) {
            
        }
    }//GEN-LAST:event_jbBuscaActionPerformed

    private void jbBuscaTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaTodosActionPerformed
        carregaTodosDiscos();
    }//GEN-LAST:event_jbBuscaTodosActionPerformed

    private void jbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarActionPerformed

         if (jtTabela.getSelectedRow() != -1) {
        List<Integer> idsDiscos = new ArrayList<Integer>();
             
        for (int j = 0 ; j < dtm.getRowCount(); j++) {
                if(jtTabela.isRowSelected(j)){
                    idsDiscos.add(Integer.parseInt(dtm.getValueAt(j, 0).toString()));
                }
        }
        
        DetalhesCompra c = new DetalhesCompra(idsDiscos);
        c.setVisible(true);
         }else {
                JOptionPane.showMessageDialog(null, "Escolha um disco para comprar!");
            }
         
    }//GEN-LAST:event_jbComprarActionPerformed

    private void jbHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHistoricoActionPerformed
        HistoricoCompras hc = new HistoricoCompras();
        hc.setVisible(true);        
    }//GEN-LAST:event_jbHistoricoActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbBusca;
    private javax.swing.JButton jbBuscaTodos;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbComprar;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbHistorico;
    private javax.swing.JTextField jtCampoBusca;
    private javax.swing.JTable jtTabela;
    // End of variables declaration//GEN-END:variables

  
}
