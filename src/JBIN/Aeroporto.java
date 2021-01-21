package JBIN;

import trabalho.pvoo.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Aeroporto {

    private int id;
    private String nome;
    private String abreviacao;
    private String cidade;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
   

    Aeroporto() {
        dataCriacao = LocalDate.now();
        dataModificacao = LocalDate.now();
    }

    public int getId() {
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cidade);
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
        final Aeroporto other = (Aeroporto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nAeroporto\n" + "ID= " + id + ", Nome= " + nome + "\nAbreviação= " + abreviacao + " Cidade= " + cidade + "\nData da Criação= " + dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\nData de Modificação= " + dataModificacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + '\n';
    }

}
