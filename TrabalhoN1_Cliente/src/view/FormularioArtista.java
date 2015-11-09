/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ArtistaController;
import controller.DiscoController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Artista;

/**
 *
 * @author Lucas
 */
public class FormularioArtista extends javax.swing.JFrame {

    ArtistaController artistaController = new ArtistaController();
    FormularioDisco fd;
    
    public FormularioArtista(FormularioDisco fd1) {
        initComponents();
         this.setLocationRelativeTo(null);
         fd = fd1;
        jlId.setVisible(false);
        jtId.setVisible(false);
    }

    public FormularioArtista(Artista a, FormularioDisco fd1) {
        initComponents();
        this.setLocationRelativeTo(null);
         fd = fd1;
        jbSalvar.setText("Atualizar");
        carregarCampos(a);
    }
  
    private void carregarCampos(Artista a) {
        jtId.setText(a.getId()+"");
        jtId.setEnabled(false);
        jtNome.setText(a.getNome());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jtId = new javax.swing.JTextField();
        jlId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Artista");

        jLabel2.setText("Nome:");

        jbSalvar.setText("Gravar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jlId.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlId)
                                .addGap(18, 18, 18)
                                .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jbSalvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            Artista a = new Artista(
                    jtNome.getText());
            
            if(jbSalvar.getText().equals("Atualizar")){
                a.setId(Integer.parseInt(jtId.getText()));
                artistaController.editarArtista(a);
            }else{
                artistaController.criarArtista(a);
            }
            
            fd.carregarArtistas();
            JOptionPane.showMessageDialog(null, ((jbSalvar.getText().equals("Atualizar")) ? "Atualização" : "Cadastro") + " feito com sucesso!");
            this.dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlId;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNome;
    // End of variables declaration//GEN-END:variables
}
