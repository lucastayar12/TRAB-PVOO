/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.pvoo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class Assento {
    
    private long id;
    private Voo voo;
    private String codAssento;
    private Passageiro passageiro;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private static long serial;
    
    Assento(){
        dataCriacao = LocalDate.now();
        this.id = ++this.serial;
    }

    public long getId() {
        return id;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public String getCodAssento() {
        return codAssento;
    }

    public void setCodAssento(String codAssento) {
        this.codAssento = codAssento;
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

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public static long getSerial() {
        return serial;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.codAssento);
        hash = 53 * hash + Objects.hashCode(this.passageiro);
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
        final Assento other = (Assento) obj;
        if (!Objects.equals(this.codAssento, other.codAssento)) {
            return false;
        }
        if (!Objects.equals(this.passageiro, other.passageiro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Assentos{" + "id=" + id + ", voo=" + voo + ", codAssento=" + codAssento + ", passageiro=" + passageiro + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
}
