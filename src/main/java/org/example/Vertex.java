package org.example;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter //Getter to the fields using lombok
public class Vertex<V>{
    private V value;
    private Map<Vertex<V>,Double> adjVertices;

    public Vertex(V value){
        this.value=value;
        this.adjVertices=new HashMap<>();
    }

    /**
     * Adds an adjacent vertex with a given weight
     *
     * @param vertex The adjacent vertex to be added
     * @param weight The weight of the edge to the adjacent vertex
     */
    public void addAdjVertice(Vertex<V> vertex,Double weight){
        adjVertices.put(vertex,weight);
    }

    /**
     * Removes the edge to the specified adjacent vertex
     *
     * @param vertex The adjacent vertex to remove the edge to
     */
    public void removeEdge(Vertex<V> vertex){
        adjVertices.remove(vertex);
    }


    /**
     * Overridden equals method
     *
     * @param o The object to compare
     * @return True or false
     */
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
