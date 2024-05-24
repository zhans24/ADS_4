package org.example.Search;

import org.example.Vertex;
import org.example.WeightedGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class DFS<V> extends Search<V> {
    public DFS(WeightedGraph<V> graph,Vertex<V> start) {
        super(start);

        dfs(graph, start);
    }

    public void dfs(WeightedGraph<V> graph,Vertex<V> start){
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

    @Override
    public Iterable<Vertex<V>> pathTo(Vertex<V> start) {
        if (!isVisited.contains(start))
            throw new RuntimeException("Vertex doesn't exist");

        LinkedList<Vertex<V>> path=new LinkedList<>();
        Vertex<V> curr=start;

        while (curr!=null){
            path.push(curr);
            curr=parentVertices.get(curr);
        }

        return path;
    }
}
