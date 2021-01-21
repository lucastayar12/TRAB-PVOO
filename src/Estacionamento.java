
import java.util.Random;
import java.util.Date;

public class Estacionamento {
    
    private int vagas;
    
    private int valorHora;
    
    public Ticket estacionar() {
        Ticket ticket = new Ticket();
        
        ticket.setNumero(new Random().nextInt());
        ticket.setHoraEntrada(new Date());
        
        return ticket;
    
    }
            
    public void pagar(Ticket ticket){
        // pagamento
 }
}
