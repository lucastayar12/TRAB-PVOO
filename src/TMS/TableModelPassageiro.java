/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TMS;

import javax.swing.table.AbstractTableModel;
import JBIN.*;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Lucas
 */
public class TableModelPassageiro extends AbstractTableModel {

    private List<Passageiro> passageiros;
    private final String[] colunas = {"Código", "Nome", "CPF", "Data de Nascimento"};

    public TableModelPassageiro() {
        this.passageiros = new ArrayList<>();
    }
    
    public Passageiro get(int rowIndex) {
        return this.passageiros.get(rowIndex);
    }

    /**
     * Adiciona uma cidade a tabela (cria uma linha)
     *
     * @param p
     */
    public void add(Passageiro p) {
        this.passageiros.add(p);
        fireTableDataChanged();
    }

    /**
     * Edita uma cidade a tabela (cria uma linha)
     *
     * @param p */
    public void edita(Passageiro p) {
        int position = 0;
        for (int i = 0; i < passageiros.size(); i++) {
            Passageiro get = passageiros.get(i);
            if (get.getDocumento().equals(p.getDocumento())) {
                position = i;
                break;
            }
        }
        this.passageiros.set(position, p);

        fireTableDataChanged();
    }

    /**
     * Remove uma cidade da tabela (remove uma linha)
     *
     * @param rowIndex
     */
    public void remove(int rowIndex) {
        this.passageiros.remove(rowIndex);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.passageiros.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return this.passageiros.get(rowIndex).getId();

            case 1:
                return this.passageiros.get(rowIndex).getNome();

            case 2:
                return this.passageiros.get(rowIndex).getDocumento();

            case 3:
                return this.passageiros.get(rowIndex).getNascimento();

            default:
                return this.passageiros.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }

}
