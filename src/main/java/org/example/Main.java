package org.example;


public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph=new WeightedGraph<>();
        Vertex<String> vertex1=new Vertex<>("a");
        Vertex<String> vertex2=new Vertex<>("b");
        Vertex<String> vertex3=new Vertex<>("c");
        Vertex<String> vertex4=new Vertex<>("d");

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);

        graph.addEdge(vertex1, vertex2, 5.0);
        graph.addEdge(vertex2, vertex3, 3.0);
        graph.addEdge(vertex1, vertex4,4.1 );

        graph.dfs(vertex1);

    }
}