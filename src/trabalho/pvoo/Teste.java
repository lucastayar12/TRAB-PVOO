package trabalho.pvoo;

import java.util.Scanner;

public class Teste {

    public Teste() {

        Scanner scanner = new Scanner(System.in);
        DAOPassageiro daopassageiro = new DAOPassageiro();
        DAOAeroporto daoaeroporto = new DAOAeroporto();
        GUI gui = new GUI();
        int op = 0;
        int op2 = 0;
        int id;

        do {
            op = gui.menuCRUD();

            switch (op) {

                case 1:
                    op2 = gui.menuPassageiro();
                    do{
                    switch (op2) {
                        case 1:
                            Passageiro p = gui.criaPassageiro();
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
                    }while(op2 != 5);

                    break;

                case 2:
                    op2 = gui.menuAeroporto();
                    
                    do{
                    switch (op2) {
                        case 1:
                            Aeroporto ae = gui.criaAeroporto();
                            boolean conf = daoaeroporto.inserir(ae);

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
                            
                            break;

                        default:
                            System.out.println("Opção Inválida");
                    }
                    }while(op2 != 5);

                    break;

                default:
                    System.out.println("Opção Inválida");

            }

        } while (op != 3);
    }

    public static void main(String[] args) {
        new Teste();
    }
}
