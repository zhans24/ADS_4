package org.example;

import java.util.HashMap;
import java.util.Map;

public class Vertex<V>{
    private V value;
    private Map<Vertex<V>,Double> adjVertices;

    public Vertex(V value){
        this.value=value;
        this.adjVertices=new HashMap<>();
    }

    public void addAdjVertice(Vertex<V> vertex,Double weight){
        adjVertices.put(vertex,weight);
    }

    public void removeEdge(Vertex<V> vertex){
        adjVertices.remove(vertex);
    }

    public V getValue() {
        return value;
    }

    public Map<Vertex<V>, Double> getAdjVertices() {
        return adjVertices;
    }

    @Override
    public boolean equals(Object o){
        if (this==o)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex<?> vertex=(Vertex<?>) o;
        return this.value.equals(vertex.value);
    }

}
