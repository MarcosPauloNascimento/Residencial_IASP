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
import residencial.db.bancodehoras.model.Monitora;

public class BancoDeHorasTxt {
    
    private String dados;
    private String data;
    private String monitora;
    private String justificativa;
    private String tipo;
    private String hora;
    private String horaSaida;
    private String horaExtra;
    private final ArrayList<String> bancoHoras = new ArrayList<String>();
    File file = new File("BancoDeHoras.txt");

    
    /**
     * @return the dados
     */
    public String getDados() {
        return dados;
    }

    /**
     * @param dados the dados to set
     */
    public void setDados(String dados) {
        this.dados = dados;
    }
    
    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the monitora
     */
    public String getMonitora() {
        return monitora;
    }

    /**
     * @param monitora the monitora to set
     */
    public void setMonitora(String monitora) {
        this.monitora = monitora;
    }

    /**
     * @return the justificativa
     */
    public String getJustificativa() {
        return justificativa;
    }

    /**
     * @param justificativa the justificativa to set
     */
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the horaSaida
     */
    public String getHoraSaida() {
        return horaSaida;
    }

    /**
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * @return the horaExtra
     */
    public String getHoraExtra() {
        return horaExtra;
    }

    /**
     * @param horaExtra the horaExtra to set
     */
    public void setHoraExtra(String horaExtra) {
        this.horaExtra = horaExtra;
    }
    
    public ArrayList<String> getBancoHoras() {
        return bancoHoras;
    }
            
    public String salvar(){
        try {
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(getDados());
            getBancoHoras().add(getDados());
            
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Monitora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Dados salvos com sucesso";
    }
    
    public List<String> listarDados(){        
        try{
            BufferedReader br = null;
            if(file.exists()){
                FileReader fr = new FileReader(file);
                br = new BufferedReader(fr);
                
                String linha;
                while((linha = br.readLine()) != null){
                    getBancoHoras().add(linha);
                }
                br.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return getBancoHoras();
    }

    
    
}
