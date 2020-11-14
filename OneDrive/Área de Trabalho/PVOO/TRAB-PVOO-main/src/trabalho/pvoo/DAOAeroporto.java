package trabalho.pvoo;

import java.time.LocalDate;
import java.util.Scanner;

public class DAOAeroporto {

    Scanner scanner = new Scanner(System.in);
    GUI gui = new GUI();

    private Aeroporto[] aeroportos = new Aeroporto[10];
    int op = 0;

    public DAOAeroporto() {

        Aeroporto ae = new Aeroporto();
        ae.setNome("Aeroporto de São Paulo");
        ae.setCidade("São Paulo");
        ae.setAbreviacao("SP");
        this.inserir(ae);

        Aeroporto ae4 = new Aeroporto();
        ae4.setNome("Aeroporto de Uberaba");
        ae4.setCidade("Uberaba");
        ae4.setAbreviacao("URA");
        this.inserir(ae4);

        Aeroporto ae5 = new Aeroporto();
        ae5.setNome("Aeroporto de Nova Iorque");
        ae5.setCidade("Nova Iorque");
        ae5.setAbreviacao("NY");
        this.inserir(ae5);

        Aeroporto ae3 = new Aeroporto();
        ae3.setNome("Aeroporto de Londres");
        ae3.setCidade("Londres");
        ae3.setAbreviacao("LON");
        this.inserir(ae3);

        Aeroporto ae2 = new Aeroporto();
        ae2.setNome("Aeroporto de Paris");
        ae2.setCidade("Paris");
        ae2.setAbreviacao("PAR");
        this.inserir(ae2);

    }

    int proximaPosicaoLivre() {
        for (int i = 0; i < aeroportos.length; i++) {
            if (aeroportos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean inserir(Aeroporto ae) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre == - 1) {
            return false;
        } else {
            aeroportos[proximaPosicaoLivre] = ae;
            return true;
        }
    }

    public void mostra() {
        for (Aeroporto aeroporto : aeroportos) {
            if (aeroporto != null) {
                System.out.println(aeroporto.toString());
            }
        }
    }

    public boolean exclui(int id) {
        for (int i = 0; i < aeroportos.length; i++) {
            Aeroporto aeroporto = aeroportos[i];
            if (aeroporto != null && aeroporto.getId() == id) {
                aeroportos[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean altera(int id) {
        for (Aeroporto aeroporto : aeroportos) {
            if (aeroporto != null && aeroporto.getId() == id) {
                op = gui.menuAlteraAeroporto();
                switch (op) {
                    case 1:
                        System.out.print("Digite o novo nome:");
                        String nome = scanner.nextLine();
                        aeroporto.setNome(nome);
                        aeroporto.setDataModificacao(LocalDate.now());
                        break;
                    case 2:
                        System.out.print("Digite a nova cidade:");
                        String cid = scanner.nextLine();
                        aeroporto.setCidade(cid);
                        aeroporto.setDataModificacao(LocalDate.now());
                        break;
                    case 3:
                        System.out.print("Digite a nova abreviação:");
                        String abrev = scanner.nextLine();
                        aeroporto.setAbreviacao(abrev);
                        aeroporto.setDataModificacao(LocalDate.now());
                        break;
                }
                return true;
            }
        }
        return false;
    }

    public Aeroporto buscaPorId(int id) {

        for (Aeroporto aeroporto : aeroportos) {
            if (aeroporto != null && aeroporto.getId() == id) {
                return aeroporto;
            }
        }
        return null;
    }

}
