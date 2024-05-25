package org.example.Search;

import org.example.Vertex;
import org.example.WeightedGraph;

import java.util.*;

public class Djikstra<V> extends Search<V>{

    private Map<Vertex<V>,Double> distances;
    public Djikstra(WeightedGraph<V> graph, Vertex<V> start){
        distances=new HashMap<>();

        ds(graph,start);
    }

    private void putDistances(WeightedGraph<V> graph){
        for (Vertex<V> vertex:graph.getVertexList()) {
            distances.put(vertex, Double.MAX_VALUE);
        }
    }

    private void ds(WeightedGraph<V> graph, Vertex<V> start) {
        putDistances(graph);
        distances.put(start, 0.0);

        Queue<Vertex<V>> queue = new PriorityQueue<>();
        queue.add(start);

        while (!queue.isEmpty()){}
    }
}
