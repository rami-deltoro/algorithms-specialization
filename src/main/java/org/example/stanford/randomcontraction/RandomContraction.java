package org.example.stanford.randomcontraction;

import org.example.model.Edge;
import org.example.model.Vertex;

import java.util.*;

public class RandomContraction {

    final Random generator = new Random();


    public int removeEdge(Graph graph,Vertex u, Vertex v){
        final Map<Integer, Vertex> vertices = graph.getVertices();
        final List<Edge> edges = graph.getEdges();

        int count = 0;
        int idU = u.id;
        int idV = v.id;
        Edge e = new Edge(vertices.get(Math.min(idU, idV)), vertices.get(Math.max(idU, idV)));
        for (int i = 0; i < u.neighbours.size(); i++){
            if (u.neighbours.get(i).equals(e)){
                u.neighbours.remove(i);
                i--;
            }
        }
        for (int i = 0; i < v.neighbours.size(); i++){
            if (v.neighbours.get(i).equals(e)){
                v.neighbours.remove(i);
                i--;
            }
        }
        for (int i = 0; i < edges.size(); i++){
            if (edges.get(i).equals(e)){
                edges.remove(i);
                i--;
                count++;
            }
        }
        return count;
    }

    public void randomContract(Graph graph){
        final Map<Integer, Vertex> vertices = graph.getVertices();
        final List<Edge> edges = graph.getEdges();

        while (vertices.size() > 2){
            int index = generator.nextInt(edges.size());
            Edge toRemove = edges.get(index);
            int idV = toRemove.getV().id;
            Vertex u = toRemove.getU();
            Vertex v = toRemove.getV();
            removeEdge(graph,u, v);
            while (!v.neighbours.isEmpty()){
                Vertex w = v.neighbours.get(0).getAnother(v);
                graph.addEdge(u, w, removeEdge(graph,v, w));
            }
            vertices.remove(idV);
        }
    }

    public int findMinCut(Graph graph) {
        final Map<Integer, Vertex> vertices = graph.getVertices();
        int n = vertices.size();
        int minCut = n;
        //WARNING: Please change the value of nRepeat to a much smaller one (e.g. n)
        //if you want the program run faster! However, n^2 * ln(n) times of repeat
        //would ensure a (1-1/n) rate of success on finding the minCut.
        //int nRepeat = (int) (Math.pow(n, 2) * Math.log(n)); //Please read Warning above!
        int nRepeat = n; //You can change to this one.
        for (int i = 0; i < nRepeat; i++){
            randomContract(graph);
            int crossingEdges = graph.getEdges().size();
            if (crossingEdges < minCut){
                minCut = crossingEdges;
            }
        }
        return minCut;
    }


}
