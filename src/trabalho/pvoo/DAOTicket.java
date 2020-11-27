package trabalho.pvoo;

public class DAOTicket {
    
    private Ticket [] tks = new Ticket[10];
    
    int proximaPosicaoLivre() {
        for (int i = 0; i < tks.length; i++) {
            if (tks[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean inserir(Ticket tk) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre == - 1) {
            return false;
        } else {
            tks[proximaPosicaoLivre] = tk;
            return true;
        }
    }

    public void mostra() {
        for (Ticket tk : tks) {
            if (tk != null) {
                System.out.println(tk.toString());
            }
        }
    }

    public boolean exclui(int id) {
        for (int i = 0; i < tks.length; i++) {
            Ticket tk = tks[i];
            if (tk != null && tk.getId() == id) {
                tks[i] = null;
                return true;
            }
        }
        return false;
    }
   
    
}
