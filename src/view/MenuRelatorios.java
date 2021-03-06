/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControleRelatorios;
import dao.MovimentosDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import model.Movimentos;
import model.Pessoa;
import model.Util;

/**
 *
 * @author robso
 */
public class MenuRelatorios extends javax.swing.JDialog {

    Pessoa usuario = null;
    List<Movimentos> extrato;

    /**
     * Creates new form MenuRelatorios
     */
    public MenuRelatorios(java.awt.Frame parent, boolean modal, Pessoa usuario) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        this.usuario = usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new niceswing.JTextField.JTextField();
        dfDataInicialExtrato = new niceswing.JDateField.JDateField();
        jTextField2 = new niceswing.JTextField.JTextField();
        dfDataFinalExtrato = new niceswing.JDateField.JDateField();
        btPesquisarExtrato = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbExtrato = new javax.swing.JTable();
        btImprimir = new niceswing.JButton.JButton();
        jPanel2 = new javax.swing.JPanel();
        vfEntrada = new niceswing.JValueField.JValueField();
        vfSaida = new niceswing.JValueField.JValueField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.setText("Data Inicial");

        jTextField2.setText("Data Final");

        btPesquisarExtrato.setText("Pesquisar");
        btPesquisarExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarExtratoActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbExtrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbExtrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbExtratoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbExtrato);

        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        vfEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vfEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vfEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vfSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vfEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vfSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dfDataInicialExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dfDataFinalExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btPesquisarExtrato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                        .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btPesquisarExtrato)
                        .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dfDataFinalExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dfDataInicialExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 469, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(59, 59, 59)))
        );

        jTabbedPane1.addTab("Extrato", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        // TODO add your handling code here:
        Map parametros = new HashMap();
        parametros.put("DataIni", dfDataInicialExtrato.getDate());
        parametros.put("DataFin", dfDataFinalExtrato.getDate());

        ControleRelatorios controle = new ControleRelatorios();
        controle.imprimirRelatorio(this, extrato, "Extrato", parametros);
    }//GEN-LAST:event_btImprimirActionPerformed

    private void tbExtratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbExtratoMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 3) {
            Util.larguraColunas(tbExtrato);
        }
    }//GEN-LAST:event_tbExtratoMouseClicked

    private void btPesquisarExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarExtratoActionPerformed
        // TODO add your handling code here:
        carregarExtrato();
    }//GEN-LAST:event_btPesquisarExtratoActionPerformed

    private void vfEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vfEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vfEntradaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuRelatorios dialog = new MenuRelatorios(new javax.swing.JFrame(), true, null);
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
    private niceswing.JButton.JButton btImprimir;
    private javax.swing.JButton btPesquisarExtrato;
    private niceswing.JDateField.JDateField dfDataFinalExtrato;
    private niceswing.JDateField.JDateField dfDataInicialExtrato;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private niceswing.JTextField.JTextField jTextField1;
    private niceswing.JTextField.JTextField jTextField2;
    private javax.swing.JTable tbExtrato;
    private niceswing.JValueField.JValueField vfEntrada;
    private niceswing.JValueField.JValueField vfSaida;
    // End of variables declaration//GEN-END:variables

    public void carregarExtrato() {
        String condicao = " where 1=1 "
                + " and m.id_usuario = " + this.usuario.id
                + " and m.data between '" + Util.dataFormatoSql(dfDataInicialExtrato.getText()) + "'"
                + " and "
                + "'" + Util.dataFormatoSql(dfDataFinalExtrato.getText()) + "'"
                + " order by data ";
        MovimentosDao mDao = new MovimentosDao();

        extrato = mDao.listar(condicao);

        String[] colunas = new String[]{
            "Data", "Pessoa", "Obs", "Entrada", "Saida", "Saldo"
        };
        this.tbExtrato.setModel(new DefaultTableModel(colunas, 0) {
            Class[] types = new Class[]{String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        DefaultTableModel dtm = (DefaultTableModel) tbExtrato.getModel();

        int linha = this.tbExtrato.getRowCount();
        for (int c = 0; c < linha; c++) {
            dtm.removeRow(0);
        }

        //Saldo Anterior
        Double sd = mDao.saldo(usuario.id, Util.dataFormatoSql(dfDataInicialExtrato.getText()));
//        Object[] d = new Object[6];
        Movimentos s = new Movimentos();
        s.data = "Saldo";
        s.nome_pessoa = "Anterior";
        s.obs = "";
        s.tipo = "";
        s.saldo = sd;

//        dtm.addRow(d);
        Double ultimo_valor = sd;
        Double totalEntrada = 0.0;
        Double totalSaida = 0.0;
        for (Movimentos m : extrato) {
//            totalEntrada += m.valor;
//            totalSaida += m.valor;
            totalEntrada += m.tipo.equals("C") ? m.valor : 0.0;
            totalSaida += m.tipo.equals("D") ? m.valor : 0.0;
//            Object[] dado = new Object[6];
//            dado[0] = m.data;
//            dado[1] = m.nome_pessoa;
//            dado[2] = m.obs;
//
//            //sem operador ternario;;;
//            if (m.tipo.equals("C")) {
//                dado[3] = m.valorFormatado();
//            } else {
//                dado[3] = "";
//            }
//            // operador ternario ;;;;
//            dado[4] = m.tipo.equals("D") ? m.valorFormatado() : "";
            Double saldo = m.tipo.equals("C") ? ultimo_valor + m.valor : ultimo_valor - m.valor;
//            dado[5] = Util.convertDoubleEmString_Valor(saldo);
            m.saldo = saldo;
            ultimo_valor = saldo;

//            dtm.addRow(dado);
        }

        vfEntrada.setDoubleValue(totalEntrada);
        vfSaida.setDoubleValue(totalSaida);
        
        extrato.add(0, s);

        for (Movimentos m : extrato) {

            Object[] dado = new Object[6];

            dado[0] = m.data;

            dado[1] = m.nome_pessoa;

            dado[2] = m.obs;

            dado[3] = m.tipo.equals("C") ? m.valorFormatado() : "";

            dado[4] = m.tipo.equals("D") ? m.valorFormatado() : "";

            dado[5] = Util.convertDoubleEmString_Valor(m.saldo);

            dtm.addRow(dado);

        }
        

        tbExtrato.getColumnModel().getColumn(0).setPreferredWidth(205);
        tbExtrato.getColumnModel().getColumn(1).setPreferredWidth(291);
        tbExtrato.getColumnModel().getColumn(2).setPreferredWidth(563);
        tbExtrato.getColumnModel().getColumn(3).setPreferredWidth(218);
        tbExtrato.getColumnModel().getColumn(4).setPreferredWidth(218);
        tbExtrato.getColumnModel().getColumn(5).setPreferredWidth(220);

        tbExtrato.getColumnModel().getColumn(3).setCellRenderer(Util.alinhaDireita());
        tbExtrato.getColumnModel().getColumn(4).setCellRenderer(Util.alinhaDireita());
        tbExtrato.getColumnModel().getColumn(5).setCellRenderer(Util.alinhaDireita());

    }

}
