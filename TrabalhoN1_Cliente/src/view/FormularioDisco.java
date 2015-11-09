/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ArtistaController;
import controller.DiscoController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Artista;
import model.Disco;

/**
 *
 * @author Lucas
 */
public class FormularioDisco extends javax.swing.JFrame {

    DefaultTableModel dtm;
    Main main;
    int idArtista = -1;
    DiscoController discoController = new DiscoController();
    ArtistaController artistaController = new ArtistaController();
     
    public FormularioDisco(Main main) {
        initComponents();
        this.setLocationRelativeTo(null);
        jlId.setVisible(false);
        jtId.setVisible(false);
        dtm = (DefaultTableModel) jtTabela.getModel();
        this.main = main;
        carregarArtistas();
    }
    
    public FormularioDisco(Disco d, Main main) {
        initComponents();
        this.setLocationRelativeTo(null);
        jbSalvar.setText("Atualizar");
        dtm = (DefaultTableModel) jtTabela.getModel();
        carregarCampos(d);
         this.main = main;
    }

    public void carregarCampos(Disco d) {
        jtId.setText(d.getId()+"");
        jtId.setEnabled(false);
        jtTitulo.setText(d.getTitulo());
        jtGenero.setText(d.getGenero());
        jtAno.setText(d.getAno()+"");
        jtPreco.setText(d.getPreco()+ "");
        idArtista  = d.getArtista().getId();
        carregarArtistas();
    }
    
    public void carregarArtistas(){
         try {
            List<Artista> listaArtista = artistaController.trazerArtistas().getArtistas();
            for (int j = dtm.getRowCount() - 1; j > -1; j--) {
                dtm.removeRow(j);
            }
            for (Artista a : listaArtista) {
                dtm.addRow(new String[]{
                    a.getId()+"",
                    a.getNome()});
                if(idArtista==a.getId()){
                    jtTabela.addRowSelectionInterval(dtm.getRowCount() - 1,dtm.getRowCount() - 1);  
                }
            }
            
          
            
        } catch (Exception e) {
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtTitulo = new javax.swing.JTextField();
        jtGenero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtAno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jbSalvar = new javax.swing.JButton();
        jtId = new javax.swing.JTextField();
        jlId = new javax.swing.JLabel();
        jbCadastrarArtista = new javax.swing.JButton();
        jbAtualizarArtista = new javax.swing.JButton();
        jbDeletarArtista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Discos");

        jLabel1.setText("Título:");

        jLabel2.setText("Gênero");

        jLabel3.setText("Ano:");

        jLabel4.setText("Preço:");

        jtTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Artista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTabela);
        if (jtTabela.getColumnModel().getColumnCount() > 0) {
            jtTabela.getColumnModel().getColumn(0).setMinWidth(0);
            jtTabela.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jbSalvar.setText("Gravar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jlId.setText("ID:");

        jbCadastrarArtista.setText("Cadastrar Artista");
        jbCadastrarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarArtistaActionPerformed(evt);
            }
        });

        jbAtualizarArtista.setText("Atualizar Artista");
        jbAtualizarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarArtistaActionPerformed(evt);
            }
        });

        jbDeletarArtista.setText("Deletar Artista");
        jbDeletarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarArtistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jlId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtId)
                            .addComponent(jtPreco)
                            .addComponent(jtAno)
                            .addComponent(jtGenero)
                            .addComponent(jtTitulo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbDeletarArtista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbAtualizarArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbCadastrarArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlId)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCadastrarArtista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAtualizarArtista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDeletarArtista))
                    .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            Artista artista = new Artista(Integer.parseInt(dtm.getValueAt(jtTabela.getSelectedRow(), 0).toString()),
                    dtm.getValueAt(jtTabela.getSelectedRow(), 1).toString());
            Disco d = new Disco(
                    jtTitulo.getText(),
                    artista,
                    jtGenero.getText(), 
                    Integer.parseInt(jtAno.getText()), 
                    Double.parseDouble(jtPreco.getText()));
            
            if(jbSalvar.getText().equals("Atualizar")){
                d.setId(Integer.parseInt(jtId.getText()));
                discoController.editarDisco(d);
            }else{
                discoController.criarDisco(d);
            }
            
            main.carregaTodosDiscos();
            JOptionPane.showMessageDialog(null, ((jbSalvar.getText().equals("Atualizar")) ? "Atualização" : "Cadastro") + " feito com sucesso!");
            this.dispose();
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Preencha todos os campos com valores aceitos");
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbCadastrarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarArtistaActionPerformed
       FormularioArtista fa = new FormularioArtista(this);
       fa.setVisible(true);
    }//GEN-LAST:event_jbCadastrarArtistaActionPerformed

    private void jbAtualizarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarArtistaActionPerformed
        try {
            if (jtTabela.getSelectedRow() != -1) {
                Artista a = new Artista();
                a.setId(Integer.parseInt(dtm.getValueAt(jtTabela.getSelectedRow(), 0).toString()));
                a = artistaController.trazerArtista(a);
                FormularioArtista fa = new FormularioArtista(a,this);
                fa.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Escolha um Artista para atualizar!");
            }
        } catch (Exception e) {
           
        }
    }//GEN-LAST:event_jbAtualizarArtistaActionPerformed

    private void jbDeletarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarArtistaActionPerformed
        try {
            if (jtTabela.getSelectedRow() != -1) {
                artistaController.deletarArtista(Integer.parseInt(dtm.getValueAt(jtTabela.getSelectedRow(), 0).toString()));
                JOptionPane.showMessageDialog(null, "Artista deletado com sucesso!");
                carregarArtistas();
            } else {
                JOptionPane.showMessageDialog(null, "Escolha um Artista para deletar!");
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jbDeletarArtistaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtualizarArtista;
    private javax.swing.JButton jbCadastrarArtista;
    private javax.swing.JButton jbDeletarArtista;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlId;
    private javax.swing.JTextField jtAno;
    private javax.swing.JTextField jtGenero;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtPreco;
    private javax.swing.JTable jtTabela;
    private javax.swing.JTextField jtTitulo;
    // End of variables declaration//GEN-END:variables
}
