/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencial.db.bancodehoras.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import residencial.db.bancodehoras.dao.BancoDeHoras;
import residencial.db.util.Utilitarios;

/**
 *
 * @author Marcos Paulo
 */
public class CadHoraExtra extends JInternalFrame {
    
    BancoDeHoras banco = new BancoDeHoras();
    Utilitarios util = new Utilitarios();
    boolean click = false;

    public CadHoraExtra() {
        initComponents();
        util.preecheComboMonitora(cbMonitoras);
        banco.listarDados(tbDados);
        JTableHeader header = new JTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 16));
        header.setBackground(new Color(102, 0, 180));
        header.setForeground(Color.white);
        btSalvar.setBackground(new Color(0, 0, 0, 0));
        btApagar.setBackground(new Color(0, 0, 0, 0));
        btApagar.setEnabled(false);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tbDados = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbMonitoras = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfHoraEntrada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfHoraSaida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taJustificativa = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        tfQtdeHoras = new javax.swing.JTextField();
        dpData = new org.jdesktop.swingx.JXDatePicker();
        btApagar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbDados.setAutoCreateRowSorter(true);
        tbDados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        tbDados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Monitora", "Tipo", "Hora Saída", "Hora Entrada", "Qtda Horas", "Justificativa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDados.setGridColor(new java.awt.Color(255, 255, 255));
        tbDados.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbDados.setRowHeight(30);
        tbDados.setSelectionBackground(new java.awt.Color(102, 0, 180));
        tbDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbDadosMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tbDados);
        if (tbDados.getColumnModel().getColumnCount() > 0) {
            tbDados.getColumnModel().getColumn(0).setMinWidth(70);
            tbDados.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbDados.getColumnModel().getColumn(0).setMaxWidth(70);
            tbDados.getColumnModel().getColumn(1).setMinWidth(90);
            tbDados.getColumnModel().getColumn(1).setPreferredWidth(90);
            tbDados.getColumnModel().getColumn(1).setMaxWidth(90);
            tbDados.getColumnModel().getColumn(2).setMinWidth(150);
            tbDados.getColumnModel().getColumn(2).setPreferredWidth(150);
            tbDados.getColumnModel().getColumn(2).setMaxWidth(150);
            tbDados.getColumnModel().getColumn(3).setMinWidth(50);
            tbDados.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbDados.getColumnModel().getColumn(3).setMaxWidth(50);
            tbDados.getColumnModel().getColumn(4).setMinWidth(90);
            tbDados.getColumnModel().getColumn(4).setPreferredWidth(90);
            tbDados.getColumnModel().getColumn(4).setMaxWidth(90);
            tbDados.getColumnModel().getColumn(5).setMinWidth(90);
            tbDados.getColumnModel().getColumn(5).setPreferredWidth(90);
            tbDados.getColumnModel().getColumn(5).setMaxWidth(90);
            tbDados.getColumnModel().getColumn(6).setMinWidth(90);
            tbDados.getColumnModel().getColumn(6).setPreferredWidth(90);
            tbDados.getColumnModel().getColumn(6).setMaxWidth(90);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 793;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(102, 0, 180));
        jPanel5.setPreferredSize(new java.awt.Dimension(354, 380));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Monitoras:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel5.add(jLabel7, gridBagConstraints);

        cbMonitoras.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbMonitoras.setPreferredSize(new java.awt.Dimension(150, 20));
        cbMonitoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonitorasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 182;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel5.add(cbMonitoras, gridBagConstraints);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel5.add(jLabel1, gridBagConstraints);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel5.add(jLabel2, gridBagConstraints);

        cbTipo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Tipo", "Crédito", "Débito" }));
        cbTipo.setPreferredSize(new java.awt.Dimension(150, 20));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 182;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel5.add(cbTipo, gridBagConstraints);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hora Entrada:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel5.add(jLabel3, gridBagConstraints);

        tfHoraEntrada.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tfHoraEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfHoraEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfHoraEntradaFocusLost(evt);
            }
        });
        tfHoraEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfHoraEntradaKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel5.add(tfHoraEntrada, gridBagConstraints);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hora Saída:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel5.add(jLabel4, gridBagConstraints);

        tfHoraSaida.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tfHoraSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfHoraSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfHoraSaidaFocusLost(evt);
            }
        });
        tfHoraSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfHoraSaidaKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel5.add(tfHoraSaida, gridBagConstraints);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Justificativa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel5.add(jLabel5, gridBagConstraints);

        btSalvar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/residencial/db/images/salvar.png"))); // NOI18N
        btSalvar.setBorder(null);
        btSalvar.setBorderPainted(false);
        btSalvar.setOpaque(false);
        btSalvar.setPreferredSize(new java.awt.Dimension(125, 50));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 10, 0);
        jPanel5.add(btSalvar, gridBagConstraints);

        taJustificativa.setColumns(10);
        taJustificativa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        taJustificativa.setRows(5);
        jScrollPane1.setViewportView(taJustificativa);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 548;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 0);
        jPanel5.add(jScrollPane1, gridBagConstraints);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Qtde Horas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel5.add(jLabel6, gridBagConstraints);

        tfQtdeHoras.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tfQtdeHoras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfQtdeHoras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfQtdeHorasFocusLost(evt);
            }
        });
        tfQtdeHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQtdeHorasKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel5.add(tfQtdeHoras, gridBagConstraints);

        dpData.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dpData.setFormats("dd/MM/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        jPanel5.add(dpData, gridBagConstraints);

        btApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/residencial/db/images/apagar.png"))); // NOI18N
        btApagar.setBorder(null);
        btApagar.setBorderPainted(false);
        btApagar.setPreferredSize(new java.awt.Dimension(125, 50));
        btApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApagarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 10, 0);
        jPanel5.add(btApagar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 93;
        gridBagConstraints.ipady = 95;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel5, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 180));
        jLabel8.setText("Cadastro de Horas Extras");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 50, 20, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        /*if(cbTipo.getSelectedItem()=="Crédito"){
            tfHoraEntrada.setEditable(true);
            tfHoraEntrada.requestFocus(true);
            tfHoraSaida.setEditable(false);
            tfHoraSaida.setText("");
        }else{
            tfHoraSaida.setEditable(true);
            tfHoraSaida.requestFocus(true);
            tfHoraEntrada.setEditable(false);
            tfHoraEntrada.setText("");
        }*/
    }//GEN-LAST:event_cbTipoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (cbMonitoras.getSelectedItem().equals("Selecione uma Monitora")) {
            JOptionPane.showMessageDialog(null, "Selecione a Monitora");
            
        } else if (cbTipo.getSelectedItem().equals("Selecione o Tipo")) {
            JOptionPane.showMessageDialog(null, "Selecione o Tipo");
            
        } else if (tfQtdeHoras.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite a Quantidade de Horas");
            tfQtdeHoras.requestFocus(true);
            
        } else if (String.valueOf(dpData.getDate()).equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a Data");
            dpData.requestFocus(true);
            
        } else if (taJustificativa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite uma justificativa");
            taJustificativa.requestFocus(true);
        } else {
            insert_update();
        }        
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfHoraEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHoraEntradaKeyReleased
        formataHora(tfHoraEntrada, evt);
        if (tfHoraEntrada.getText().length() == 5) {
            tfHoraSaida.requestFocus(true);
        }
    }//GEN-LAST:event_tfHoraEntradaKeyReleased

    private void tfHoraSaidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHoraSaidaKeyReleased
        formataHora(tfHoraSaida, evt);
        if (tfHoraSaida.getText().length() == 5) {
            tfQtdeHoras.requestFocus(true);
        }
    }//GEN-LAST:event_tfHoraSaidaKeyReleased

    private void tfHoraSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfHoraSaidaFocusLost
        if (!tfHoraSaida.getText().isEmpty() && !validaHora(tfHoraSaida.getText())) {
            JOptionPane.showMessageDialog(null, "Hora Inválida");
            tfHoraSaida.setText("");
            tfHoraSaida.requestFocus(true);
        }
    }//GEN-LAST:event_tfHoraSaidaFocusLost

    private void tfQtdeHorasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtdeHorasKeyReleased
        formataHora(tfQtdeHoras, evt);
        if (tfQtdeHoras.getText().length() == 5) {
            dpData.requestFocus(true);
        }
    }//GEN-LAST:event_tfQtdeHorasKeyReleased

    private void tfHoraEntradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfHoraEntradaFocusLost
        if (!tfHoraEntrada.getText().isEmpty() && !validaHora(tfHoraEntrada.getText())) {
            JOptionPane.showMessageDialog(null, "Hora Inválida");
            tfHoraEntrada.setText("");
            tfHoraEntrada.requestFocus(true);
        }
    }//GEN-LAST:event_tfHoraEntradaFocusLost

    private void tfQtdeHorasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQtdeHorasFocusLost
        if (!tfQtdeHoras.getText().isEmpty() && !validaHora(tfQtdeHoras.getText())) {
            JOptionPane.showMessageDialog(null, "Hora Inválida");
            tfQtdeHoras.setText("");
            tfQtdeHoras.requestFocus(true);
        }
    }//GEN-LAST:event_tfQtdeHorasFocusLost

    private void tbDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDadosMouseClicked
        int linha = tbDados.getSelectedRow();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if (evt.getClickCount() == 1) {
            click = true;
            btApagar.setEnabled(true);
            banco.setBancoId(Integer.parseInt(tbDados.getValueAt(linha, 0).toString()));
            banco.setNomeMonitora(tbDados.getValueAt(linha, 2).toString());
            try {
                dpData.setDate(df.parse(tbDados.getValueAt(linha, 1).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(CadHoraExtra.class.getName()).log(Level.SEVERE, null, ex);
            }
            cbMonitoras.setSelectedItem(tbDados.getValueAt(linha, 2).toString());
            cbTipo.setSelectedItem(tbDados.getValueAt(linha, 3).toString());
            tfHoraEntrada.setText(tbDados.getValueAt(linha, 4).toString());
            tfHoraSaida.setText(tbDados.getValueAt(linha, 5).toString());
            tfQtdeHoras.setText(tbDados.getValueAt(linha, 6).toString());
            taJustificativa.setText(tbDados.getValueAt(linha, 7).toString());            
        }
    }//GEN-LAST:event_tbDadosMouseClicked

    private void cbMonitorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonitorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMonitorasActionPerformed

    private void tbDadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDadosMouseEntered
        
    }//GEN-LAST:event_tbDadosMouseEntered

    private void btApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApagarActionPerformed
        banco.delete();
        limparCampos();
    }//GEN-LAST:event_btApagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btApagar;
    private javax.swing.JButton btSalvar;
    public javax.swing.JComboBox<String> cbMonitoras;
    private javax.swing.JComboBox<String> cbTipo;
    private org.jdesktop.swingx.JXDatePicker dpData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taJustificativa;
    private javax.swing.JTable tbDados;
    private javax.swing.JTextField tfHoraEntrada;
    private javax.swing.JTextField tfHoraSaida;
    private javax.swing.JTextField tfQtdeHoras;
    // End of variables declaration//GEN-END:variables

    public void formataHora(JTextField tfHora, java.awt.event.KeyEvent evt) {
        char[] c = tfHora.getText().toCharArray();
        for (int i = 0; i < c.length; i++) {
            // verifica se o char não é um dígito
            if (Character.isDigit(c[i]) || c[i] == ':') {
                
                if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
                    String formata = tfHora.getText();
                    if (formata.length() == 2) {
                        formata = formata + ":";
                        tfHora.setText(formata);
                    }
                    
                    while (formata.length() > 5) {
                        formata = formata.substring(0, formata.length() - 1);
                        tfHora.setText(formata);
                    }
                }
                
            } else {
                tfHora.setText(tfHora.getText().substring(0, tfHora.getText().length() - 1));
                break;
            }
        }
    }
    
    public boolean validaHora(String hora) {
        boolean result = false;
        int h, m;
        if (hora.length() == 5) {
            String[] hm = hora.split(":");
            h = Integer.parseInt(hm[0]);
            m = Integer.parseInt(hm[1]);
            if (h <= 23 && m <= 59) {                
                result = true;
            }
        }
        return result;
    }
    
    public void insert_update() {
        String[] id = cbMonitoras.getSelectedItem().toString().split("-");
        banco.setMonitoraId(Integer.parseInt(id[0]));        
        banco.setData(util.converteData(new SimpleDateFormat("dd/MM/yyyy").format(dpData.getDate())));
        banco.setTipo((String) cbTipo.getSelectedItem());
        banco.setJustificativa(taJustificativa.getText());
        banco.setQtdeHoraExtra(tfQtdeHoras.getText());
        banco.setHoraSaida(tfHoraEntrada.getText());
        banco.setHoraEntrada(tfHoraSaida.getText());
        
        if (click) {
            banco.update();
        } else {
            banco.insert();
        }
        banco.listarDados(tbDados);
        
        limparCampos();
        
    }    
    
    public void limparCampos() {
        banco.listarDados(tbDados);
        util.preecheComboMonitora(cbMonitoras);
        cbMonitoras.setSelectedIndex(0);
        dpData.cancelEdit();
        cbTipo.setSelectedIndex(0);
        taJustificativa.setText("");
        tfQtdeHoras.setText("");
        tfHoraEntrada.setText("");
        tfHoraSaida.setText("");
        btApagar.setEnabled(false);
        click = false;
    }
    
}
