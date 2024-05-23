package org.example;

import java.util.ArrayList;

public class WeightedGraph<V> {
    private ArrayList<Vertex<V>> vertexList;

    public WeightedGraph(){
        vertexList=new ArrayList<>();
    }

    public void addVertex(Vertex<V> vertex){
        vertexList.add(vertex);
    }

    public void addEdge(Vertex<V> vertex1,Vertex<V> vertex2,Double weight){
        vertex1.addEdge(vertex2, weight);
        vertex2.addEdge(vertex1, weight);
    }

    public void removeEdge(Vertex<V> vertex1,Vertex<V> vertex2){
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
