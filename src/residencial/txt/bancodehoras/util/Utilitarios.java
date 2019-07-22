/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencial.txt.bancodehoras.util;

import residencial.txt.bancodehoras.model.BancoDeHorasTxt;
import residencial.txt.bancodehoras.model.MonitoraTxt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos Paulo
 */
public class Utilitarios {
    
    BancoDeHorasTxt bancoHoras = new BancoDeHorasTxt();
    
    public Utilitarios(){
        
    }
    
    public boolean validaHora(String hora){
        boolean result = false;
        int h, m;
        if(hora.length()==5){
            String[] hm = hora.split(":");
            h = Integer.parseInt(hm[0]);
            m = Integer.parseInt(hm[1]);
            if(h<=24 && m<=59){                
                result = true;
            }
        }
        return result;
    }
    
    public void carregarMonitoras(JComboBox cbMonitoras){
        cbMonitoras.removeAllItems();
        List<String> lista = new MonitoraTxt().listarMonitoras();
        cbMonitoras.addItem("Selecione uma Monitora");
        for(String m : lista) {
            String[] dados = m.split(";");
            if(dados[1].equals("Ativo")){
                cbMonitoras.addItem(dados[0]);
            }
            
        }
    }
    
    public boolean validaData(String dt){
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
    
    
}
