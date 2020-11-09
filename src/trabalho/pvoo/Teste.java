package trabalho.pvoo;

import java.util.Scanner;

public class Teste {

    public Teste() {

        Scanner scanner = new Scanner(System.in);
        DAOPassageiro daopassageiro = new DAOPassageiro();
        DAOAeroporto daoaeroporto = new DAOAeroporto();
        DAOCompanhia_A daocompanhiaa = new DAOCompanhia_A();
        GUI gui = new GUI();
        int op = 0;
        int op2 = 0;
        int id;
        boolean conf;

        do {
            op = gui.menuCRUD();

            switch (op) {

                case 1://CRUD PASSAGEIRO
                    do {
                        op2 = gui.menuPassageiro();
                        switch (op2) {
                            case 1:
                                Passageiro p = gui.criaPassageiro();
                                conf = daopassageiro.inserir(p);
                                if (conf) {
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
                                System.out.println("\nSaindo...\n");
                                break;

                            default:
                                System.out.println("Opção Inválida");

                        }
                    } while (op2 != 5);

                    break;

                case 2: //CRUD AEROPORTO                  
                    do {
                        op2 = gui.menuAeroporto();
                        switch (op2) {
                            case 1:
                                Aeroporto ae = gui.criaAeroporto();
                                conf = daoaeroporto.inserir(ae);

                                if (conf) {
                                    System.out.println("Aeroporto foi inserido.");
                                } else {
                                    System.out.println("Aeroporto não foi criado");
                                }
                                break;

                            case 2:
                                daoaeroporto.mostra();
                                break;

                            case 3:
                                daoaeroporto.mostra();
                                System.out.print("Digite o id do aeroporto que deseja alterar:");
                                id = Integer.parseInt(scanner.nextLine());
                                daoaeroporto.altera(id);
                                break;

                            case 4:
                                daoaeroporto.mostra();
                                System.out.print("Digite o id do aeroporto que deseja excluir:");
                                id = Integer.parseInt(scanner.nextLine());
                                daoaeroporto.exclui(id);
                                break;

                            case 5:
                                System.out.println("\nSaindo...\n");
                                break;

                            default:
                                System.out.println("Opção Inválida");
                        }
                    } while (op2 != 5);

                    break;

                case 3: //CRUD COMPANHIA AÉREA
                    do {
                        op2 = gui.menuCompanhia_A();
                        switch (op2) {
                            case 1:
                                Companhia_A ca = gui.criaCompanhia_A();
                                conf = daocompanhiaa.inserir(ca);

                                if (conf) {
                                    System.out.println("Companhia Aéria foi inserida.");
                                } else {
                                    System.out.println("Companhia Aéria não foi criada.");
                                }
                                break;

                            case 2:
                                daocompanhiaa.mostra();
                                break;

                            case 3:
                                daocompanhiaa.mostra();
                                System.out.print("Digite o id da companhia aéria que deseja alterar:");
                                id = Integer.parseInt(scanner.nextLine());
                                daocompanhiaa.altera(id);
                                break;

                            case 4:
                                daocompanhiaa.mostra();
                                System.out.print("Digite o id da companhia aéria que deseja excluir:");
                                id = Integer.parseInt(scanner.nextLine());
                                daocompanhiaa.exclui(id);
                                break;

                            case 5:
                                System.out.println("\nSaindo...\n");
                                break;

                            default:
                                System.out.println("Opção Inválida");

                        }

                    } while (op2 != 5);
                    break;

                default:
                    System.out.println("Opção Inválida");

            }
        } while (op != 4);
    }

    public static void main(String[] args) {
        new Teste();
    }
}
