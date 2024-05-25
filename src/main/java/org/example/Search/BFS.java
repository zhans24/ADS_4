package org.example.Search;

import org.example.Graphs.Graph;
import org.example.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class BFS<V> extends Search<V>{
    public BFS(Graph<V> graph, Vertex<V> start) {
        bfs(graph,start);
    }

    /**
     * Performs breadth-first search starting from the given vertex in the graph
     *
     * @param graph The graph to perform BFS on
     * @param start The starting vertex for BFS
     */
    private void bfs(Graph<V> graph,Vertex<V> start){
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
