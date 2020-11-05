package trabalho.pvoo;

import java.util.Scanner;

public class Teste {

    public Teste() {

        Scanner scanner = new Scanner(System.in);
        DAOPassageiro daopassageiro = new DAOPassageiro();
        int op = 0;
        int id;

        do {
            op = menu();

            switch (op) {
                case 1:
                    Passageiro p = criaPassageiro();
                    boolean certo = daopassageiro.inserir(p);
                    if (certo) {
                        System.out.println("Passageiro foi inserido.");
                    } else {
                        System.out.println("Passageiro não foi criado");
                    }

                    break;
                case 2:
                    daopassageiro.mostra();
                    break;
                case 3:
                    daopassageiro.mostra();
                    System.out.print("Digite o id do passageiro que deseja alterar:");
                    id = Integer.parseInt(scanner.nextLine());
                    daopassageiro.altera(id);
                    break;
                case 4:
                    daopassageiro.mostra();
                    System.out.print("Digite o id do passageiro que deseja excluir:");
                    id = Integer.parseInt(scanner.nextLine());
                    daopassageiro.exclui(id);
                    break;
                case 5:
                    break;

                default:
                    System.out.println("Opção Inválida");
            }

        } while (op != 5);
    }

    public static void main(String[] args) {
        new Teste();
    }

    private int menu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1- Adicionar passageiro");
        System.out.println("2- Listar passageiros");
        System.out.println("3- Altera passageiro");
        System.out.println("4- Remover passageiro");
        System.out.print("Ditie a opção:");
        return Integer.parseInt(scanner.nextLine());

    }

    private static Passageiro criaPassageiro() {

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
}
