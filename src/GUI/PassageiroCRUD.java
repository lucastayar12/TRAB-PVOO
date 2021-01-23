/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAOS.DAOPassageiro;
import JBIN.Passageiro;
import java.time.LocalDate;
import TMS.TableModelPassageiro;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Lucas
 */
public class PassageiroCRUD extends javax.swing.JFrame {

    TableModelPassageiro tableModelPassageiro;
    DAOPassageiro daoPassageiro = new DAOPassageiro();

    /**
     * Creates new form PassageiroDAO
     */
    public PassageiroCRUD() {
        initComponents();
        setLocationRelativeTo(null);
        this.tableModelPassageiro = new TableModelPassageiro();
        this.jTable1.setModel(tableModelPassageiro);

        List<Passageiro> passageiros = daoPassageiro.lista();
        for (Passageiro p : passageiros) {
            this.tableModelPassageiro.add(p);
        }
        
        MaskFormatter mascaraData = null;
        MaskFormatter mascaraCPF = null;
        LocalDate datas = LocalDate.now();

        try {
            mascaraCPF = new  MaskFormatter("###.###.###-##");
            mascaraData = new MaskFormatter("##/##/####");
            mascaraCPF.setPlaceholderCharacter('_');
            mascaraData.setPlaceholderCharacter('_');
        } catch (ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        
        this.cpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
        this.dat_Nasc.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
        

        this.dat_Nasc.setText(String.valueOf(datas.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dat_Nasc = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();
        limpa = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        javax.swing.JButton excluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        senha = new javax.swing.JPasswordField();
        cpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Passageiro CRUD");
        setLocationByPlatform(true);

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        jLabel1.setLabelFor(nome);
        jLabel1.setText("Nome:");

        jLabel2.setLabelFor(cod);
        jLabel2.setText("Código:");

        dat_Nasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        dat_Nasc.setFocusCycleRoot(true);
        dat_Nasc.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        dat_Nasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dat_NascActionPerformed(evt);
            }
        });

        jLabel3.setLabelFor(dat_Nasc);
        jLabel3.setText("Data de Nascimento:");

        jLabel4.setLabelFor(cpf);
        jLabel4.setText("CPF:");

        jLabel5.setLabelFor(senha);
        jLabel5.setText("Senha:");

        salvar.setText("Salvar");
        salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salvarMouseClicked(evt);
            }
        });

        limpa.setText("Limpar");
        limpa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limpaMouseClicked(evt);
            }
        });

        alterar.setText("Alterar");
        alterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alterarMouseClicked(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                excluirMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        senha.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 686, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(dat_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(210, 210, 210))
                                    .addComponent(cpf)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(limpa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cod))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(nome))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dat_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void salvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salvarMouseClicked
        // TODO add your handling code here:
        Passageiro p = new Passageiro();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        p.setDocumento(cpf.getText());
        p.setNome(nome.getText());
        p.setNascimento(LocalDate.parse(dat_Nasc.getText(),df));
        p.setSenha( new String(senha.getPassword()));
        int id = daoPassageiro.adiciona(p);
        List<Passageiro> passageiros = daoPassageiro.lista();

        for (Passageiro ps : passageiros) {
            if (id == ps.getId()) {
                this.tableModelPassageiro.add(ps);
            }
        }
    }//GEN-LAST:event_salvarMouseClicked

    private void dat_NascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dat_NascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dat_NascActionPerformed

    private void limpaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpaMouseClicked
        // TODO add your handling code here

        nome.setText("");
        senha.setText("");
        cpf.setText("");
        cod.setText("");
        dat_Nasc.setText("");

    }//GEN-LAST:event_limpaMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int linha = this.jTable1.getSelectedRow();
        Passageiro pTemp = this.tableModelPassageiro.get(linha);
        this.cod.setText(String.valueOf(pTemp.getId()));
        this.nome.setText(pTemp.getNome());
        this.cpf.setText(pTemp.getDocumento());
        this.dat_Nasc.setText(String.valueOf(pTemp.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        String passText = new String(pTemp.getSenha());
        this.senha.setText(passText);
    }//GEN-LAST:event_jTable1MouseClicked

    private void excluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excluirMouseClicked
        // TODO add your handling code here:
        Passageiro p = new Passageiro();
        p.setId(Long.parseLong(cod.getText()));
        daoPassageiro.exclui(p);
        for (int i = 0; i < tableModelPassageiro.getRowCount(); i++) {
            if (tableModelPassageiro.get(i).getId() == p.getId()) {
                tableModelPassageiro.remove(i);
            }
        }
    }//GEN-LAST:event_excluirMouseClicked

    private void alterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alterarMouseClicked
        // TODO add your handling code here:
        Passageiro p = new Passageiro();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        p.setId(Long.valueOf(cod.getText()));
        p.setDocumento(cpf.getText());
        p.setNome(nome.getText());
        p.setNascimento(LocalDate.parse(dat_Nasc.getText(), df));
        p.setSenha(new String(senha.getPassword()));
        Long id = daoPassageiro.altera(p);
        
        List<Passageiro> passageiros = daoPassageiro.lista();
        for (Passageiro ps : passageiros) {
            if (id == ps.getId()) {
                this.tableModelPassageiro.edita(ps);
            }
        }

    }//GEN-LAST:event_alterarMouseClicked

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
            java.util.logging.Logger.getLogger(PassageiroCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassageiroCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassageiroCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassageiroCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassageiroCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JTextField cod;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField dat_Nasc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limpa;
    private javax.swing.JTextField nome;
    private javax.swing.JButton salvar;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}
