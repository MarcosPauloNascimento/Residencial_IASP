package residencial.db.bancodehoras.dao;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import residencial.db.conexao.Conexao;

public class BancoDeHoras {
    
    Conexao conBanco = new Conexao();
    Connection conn;
    
    private int bancoId;
    private int monitoraId;
    private String data;
    private String tipo;
    private String justificativa;
    private String nomeMonitora;
    private String horaSaida;
    private String horaEntrada;
    private String qtdeHoraExtra;
    
    public int getBancoId() {
        return bancoId;
    }
    
    public void setBancoId(int bancoId) {
        this.bancoId = bancoId;
    }
    
    public int getMonitoraId() {
        return monitoraId;
    }
    
    public void setMonitoraId(int monitoraId) {
        this.monitoraId = monitoraId;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getTipo() {
        return tipo;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeMonitora() {
        return nomeMonitora;
    }

    public void setNomeMonitora(String nomeMonitora) {
        this.nomeMonitora = nomeMonitora;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    
    public String getQtdeHoraExtra() {
        return qtdeHoraExtra;
    }

    public void setQtdeHoraExtra(String qtdeHoraExtra) {
        this.qtdeHoraExtra = qtdeHoraExtra;
    }
    
    public void insert(){
        
        try{
            conn = conBanco.abrir();            
            codAutomatico();
            
            String insert = "INSERT INTO BANCO VALUES ("+getBancoId()+","
                    + "'"+getData()+"',"
                    + "'"+getTipo()+"',"
                    + "'"+getHoraEntrada()+"',"
                    + "'"+getHoraSaida()+"',"
                    + "'"+getQtdeHoraExtra()+"',"
                    + "'"+getJustificativa()+"',"
                    + ""+getMonitoraId()+")";
            
                    PreparedStatement stmt = (PreparedStatement)conn.prepareStatement(insert);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso");
       
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null, "ERRO AO TENTAR INSERIR OS DADOS" +erro);
            erro.printStackTrace();
        }finally{
            conBanco.fechar();
            
        }
    }
    
    public void update(){
        
        try{
            conn = conBanco.abrir();
            
            conBanco.executeSQL("SELECT * FROM BANCO");
            conBanco.statement.executeUpdate("UPDATE BANCO SET DATA = '" + getData() + "',"
                    + "TIPO = '" + getTipo() + "',"
                    + "HORAENTRADA = '" + getHoraEntrada() + "',"
                    + "HORASAIDA = '" + getHoraSaida() + "',"
                    + "QTDEHORAS = '" + getQtdeHoraExtra() + "',"
                    + "JUSTIFICATIVA = '" + getJustificativa() + "',"
                    + "MONITORAID = " + getMonitoraId() + " WHERE BANCOID = "+ getBancoId());
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
       
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null, "ERRO AO TENTAR ALTERAR OS DADOS" +erro);
            erro.printStackTrace();
        }finally{
            conBanco.fechar();
            
        }
    } 
    
    public List<String> listarMonitora(){
        
        List <String> list = new ArrayList<String>();
        try {
            conn = conBanco.abrir();
                conBanco.executeSQL("SELECT * FROM MONITORAS WHERE STATUS = 'Ativo' ORDER BY NOME");
             
            while (conBanco.result.next()) {
                list.add(conBanco.result.getString("MonitoraId")+"-"+conBanco.result.getString("Nome"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BancoDeHoras.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            conBanco.fechar();
        }

        return list;

    }

    
    public void listarDados(JTable tabela){
        DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
        modelo.setNumRows(0);
        String monitora;
        try{
            conn = conBanco.abrir();
            
            conBanco.executeSQL("SELECT * FROM BANCO b INNER JOIN MONITORAS m ON b.MONITORAID = m.MONITORAID "
                    + "WHERE m.STATUS = 'Ativo' ORDER BY b.DATA");
            
            while (conBanco.result.next()) {
                //monitora = 
                modelo.addRow(new Object[]{
                    
                    conBanco.result.getInt("BancoId"),
                    new SimpleDateFormat("dd/MM/yyyy").format(conBanco.result.getDate("Data")),
                    conBanco.result.getString("MonitoraId")+ "-" + conBanco.result.getString("Nome"),
                    conBanco.result.getString("Tipo"),
                    conBanco.result.getString("HoraSaida"),
                    conBanco.result.getString("HoraEntrada"),
                    conBanco.result.getString("QtdeHoras"),
                    conBanco.result.getString("Justificativa")
                });
            }
        }catch(SQLException ex){
            Logger.getLogger(BancoDeHoras.class.getName()).log(Level.SEVERE,"Erro ao Listar os Dados Cadastrados", ex);
        }finally{
            conBanco.fechar();
        }               
    }
    
    public void listarDadosPorMonitora(JTable tabela, JLabel lbHoraExtra, JLabel lbStatus) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        boolean minutoNegativo = false;
        String horaString = "", minutoString = "";
        int horaExtra = 0,
                minutosExtras = 0,
                modMinutos = 0,
                minutosCredito = 0,
                minutosDebito = 0,
                horaAux = 0,
                minutoAux = 0;
        try {
            conn = conBanco.abrir();

            conBanco.executeSQL("SELECT * FROM BANCO b INNER JOIN MONITORAS m ON b.MONITORAID = m.MONITORAID "
                    + "WHERE m.STATUS = 'Ativo' AND b.MONITORAID = " + getMonitoraId() + " ORDER BY b.DATA");

            while (conBanco.result.next()) {
                //monitora = 
                modelo.addRow(new Object[]{
                    new SimpleDateFormat("dd/MM/yyyy").format(conBanco.result.getDate("Data")),
                    conBanco.result.getString("MonitoraId") + "-" + conBanco.result.getString("Nome"),
                    conBanco.result.getString("Tipo"),
                    conBanco.result.getString("HoraSaida"),
                    conBanco.result.getString("HoraEntrada"),
                    conBanco.result.getString("QtdeHoras"),
                    conBanco.result.getString("Justificativa")
                });

                horaString = conBanco.result.getString("QtdeHoras").substring(0, 2);
                minutoString = conBanco.result.getString("QtdeHoras").substring(3, 5);

                if (conBanco.result.getString("Tipo").equals("Crédito")) {
                    horaAux = Integer.parseInt(horaString);
                    minutoAux = Integer.parseInt(minutoString);
                    minutosCredito += (horaAux * 60) + minutoAux;
                } else {
                    horaAux = Integer.parseInt(horaString);
                    minutoAux = Integer.parseInt(minutoString);
                    minutosDebito += (horaAux * 60) + minutoAux;
                }

            }

            minutosExtras = minutosCredito - minutosDebito;
            if (minutosExtras < 0) {
                minutosExtras = minutosExtras * -1;
                minutoNegativo = true;
            }
            modMinutos = minutosExtras % 60;
            horaExtra = (minutosExtras - modMinutos) / 60;

            horaString = String.valueOf(horaExtra);
            minutoString = String.valueOf(modMinutos);

            if (horaExtra >= 0 && horaExtra < 10) {
                horaString = "0" + horaString;
            }

            if (modMinutos >= 0 && modMinutos < 10) {
                minutoString = "0" + modMinutos;
            }

            if (minutoNegativo) {
                lbHoraExtra.setForeground(Color.red);
                lbStatus.setText("DÉBITO");
                lbStatus.setForeground(Color.red);
            } else {
                lbHoraExtra.setForeground(new Color(0, 153, 51));
                lbStatus.setText("CRÉDITO");
                lbStatus.setForeground(new Color(0, 153, 51));
            }

            lbHoraExtra.setText(horaString + "hs e " + minutoString + "min");
            //lbHoraExtra.setText(horaString + ":" + minutoString);

        } catch (SQLException ex) {
            Logger.getLogger(BancoDeHoras.class.getName()).log(Level.SEVERE, "Erro ao Listar os Dados Cadastrados", ex);
        } finally {
            conBanco.fechar();
        }
    }
    
    public void codAutomatico(){
        
        try
        {
            conBanco.executeSQL("SELECT MAX(BancoId) FROM BANCO");
            conBanco.result.first();
            int codigo = conBanco.result.getInt(1);
            setBancoId(codigo+1);
        }
        catch(Exception erro)
        {
            int nro = 1;
            setBancoId(nro);
                            
        }
       
    }
}
