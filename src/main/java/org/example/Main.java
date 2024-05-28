package org.example;


import org.example.Graphs.Graph;
import org.example.Graphs.WeightedGraph;
import org.example.Search.BFS;
import org.example.Search.DFS;
import org.example.Search.Djikstra;
import org.example.Search.Search;

public class Main {
    static Vertex<String> Almaty;
    static Vertex<String> Astana;
    static Vertex<String> Shymkent;
    static Vertex<String> Kostanay;
    static Vertex<String> Kyzylorda;
    static Vertex<String> Atyrau;

    public static void main(String[] args) {

        WeightedGraph<String> weightedGraph = new WeightedGraph<>();
        fillWithWeights(weightedGraph);
        System.out.println("Dijkstra:");
        Search<String> djk = new Djikstra<>(weightedGraph, Almaty);
        showPathTo(djk, Kyzylorda);

        System.out.println("\n--------------------------------");

        Graph<String> graph = new Graph<>();
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DFS<>(graph, Almaty);
        showPathTo(dfs, Kyzylorda);

        System.out.println("\n--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BFS<>(graph, Almaty);
        showPathTo(bfs, Kyzylorda);
    }

    public static void fillWithoutWeights(Graph<String> graph) {
        Almaty=new Vertex<>("Almaty");
        Astana=new Vertex<>("Astana");
        Shymkent=new Vertex<>("Shymkent");
        Kostanay=new Vertex<>("Kostanay");
        Kyzylorda=new Vertex<>("Kyzylorda");
        Atyrau=new Vertex<>("Atyrau");

        graph.addVertex(Almaty);
        graph.addVertex(Astana);
        graph.addVertex(Shymkent);
        graph.addVertex(Kostanay);
        graph.addVertex(Kyzylorda);
        graph.addVertex(Atyrau);

        graph.addEdge(Almaty, Astana);
        graph.addEdge(Shymkent, Atyrau);
        graph.addEdge(Atyrau, Astana);
        graph.addEdge(Almaty, Shymkent);
        graph.addEdge(Astana, Kostanay);
        graph.addEdge(Shymkent, Kyzylorda);
    }

    public static void fillWithWeights(WeightedGraph<String> weightedGraph) {
        Almaty=new Vertex<>("Almaty");
        Astana=new Vertex<>("Astana");
        Shymkent=new Vertex<>("Shymkent");
        Kostanay=new Vertex<>("Kostanay");
        Kyzylorda=new Vertex<>("Kyzylorda");
        Atyrau=new Vertex<>("Atyrau");

        weightedGraph.addVertex(Almaty);
        weightedGraph.addVertex(Astana);
        weightedGraph.addVertex(Shymkent);
        weightedGraph.addVertex(Kostanay);
        weightedGraph.addVertex(Kyzylorda);
        weightedGraph.addVertex(Atyrau);

        weightedGraph.addEdge(Almaty, Astana, 2.1);
        weightedGraph.addEdge(Shymkent, Atyrau, 7.8);
        weightedGraph.addEdge(Atyrau, Astana, 7.1);
        weightedGraph.addEdge(Almaty, Shymkent, 7.2);
        weightedGraph.addEdge(Shymkent, Astana, 3.9);
        weightedGraph.addEdge(Astana, Kostanay, 3.5);
        weightedGraph.addEdge(Shymkent, Kyzylorda, 5.4);
    }

    public static <V> void  showPathTo(Search<V> search,Vertex<V> target){
        for (Vertex<?> vertex:search.pathTo(target)) {
            System.out.print(vertex.getValue()+"->");
        }
    }

}
