package org.example.Graphs;

import org.example.Vertex;

import java.util.*;

public class WeightedGraph<V> {
    private ArrayList<Vertex<V>> vertexList;

    public WeightedGraph(){
        vertexList=new ArrayList<>();
    }

    /**
     * Adds a vertex to the graph
     *
     * @param vertex The vertex to add
     */
    public void addVertex(Vertex<V> vertex){
        vertexList.add(vertex);
    }

    /**
     * Adds an edge between two vertices in the graph
     *
     * @param vertex1 The first vertex
     * @param vertex2 The second vertex
     */
    public void addEdge(Vertex<V> vertex1,Vertex<V> vertex2,Double weight){
        chechVertex(vertex1);
        chechVertex(vertex2);
        vertex1.addAdjVertice(vertex2, weight);
        vertex2.addAdjVertice(vertex1, weight);
    }

    /**
     * Getter
     * @return The list of vertices in the graph
     */
    public ArrayList<Vertex<V>> getVertexList(){
        return vertexList;
    }

    /**
     * Retrieves the adjacency list for a given vertex
     *
     * @param vertex The vertex to get the adjacency list for
     * @return The adjacency list for the vertex
     */
    public Map<Vertex<V>,Double> getAdjList(Vertex<V> vertex){
        return vertex.getAdjVertices();
    }

    /**
     * Checks if the vertex exists in the graph
     *
     * @param vertex The vertex to check
     */
    public void chechVertex(Vertex<V> vertex){
        if (!vertexList.contains(vertex))
            throw new RuntimeException(vertex.getValue()+" <- this vertex doesn't exist");
    }

    /**
     * Removes an edge between two vertices in the graph
     *
     * @param vertex1 The first vertex
     * @param vertex2 The second vertex
     */
    public void removeEdge(Vertex<V> vertex1,Vertex<V> vertex2){
        chechVertex(vertex1);
        chechVertex(vertex2);
        vertex1.removeEdge(vertex2);
        vertex2.removeEdge(vertex1);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("{");
        for (Vertex<V> vertex:vertexList) {
            sb.append(vertex.getValue()+":");
            sb.append("[");
            for (Vertex<V> v:vertex.getAdjVertices().keySet()) {
                sb.append(v.getValue());
                sb.append(",");
            }
            if (sb.lastIndexOf(",")!=-1) sb.deleteCharAt(sb.lastIndexOf(","));

            sb.append("] ");
            if (!vertexList.getLast().equals(vertex)) sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}
