package org.example.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Edge {

    private final Vertex u;
    private final Vertex v;


    public Vertex getAnother(Vertex u){
        if (u == this.u){
            return v;
        } else {
            return this.u;
        }
    }

    public boolean equals(Edge e){
        if (e.u == this.u && e.v == this.v){
            return true;
        } else {
            return false;
        }
    }

}
