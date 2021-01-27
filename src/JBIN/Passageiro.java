package JBIN;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Passageiro {

    private Long id;
    private String nome;
    private LocalDate nascimento;
    private String documento;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
   
    public Passageiro() {
        this.dataCriacao = LocalDate.now();
        dataModificacao = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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
    public String toString() {
        return "\nPassageiro\n" + "ID= " + id + " Nome= " + nome + "\nNascimento= " + nascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " Documento= " + documento + "\nData de Criação= " + dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " Data de Modificacao= " + dataModificacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + '\n';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nome);
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
        final Passageiro other = (Passageiro) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        return true;
    }

}
