package JBIN;

import trabalho.pvoo.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ticket {
    
    private long id;
    private double valor;
    private Voo voo;
    private Passageiro passageiro;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private static long serial;

    public Ticket() {
    dataCriacao = LocalDate.now();
    dataModificacao = LocalDate.now();
    id = ++serial;
    }

    public long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 19 * hash + Objects.hashCode(this.passageiro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.passageiro, other.passageiro)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "\nTicket\n" + "ID= " + id + " Valor= R$ " + valor + "\n----" + voo + "\n----" + passageiro + "\nData de Criação= " + dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))  + " Data de Modificação= " + dataModificacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + '}';
    }

}
