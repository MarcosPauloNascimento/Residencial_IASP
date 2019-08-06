package residencial.db.bancodehoras.dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
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

    int minDebito = 0, minCredito = 0;
    String horaString = "", minutoString = "";
    public static List<String> bancoDeHoras = new ArrayList<String>();
    public static List<String> listTotalHoras = new ArrayList<String>();
    private int bancoId;
    private int monitoraId;
    private String data;
    private String tipo;
    private String justificativa;
    private String nomeMonitora;
    private String horaSaida;
    private String horaEntrada;
    private String qtdeHoraExtra;
    private String status;
    private String totalHoras;
    private String diretorio;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(String totalHoras) {
        this.totalHoras = totalHoras;
    }
    
    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public void insertSource() {

        try {
            conn = conBanco.abrir();
            String insert = "INSERT INTO DIRETORIO VALUES ('" + getDiretorio()+ "')";

            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(insert);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Diretório Adicionado");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO AO TENTAR INSERIR OS DADOS" + erro);
            erro.printStackTrace();
        } finally {
            conBanco.fechar();

        }
    }

    public void updateSource() {

        try {
            conn = conBanco.abrir();

            conBanco.executeSQL("SELECT * FROM DIRETORIO");
            conBanco.statement.executeUpdate("UPDATE DIRETORIO SET DIRETORIO = '" + getDiretorio()+"'");
            JOptionPane.showMessageDialog(null, "Diretório Alterado");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO AO TENTAR ALTERAR OS DADOS" + erro);
            erro.printStackTrace();
        } finally {
            conBanco.fechar();

        }
    }
    
    public String selectSource(){
        try{
            conBanco.abrir();
            
            conBanco.executeSQL("SELECT * FROM DIRETORIO");
            
            if(conBanco.result.first()){
                setDiretorio(conBanco.result.getString("Diretorio"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BancoDeHoras.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            conBanco.fechar();
        }
        return getDiretorio();
    }
    public void insert() {

        try {
            conn = conBanco.abrir();
            codAutomatico();

            String insert = "INSERT INTO BANCO VALUES (" + getBancoId() + ","
                    + "'" + getData() + "',"
                    + "'" + getTipo() + "',"
                    + "'" + getHoraEntrada() + "',"
                    + "'" + getHoraSaida() + "',"
                    + "'" + getQtdeHoraExtra() + "',"
                    + "'" + getJustificativa() + "',"
                    + "" + getMonitoraId() + ")";

            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(insert);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO AO TENTAR INSERIR OS DADOS" + erro);
            erro.printStackTrace();
        } finally {
            conBanco.fechar();

        }
    }

    public void update() {

        try {
            conn = conBanco.abrir();

            conBanco.executeSQL("SELECT * FROM BANCO");
            conBanco.statement.executeUpdate("UPDATE BANCO SET DATA = '" + getData() + "',"
                    + "TIPO = '" + getTipo() + "',"
                    + "HORAENTRADA = '" + getHoraEntrada() + "',"
                    + "HORASAIDA = '" + getHoraSaida() + "',"
                    + "QTDEHORAS = '" + getQtdeHoraExtra() + "',"
                    + "JUSTIFICATIVA = '" + getJustificativa() + "',"
                    + "MONITORAID = " + getMonitoraId() + " WHERE BANCOID = " + getBancoId());
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO AO TENTAR ALTERAR OS DADOS" + erro);
            erro.printStackTrace();
        } finally {
            conBanco.fechar();

        }
    }
    
    public void delete() {

        try {
            conBanco.abrir();
            conBanco.executeSQL("SELECT * FROM BANCO WHERE BANCOID = " + getBancoId());
            
            conBanco.result.first();
            String nome = "Deletar registro da monitora " + getNomeMonitora() + "?";
            int opcao = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION){
                String sql = "DELETE FROM BANCO WHERE BANCOID = " + getBancoId();
                conBanco.statement.executeUpdate(sql);

            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO AO TENTAR ALTERAR OS DADOS" + erro);
            erro.printStackTrace();
        } finally {
            conBanco.fechar();

        }
    }

    public List<String> listarMonitora() {

        List<String> list = new ArrayList<String>();
        try {
            conn = conBanco.abrir();
            conBanco.executeSQL("SELECT * FROM MONITORAS WHERE STATUS = 'Ativo' ORDER BY NOME");

            while (conBanco.result.next()) {
                list.add(conBanco.result.getString("MonitoraId") + "-" + conBanco.result.getString("Nome"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BancoDeHoras.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            conBanco.fechar();
        }

        return list;

    }

    public void listarDados(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        String monitora;
        try {
            conn = conBanco.abrir();

            conBanco.executeSQL("SELECT * FROM BANCO b INNER JOIN MONITORAS m ON b.MONITORAID = m.MONITORAID "
                    + "WHERE m.STATUS = 'Ativo' ORDER BY b.DATA");

            while (conBanco.result.next()) {
                //monitora = 
                modelo.addRow(new Object[]{
                    conBanco.result.getInt("BancoId"),
                    new SimpleDateFormat("dd/MM/yyyy").format(conBanco.result.getDate("Data")),
                    conBanco.result.getString("MonitoraId") + "-" + conBanco.result.getString("Nome"),
                    conBanco.result.getString("Tipo"),
                    conBanco.result.getString("HoraSaida"),
                    conBanco.result.getString("HoraEntrada"),
                    conBanco.result.getString("QtdeHoras"),
                    conBanco.result.getString("Justificativa")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDeHoras.class.getName()).log(Level.SEVERE, "Erro ao Listar os Dados Cadastrados", ex);
        } finally {
            conBanco.fechar();
        }
    }

    public void calculaHoraExtra(String tipo, String horas, String minutos) {
        boolean minutoNegativo = false;
        int horaExtra,
                minutosExtras,
                modMinutos,
                horaAux = 0,
                minutoAux = 0;

        if (tipo.equals("Crédito")) {
            horaAux = Integer.parseInt(horas);
            minutoAux = Integer.parseInt(minutos);
            minCredito += (horaAux * 60) + minutoAux;
        } else {
            horaAux = Integer.parseInt(horas);
            minutoAux = Integer.parseInt(minutos);
            minDebito += (horaAux * 60) + minutoAux;
        }

        //calculando as horas em minutos e convertendo para horas novamente.
        minutosExtras = minCredito - minDebito;
        if (minutosExtras < 0) {
            minutosExtras = minutosExtras * -1;
            minutoNegativo = true;
        }
        modMinutos = minutosExtras % 60;
        horaExtra = (minutosExtras - modMinutos) / 60;

        horas = String.valueOf(horaExtra);
        minutos = String.valueOf(modMinutos);

        if (horaExtra >= 0 && horaExtra < 10) {
            horas = "0" + horas;
        }

        if (modMinutos >= 0 && modMinutos < 10) {
            minutos = "0" + modMinutos;
        }

        if (minutoNegativo) {
            setStatus("Débito");
        } else {
            setStatus("Crédito");
        }

        setTotalHoras(horas + "hs e " + minutos + "min");
        //lbHoraExtra.setText(horaString + ":" + minutoString);
    }

    // Este método seleciona as horas extras cadastradas para a monitora informada e calcula a quantidade de horas extras
    public void listarDadosPorMonitora(JTable tabela, int id) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        bancoDeHoras.clear();//limpa a lista

        try {
            conn = conBanco.abrir();

            conBanco.executeSQL("SELECT * FROM BANCO b INNER JOIN MONITORAS m ON b.MONITORAID = m.MONITORAID "
                    + "WHERE m.STATUS = 'Ativo' AND b.MONITORAID = " + id + " ORDER BY b.DATA");

            while (conBanco.result.next()) {

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

                calculaHoraExtra(conBanco.result.getString("Tipo"), horaString, minutoString);

                bancoDeHoras.add(conBanco.result.getString("Nome") + ";"
                        + new SimpleDateFormat("dd/MM/yyyy").format(conBanco.result.getDate("Data")) + ";"
                        + conBanco.result.getString("Tipo") + ";"
                        + conBanco.result.getString("HoraEntrada") + ";"
                        + conBanco.result.getString("HoraSaida") + ";"
                        + conBanco.result.getString("QtdeHoras") + ";"
                        + conBanco.result.getString("Justificativa") + ";"
                        + conBanco.result.getString("MonitoraId"));

            }
            minCredito = 0;
            minDebito = 0;

        } catch (SQLException ex) {
            Logger.getLogger(BancoDeHoras.class.getName()).log(Level.SEVERE, "Erro ao Listar os Dados Cadastrados", ex);
        } finally {
            conBanco.fechar();
        }
    }

    public void listarTodosDados(String id) {
        bancoDeHoras.clear();//limpa a lista

        try {
            conn = conBanco.abrir();

            conBanco.executeSQL("SELECT * FROM BANCO b INNER JOIN MONITORAS m ON b.MONITORAID = m.MONITORAID "
                    + "WHERE m.STATUS = 'Ativo' AND b.MONITORAID = " + id + " ORDER BY b.DATA");

            while (conBanco.result.next()) {

                horaString = conBanco.result.getString("QtdeHoras").substring(0, 2);
                minutoString = conBanco.result.getString("QtdeHoras").substring(3, 5);

                calculaHoraExtra(conBanco.result.getString("Tipo"), horaString, minutoString);

                bancoDeHoras.add(conBanco.result.getString("Nome") + ";"
                        + new SimpleDateFormat("dd/MM/yyyy").format(conBanco.result.getDate("Data")) + ";"
                        + conBanco.result.getString("Tipo") + ";"
                        + conBanco.result.getString("HoraEntrada") + ";"
                        + conBanco.result.getString("HoraSaida") + ";"
                        + conBanco.result.getString("QtdeHoras") + ";"
                        + conBanco.result.getString("Justificativa") + ";"
                        + conBanco.result.getString("MonitoraId"));

            }
           
            
            minCredito = 0;
            minDebito = 0;

        } catch (SQLException ex) {
            Logger.getLogger(BancoDeHoras.class.getName()).log(Level.SEVERE, "Erro ao Listar os Dados Cadastrados", ex);
        } finally {
            conBanco.fechar();
        }
    }

    public List<String> listaIds() {
        List<String> id = new ArrayList<>();
        try {
            conn = conBanco.abrir();

            conBanco.executeSQL("SELECT distinct(b.MonitoraId) "
                    + "FROM BANCO b INNER JOIN MONITORAS m "
                    + "ON b.MONITORAID = m.MONITORAID "
                    + "WHERE m.STATUS = 'Ativo' "
                    + "ORDER BY m.nome, b.data");

            while (conBanco.result.next()) {
                id.add(conBanco.result.getString("MonitoraId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDeHoras.class.getName()).log(Level.SEVERE, "Erro ao Listar os Dados Cadastrados", ex);
        } finally {
            conBanco.fechar();
        }
        return id;
    }

    public void codAutomatico() {

        try {
            conBanco.executeSQL("SELECT MAX(BancoId) FROM BANCO");
            conBanco.result.first();
            int codigo = conBanco.result.getInt(1);
            setBancoId(codigo + 1);
        } catch (Exception erro) {
            int nro = 1;
            setBancoId(nro);

        }

    }
}
