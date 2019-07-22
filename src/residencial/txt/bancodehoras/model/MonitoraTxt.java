/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencial.txt.bancodehoras.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonitoraTxt {

    private String dados;
    private String status;
    private final ArrayList<String> monitoras = new ArrayList<String>();
    File file = new File("Monitora.txt");
    
    /**
     * @return the nome
     */
    public String getDados() {
        return dados;
    }

    /**
     * @param nome the nome to set
     */
    public void setDados(String dados) {
        this.dados = dados;
    }
    
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    public ArrayList<String> getMonitoras() {
        return monitoras;
    }
    
    public String salvar(){
        try {
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(getDados());
            getMonitoras().add(getDados());
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(MonitoraTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Dados salvos com sucesso";
    }
    
    public String alterar(int index){
        try {
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(getDados());
            getMonitoras().add(index,getDados());
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(MonitoraTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Dados alterados com sucesso";
    }
    
    public void lerDados(){
        
        try{
            BufferedReader br = null;
            if(file.exists()){
                FileReader fr = new FileReader(file);
                br = new BufferedReader(fr);
                
                String linha;
                while((linha = br.readLine()) != null){
                    getMonitoras().add(linha);
                }
                br.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public List<String> listarMonitoras(){        
        try{
            BufferedReader br = null;
            if(file.exists()){
                FileReader fr = new FileReader(file);
                br = new BufferedReader(fr);
                
                String linha;
                while((linha = br.readLine()) != null){
                    getMonitoras().add(linha);
                }
                br.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return getMonitoras();
    }

    
    
        
}