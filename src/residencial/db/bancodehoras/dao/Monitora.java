package residencial.db.bancodehoras.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import residencial.db.conexao.Conexao;

public class Monitora {
    
    Conexao conMonitora = new Conexao();
    Connection conn;

    private int monitoraId;
    private String nomeMonitora;
    private String status;
    
    public int getMonitoraId() {
        return monitoraId;
    }
    
    public void setMonitoraId(int monitoraId){
        this.monitoraId = monitoraId;
    }

    public String getNomeMonitora() {
        return nomeMonitora;
    }
    
    public void setNomeMonitora(String nomeMonitora) {
        this.nomeMonitora = nomeMonitora;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public void insert(){
        
        try{
            conn = conMonitora.abrir();
            codAutomatico();
            String insert = "INSERT INTO MONITORAS VALUES ("+getMonitoraId()+",'"+getNomeMonitora()+"','"+getStatus()+"')";
                    PreparedStatement stmt = (PreparedStatement)conn.prepareStatement(insert);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Monitora cadastrada com sucesso");
       
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null, "ERRO AO TENTAR INSERIR OS DADOS" +erro);
            erro.printStackTrace();
        }finally{
            conMonitora.fechar();
            
        }
    }
    
    public void update(){
        
        try{
            conn = conMonitora.abrir();
            
            conMonitora.executeSQL("SELECT * FROM MONITORAS");
            conMonitora.statement.executeUpdate("UPDATE MONITORAS SET NOME = '"+ getNomeMonitora()+"',"
                        + "STATUS = '"+getStatus()+"' WHERE MONITORAID = "+getMonitoraId());
            JOptionPane.showMessageDialog(null, "Monitora alterada com sucesso");
       
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null, "ERRO AO TENTAR ALTERAR OS DADOS" +erro);
            erro.printStackTrace();
        }finally{
            conMonitora.fechar();
            
        }
    }
    
    public void monitoraAtiva(JTable tabela){
        try
        {
            conMonitora.abrir();
            DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
            modelo.setNumRows(0);
            
            //STATUS = 0 ATIVO
            //STATUS = 1 INATIVO

            conMonitora.executeSQL("SELECT * FROM MONITORAS WHERE STATUS = 'Ativo' ORDER BY NOME");
        
            while(conMonitora.result.next())
            modelo.addRow(new Object[]
            {conMonitora.result.getString("MonitoraId"),
             conMonitora.result.getString("Nome")});
            
        }    
        
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel adicionar os dados na tabela..."+"\n"+"Erro.: "+ erro);
        }finally{
            conMonitora.fechar();
            
        }
    }
    
    public void monitoraInativa(JTable tabela){
        try
        {
            conMonitora.abrir();
            DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
            modelo.setNumRows(0);
            
            //STATUS = 0 ATIVO
            //STATUS = 1 INATIVO

            conMonitora.executeSQL("SELECT * FROM MONITORAS WHERE STATUS = 'Inativo' ORDER BY NOME");
        
            while(conMonitora.result.next())
            modelo.addRow(new Object[]
            {conMonitora.result.getString("monitoraId"),
             conMonitora.result.getString("nome")});
            
        }    
        
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel adicionar os dados na tabela..."+"\n"+"Erro.: "+ erro);
        }finally{
            conMonitora.fechar();
            
        }
    }
    
    public void codAutomatico() {

        try {
            conMonitora.executeSQL("SELECT MAX(MonitoraId) FROM MONITORAS");
            conMonitora.result.first();
            int codigo = conMonitora.result.getInt(1);
            setMonitoraId(codigo + 1);
        } catch (Exception erro) {
            int nro = 1;
            setMonitoraId(nro);

        }

    }

    
        
}
