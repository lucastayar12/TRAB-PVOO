/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TMS;

import JBIN.Aeroporto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class TableModelAeroporto extends AbstractTableModel{
    
    private List<Aeroporto> aeroportos;
    private final String[] colunas = {"Código", "Nome", "Cidade", "Abreviação"};

    public TableModelAeroporto() {
        this.aeroportos = new ArrayList<>();
    }
    
    public Aeroporto get(int rowIndex) {
        return this.aeroportos.get(rowIndex);
    }
    
    public void add(Aeroporto p) {
        this.aeroportos.add(p);
        fireTableDataChanged();
    }
    
    public void edita(Aeroporto p) {
        int position = 0;
        for (int i = 0; i < aeroportos.size(); i++) {
            Aeroporto get = aeroportos.get(i);
            if (get.getId() == p.getId()) {
                position = i;
                break;
            }
        }
        this.aeroportos.set(position, p);
        fireTableDataChanged();
    }
    
    public void remove(int rowIndex) {
        this.aeroportos.remove(rowIndex);
        fireTableDataChanged();
    }
    
    
    @Override
    public int getRowCount() {
       return this.aeroportos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch (columnIndex) {

            case 0:
                return this.aeroportos.get(rowIndex).getId();

            case 1:
                return this.aeroportos.get(rowIndex).getNome();

            case 2:
                return this.aeroportos.get(rowIndex).getCidade();

            case 3:
                return this.aeroportos.get(rowIndex).getAbreviacao();

            default:
                return this.aeroportos.get(rowIndex);
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
    
}
