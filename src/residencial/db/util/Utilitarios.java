/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencial.db.util;


import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import residencial.db.bancodehoras.dao.BancoDeHoras;
import residencial.db.conexao.Conexao;

public class Utilitarios {
    
    Conexao conUtil = new Conexao();
    Connection conn;
    
    //TROCA PONTO POR VIRGULA
    public String trocaPontoParaVirgula(String valor){
        valor = valor.replace(".", ",");        
        return valor;
    }
      
    //PEGA DATA E HORA ATUAIS
    public String getDateTime() { 
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	Date date = new Date(); 
	return dateFormat.format(date); 
    }
    
    //CONVERTE A DATA PARA PADRAO AMERICANO
    public String converteData(String data){
        String dia = data.substring(0,2);
        String mes = data.substring(3,5);
        String ano = data.substring(6,10);
        String dataAmerica = new StringBuffer().append(ano).append(mes).append(dia).toString();
        return dataAmerica;
    }
    
    //VALIDA SE A DATA É VÁLIDA
    public boolean verificaData(String dt){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        //String dataString = dt.getText();
        boolean DataCerta;

        try {
            java.util.Date data = sdf.parse(dt);
            DataCerta = true;
          // se passou pra cá, é porque a data é válida
        } catch(ParseException e) {
          // se cair aqui, a data é inválida
          JOptionPane.showMessageDialog(null,"Data inválida");
          DataCerta = false;
        }
        
        return DataCerta;
    }
    
    public void preecheComboMonitora(JComboBox cbMonitoras){
        cbMonitoras.removeAllItems();
        cbMonitoras.addItem("Selecione uma Monitora");
        List<String> lista = new BancoDeHoras().listarMonitora();
        for(String m : lista) {
            cbMonitoras.addItem(m);
        }
    }
    
}

