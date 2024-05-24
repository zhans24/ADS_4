package org.example.Search;

import org.example.Vertex;
import org.example.WeightedGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Search<V> {
    protected Set<Vertex<V>> isVisited;
    protected Map<Vertex<V>,Vertex<V>> parentVertices;


    public Search(Vertex<V> start){
        this.isVisited=new HashSet<>();
        this.parentVertices=new HashMap<>();
    }

    public abstract Iterable<Vertex<V>> pathTo(Vertex<V> start);
}
