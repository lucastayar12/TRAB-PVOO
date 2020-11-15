/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.pvoo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author eduardoasilvestre
 */
public class TestDijkstraAlgorithm1 {

    private List<Vertex> nodes;
    private List<Edge> edges;
    DAOTicket daoticket = new DAOTicket();

    public void Executa(Voo voo) {

        CidadesDistancia c1 = new CidadesDistancia("UBERABA", "SAO PAULO", 500);

        //...
        //...
        Aeroporto origem = voo.getOrigem();
        Aeroporto destino = voo.getDestino();

        int ido = origem.getId() - 1;
        int idd = destino.getId() - 1;

        Graph graph = this.createGraph();
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        //source
        dijkstra.execute(nodes.get(ido));
        //destination
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(idd));

        //Total distance
        int totalDistance = 0;
        path.size();
        for (Vertex vertex : path) {
            System.out.println(vertex);
        }

    }

    public double Executa2(int id, int id2, DAOVoo daovoo, Passageiro p) {

        CidadesDistancia c1 = new CidadesDistancia("UBERABA", "SAO PAULO", 500);
        //...
        //...

        double valorTotal = 0;

        Voo vooo = daovoo.verifVooOrigem(id);
        Voo vood = daovoo.verifVooDestino(id2);

        Ticket ticket = new Ticket();
        ticket.setVoo(vooo);
        ticket.setPassageiro(p);
        ticket.setValor(100);
        daoticket.inserir(ticket);
        
        vooo.setEstado("Executado");

        valorTotal = valorTotal + ticket.getValor();

        

        int cont = 0;

        int ido = id - 1;
        int idd = id2 - 1;

        Graph graph = this.createGraph();
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        //source
        dijkstra.execute(nodes.get(ido));
        //destination
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(idd));

        //Total distance
        int totalDistance = 0;
        path.size();
        for (Vertex vertex : path) {
            System.out.println(vertex);
            
            if (cont > 2) {
                Ticket tnew = new Ticket();
                tnew.setVoo(daovoo.buscaPorId(cont));
                tnew.setPassageiro(p);
                tnew.setValor(100);
                daoticket.inserir(tnew);
                
                Voo voo = daovoo.buscaPorId(cont);
                voo.setEstado("Executado");
                

                valorTotal = valorTotal + tnew.getValor();
            }
            cont++;
            
            if(cont == path.size() && cont <= 2){
                
                ticket.setVoo(vooo);
                Voo voo = daovoo.buscaPorId(cont);
                voo.setEstado("Executado");
            }
            
            if(cont == path.size() && cont > 2){
                Ticket tf = new Ticket();
                tf.setVoo(vood);
                tf.setPassageiro(p);
                tf.setValor(100);
                daoticket.inserir(tf);
                
                Voo voo = daovoo.buscaPorId(cont);
                voo.setEstado("Executado");
                

                valorTotal = valorTotal + tf.getValor();
            }
            

        }
        
        daoticket.mostra();
        
        
        return valorTotal;

    }

    private Graph createGraph() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();

        int i = 1;
        Vertex UBERABA = new Vertex("Node_" + i++, "UBERABA");
        nodes.add(UBERABA);
        Vertex SAOPAULO = new Vertex("Node_" + i++, "SAOPAULO");
        nodes.add(SAOPAULO);
        Vertex NOVAIORQUE = new Vertex("Node_" + i++, "NOVAIORQUE");
        nodes.add(NOVAIORQUE);
        Vertex LONDRES = new Vertex("Node_" + i++, "LONDRES");
        nodes.add(LONDRES);
        Vertex PARIS = new Vertex("Node_" + i++, "PARIS");
        nodes.add(PARIS);

        //UBERABA: 0
        //SAOPAULO: 1
        //NOVAIORQUE: 2
        //LONDRES: 3
        //PARIS: 4
        i = 1;
        //Uberaba <-> São Paulo = 500
        edges.add(this.createLane("Edge_" + i++, 0, 1, 500));
        edges.add(this.createLane("Edge_" + i++, 1, 0, 500));

        //São Paulo <–> Nova Iorque = 10200
        //edges.add(this.createLane("Edge_1", 1, 2, 10200));
        //edges.add(this.createLane("Edge_1", 2, 1, 10200));
        //São Paulo <–> Londres = 12600
        edges.add(this.createLane("Edge_" + i++, 1, 3, 12600));
        edges.add(this.createLane("Edge_" + i++, 3, 1, 12600));

        //São Paulo <–> Paris = 10600
        edges.add(this.createLane("Edge_" + i++, 1, 4, 10600));
        edges.add(this.createLane("Edge_" + i++, 4, 1, 10600));

        //Nova Iorque <–> Londres = 8000
        edges.add(this.createLane("Edge_" + i++, 2, 3, 8000));
        edges.add(this.createLane("Edge_" + i++, 3, 2, 8000));

        //Nova Iorque <–> Paris = 7500
        edges.add(this.createLane("Edge_" + i++, 2, 4, 7500));
        edges.add(this.createLane("Edge_" + i++, 4, 2, 7500));

        //Londres <–> Paris = 1500
        edges.add(this.createLane("Edge_" + i++, 3, 4, 1500));
        edges.add(this.createLane("Edge_" + i++, 4, 3, 1500));

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        return graph;
    }

    private Edge createLane(String laneId, int sourceLocNo, int destLocNo,
            int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        return lane;
    }
}
