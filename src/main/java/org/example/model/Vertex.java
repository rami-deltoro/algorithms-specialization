package org.example.model;

import java.util.ArrayList;

public class Vertex {

    public int id;
    public ArrayList<Edge> neighbours;

    public Vertex(int id){
        this.id = id;
        neighbours = new ArrayList<Edge>();
    }
}
