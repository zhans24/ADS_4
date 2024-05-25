package org.example.Search;

import org.example.Vertex;
import org.example.WeightedGraph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS<V> extends Search<V>{
    public BFS(WeightedGraph<V> graph, Vertex<V> start) {
        bfs(graph,start);
    }

    private void bfs(WeightedGraph<V> graph,Vertex<V> start){
        Queue<Vertex<V>> queue=new LinkedList<>();

        isVisited.add(start);
        queue.add(start);

        while (!queue.isEmpty()){
            Vertex<V> curr=queue.remove();

            for (Vertex<V> vertex:graph.getAdjList(curr).keySet()) {
                if (!isVisited.contains(vertex)) {
                    isVisited.add(vertex);
                    queue.add(vertex);
                    parentVertices.put(vertex, curr);
                }
            }
        }
    }

}
