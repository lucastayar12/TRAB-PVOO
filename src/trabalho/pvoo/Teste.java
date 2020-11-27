package trabalho.pvoo;

import java.util.Scanner;

public class Teste {

    public Teste() {

        Scanner scanner = new Scanner(System.in);
        DAOPassageiro daopassageiro = new DAOPassageiro();
        DAOAeroporto daoaeroporto = new DAOAeroporto();
        DAOCompanhia_A daocompanhiaa = new DAOCompanhia_A();
        DAOAssento daoassento = new DAOAssento();
        DAOVoo daovoo = new DAOVoo(daoaeroporto, daocompanhiaa, daoassento);
        DAOTicket daoticket = new DAOTicket();
        GUI gui = new GUI();
        int op;
        int op2;
        int id, id2;
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

                case 4://CRUD VOO
                    do {
                        op2 = gui.menuVoo();

                        switch (op2) {
                            case 1:
                                Voo voo = gui.criaVoo(daoaeroporto, daocompanhiaa);
                                conf = daovoo.inserir(voo);

                                if (conf) {
                                    System.out.println("Vôo foi inserido.");
                                } else {
                                    System.out.println("Vôo não foi criado.");
                                }

                                break;

                            case 2:
                                daovoo.mostra();
                                break;

                            case 3:
                                daovoo.mostra();
                                System.out.print("Digite o ID do vôo que deseja alterar:");
                                id = Integer.parseInt(scanner.nextLine());
                                daovoo.altera(id, daoaeroporto, daocompanhiaa);

                                break;

                            case 4:
                                daovoo.mostra();
                                System.out.print("Digite o ID do vôo que deseja excluir:");
                                id = Integer.parseInt(scanner.nextLine());
                                daovoo.exclui(id);

                                break;

                            case 5:
                                System.out.println("\nSaindo...\n");

                                break;
                            default:
                                System.out.println("Opção Inválida");
                        }

                    } while (op2 != 5);
                    break;

                case 5:  //CRUD DE ASSENTO DO VÔO
                    do {
                        op2 = gui.menuAssento();

                        switch (op2) {
                            case 1:
                                Assento ass = gui.criaAssento(daovoo, daopassageiro);
                                conf = daoassento.inserir(ass);
                                if (conf) {
                                    System.out.println("Assento foi inserido. ");
                                } else {

                                    System.out.println("Assento nao foi criado. ");
                                }
                                break;

                            case 2:
                                daoassento.mostra();
                                break;

                            case 3:
                                daoassento.mostra();
                                System.out.print("Digite o ID do assento que deseja alterar: ");
                                id = Integer.parseInt(scanner.nextLine());
                                daoassento.altera(id, daovoo, daopassageiro);

                                break;

                            case 4:
                                daoassento.mostra();
                                System.out.print("Dgite o ID do assento que deseja excluir: ");
                                id = Integer.parseInt(scanner.nextLine());
                                daoassento.exclui(id);

                                break;
                            case 5:

                                System.out.println("\nSaindo...\n");

                                break;
                            default:
                                System.out.println("Opção Inválida");
                        }
                    } while (op2 != 5);
                    break;

                case 6://EXECUTA VOO

                    TestDijkstraAlgorithm1 Test = new TestDijkstraAlgorithm1();
                    daopassageiro.mostra();
                    System.out.print("Digite o ID do passageiro que vai viajar:");
                    id = Integer.parseInt(scanner.nextLine());
                    Passageiro p = daopassageiro.buscaPorId(id);

                    System.out.println("Selecione a cidade de origem");
                    id = gui.menuCidade();
                    System.out.println("Selecione a cidade de destino");
                    id2 = gui.menuCidade();

                    double total = Test.Executa2(id, id2, daovoo, p, daoassento);

                    System.out.println("\nO valor total da viagem é de R$ " + total + "\n");

                    break;

                default:
                    System.out.println("Opção Inválida");
            }
        } while (op != 7);
    }

    public static void main(String[] args) {

        new Teste();

    }
}
