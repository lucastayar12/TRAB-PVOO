/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TMS;

import JBIN.Ticket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author adrie
 */

public class TableModelTicket extends AbstractTableModel {

            List<Ticket> tickets;
        private final String[] colunas = {"Código", "Valor", "Voo", "Passageiro", "Dat_Criacao", "Dat_Mod"};
     
         public TableModelTicket() {
        this.tickets = new ArrayList();
    }

    public Ticket get(int rowIndex) {
        return this.tickets.get(rowIndex);
    }

    public void add(Ticket ticket) {
        this.tickets.add(ticket);
        fireTableDataChanged();
    }

    public void edita(Ticket ticket) {
        int position = 0;
        for (int i = 0; i < tickets.size(); i++) {
            Ticket get = tickets.get(i);
            if (get.getId() == ticket.getId()) {
                position = i;
                break;
            }
        }
        this.tickets.set(position, ticket);
        fireTableDataChanged();
    }

        public void remove(int rowIndex) {
        this.tickets.remove(rowIndex);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return this.tickets.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return this.tickets.get(rowIndex).getId();

            case 1:
                return this.tickets.get(rowIndex).getValor();

            case 2:
                return this.tickets.get(rowIndex).getVoo().getId();

            case 3:
                return this.tickets.get(rowIndex).getPassageiro().getNome();
               
            case 4: 
                return this.tickets.get(rowIndex).getDataCriacao();
                
            case 5: 
                return this.tickets.get(rowIndex).getDataModificacao();
                

            default:
                return this.tickets.get(rowIndex);
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }

    
}
