package org.example.stanford.randomcontraction;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Edge;
import org.example.model.Vertex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Slf4j
@Data
public class Graph {

    private Map<Integer, Vertex> vertices;
    private List<Edge> edges;


    //TODO combine loops
    public Graph(File inputFile) throws FileNotFoundException {
        vertices = new HashMap<>();
        edges = new ArrayList<>();

        Scanner in = new Scanner(inputFile);
        //add all vertices
        while (in.hasNextLine()){
            Scanner line = new Scanner(in.nextLine());
            int id = line.nextInt();
            Vertex v = new Vertex(id);
            //log.info("Adding all Vertices :: Creating new Vertex with id = {}",id);
            vertices.put(id, v);
        }
        in = new Scanner(inputFile);
        //add edges
        while (in.hasNextLine()){
            Scanner line = new Scanner(in.nextLine());
            int idU = line.nextInt();
            //log.info("Adding edges :: Creating Vertex with id = {} ",idU);
            Vertex u = vertices.get(idU);
            while (line.hasNextInt()){
                int idV = line.nextInt();
                Vertex v = vertices.get(idV);
                log.info("Attempting to add edge for idU = {} & idV = {}",idU,idV);
                if (u.id < v.id){
                    log.info("Added edge for idU = {} & idV = {}",idU,idV);
                    addEdge(u, v, 1);
                } else {
                    log.warn("          DID NOT :: Add edge for idU = {} & idV = {}",idU,idV);

                }
            }
        }
    }

    public void addEdge(Vertex u, Vertex v, int count){
        int idU = u.id;
        int idV = v.id;
        Edge e = new Edge(vertices.get(Math.min(idU, idV)), vertices.get(Math.max(idU, idV)));
        for (int i = 0; i < count; i++){
            vertices.get(idU).neighbours.add(e);
            vertices.get(idV).neighbours.add(e);
            edges.add(e);
        }
    }

    public void printGraph(){
        System.out.println("vertices:");
        Set<Integer> keySet = vertices.keySet();
        for(Integer id :keySet) {
            System.out.print(id + ": ");
            for (Edge e : vertices.get(id).neighbours){
                System.out.print(e.getU().id + "-" + e.getV().id + " ");
            }
            System.out.println();
        }
        System.out.println("edges:");
        for (Edge e : edges){
            System.out.print(e.getU().id + "-" + e.getV().id + " ");
        }
        System.out.println();
    }

}
