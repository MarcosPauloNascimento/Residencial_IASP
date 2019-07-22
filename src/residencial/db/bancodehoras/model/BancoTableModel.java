package residencial.db.bancodehoras.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import residencial.db.bancodehoras.dao.BancoDeHoras;

/**
 *
 * @author Markin
 */
public class BancoTableModel extends AbstractTableModel{
    
    static List<BancoDeHoras> listaBancoHoras;
    BancoDeHoras banco = new BancoDeHoras();
    String[] nomeColuna = {"Data","Monitora","Tipo","Hora Saida","Hora Entrada", "Qtde Horas", "Justificativa"};

    public BancoTableModel() {
        this.listaBancoHoras = new ArrayList<>();
    } 
    
    
    public void addItem(BancoDeHoras bh){
        this.listaBancoHoras.add(bh);
        fireTableDataChanged();
    }
    
    public void removeRow(int rowIndex){
        this.listaBancoHoras.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
        
    }
    
   /* public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 3)
            return true;
        else    
            return false;
    }*/

    

    @Override
    public int getRowCount() {
        return listaBancoHoras.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColuna.length;
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //ProdutosDao prod = listaBancoHoras.get(rowIndex);
        
        switch(columnIndex){
            case 0:return listaBancoHoras.get(rowIndex).getData();
            case 1:return listaBancoHoras.get(rowIndex).getMonitoraId()+"-"+listaBancoHoras.get(rowIndex).getNomeMonitora();
            case 2:return listaBancoHoras.get(rowIndex).getTipo();
            case 3:return listaBancoHoras.get(rowIndex).getHoraSaida();
            case 4:return listaBancoHoras.get(rowIndex).getHoraEntrada();
            case 5:return listaBancoHoras.get(rowIndex).getQtdeHoraExtra();
            case 6:return listaBancoHoras.get(rowIndex).getJustificativa();
        }
        return null;
        
        /*
        switch(columnIndex){
            case 0:
                return this.listaItemOrcamento.get(rowIndex).getCodItem();
            case 1:
                return this.listaItemOrcamento.get(rowIndex).getCodProduto();
            case 2:
                return this.listaItemOrcamento.get(rowIndex).getDescricaoProduto();
            case 3:
                return this.listaItemOrcamento.get(rowIndex).getUnidade();
            case 4:
                return this.listaItemOrcamento.get(rowIndex).getQuantidade();
            case 5:
                return this.listaItemOrcamento.get(rowIndex).getValorUnit();
            case 6:
                return this.listaItemOrcamento.get(rowIndex).getValorTotal();   
            default:
                return null;
        }*/
        
    }
    
    public Class<?> getColunmClass(int columnIndex) {
        
        if(columnIndex == 0){
            return String.class;
        }else if(columnIndex == 1){
            return String.class;
        }else if(columnIndex == 2){
            return String.class;
        }else if(columnIndex == 3){
            return String.class;
        }else if(columnIndex == 4){
            return String.class;
        }else if(columnIndex == 5){
            return String.class;
        }else if(columnIndex == 6){
            return String.class;
        }
        return null;
    }
    public String getColumnName(int columnIndex){
        return this.nomeColuna[columnIndex];
    }
    
}
