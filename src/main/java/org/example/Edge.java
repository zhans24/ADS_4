package org.example;

import lombok.Data;

@Data // for getters&setters,equal methods
public class Edge<V> {
    private Vertex<V> start;
    private Vertex<V> end;
    private Double weight;

    public Edge(Vertex<V> start, Vertex<V> end, Double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;

    }
}
