package trabalho.pvoo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class DAOVoo {

    DAOAeroporto daoaeroporto = new DAOAeroporto();
    DAOCompanhia_A daocompanhiaa = new DAOCompanhia_A();
    Scanner scanner = new Scanner(System.in);
    GUI gui = new GUI();

    private Voo[] voos = new Voo[10];
    int op = 0;

    DAOVoo() {
        Voo v1 = new Voo();
        v1.setOrigem(daoaeroporto.buscaPorId(2));//UBERABA
        v1.setDestino(daoaeroporto.buscaPorId(1));//SÃO PAULO
        v1.setData(LocalDate.of(2021, Month.JULY, 25));
        v1.setDuracao(500);
        v1.setCompanhia(daocompanhiaa.buscaPorId(1));
        v1.setCapacidade(2);
        v1.setAviao("BOING 777");
        this.inserir(v1);

    }

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
                        int du = Integer.parseInt(scanner.nextLine());
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

                    default:
                        System.out.println("Opção inválida");
                }

                return true;
            }
        }
        return false;
    }

    public Voo criaVoo() {

        Scanner scanner = new Scanner(System.in);
        Voo voo = new Voo();

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
        int duracao = Integer.parseInt(scanner.nextLine());
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
    
    public Voo buscaPorId(int id){
        
        Voo voof = new Voo();
        
        for (Voo voo : voos) {
            if (voo != null && voo.getId() == id) {
                voof = voo;
            }
        }
        
       return voof;
    }
}
