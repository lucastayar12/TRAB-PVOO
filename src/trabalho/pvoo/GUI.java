/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.pvoo;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class GUI {

    DAOAeroporto daoaeroporto = new DAOAeroporto();
    DAOCompanhia_A daocompanhiaa = new DAOCompanhia_A();

    public int menuPassageiro() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1- Adicionar passageiro");
        System.out.println("2- Listar passageiros");
        System.out.println("3- Altera passageiro");
        System.out.println("4- Remover passageiro");
        System.out.println("5- Sair");
        System.out.print("Digite a opção:");

        return Integer.parseInt(scanner.nextLine());

    }

    public int menuAeroporto() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Adicionar aeroporto");
        System.out.println("2- Listar aeroporto");
        System.out.println("3- Altera aeroporto");
        System.out.println("4- Remover aeroporto");
        System.out.println("5- Sair");
        System.out.print("Digite a opção:");

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuCompanhia_A() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Adicionar companhia aérea");
        System.out.println("2- Listar companhia aérea");
        System.out.println("3- Altera companhia aérea");
        System.out.println("4- Remover companhia aérea");
        System.out.println("5- Sair");
        System.out.print("Digite a opção:");

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuVoo() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Adicionar Vôo");
        System.out.println("2- Listar Vôo");
        System.out.println("3- Altera Vôo");
        System.out.println("4- Remover Vôo");
        System.out.println("5- Sair");
        System.out.print("Digite a opção:");

        return Integer.parseInt(scanner.nextLine());
    }

    public Passageiro criaPassageiro() {

        Scanner scanner = new Scanner(System.in);
        Passageiro p = new Passageiro();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        p.setNome(nome);

        System.out.print("Digite a data de Nascimento: ");
        String dat_nasc = scanner.nextLine();
        p.setNascimento(dat_nasc);

        System.out.print("Digite o Documento: ");
        String doc = scanner.nextLine();
        p.setDocumento(doc);

        return p;
    }

    public Aeroporto criaAeroporto() {

        Scanner scanner = new Scanner(System.in);
        Aeroporto ae = new Aeroporto();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        ae.setNome(nome);

        System.out.print("Digite a cidade: ");
        String cid = scanner.nextLine();
        ae.setCidade(cid);

        System.out.print("Digite a abrevição: ");
        String abrev = scanner.nextLine();
        ae.setAbreviacao(abrev);

        return ae;
    }

    public Companhia_A criaCompanhia_A() {

        Scanner scanner = new Scanner(System.in);
        Companhia_A ca = new Companhia_A();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        ca.setNome(nome);

        System.out.print("Digite a abrevição: ");
        String abrev = scanner.nextLine();
        ca.setAbreviacao(abrev);

        return ca;
    }

    public Voo criaVoo() {

        Scanner scanner = new Scanner(System.in);
        Voo voo = new Voo();
        Aeroporto ae = new Aeroporto();

        daoaeroporto.mostra();
        System.out.print("Digite ID da cidade de origem:");
        int id = Integer.parseInt(scanner.nextLine());
        voo.setOrigem(daoaeroporto.buscaPorId(id));

        daoaeroporto.mostra();
        System.out.print("Digite ID da cidade de destino:");
        id = Integer.parseInt(scanner.nextLine());
        voo.setDestino(daoaeroporto.buscaPorId(id));

        System.out.print("Digite a data do voo:");
        LocalDate data = LocalDate.parse(scanner.nextLine());
        voo.setData(data);

        System.out.print("Digite a duração do voo:");
        String duracao = scanner.nextLine();
        voo.setDuracao(duracao);

        daocompanhiaa.mostra();
        System.out.print("Digite ID da Companhia Aéria:");
        id = Integer.parseInt(scanner.nextLine());
        voo.setCompanhia(daocompanhiaa.buscaPorId(id));

        System.out.print("Digite a capacidade do voo:");
        long capacidade = Integer.parseInt(scanner.nextLine());
        voo.setCapacidade(capacidade);

        System.out.print("Digite o avião do voo:");
        String avi = scanner.nextLine();
        voo.setAviao(avi);

        return voo;
    }

    public int menuAlteraPassageiro() {

        Scanner scanner = new Scanner(System.in);
        int op = 0;

        System.out.println("1- Altera nome");
        System.out.println("2- Altera documento");
        System.out.println("3- Altera Data de nascimento");
        System.out.print("Digite uma opção:");
        return op = Integer.parseInt(scanner.nextLine());
    }
    
    public int menuAlteraVoo() {

        Scanner scanner = new Scanner(System.in);
        int op = 0;

        System.out.println("1- Altera origem");
        System.out.println("2- Altera destino");
        System.out.println("3- Altera Data");
        System.out.println("4- Altera Duração");
        System.out.println("5- Altera companhia aérea");
        System.out.println("6- Altera Capacidade");
        System.out.println("7- Altera Avião");
        System.out.print("Digite uma opção:");
        return op = Integer.parseInt(scanner.nextLine());
    }

    public int menuAlteraAeroporto() {

        Scanner scanner = new Scanner(System.in);
        int op = 0;

        System.out.println("1- Altera nome");
        System.out.println("2- Altera cidade");
        System.out.println("3- Altera abreviação");
        System.out.print("Digite uma opção:");
        return op = Integer.parseInt(scanner.nextLine());
    }

    public int menuAlteraComapanhia_A() {

        Scanner scanner = new Scanner(System.in);
        int op = 0;

        System.out.println("1- Altera nome");
        System.out.println("2- Altera abreviação");
        System.out.print("Digite uma opção:");
        return op = Integer.parseInt(scanner.nextLine());
    }

    public int menuCRUD() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1- CRUD Passageiro");
        System.out.println("2- CRUD Aaeroporto");
        System.out.println("3- CRUD Companhia Aérea");
        System.out.println("4- CRUD Vôo");
        System.out.print("Digite uma opção: ");
        int op = Integer.parseInt(scanner.nextLine());

        return op;

    }

}
