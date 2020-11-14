package trabalho.pvoo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Voo {

    private long id;
    private Aeroporto origem;
    private Aeroporto destino;
    private LocalDate data;
    private int duracao;
    private Companhia_A companhia;
    private long capacidade;
    private String aviao;
    private String estado = "Planejado";
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private static long serial;

    Voo() {
        dataCriacao = LocalDate.now();
        dataModificacao = LocalDate.now();
        this.id = ++this.serial;
    }

    public long getId() {
        return id;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }
    
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Companhia_A getCompanhia() {
        return companhia;
    }

    public void setCompanhia(Companhia_A companhia) {
        this.companhia = companhia;
    }

    public long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(long capacidade) {
        this.capacidade = capacidade;
    }
    
    public String getAviao() {
        return aviao;
    }

    public void setAviao(String aviao) {
        this.aviao = aviao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.origem);
        hash = 17 * hash + Objects.hashCode(this.destino);
        hash = 17 * hash + Objects.hashCode(this.duracao);
        hash = 17 * hash + Objects.hashCode(this.companhia);
        hash = 17 * hash + Objects.hashCode(this.aviao);
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
        final Voo other = (Voo) obj;
        if (!Objects.equals(this.origem, other.origem)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        if (!Objects.equals(this.duracao, other.duracao)) {
            return false;
        }
        if (!Objects.equals(this.aviao, other.aviao)) {
            return false;
        }
        if (!Objects.equals(this.companhia, other.companhia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nVoo\n" + "ID= " + id + " Origem= " + origem.toString() + " Destino= " + destino.toString() + "\nData= " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " Duracao= " + duracao + "\n" + companhia.toString() + " Capacidade= " + capacidade + "\nAvião= " + aviao + " Estado= " + estado + "\nData de Criação= " + dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " Data de Modificação= " + dataModificacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + '\n';
    }
    
    

}
