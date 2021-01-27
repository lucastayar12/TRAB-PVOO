/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TMS;

import JBIN.Companhia_A;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author adrie
 */
public class TableModelCompanhia_A extends AbstractTableModel {

    private List<Companhia_A> companhiaas;
    private final String[] colunas = {"Código", "Nome", "Abreviação"};

    public TableModelCompanhia_A() {
        this.companhiaas = new ArrayList<>();
    }

    public Companhia_A get(int rowIndex) {
        return this.companhiaas.get(rowIndex);
    }

    
    public void add(Companhia_A co) {
        this.companhiaas.add(co);
        fireTableDataChanged();
    }

    
    public void edita(Companhia_A co) {
        int position = 0;
        for (int i = 0; i < companhiaas.size(); i++) {
            Companhia_A get = companhiaas.get(i);
            if (get.getId() == co.getId()) {
                position = i;
                break;
            }
        }
        this.companhiaas.set(position, co);
        fireTableDataChanged();
    }

    public void remove(int rowIndex) {
        this.companhiaas.remove(rowIndex);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.companhiaas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return this.companhiaas.get(rowIndex).getId();

            case 1:
                return this.companhiaas.get(rowIndex).getNome();

            case 2:
                return this.companhiaas.get(rowIndex).getAbreviacao();

            default:
                return this.companhiaas.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }

}
