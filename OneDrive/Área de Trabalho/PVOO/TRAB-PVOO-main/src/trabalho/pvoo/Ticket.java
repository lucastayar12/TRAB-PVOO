package trabalho.pvoo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ticket {
    
    long id;
    double valor;
    Voo voo;
    Passageiro passageiro;
    LocalDate dataCriacao;
    LocalDate dataModificacao;

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", valor=" + valor + ", voo=" + voo + ", passageiro=" + passageiro + ", dataCriacao=" + dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))  + ", dataModificacao=" + dataModificacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + '}';
    }

}
