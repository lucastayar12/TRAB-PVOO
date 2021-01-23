/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TMS;

import JBIN.Voo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class TableModelVoo extends AbstractTableModel {

    List<Voo> voos;
    private final String[] colunas = {"Código", "Origem", "Destino", "Data", "Duração", "Companhia Aérea", "Capacidade", "Aviao", "Estado"};

    public TableModelVoo() {
        this.voos = new ArrayList();
    }

    public Voo get(int rowIndex) {
        return this.voos.get(rowIndex);
    }

    public void add(Voo voo) {
        this.voos.add(voo);
        fireTableDataChanged();
    }

    public void edita(Voo voo) {
        int position = 0;
        for (int i = 0; i < voos.size(); i++) {
            Voo get = voos.get(i);
            if (get.getId() == voo.getId()) {
                position = i;
                break;
            }
        }
        this.voos.set(position, voo);
        fireTableDataChanged();
    }

    public void remove(int rowIndex) {
        this.voos.remove(rowIndex);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.voos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return this.voos.get(rowIndex).getId();

            case 1:
                return this.voos.get(rowIndex).getOrigem().getNome();

            case 2:
                return this.voos.get(rowIndex).getDestino().getNome();

            case 3:
                return this.voos.get(rowIndex).getData();

            case 4:
                return this.voos.get(rowIndex).getDuracao();

            case 5:
                return this.voos.get(rowIndex).getCompanhia().getNome();

            case 6:
                return this.voos.get(rowIndex).getCapacidade();

            case 7:
                return this.voos.get(rowIndex).getAviao();
                
            case 8:
                return this.voos.get(rowIndex).getEstado();

            default:
                return this.voos.get(rowIndex);
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }

}
