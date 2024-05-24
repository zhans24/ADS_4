package org.example.Search;

import org.example.Vertex;

import java.util.*;

public abstract class Search<V> {
    protected Set<Vertex<V>> isVisited;
    protected Map<Vertex<V>,Vertex<V>> parentVertices;

    public Search(){
        this.isVisited=new HashSet<>();
        this.parentVertices=new HashMap<>();
    }

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
