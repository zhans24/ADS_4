package org.example;

import java.util.*;

public class WeightedGraph<V> {
    private ArrayList<Vertex<V>> vertexList;

    public WeightedGraph(){
        vertexList=new ArrayList<>();
    }

    public void addVertex(Vertex<V> vertex){
        vertexList.add(vertex);
    }

    public void addEdge(Vertex<V> vertex1,Vertex<V> vertex2,Double weight){
        chechVertex(vertex1);
        chechVertex(vertex2);
        vertex1.addAdjVertice(vertex2, weight);
        vertex2.addAdjVertice(vertex1, weight);
    }

    public ArrayList<Vertex<V>> getVertexList(){
        return vertexList;
    }

    public Map<Vertex<V>,Double> getAdjList(Vertex<V> vertex){
        return vertex.getAdjVertices();
    }
    public void chechVertex(Vertex<V> vertex){
        if (!vertexList.contains(vertex))
            throw new RuntimeException(vertex.getValue()+" <- this vertex doesn't exist");
    }

    public void removeEdge(Vertex<V> vertex1,Vertex<V> vertex2){
        chechVertex(vertex1);
        chechVertex(vertex2);
        vertex1.removeEdge(vertex2);
        vertex2.removeEdge(vertex1);
    }


    public void bfs(Vertex<V> start){
        Set<Vertex<V>> isVisited=new HashSet<>();
        Queue<Vertex<V>> queue=new LinkedList<>();

        isVisited.add(start);
        queue.add(start);

        while (!queue.isEmpty()){
            Vertex<V> curr=queue.remove();
            System.out.print(curr.getValue()+"-> ");
            for (Vertex<V> vertex:curr.getAdjVertices().keySet()) {
                if (!isVisited.contains(vertex)) {
                    isVisited.add(vertex);
                    queue.add(vertex);
                }
            }
        }

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
