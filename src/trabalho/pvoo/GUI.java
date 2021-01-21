package trabalho.pvoo;

import java.time.LocalDate;
import java.util.Scanner;

public class GUI {

    public int menuPassageiro() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1- Adicionar passageiro");
        System.out.println("2- Listar passageiros");
        System.out.println("3- Altera passageiro");
        System.out.println("4- Remover passageiro");
        System.out.println("5- Sair");
        System.out.print("Digite a opção:");

        return Integer.parseInt(scanner.nextLine());

    }

    public int menuAeroporto() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1- Adicionar aeroporto");
        System.out.println("2- Listar aeroporto");
        System.out.println("3- Altera aeroporto");
        System.out.println("4- Remover aeroporto");
        System.out.println("5- Sair");
        System.out.print("Digite a opção:");

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuCompanhia_A() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1- Adicionar companhia aérea");
        System.out.println("2- Listar companhia aérea");
        System.out.println("3- Altera companhia aérea");
        System.out.println("4- Remover companhia aérea");
        System.out.println("5- Sair");
        System.out.print("Digite a opção:");

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuVoo() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1- Adicionar Vôo");
        System.out.println("2- Listar Vôo");
        System.out.println("3- Altera Vôo");
        System.out.println("4- Remover Vôo");
        System.out.println("5- Sair");
        System.out.print("Digite a opção:");

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAssento() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1- Adicionar Assento");
        System.out.println("2- Listar Assentos");
        System.out.println("3- Altera Assento");
        System.out.println("4- Remover Assento");
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
        LocalDate dat_nasc = LocalDate.parse(scanner.nextLine());
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
    
    public Voo criaVoo(DAOAeroporto ae, DAOCompanhia_A companhiaa) {

        Scanner scanner = new Scanner(System.in);
        Voo voo = new Voo();

        ae.mostra();
        System.out.print("Digite ID da cidade de origem:");
        int id = Integer.parseInt(scanner.nextLine());
        voo.setOrigem(ae.buscaPorId(id));

        ae.mostra();
        System.out.print("Digite ID da cidade de destino:");
        id = Integer.parseInt(scanner.nextLine());
        voo.setDestino(ae.buscaPorId(id));

        System.out.print("Digite a data do voo:");
        LocalDate data = LocalDate.parse(scanner.nextLine());
        voo.setData(data);

        System.out.print("Digite a duração do voo:");
        int duracao = Integer.parseInt(scanner.nextLine());
        voo.setDuracao(duracao);

        companhiaa.mostra();
        System.out.print("Digite ID da Companhia Aéria:");
        id = Integer.parseInt(scanner.nextLine());
        voo.setCompanhia(companhiaa.buscaPorId(id));

        System.out.print("Digite a capacidade do voo:");
        long capacidade = Integer.parseInt(scanner.nextLine());
        voo.setCapacidade(capacidade);

        System.out.print("Digite o avião do voo:");
        String avi = scanner.nextLine();
        voo.setAviao(avi);

        return voo;
    }

    public Assento criaAssento(DAOVoo daovoo, DAOPassageiro daop) {

        Assento ass = new Assento();
        Scanner scanner = new Scanner(System.in);

        daovoo.mostra();
        System.out.print("Digite o ID do Vôo que deseja selecionar:");
        int id = Integer.parseInt(scanner.nextLine());
        ass.setVoo(daovoo.buscaPorId(id));

        System.out.print("\nDigite o código do Asssento:");
        String codas = scanner.nextLine();
        ass.setCodAssento(codas);

        daop.mostra();
        System.out.print("Digite o ID do passageiro que deseja selecionar:");
        id = Integer.parseInt(scanner.nextLine());
        ass.setPassageiro(daop.buscaPorId(id));

        return ass;

    }
    
    public int menuAlteraPassageiro() {

        Scanner scanner = new Scanner(System.in);
        int op = 0;

        System.out.println("\n1- Altera nome");
        System.out.println("2- Altera documento");
        System.out.println("3- Altera Data de nascimento");
        System.out.print("Digite uma opção:");
        return op = Integer.parseInt(scanner.nextLine());
    }

    public int menuAlteraVoo() {

        Scanner scanner = new Scanner(System.in);
        int op = 0;

        System.out.println("\n1- Altera origem");
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
        int op;

        System.out.println("\n1- Altera nome");
        System.out.println("2- Altera cidade");
        System.out.println("3- Altera abreviação");
        System.out.print("Digite uma opção:");
        return op = Integer.parseInt(scanner.nextLine());
    }

    public int menuAlteraAssento() {

        Scanner scanner = new Scanner(System.in);
        int op;

        System.out.println("\n1- Altera Vôo");
        System.out.println("2- Altera Código de Assento");
        System.out.println("3- Altera Passageiro");
        System.out.print("Digite uma opção:");
        return op = Integer.parseInt(scanner.nextLine());
    }

    public int menuAlteraComapanhia_A() {

        Scanner scanner = new Scanner(System.in);
        int op = 0;

        System.out.println("\n1- Altera nome");
        System.out.println("2- Altera abreviação");
        System.out.print("Digite uma opção:");
        return op = Integer.parseInt(scanner.nextLine());
    }

    public int menuCRUD() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1- CRUD Passageiro");
        System.out.println("2- CRUD Aaeroporto");
        System.out.println("3- CRUD Companhia Aérea");
        System.out.println("4- CRUD Vôo");
        System.out.println("5- CRUD Assento do Vôo");
        System.out.println("6- Executa vôo");
        System.out.print("Digite uma opção: ");
        int op = Integer.parseInt(scanner.nextLine());

        return op;

    }
    
    public int menuCidade(){
        Scanner scanner = new Scanner(System.in);
        int id;
        
        System.out.println("\n1- Uberaba");
        System.out.println("2- São Paulo");
        System.out.println("3- Nova Iorque");
        System.out.println("4- Londres");
        System.out.println("5- Paris");
        System.out.print("Digite uma opção:");
        
        
        return id = Integer.parseInt(scanner.nextLine());
        
    }

}
