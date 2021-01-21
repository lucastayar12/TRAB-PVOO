
import java.util.Date;

public class Ticket {
    
    private int numero;
    
    private Date  horaEntrada;
    
    private int getNumero(){
          return numero;   
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public Date getHoraEntrada(){
        return horaEntrada;
    }
    
    public void setHoraEntrada(Date horaEntrada){
        this.horaEntrada = horaEntrada;
    }
}
