
package trabalho.pvoo;

import java.util.Scanner;

public class DAOVoo {
    
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
    
}
