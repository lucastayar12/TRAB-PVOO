/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TMS;
import JBIN.Assento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author adrie
 */
public class TableModelAssento extends AbstractTableModel {
    
    List<Assento> assentos;
    private final String[] colunas = {"Código", "Voo", "Cod_assento", "Passageiro", "Dat_Criacao", "Dat_Mod"};

    public TableModelAssento() {
        this.assentos = new ArrayList();
    }

    public Assento get(int rowIndex) {
        return this.assentos.get(rowIndex);
    }

    public void add(Assento assento) {
        this.assentos.add(assento);
        fireTableDataChanged();
    }

    public void edita(Assento assento) {
        int position = 0;
        for (int i = 0; i < assentos.size(); i++) {
            Assento get = assentos.get(i);
            if (get.getId() == assento.getId()) {
                position = i;
                break;
            }
        }
        this.assentos.set(position, assento);
        fireTableDataChanged();
    }

    public void remove(int rowIndex) {
        this.assentos.remove(rowIndex);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return this.assentos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return this.assentos.get(rowIndex).getId();

            case 1:
                return this.assentos.get(rowIndex).getVoo().getId();

            case 2:
                return this.assentos.get(rowIndex).getCodAssento();

            case 3:
                return this.assentos.get(rowIndex).getPassageiro().getNome();
                
            case 4:
                return this.assentos.get(rowIndex).getDataCriacao();
                
            case 5:
                return this.assentos.get(rowIndex).getDataModificacao();    

            default:
                return this.assentos.get(rowIndex);
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }

}
