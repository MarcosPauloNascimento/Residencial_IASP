/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencial.db.bancodehoras.view;

import residencial.db.util.Utilitarios;
import java.awt.Color;
import static java.awt.SystemColor.window;
import java.awt.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import residencial.db.bancodehoras.dao.BancoDeHoras;
import residencial.db.relatorios.RelHoraExtraMonitora;

/**
 *
 * @author Marcos Paulo
 */
public class MonitorHoraExtra extends JInternalFrame {

    DefaultTableModel modelo;
    Utilitarios util = new Utilitarios();
    BancoDeHoras banco = new BancoDeHoras();
    RelHoraExtraMonitora rel = new RelHoraExtraMonitora();
    boolean click = false, imprimeTodas = false, atualizar = false;
    String[] dadosMonitora;
    String nomeRelatorio;

    public MonitorHoraExtra() {
        initComponents();
        modelo = (DefaultTableModel) tbDados.getModel();
        modelo.setNumRows(0);
        lbStatus.setText("Selecione uma monitora");
        lbHoraExtra.setText("para calcular as horas extras.");
        util.preecheComboMonitora(cbMonitoras);
        btImprimir.setBackground(new Color(0, 0, 0, 0));
        btSelecionaDiretorio.setBackground(new Color(0, 0, 0, 0));
        tfDiretorio.setText(banco.selectSource());
        tfDiretorio.setToolTipText(tfDiretorio.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        cbMonitoras = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();
        panelStatus = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();
        lbHoraExtra = new javax.swing.JLabel();
        cbImprimirTodas = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        tfDiretorio = new javax.swing.JTextField();
        btSelecionaDiretorio = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(102, 0, 180));
        jPanel2.setMinimumSize(new java.awt.Dimension(743, 288));
        jPanel2.setPreferredSize(new java.awt.Dimension(354, 380));

        cbMonitoras.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbMonitoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMonitorasMouseClicked(evt);
            }
        });
        cbMonitoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonitorasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Monitora:");

        btImprimir.setBackground(new java.awt.Color(255, 255, 255));
        btImprimir.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/residencial/db/images/imprimir.png"))); // NOI18N
        btImprimir.setBorder(null);
        btImprimir.setBorderPainted(false);
        btImprimir.setPreferredSize(new java.awt.Dimension(155, 50));
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        panelStatus.setBackground(new java.awt.Color(102, 0, 180));
        panelStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        panelStatus.setLayout(new java.awt.GridLayout(2, 0, 0, 10));

        lbStatus.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 255, 255));
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatus.setText("Status:");
        panelStatus.add(lbStatus);

        lbHoraExtra.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbHoraExtra.setForeground(new java.awt.Color(255, 255, 255));
        lbHoraExtra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHoraExtra.setText("00:00");
        panelStatus.add(lbHoraExtra);

        cbImprimirTodas.setBackground(new java.awt.Color(102, 0, 180));
        cbImprimirTodas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbImprimirTodas.setForeground(new java.awt.Color(255, 255, 255));
        cbImprimirTodas.setText("Imprimir Todas");
        cbImprimirTodas.setIconTextGap(10);
        cbImprimirTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbImprimirTodasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Salvar o relatório em:");

        tfDiretorio.setEditable(false);
        tfDiretorio.setColumns(1);
        tfDiretorio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tfDiretorio.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        btSelecionaDiretorio.setBackground(new java.awt.Color(255, 255, 255));
        btSelecionaDiretorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/residencial/db/images/seleciona.png"))); // NOI18N
        btSelecionaDiretorio.setBorder(null);
        btSelecionaDiretorio.setBorderPainted(false);
        btSelecionaDiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionaDiretorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbImprimirTodas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(cbMonitoras, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tfDiretorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSelecionaDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(cbMonitoras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbImprimirTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btSelecionaDiretorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDiretorio))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 93;
        gridBagConstraints.ipady = 92;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel2, gridBagConstraints);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbDados.setAutoCreateRowSorter(true);
        tbDados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Monitora", "Tipo", "Hora Saída", "Hora Entrada", "Qtda Horas", "Justificativa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDados.setGridColor(new java.awt.Color(255, 255, 255));
        tbDados.setRowHeight(30);
        tbDados.setRowMargin(0);
        tbDados.setSelectionBackground(new java.awt.Color(102, 0, 180));
        tbDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDados);
        if (tbDados.getColumnModel().getColumnCount() > 0) {
            tbDados.getColumnModel().getColumn(0).setMinWidth(100);
            tbDados.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbDados.getColumnModel().getColumn(0).setMaxWidth(100);
            tbDados.getColumnModel().getColumn(1).setMinWidth(250);
            tbDados.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbDados.getColumnModel().getColumn(1).setMaxWidth(250);
            tbDados.getColumnModel().getColumn(2).setMinWidth(80);
            tbDados.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbDados.getColumnModel().getColumn(2).setMaxWidth(80);
            tbDados.getColumnModel().getColumn(3).setMinWidth(90);
            tbDados.getColumnModel().getColumn(3).setPreferredWidth(90);
            tbDados.getColumnModel().getColumn(3).setMaxWidth(90);
            tbDados.getColumnModel().getColumn(4).setMinWidth(90);
            tbDados.getColumnModel().getColumn(4).setPreferredWidth(90);
            tbDados.getColumnModel().getColumn(4).setMaxWidth(90);
            tbDados.getColumnModel().getColumn(5).setMinWidth(90);
            tbDados.getColumnModel().getColumn(5).setPreferredWidth(90);
            tbDados.getColumnModel().getColumn(5).setMaxWidth(90);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 977;
        gridBagConstraints.ipady = 260;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 180));
        jLabel2.setText("Calculadora de Horas Extras");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(50, 50, 20, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMonitorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonitorasActionPerformed
        if (atualizar) {
            util.preecheComboMonitora(cbMonitoras);
            atualizar = false;
        }
        if (!cbMonitoras.getSelectedItem().equals("Selecione uma Monitora")) {
            dadosMonitora = cbMonitoras.getSelectedItem().toString().split("-");
            banco.setMonitoraId(Integer.parseInt(dadosMonitora[0]));
            banco.listarDadosPorMonitora(tbDados, banco.getMonitoraId());
            nomeRelatorio = dadosMonitora[1] + "_" + util.getDateTime();

            if (tbDados.getRowCount() == 0) {
                lbHoraExtra.setForeground(Color.white);
                lbStatus.setForeground(Color.white);
                lbStatus.setText("A monitora selecionada");
                lbHoraExtra.setText("não tem horas extras cadastradas.");
            } else {
                lbHoraExtra.setText(banco.getTotalHoras());
                if (banco.getStatus().equals("Crédito")) {
                    lbHoraExtra.setForeground(new Color(0, 153, 51));
                    lbStatus.setText(banco.getStatus());
                    lbStatus.setForeground(new Color(0, 153, 51));
                } else {
                    lbHoraExtra.setForeground(Color.red);
                    lbStatus.setText(banco.getStatus());
                    lbStatus.setForeground(Color.red);
                }
            }

        } else {
            modelo.setNumRows(0);
            lbHoraExtra.setForeground(Color.white);
            lbStatus.setForeground(Color.white);
            lbStatus.setText("Selecione uma monitora");
            lbHoraExtra.setText("para calcular as horas extras.");
        }

        if (!cbMonitoras.getSelectedItem().equals("Selecione uma Monitora") && tbDados.getRowCount() == 0) {
            lbHoraExtra.setForeground(Color.white);
            lbStatus.setForeground(Color.white);
            lbStatus.setText("A monitora selecionada");
            lbHoraExtra.setText("não tem horas extras cadastradas.");
        }
    }//GEN-LAST:event_cbMonitorasActionPerformed

    private void tbDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDadosMouseClicked
        int linha = tbDados.getSelectedRow();
        if (evt.getClickCount() == 1) {
            click = true;
            String[] id = tbDados.getValueAt(linha, 1).toString().split("-");
            banco.setMonitoraId(Integer.parseInt(id[0]));
        }
    }//GEN-LAST:event_tbDadosMouseClicked

    private void cbMonitorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMonitorasMouseClicked

    }//GEN-LAST:event_cbMonitorasMouseClicked

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed

        if (!tfDiretorio.getText().isEmpty()) {
            //criamos um documento vazio
            File file = new File("C:/Residencial");
            file.mkdirs();
            if (tbDados.getRowCount() == 0 && !imprimeTodas) {
                JOptionPane.showMessageDialog(null, "Não existem dados para imprimir.");
            } else {
                try {
                    rel.imprime(tfDiretorio.getText().replace("\\", "\\"), imprimeTodas, nomeRelatorio, tbDados, banco.getMonitoraId());
//                Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "C://Residencial//" + nomeRelatorio + ".pdf"});
                    Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "" + tfDiretorio.getText().replace("\\", "\\") + "", "" + tfDiretorio.getText() + "\\" + nomeRelatorio + ".pdf"});

                } catch (IOException ex) {
                    Logger.getLogger(MonitorHoraExtra.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma pasta para salvar os relatórios");
        }


    }//GEN-LAST:event_btImprimirActionPerformed

    private void cbImprimirTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbImprimirTodasActionPerformed
        if (cbImprimirTodas.isSelected()) {
            cbMonitoras.setEnabled(false);
            nomeRelatorio = "Hora_Extra_Todas_Monitoras_" + util.getDateTime();
            imprimeTodas = true;
        } else {
            cbMonitoras.setEnabled(true);
            imprimeTodas = false;
        }
    }//GEN-LAST:event_cbImprimirTodasActionPerformed

    private void btSelecionaDiretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionaDiretorioActionPerformed
        JFileChooser fc = new JFileChooser();
        String dir = null;
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            dir = file.getAbsolutePath();

            banco.setDiretorio(dir.replace("\\","\\\\"));
            if (tfDiretorio.getText().isEmpty()) {
                banco.insertSource();
            } else {
                banco.updateSource();
            }
        }
        tfDiretorio.setText(dir);
    }//GEN-LAST:event_btSelecionaDiretorioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btSelecionaDiretorio;
    private javax.swing.JCheckBox cbImprimirTodas;
    public javax.swing.JComboBox<String> cbMonitoras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbHoraExtra;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JTable tbDados;
    private javax.swing.JTextField tfDiretorio;
    // End of variables declaration//GEN-END:variables

    public void limparCampos() {
        cbImprimirTodas.setSelected(false);
        cbMonitoras.setEnabled(true);
        atualizar = true;
        cbMonitoras.setSelectedIndex(0);
        modelo.setNumRows(0);
        lbStatus.setText("Selecione uma monitora");
        lbHoraExtra.setText("para calcular as horas extras.");
        click = false;
    }
}
