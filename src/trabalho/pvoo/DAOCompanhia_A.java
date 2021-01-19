package trabalho.pvoo;

import java.time.LocalDate;
import java.util.Scanner;
import trabalho.pvoo.Companhia_A;
import trabalho.pvoo.GUI;

public class DAOCompanhia_A {

    Scanner scanner = new Scanner(System.in);
    GUI gui = new GUI();

    private Companhia_A[] companhiaas = new Companhia_A[10];
    int op = 0;

    DAOCompanhia_A() {
        Companhia_A ca = new Companhia_A();
        ca.setNome("GOL");
        ca.setAbreviacao("GOL");
        this.inserir(ca);

        Companhia_A ca1 = new Companhia_A();
        ca1.setNome("TAM");
        ca1.setAbreviacao("TAM");
        this.inserir(ca1);

        Companhia_A ca2 = new Companhia_A();
        ca2.setNome("Azul Cargo");
        ca2.setAbreviacao("AZUL");
        this.inserir(ca2);
    }

    int proximaPosicaoLivre() {
        for (int i = 0; i < companhiaas.length; i++) {
            if (companhiaas[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean inserir(Companhia_A ca) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre == - 1) {
            return false;
        } else {
            companhiaas[proximaPosicaoLivre] = ca;
            return true;
        }
    }

    public void mostra() {
        for (Companhia_A companhiaa : companhiaas) {
            if (companhiaa != null) {
                System.out.println(companhiaa.toString());
            }
        }
    }

    public boolean exclui(int id) {
        for (int i = 0; i < companhiaas.length; i++) {
            Companhia_A companhiaa = companhiaas[i];
            if (companhiaa != null && companhiaa.getId() == id) {
                companhiaas[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean altera(int id) {
        for (Companhia_A companhiaa : companhiaas) {
            if (companhiaa != null && companhiaa.getId() == id) {
                op = gui.menuAlteraComapanhia_A();
                switch (op) {
                    case 1:
                        System.out.print("Digite o novo nome:");
                        String nome = scanner.nextLine();
                        companhiaa.setNome(nome);
                        companhiaa.setDataModificacao(LocalDate.now());
                        break;
                    case 2:
                        System.out.print("Digite a nova abreviação:");
                        String abrev = scanner.nextLine();
                        companhiaa.setAbreviacao(abrev);
                        companhiaa.setDataModificacao(LocalDate.now());
                        break;
                }
                return true;
            }
        }
        return false;
    }

    public Companhia_A buscaPorId(int id) {

        for (Companhia_A companhiaa : companhiaas) {
            if (companhiaa != null && companhiaa.getId() == id) {
                return companhiaa;
            }
        }

        return null;
    }

}
