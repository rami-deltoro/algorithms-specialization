package org.example.stanford.randomcontraction;

import org.example.model.Edge;
import org.example.model.Vertex;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

public class RandomContraction {

    public int removeEdge(Graph graph,Vertex u, Vertex v){
        final Hashtable<Integer, Vertex> vertices = graph.getVertices();
        final ArrayList<Edge> edges = graph.getEdges();

        int count = 0;
        int idU = u.id;
        int idV = v.id;
        Edge e = new Edge(vertices.get(Math.min(idU, idV)), vertices.get(Math.max(idU, idV)));
        for (int i = 0; i < u.neighbours.size(); i++){
            if (u.neighbours.get(i).isSame(e)){
                u.neighbours.remove(i);
                i--;
            }
        }
        for (int i = 0; i < v.neighbours.size(); i++){
            if (v.neighbours.get(i).isSame(e)){
                v.neighbours.remove(i);
                i--;
            }
        }
        for (int i = 0; i < edges.size(); i++){
            if (edges.get(i).isSame(e)){
                edges.remove(i);
                i--;
                count++;
            }
        }
        return count;
    }

    public void randomContract(Graph graph){
        final Hashtable<Integer, Vertex> vertices = graph.getVertices();
        final ArrayList<Edge> edges = graph.getEdges();
        final Random generator = new Random();

        while (vertices.size() > 2){
            int index = generator.nextInt(edges.size());
            Edge toRemove = edges.get(index);
            int idV = toRemove.v.id;
            Vertex u = toRemove.u;
            Vertex v = toRemove.v;
            removeEdge(graph,u, v);
            while (v.neighbours.size() > 0){
                Vertex w = v.neighbours.get(0).getAnother(v);
                graph.addEdge(u, w, removeEdge(graph,v, w));
            }
            vertices.remove(idV);
        }
    }

    public int findMinCut(Graph graph) {
        final Hashtable<Integer, Vertex> vertices = graph.getVertices();
        int n = vertices.size();
        int minCut = n;
        //WARNING: Please change the value of nRepeat to a much smaller one (e.g. n)
        //if you want the program run faster! However, n^2 * ln(n) times of repeat
        //would ensure a (1-1/n) rate of success on finding the minCut.
        //int nRepeat = (int) (Math.pow(n, 2) * Math.log(n)); //Please read Warning above!
        int nRepeat = n; //You can change to this one.
        for (int i = 0; i < nRepeat; i++){
            //Graph g = new Graph(this.inputFileName);
            //g.randomContract();
            randomContract(graph);
            int crossingEdges = graph.getEdges().size();
            if (crossingEdges < minCut){
                minCut = crossingEdges;
            }
        }
        return minCut;
    }


}
