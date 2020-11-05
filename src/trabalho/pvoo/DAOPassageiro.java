package trabalho.pvoo;

import java.time.LocalDate;
import java.util.Scanner;

public class DAOPassageiro {
    
    Scanner scanner = new Scanner(System.in);
    private Passageiro[] passageiros = new Passageiro[10];
    int op = 0;

    public DAOPassageiro() {
        Passageiro p1 = new Passageiro();
        p1.setNome("Suzane Hichtoffen");
        p1.setNascimento("11/02/1986");
        p1.setDocumento("2131591851-10");
        this.inserir(p1);
        
        Passageiro p2 = new Passageiro();
        p2.setNome("Bruno Goleiro");
        p2.setNascimento("10/05/1980");
        p2.setDocumento("1929529520-85");
        this.inserir(p2);
        
        Passageiro p3 = new Passageiro();
        p3.setNome("Adailton");
        p3.setNascimento("28/06/1983");
        p3.setDocumento("1849840068-32");
        this.inserir(p3);
        
    }

    int proximaPosicaoLivre() {
        for (int i = 0; i < passageiros.length; i++) {
            if (passageiros[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean inserir(Passageiro p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre == - 1) {
            return false;
        } else {
            passageiros[proximaPosicaoLivre] = p;
            return true;
        }
    }

    public void mostra() {
        for (Passageiro passageiro : passageiros) {
            if (passageiro != null) {
                System.out.println(passageiro.toString());
            }
        }
    }

    public boolean exclui(int id) {
        for (int i = 0; i < passageiros.length; i++) {
            Passageiro passageiro = passageiros[i];
            if (passageiro != null && passageiro.getId() == id) {
                passageiros[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean altera(int id) {
        for (int i = 0; i < passageiros.length; i++) {
            Passageiro passageiro = passageiros[i];
            if (passageiro != null && passageiro.getId() == id) {
                System.out.println("1- Altera nome");
                System.out.println("2- Altera documento");
                System.out.println("3- Altera Data de nascimento");
                System.out.print("Digite uma opção:");
                op = Integer.parseInt(scanner.nextLine());
                
                switch(op)
                {
                    case 1:
                        System.out.print("Digite o novo nome:");
                        String nome = scanner.nextLine();
                        passageiros[i].setNome(nome);
                        passageiros[i].setDataModificacao(LocalDate.now());
                       
                        break;
                    case 2:
                        System.out.print("Digite o novo documento:");
                        String doc = scanner.nextLine();
                        passageiros[i].setDocumento(doc);
                        passageiros[i].setDataModificacao(LocalDate.now());
                        break;
                    case 3:
                        System.out.print("Dgite a nova data de nascimento:");
                        String dt_nasc = scanner.nextLine();
                        passageiros[i].setNascimento(dt_nasc);
                        passageiros[i].setDataModificacao(LocalDate.now());
                        break;
                }
                
                return true;
            }
        }
        return false;
    }

}
