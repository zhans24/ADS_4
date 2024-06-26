package org.example.Search;

import org.example.Vertex;

import java.util.*;

public abstract class Search<V> {
    protected Set<Vertex<V>> isVisited=new HashSet<>();;
    protected Map<Vertex<V>,Vertex<V>> parentVertices=new HashMap<>();

    /**
     * Returns the path from the start vertex to the target vertex
     *
     * @param target The target vertex to find the path to
     * @return An Iterable representing the path from the start vertex to the target vertex
     */
    public Iterable<Vertex<V>> pathTo(Vertex<V> target) {
        if (!isVisited.contains(target))
            throw new RuntimeException("Vertex doesn't exist");

        LinkedList<Vertex<V>> path=new LinkedList<>();
        Vertex<V> curr=target;

        while (curr!=null){
            path.push(curr);
            curr=parentVertices.get(curr);
        }

        return path;
    }
}
