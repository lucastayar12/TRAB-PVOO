package trabalho.pvoo;

import java.time.LocalDate;
import java.util.Scanner;

public class DAOVoo {

    Aeroporto ae = new Aeroporto();
    DAOAeroporto daoaeroporto = new DAOAeroporto();
    DAOCompanhia_A daocompanhiaa = new DAOCompanhia_A();
    Scanner scanner = new Scanner(System.in);
    GUI gui = new GUI();

    private Voo[] voos = new Voo[10];
    int op = 0;

    int proximaPosicaoLivre() {
        for (int i = 0; i < voos.length; i++) {
            if (voos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean inserir(Voo voo) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre == - 1) {
            return false;
        } else {
            voos[proximaPosicaoLivre] = voo;
            return true;
        }
    }

    public void mostra() {
        for (Voo voo : voos) {
            if (voo != null) {
                System.out.println(voo.toString());
            }
        }
    }

    public boolean exclui(int id) {
        for (int i = 0; i < voos.length; i++) {
            Voo voo = voos[i];
            if (voo != null && voo.getId() == id) {
                voos[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean altera(int id) {
        for (int i = 0; i < voos.length; i++) {
            Voo voo = voos[i];
            if (voo != null && voo.getId() == id) {

                op = gui.menuAlteraVoo();

                switch (op) {
                    case 1:
                        daoaeroporto.mostra();
                        System.out.print("Digite o ID da nova origem:");
                        id = Integer.parseInt(scanner.nextLine());
                        voos[i].setOrigem(daoaeroporto.buscaPorId(id));
                        voos[i].setDataModificacao(LocalDate.now());

                        break;

                    case 2:
                        daoaeroporto.mostra();
                        System.out.print("Digite o ID do novo destino:");
                        id = Integer.parseInt(scanner.nextLine());
                        voos[i].setDestino(daoaeroporto.buscaPorId(id));
                        voos[i].setDataModificacao(LocalDate.now());

                        break;

                    case 3:

                        System.out.print("Digite a nova data:");
                        LocalDate dt = LocalDate.parse(scanner.nextLine());
                        voos[i].setData(dt);
                        voos[i].setDataModificacao(LocalDate.now());

                        break;

                    case 4:
                        System.out.print("Digite a nova duração:");
                        String du = scanner.nextLine();
                        voos[i].setDuracao(du);
                        voos[i].setDataModificacao(LocalDate.now());

                        break;

                    case 5:
                        daocompanhiaa.mostra();
                        System.out.print("Digite o ID da nova companhia aérea:");
                        id = Integer.parseInt(scanner.nextLine());
                        voos[i].setCompanhia(daocompanhiaa.buscaPorId(id));
                        voos[i].setDataModificacao(LocalDate.now());

                        break;

                    case 6:
                        System.out.print("Digite a nova capacidade:");
                        long cap = Long.parseLong(scanner.nextLine());
                        voos[i].setCapacidade(cap);
                        voos[i].setDataModificacao(LocalDate.now());

                        break;
                        
                    case 7:
                        System.out.print("Digite o avião:");
                        String avi = scanner.nextLine();
                        voos[i].setAviao(avi);
                        voos[i].setDataModificacao(LocalDate.now());
                       
                    
                        break;
                        
                    default: System.out.println("Opção inválida"); 
                }

                return true;
            }
        }
        return false;
    }

}
