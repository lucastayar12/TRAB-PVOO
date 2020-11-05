/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.pvoo;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class GUI {

    public int menuPassageiro() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1- Adicionar passageiro");
        System.out.println("2- Listar passageiros");
        System.out.println("3- Altera passageiro");
        System.out.println("4- Remover passageiro");
        System.out.print("Digite a opção:");

        return Integer.parseInt(scanner.nextLine());

    }
    
    public int menuAeroporto(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Adicionar aeroporto");
        System.out.println("2- Listar aeroporto");
        System.out.println("3- Altera aeroporto");
        System.out.println("4- Remover aeroporto");
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

    public int menuAlteraPassageiro() {

        Scanner scanner = new Scanner(System.in);
        int op = 0;
        
        System.out.println("1- Altera nome");
        System.out.println("2- Altera documento");
        System.out.println("3- Altera Data de nascimento");
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
    
    public Aeroporto criaAeroporto() {

        Scanner scanner = new Scanner(System.in);
        Aeroporto ae = new Aeroporto();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        ae.setNome(nome);

        System.out.print("Digite a data de Nascimento: ");
        String cid = scanner.nextLine();
        ae.setCidade(cid);

        System.out.print("Digite o Documento: ");
        String abrev = scanner.nextLine();
        ae.setAbreviacao(abrev);

        return ae;
    }
    
    public int menuCRUD(){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("1- CRUD Passageiro");
        System.out.println("2- CRUD Aaeroporto");
        System.out.print("Digite uma opção: ");
        int op = Integer.parseInt(scanner.nextLine());
        
        return op;
        
    }

}
