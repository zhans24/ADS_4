package org.example.Search;

import org.example.Vertex;
import org.example.Graphs.WeightedGraph;

import java.util.*;

public class Djikstra<V> extends Search<V>{

    private Map<Vertex<V>,Double> distances;
    
    public Djikstra(WeightedGraph<V> graph, Vertex<V> start){
        distances=new HashMap<>();

        ds(graph,start);
    }

    /**
     * Initializes distances with infinite value
     */
    private void putDistances(WeightedGraph<V> graph){
        for (Vertex<V> vertex:graph.getVertexList()) {
            distances.put(vertex, Double.MAX_VALUE);
        }
    }

    /**
     * Performs Dijkstra's algorithm
     *
     * @param graph The weighted graph
     * @param start The starting vertex for Dijkstra's algorithm
     */
    private void ds(WeightedGraph<V> graph, Vertex<V> start) {
        putDistances(graph);
        distances.put(start, 0.0);

        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            Vertex<V> curr=queue.remove();
            isVisited.add(curr);
            Map<Vertex<V>,Double> edges=curr.getAdjVertices();

            for (Vertex<V> vertex:edges.keySet()) {
                Double distance= (edges.get(vertex) + edges.get(vertex));

                if (distance<distances.get(vertex)){
                    distances.put(vertex, distance);
                    queue.add(vertex);
                    parentVertices.put(vertex,curr);
                }
            }
        }
    }
}
