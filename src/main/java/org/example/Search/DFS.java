package org.example.Search;

import org.example.Graphs.Graph;
import org.example.Vertex;

import java.util.Stack;

public class DFS<V> extends Search<V> {
    public DFS(Graph<V> graph, Vertex<V> start) {
        dfs(graph, start);
    }

    /**
     * Performs depth-first search starting from the given vertex in the graph
     *
     * @param graph The graph to perform DFS on
     * @param start The starting vertex for DFS
     */
    private void dfs(Graph<V> graph,Vertex<V> start){
        Stack<Vertex<V>> stack=new Stack<>();

        isVisited.add(start);
        stack.push(start);

        while (!stack.empty()){
            Vertex<V> curr=stack.pop();

            for (Vertex<V> vertex:graph.getAdjList(curr).keySet()) {
                if (!isVisited.contains(vertex)) {
                    isVisited.add(vertex);
                    stack.push(vertex);
                    parentVertices.put(vertex, curr);
                }
            }
        }
    }

}
