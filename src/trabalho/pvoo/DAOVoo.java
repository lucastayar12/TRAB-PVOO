package trabalho.pvoo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class DAOVoo {

    Scanner scanner = new Scanner(System.in);
    GUI gui = new GUI();

    private Voo[] voos = new Voo[10];
    int op = 0;

    DAOVoo(DAOAeroporto daoaeroporto, DAOCompanhia_A daocompanhiaa, DAOAssento daoassento) {
        Voo v1 = new Voo();
        v1.setOrigem(daoaeroporto.buscaPorId(1));//UBERABA
        v1.setDestino(daoaeroporto.buscaPorId(2));//SÃO PAULO
        v1.setData(LocalDate.of(2021, Month.JULY, 25));
        v1.setDuracao(500);
        v1.setCompanhia(daocompanhiaa.buscaPorId(1));
        v1.setCapacidade(2);
        
        Assento ass = new Assento();
        ass.setVoo(v1);
        ass.setCodAssento("001");
        daoassento.inserir(ass);
        
        Assento ass2 = new Assento();
        ass2.setVoo(v1);
        ass2.setCodAssento("002");
        daoassento.inserir(ass2);
        
        v1.setAviao("BOING 777");
        this.inserir(v1);

        Voo v2 = new Voo();
        v2.setOrigem(daoaeroporto.buscaPorId(2));//SÃO PAULO
        v2.setDestino(daoaeroporto.buscaPorId(4));//LONDRES
        v2.setData(LocalDate.of(2021, Month.JULY, 26));
        v2.setDuracao(12600);
        v2.setCompanhia(daocompanhiaa.buscaPorId(2));
        v2.setCapacidade(2);
        v2.setAviao("BOING 123");
        this.inserir(v2);

        Voo v3 = new Voo();
        v3.setOrigem(daoaeroporto.buscaPorId(2));//SÃO PAULO 
        v3.setDestino(daoaeroporto.buscaPorId(5));//PARIS
        v3.setData(LocalDate.of(2021, Month.JULY, 26));
        v3.setDuracao(10600);
        v3.setCompanhia(daocompanhiaa.buscaPorId(3));
        v3.setCapacidade(2);
        v3.setAviao("BOING 568");
        this.inserir(v3);

        Voo v4 = new Voo();
        v4.setOrigem(daoaeroporto.buscaPorId(3));//NY 
        v4.setDestino(daoaeroporto.buscaPorId(5));//PARIS
        v4.setData(LocalDate.of(2021, Month.JULY, 27));
        v4.setDuracao(7500);
        v4.setCompanhia(daocompanhiaa.buscaPorId(1));
        v4.setCapacidade(2);
        v4.setAviao("BOING 974");
        this.inserir(v4);

        Voo v7 = new Voo();
        v7.setOrigem(daoaeroporto.buscaPorId(5));//NY 
        v7.setDestino(daoaeroporto.buscaPorId(3));//PARIS
        v7.setData(LocalDate.of(2021, Month.JULY, 27));
        v7.setDuracao(7500);
        v7.setCompanhia(daocompanhiaa.buscaPorId(1));
        v7.setCapacidade(2);
        v7.setAviao("BOING 322");
        this.inserir(v7);

        Voo v5 = new Voo();
        v5.setOrigem(daoaeroporto.buscaPorId(3));//NY
        v5.setDestino(daoaeroporto.buscaPorId(4));//LONDRES
        v5.setData(LocalDate.of(2021, Month.JULY, 27));
        v5.setDuracao(8000);
        v5.setCompanhia(daocompanhiaa.buscaPorId(3));
        v5.setCapacidade(2);
        v5.setAviao("BOING 971");
        this.inserir(v5);

        Voo v6 = new Voo();
        v6.setOrigem(daoaeroporto.buscaPorId(4));//LONDRES
        v6.setDestino(daoaeroporto.buscaPorId(5));//PARIS
        v6.setData(LocalDate.of(2021, Month.JULY, 28));
        v6.setDuracao(1500);
        v6.setCompanhia(daocompanhiaa.buscaPorId(2));
        v6.setCapacidade(2);
        v6.setAviao("BOING 111");
        this.inserir(v6);

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

    public boolean altera(int id, DAOAeroporto daoaeroporto, DAOCompanhia_A daocompanhiaa) {
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

    public Voo buscaPorId(int id) {

        for (Voo voo : voos) {
            if (voo != null && voo.getId() == id) {
                return voo;
            }
        }
        return null;
    }

    public Voo verifVooOrigem(int id) {

        for (Voo voo : voos) {
            if (voo != null && voo.getOrigem().getId() == id) {
                return voo;
            }
        }
        return null;
    }

    public Voo verifVooDestino(int id) {

        for (Voo voo : voos) {
            if (voo != null && voo.getDestino().getId() == id) {
                return voo;
            }
        }
        return null;
    }
}
