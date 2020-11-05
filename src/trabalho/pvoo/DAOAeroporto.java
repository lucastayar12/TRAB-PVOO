/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.pvoo;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
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
        
        Aeroporto ae2 = new Aeroporto();
        ae2.setNome("Aeroporto de Paris");
        ae2.setCidade("Paris");
        ae2.setAbreviacao("PAR");
        this.inserir(ae2);
        
        Aeroporto ae3 = new Aeroporto();
        ae3.setNome("Aeroporto de Londres");
        ae3.setCidade("Londres");
        ae3.setAbreviacao("LON");
        this.inserir(ae3);
        
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
        for (int i = 0; i < aeroportos.length; i++) {
            Aeroporto aeroporto = aeroportos[i];
            if (aeroporto != null && aeroporto.getId() == id) {
                
                op = gui.menuAlteraAeroporto();
                
                switch(op)
                {
                    case 1:
                        System.out.print("Digite o novo nome:");
                        String nome = scanner.nextLine();
                        aeroportos[i].setNome(nome);
                        aeroportos[i].setDataModificacao(LocalDate.now());
                       
                        break;
                    case 2:
                        System.out.print("Digite a nova cidade:");
                        String cid = scanner.nextLine();
                        aeroportos[i].setCidade(cid);
                        aeroportos[i].setDataModificacao(LocalDate.now());
                        break;
                    case 3:
                        System.out.print("Digite a nova abreviação:");
                        String abrev = scanner.nextLine();
                        aeroportos[i].setAbreviacao(abrev);
                        aeroportos[i].setDataModificacao(LocalDate.now());
                        break;
                }
                
                return true;
            }
        }
        return false;
    }
    
}