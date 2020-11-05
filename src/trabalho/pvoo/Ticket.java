/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.pvoo;

import java.time.LocalDate;

/**
 *
 * @author Lucas
 */
public class Ticket {
    
    long id;
    double valor;
    Voo voo;
    Passageiro passageiro;
    LocalDate dataCriacao;
    LocalDate dataModificacao;

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", valor=" + valor + ", voo=" + voo + ", passageiro=" + passageiro + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

}
