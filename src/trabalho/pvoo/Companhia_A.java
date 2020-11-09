package trabalho.pvoo;

import java.time.LocalDate;
import java.util.Objects;

public class Companhia_A {

    private long id;
    private String nome;
    private String abreviacao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private static long serial;

    public Companhia_A() {
        this.dataCriacao = LocalDate.now();
        this.id = ++this.serial;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
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
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.abreviacao);
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
        final Companhia_A other = (Companhia_A) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.abreviacao, other.abreviacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nCompanhia Aéria\n" + "ID= " + id + ", Nome= " + nome + " Abreviacao= " + abreviacao + "\nData de criação= " + dataCriacao + " Data de modificação= " + dataModificacao + '\n';
    }

}
