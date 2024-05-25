package org.example.Search;

import org.example.Vertex;
import org.example.WeightedGraph;

import java.util.Stack;

public class DFS<V> extends Search<V> {
    public DFS(WeightedGraph<V> graph,Vertex<V> start) {
        dfs(graph, start);
    }

    private void dfs(WeightedGraph<V> graph,Vertex<V> start){
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
