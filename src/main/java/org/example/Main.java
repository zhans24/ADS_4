package org.example;


import org.example.Search.Djikstra;
import org.example.Search.Search;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph=new WeightedGraph<>();
        Vertex<String> a=new Vertex<>("a");
        Vertex<String> b=new Vertex<>("b");
        Vertex<String> e=new Vertex<>("e");
        Vertex<String> c=new Vertex<>("c");
        Vertex<String> d=new Vertex<>("d");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);

        graph.addEdge(a, b, 3.0);
        graph.addEdge(b, e, 8.0);
        graph.addEdge(a, c,6.0 );
        graph.addEdge(a, d, 1.0);
        graph.addEdge(d, e, 12.0);
        graph.addEdge(a, c, 6.0);
        graph.addEdge(c, e, 4.0);
        graph.addEdge(d, c, 4.0);

        Search<String> djikstra=new Djikstra<>(graph, a);
        showPathTo(djikstra, e);


    }

    public static <V> void  showPathTo(Search<V> search,Vertex<V> target){
        for (Vertex<?> vertex:search.pathTo(target)) {
            System.out.print(vertex.getValue()+"->");
        }
    }
}