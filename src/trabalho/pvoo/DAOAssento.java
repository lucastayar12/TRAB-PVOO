package trabalho.pvoo;

import java.time.LocalDate;
import java.util.Scanner;

public class DAOAssento {

    Assento assentos[] = new Assento[10];
    GUI gui = new GUI();
    int op;

    Scanner scanner = new Scanner(System.in);

    int proximaPosicaoLivre() {
        for (int i = 0; i < assentos.length; i++) {
            if (assentos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean inserir(Assento ass) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre == - 1) {
            return false;
        } else {
            assentos[proximaPosicaoLivre] = ass;
            return true;
        }
    }

    public void mostra() {
        for (Assento ass : assentos) {
            if (ass != null) {
                System.out.println(ass.toString());
            }
        }
    }

    public boolean exclui(int id) {
        for (int i = 0; i < assentos.length; i++) {
            Assento ass = assentos[i];
            if (ass != null && ass.getId() == id) {
                assentos[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean altera(int id, DAOVoo daovoo, DAOPassageiro daopassageiro) {
        for (Assento ass : assentos) {
            if (ass != null && ass.getId() == id) {
                op = gui.menuAlteraPassageiro();
                switch (op) {
                    case 1:
                        daovoo.mostra();
                        System.out.print("Digite o ID do novo Vôo:");
                        id = Integer.parseInt(scanner.nextLine());
                        ass.setVoo(daovoo.buscaPorId(id));
                        ass.setDataModificacao(LocalDate.now());
                        break;
                    case 2:
                        System.out.print("Digite o novo Código de Assento:");
                        String cod = scanner.nextLine();
                        ass.setCodAssento(cod);
                        ass.setDataModificacao(LocalDate.now());
                        break;
                    case 3:
                        System.out.print("Digite o ID do novo pssageiro:");
                        id = Integer.parseInt(scanner.nextLine());
                        ass.setPassageiro(daopassageiro.buscaPorId(id));
                        ass.setDataModificacao(LocalDate.now());
                        break;
                }
                return true;
            }
        }
        return false;
    }

    public Assento buscaPorId(int id) {

        for (Assento ass : assentos) {
            if (ass != null && ass.getId() == id) {
                return ass;
            }
        }

        return null;
    }

    public Assento buscarVoo(Voo voo, DAOAssento daoassento) {
        
        Assento assaux;
        for (Assento ass : assentos) {
            if (ass != null && ass.getVoo() == voo) {
                System.out.println(ass.toString());
            }        
        }
        System.out.print("\nDigite o ID do assento:");
	int id = Integer.parseInt(scanner.nextLine());
	return assaux = daoassento.buscaPorId(id);
        
    }

}
